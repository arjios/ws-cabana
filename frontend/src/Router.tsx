import { BrowserRouter, Routes, Route } from "react-router-dom";
import Navbar from "components/Navbar";
import Home from "pages/Home";
import Sales from "pages/Sales";
import Orders from "pages/Orders";
import Users from "pages/Admin/Users";
import Auth from "pages/Auth";


const Router = () => {
  return (
    <BrowserRouter>
      <Navbar text="LOGIN" />
      <Routes>
        <Route index element={<Home />} />
        <Route path="/" element={<Home />} />
        <Route path="/admin/users" element={<Users />} />
        <Route path="/orders" element={<Orders />} />
        <Route path="/sales" element={<Sales />} />
        <Route path="/auth" element={<Auth />} />
      </Routes>
    </BrowserRouter>
  );
};

export default Router;
