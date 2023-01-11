import { Link } from "react-router-dom";
import "./styles.css";
import "bootstrap/js/src/collapse.js";


type Props = {
    name?: string;
}

const SubBar = ({name} : Props) => {
  return (
    <>
      <nav className="navbar navbar-expand-md navbar-light bg-secondary">
        <div className="subbar_container container-fluid">
        <div className="sub_user">Usuario: {name}</div>
        <Link to="/" className="sub_sair">Sair</Link>
        </div>
      </nav>
    </>
  );
};

export default SubBar;
