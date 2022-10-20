import { BrowserRouter, Routes, Route } from "react-router-dom";
import Navbar from "components/Navbar";
import Home from "pages/Home";
import Auth from 'pages/Admin/Auth';
import Menu from 'pages/Menu';

const Router = () => {
    return(
        <BrowserRouter>
        <Navbar />
        <Routes>
            <Route path = '/Admin/Auth/*' element={<Auth/>} />
            <Route path = '/Menu/*' element={<Menu />} />
            <Route path = '/' element={<Home />} />
        </Routes>
    </BrowserRouter>
    );
}

export default Router;
