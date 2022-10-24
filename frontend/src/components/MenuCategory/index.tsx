import "./styles.css";

type Props = {
  name: string;
}

const MenuCategory = ( { name }: Props ) => {
  return (
    <div>
      <button className="btn btn-primary btn-icon">
        <p>{ name }</p>
      </button>
    </div>
  );
};

export default MenuCategory;
