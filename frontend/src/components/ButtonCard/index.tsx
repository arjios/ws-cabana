import "./styles.css";

type Props ={
  text: string;
}

const ButtonCard = ({ text }: Props) => {
  return (
    <div>
      <button className="btn btn-card">{text}</button>
    </div>
  );
};

export default ButtonCard;
