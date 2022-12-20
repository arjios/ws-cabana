import { ReactComponent as HomeImage } from "../../assets/images/image.svg";
import { Link } from "react-router-dom";

import "./styles.css";
import ButtonIcon from "components/ButtonIcon";
import { getTokenData } from "util/requests";

const Home = () => {
  return (
    <div className="home_container">
      <h1>{getTokenData()?.user_name}</h1>
      <div className="base_card home_card">
        <div className="home_image">
          <HomeImage />
        </div>
        <div className="home_content">
          <h1>Cabana do Sol</h1>
        </div>
        <div className="home_button">
          <Link to="/login/auth">
            <ButtonIcon text="LOGIN" />
          </Link>
        </div>
      </div>
    </div>
  );
};

export default Home;
