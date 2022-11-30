
import "./styles.css";

type Props = {
  text: string;
};

const ButtonIcon = ({ text }: Props) => {
  return (
    <button className="btn btn-primary btn-icon">
      <p className="btn-text">{text}</p>
    </button>
  );
};

export default ButtonIcon;
