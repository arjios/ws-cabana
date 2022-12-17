import { BrowserRouter, Routes, Route } from "react-router-dom";
import Navbar from "components/Navbar";
import Home from "pages/Home";
import Formlogin from "pages/Login/Auth/Formlogin";
import Formrecover from "pages/Login/Auth/Formrecover";
import Formregister from "pages/Login/Auth/Formregister/indeex";
import Sales from "pages/Sales";
import Orders from "pages/Orders";
import Users from "pages/Admin/Users";


const Router = () => {
  return (
    <BrowserRouter>
      <Navbar text="LOGIN" />
      <Routes>
        <Route index element={<Home />} />
        <Route path="/" element={<Home />} />
        <Route path="/admin/users/*" element={<Users />} />
        <Route path="/orders/*" element={<Orders />} />
        <Route path="/sales/*" element={<Sales />} />
        <Route path="/login/auth/formlogin" element={<Formlogin />} />
        <Route path="/login/auth/formrecover" element={<Formrecover />} />
        <Route path="/login/auth/formregister" element={<Formregister />} />
      </Routes>
    </BrowserRouter>
  );
};

export default Router;
