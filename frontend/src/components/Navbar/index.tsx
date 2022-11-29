import "./styles.css";
import "bootstrap/js/src/collapse.js";
import { Link } from "react-router-dom";
import ButtonIcon from "components/ButtonIcon";

type Props = {
  text: string;
};

const Navbar = ({text}: Props) => {
  return (
    <>
      <nav className="navbar navbar-expand-md navbar-dark bg-primary">
        <div className="navbar_container container-fluid">
          <Link to="/" className="navbar_logo">
            <h4>Beach Hut</h4>
          </Link>
          <button
            className="navbar-toggler"
            type="button"
            data-bs-toggle="collapse"
            data-bs-target="#navbar-hamburger"
            aria-controls="navbar-hamburger"
            aria-expanded="false"
            aria-label="Toggle navigation"
          >
            <span className="navbar-toggler-icon"></span>
          </button>
          <div className="collapse navbar-collapse" id="navbar-hamburger">
            <ul className="navbar-nav offset-md-11 main-menu">
              <li className="navbar_item">
                <Link to="/">
                  <ButtonIcon text={text} />
                </Link>
              </li>
            </ul>
          </div>
          <Link to="/">
                  <ButtonIcon text={text} />
                </Link>
        </div>
      </nav>
    </>
  );
};

export default Navbar;
