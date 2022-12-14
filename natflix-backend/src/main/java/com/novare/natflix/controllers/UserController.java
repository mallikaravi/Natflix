package com.novare.natflix.controllers;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseCookie;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.novare.natflix.exceptions.NatflixException;
import com.novare.natflix.models.ERole;
import com.novare.natflix.models.Role;
import com.novare.natflix.models.User;
import com.novare.natflix.payload.LoginRequest;
import com.novare.natflix.payload.UserDTO;
import com.novare.natflix.repositories.RoleRepository;
import com.novare.natflix.repositories.UserRepository;
import com.novare.natflix.security.jwt.JwtUtils;
import com.novare.natflix.security.services.UserDetailsImpl;
import com.novare.natflix.services.IUserService;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api")
@Validated
public class UserController {
    @Autowired
    private IUserService userService;

    @Autowired
    private RoleRepository roleRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private JwtUtils jwtUtils;

    @PostMapping("/login")
    public ResponseEntity<UserDTO> authenticateUser(@Valid @RequestBody LoginRequest loginRequest) {

        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(loginRequest.getEmail(), loginRequest.getPassword()));

        SecurityContextHolder.getContext().setAuthentication(authentication);

        UserDetailsImpl userDetails = (UserDetailsImpl) authentication.getPrincipal();

        ResponseCookie jwtCookie = jwtUtils.generateJwtCookie(userDetails);

        String roleName = userDetails.getAuthorities().stream().map(item -> item.getAuthority())
                .collect(Collectors.toList()).get(0);

        Role role = roleRepository.findByName(ERole.valueOf(roleName))
                .orElseThrow(() -> new NatflixException(HttpStatus.BAD_REQUEST, "Role Not Found " + roleName));

        User user = new User(userDetails.getId(), userDetails.getFullName(), userDetails.getUsername(), role);

        return ResponseEntity.ok().header(HttpHeaders.SET_COOKIE, jwtCookie.toString())
                .body(UserDTO.build(user));
    }

    @PostMapping("/logout")
    public ResponseEntity<?> logoutUser() {
        ResponseCookie cookie = jwtUtils.getCleanJwtCookie();
        return ResponseEntity.ok().header(HttpHeaders.SET_COOKIE, cookie.toString()).body("You've been logged out!");
    }

    @PostMapping("/signup")
    public ResponseEntity<UserDTO> createUser(@Valid @RequestBody UserDTO signUpRequest) throws NatflixException {
        if (userRepository.existsByEmail(signUpRequest.getEmail())) {
            throw new NatflixException(HttpStatus.BAD_REQUEST, "User Already Exist " + signUpRequest.getEmail());
        }
        User toUser = UserDTO.buildModel(signUpRequest);
        final User createUser = userService.createUser(toUser);
        return ResponseEntity.ok(UserDTO.build(createUser));
    }

    @GetMapping("/user")
//    @PreAuthorize("hasRole('ADMIN')")
    public List<User> findAll() throws NatflixException {
        return userRepository.findAll();
    }

    @GetMapping("/user/{id}")
//    @PreAuthorize("hasRole('CUSTOMER') or hasRole('ADMIN')")
    public ResponseEntity<User> getUsersById(@PathVariable(value = "id") Long userId) throws NatflixException {
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new NatflixException(HttpStatus.NOT_FOUND, "User not found on :: " + userId));
        return ResponseEntity.ok().body(user);
    }

    @PutMapping("/user/{id}")
//    @PreAuthorize("hasRole('CUSTOMER') or hasRole('ADMIN')")
    public ResponseEntity<User> updateUser(@PathVariable(value = "id") Long userId, @RequestBody User updateRequest)
            throws NatflixException {
        updateRequest.setId(userId);
        final User updatedUser = userService.updateUser(updateRequest);
        return ResponseEntity.ok(updatedUser);
    }

    @DeleteMapping("/user/{id}")
//    @PreAuthorize("hasRole('ADMIN')")
    public Map<String, Boolean> deleteUser(@PathVariable(value = "id") Long userId) throws NatflixException {
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new NatflixException(HttpStatus.NOT_FOUND, "User not found on :: " + userId));

        userRepository.delete(user);
        Map<String, Boolean> response = new HashMap<>();
        response.put("deleted", Boolean.TRUE);
        return response;
    }
}