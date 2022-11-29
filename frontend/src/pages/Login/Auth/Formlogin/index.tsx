import ButtonIcon from "components/ButtonIcon";
import { Link } from "react-router-dom";

const Formlogin = () => {

    return (
        <div className="form_card">
            <h1>Form Login Card</h1>
            <Link to="/"><ButtonIcon text="HOME" /></Link> 
        </div>
    )
}

export default Formlogin;