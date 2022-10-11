import "./styles.css";
import "bootstrap/js/src/collapse.js";

const Navbar = () => {
  return (
    <>
      <nav className="navbar navbar-expand-md navbar-dark bg-primary">
        <div className="navbar_container container-fluid">
          <a href="link" className="navbar_logo">
            <h4>Beach Hut</h4>
          </a>
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
                <a href="link" className="navbar_link">
                  Login
                </a>
              </li>
            </ul>
          </div>
        </div>
      </nav>
    </>
  );
};

export default Navbar;
