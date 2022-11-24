import { BrowserRouter, Routes, Route, Navigate } from "react-router-dom";
import Navbar from "components/Navbar";
import Home from "pages/Home";
import Login from "pages/Login";
import Formlogin from "pages/Login/Auth/Formlogin";


const Router = () => {
  return (
    <BrowserRouter>
      <Navbar />
      <Routes>
        <Route path="/" element={<Home />} />
        <Route index element={<Home />} />
        <Route path="/login" element={<Login />} />
        <Route path="/login/auth" element={<Navigate to="/login/auth/formlogin" />} />
        <Route path="/login/auth/login" element={<Formlogin />} />
      </Routes>
    </BrowserRouter>
  );
};

export default Router;
