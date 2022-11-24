import { ReactComponent as HomeImage } from "../../assets/images/image.svg";

import "./styles.css";
import ButtonIcon from "components/ButtonIcon";
import { Link } from "react-router-dom";

const Home = () => {
  return (
    <div className="home_container">
      <div className="base_card home_card">
        <div className="home_content">
          <h1>Cabana do Sol</h1>
          <Link to="/login">
            <ButtonIcon text="LOGIN" />
          </Link>
        </div>
        <div className="home_image">
          <HomeImage />
        </div>
      </div>
    </div>
  );
};

export default Home;
