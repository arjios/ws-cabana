
import { Route, Routes } from "react-router-dom";
import Formlogin from "./Formlogin";
import Formrecover from "./Formrecover";
import Formregister from "./Formregister/indeex";
import "./styles.css";

const Auth = () => {
  return (
    <div className="auth_container">
        <div className="auth_content">
            <Routes>
                <Route path="/login/auth/formlogin" element={<Formlogin/>} />
            </Routes>
            <Routes>
                <Route path="/login/auth/formregister" element={<Formregister/>} />
            </Routes>
            <Routes>
                <Route path="/login/auth/formrecover" element={<Formrecover/>} />
            </Routes>
        </div>
    </div>
  );
};

export default Auth;
