

import "./styles.css";

type Props ={
  name: string;
}

const ButtonCard = ( { name } : Props ) => {
  return (
    <div>
      <button className="btn btn-card">{ name }</button>
    </div>
  );
};

export default ButtonCard;
