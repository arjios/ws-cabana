
import "./styles.css";

type Props = {
  text: string;
};

const ButtonIcon = ({ text }: Props) => {
  return (
    <button className="btn btn-primary btn-icon">
      <p>{text}</p>
    </button>
  );
};

export default ButtonIcon;
