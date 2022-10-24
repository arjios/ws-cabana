import './styles.css';

import ButtonCard from 'components/ButtonCard';
import { Category } from 'types/category';

type Props = {
    category: Category;
}


const MenuCard = ( { category } : Props ) => {

    return(
        <div className = "base_card menu_card">
            <div className = "card_img col-md-3 col-xs-6">
                <img src = {category.urlImage} className = "card_img__pic" alt = "Bolinho" />
            </div>

            <div className = "card_img col-md-3 col-xs-6">
                <ButtonCard  name = {category.name} />
            </div>

        </div>
    );

}

export default MenuCard;