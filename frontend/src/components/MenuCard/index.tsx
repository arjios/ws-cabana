import './styles.css';

import MenuImg from 'assets/images/jpg/bolinhodefeijoada.jpg';
import ButtonCard from 'components/ButtonCard';

const MenuCard = () => {

    return(
        <div className = "base_card menu_card">
            <div className = "card_img col-md-3 col-xs-6">
                <img src = {MenuImg} className = "card_img__pic" alt = "Bolinho" />
            </div>

            <div className = "card_img col-md-3 col-xs-6">
                <ButtonCard text="ENTRADAS"/>
            </div>

        </div>
    );

}

export default MenuCard;