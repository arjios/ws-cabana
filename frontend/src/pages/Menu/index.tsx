import { Link } from "react-router-dom";
import MenuCard from "components/MenuCard";
import { Category } from "types/category";

const Menu = () => {
  const category: Category = {
    id: 1,
    name: "Entradas",
    urlImage: "../../assets/images/jpg/bolinhodefeijoada.jpg",
    products: [
      {
        id: 1,
        number: 106,
        name: "Torresmo de Barriguinha 250g",
        description: "Torresmo de Barriguinha 250g com Molho Barbecue",
        urlImage: "../../assets/images/jpg/bolinhodefeijoada.jpg",
        date: "2022-10-24T14:25:38.335692Z",
        price: 34.9,
        category: "Entradas",
      },
    ],
  };

  return (
    <div className="container my-4">
      <div className="row">
        <div className="col-sm-6 col-md-4 col-lg-4 col-xl-3">
          <Link to="/Menu/MenuList">
            <MenuCard category={category} />
          </Link>
        </div>
        <div className="col-sm-6 col-md-4 col-lg-4 col-xl-3">
          <MenuCard category={category} />
        </div>
        <div className="col-sm-6 col-md-4 col-lg-4 col-xl-3">
          <MenuCard category={category} />
        </div>
        <div className="col-sm-6 col-md-4 col-lg-4 col-xl-3">
          <MenuCard category={category} />
        </div>
        <div className="col-sm-6 col-md-4 col-lg-4 col-xl-3">
          <MenuCard category={category} />
        </div>
        <div className="col-sm-6 col-md-4 col-lg-4 col-xl-3">
          <MenuCard category={category} />
        </div>
        <div className="col-sm-6 col-md-4 col-lg-4 col-xl-3">
          <MenuCard category={category} />
        </div>
        <div className="col-sm-6 col-md-4 col-lg-4 col-xl-3">
          <MenuCard category={category} />
        </div>
        <div className="col-sm-6 col-md-4 col-lg-4 col-xl-3">
          <MenuCard category={category} />
        </div>
      </div>
    </div>
  );
};

export default Menu;
