// Node modules
import { FormEvent, useState } from "react";
import { Link , useNavigate} from "react-router-dom";

// Project files
import ListInput from "components/ListInput";
import Fields from "data/fields-sign-in.json";
import iUser from "interfaces/iUser";
import { useUser } from "state/UserContext";

export default function Login() {
  // Global state
  const { user, setUser } = useUser();
  const navigate = useNavigate();

  // Local state
  const [form, setForm] = useState({ email: "", password: "" });

  // Properties
  const endPoint = "login/";

  // Methods
  function onSubmit(event: FormEvent): void {
    event.preventDefault();
    navigate("/"); 
 
    fetch(endPoint, {
      method: "POST",
      headers: {
        "Content-Type": "application/json",
        "x-access-token": "token-value",
      },
      body: JSON.stringify(form)
    })
      .then((response) => response.json())
      .then((result) => onSuccess(result))
      .catch((error) => onFailure(error));
  }

  function onSuccess(returningUser: iUser) {
    setUser(returningUser);
  }

  function onFailure(error: string) {
    console.error(error);
    alert(error);
  }

  return (
    <div id="sign-in" className="auth">
      <div className="container">
        <h1>Sign In</h1>
        <form onSubmit={(event) => onSubmit(event)}>
          <ListInput fields={Fields} state={[form, setForm]} />
          <button>Sign in</button>
        </form>
        <footer>
          <p>
            New to Natflix? <Link to="/registration">Sign up now</Link>.
          </p>
        </footer>
      </div>
    </div>
  );
}
