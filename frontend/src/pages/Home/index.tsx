
import { ReactComponent as HomeImage } from '../../assets/images/image.svg';
import Navbar from 'components/Navbar';

import './styles.css';


const Home = () => {
  return (
    <>
      <Navbar />
      <div className = "home_container">
        <div className = "home_card">
          <div className = "home_content">
              <h1>-   Cabana do Sol-</h1>
          </div>
          <div className = "home_image">
            <HomeImage />
          </div>
        </div>
      </div>
    </>
  );
};

export default Home;
