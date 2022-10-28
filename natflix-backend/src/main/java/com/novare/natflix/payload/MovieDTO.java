package com.novare.natflix.payload;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.novare.natflix.models.AdditionalDetails;
import com.novare.natflix.models.Movies;

public class MovieDTO {
    @JsonProperty("id")
    private Integer id;

    @JsonProperty("content_id")
    private Integer contId;

    @JsonProperty("video_code")
    private String videoCode;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getContId() {
        return contId;
    }

    public void setContId(Integer contId) {
        this.contId = contId;
    }

    public String getVideoCode() {
        return videoCode;
    }

    public void setVideoCode(String videoCode) {
        this.videoCode = videoCode;
    }

    public static List<MovieDTO> buildMovie(List<Movies> moviesList) {
        List<MovieDTO> movieResponses = new ArrayList<>();
        for (Movies movies : moviesList) {
            MovieDTO response = new MovieDTO();
            AdditionalDetails details = movies.getAdditional();
            response.setContId(movies.getContent().getId());
            response.setId(movies.getId());
            response.setVideoCode(details.getVideoCode());
            movieResponses.add(response);
        }

        return movieResponses;
    }
}
