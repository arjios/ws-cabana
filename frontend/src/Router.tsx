import { BrowserRouter, Routes, Route } from "react-router-dom";
import Navbar from "components/Navbar";
import Home from "pages/Home";
import Formlogin from "pages/Login/Auth/Formlogin";
import Formrecover from "pages/Login/Auth/Formrecover";
import Formregister from "pages/Login/Auth/Formregister/indeex";
import Auth from "pages/Login/Auth";

const Router = () => {
  return (
    <BrowserRouter>
      <Navbar text="LOGIN" />
      <Routes>
        <Route index element={<Home />} />
        <Route path="/" element={<Home />} />
        <Route path="/login/auth/*" element={<Auth />} />
        <Route path="/login/auth/formlogin" element={<Formlogin />} />
        <Route path="/login/auth/formrecover" element={<Formrecover />} />
        <Route path="/login/auth/formregister" element={<Formregister />} />
      </Routes>
    </BrowserRouter>
  );
};

export default Router;
