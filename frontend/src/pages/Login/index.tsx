
import ButtonIcon from 'components/ButtonIcon';
import { Link } from 'react-router-dom';

import './styles.css';

const Login = () => {
  return (
    <>
      <div className = "login_container">
        <div className = "base_card home_card">
          <div className = "login_content">
              <h1>Cabana do Sol</h1>
              <Link to="/"><ButtonIcon text="HOME"/></Link>
          </div>
        </div>
      </div>
    </>
  );
};

export default Login;