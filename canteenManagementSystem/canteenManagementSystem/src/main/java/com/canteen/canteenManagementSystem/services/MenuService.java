package com.canteen.canteenManagementSystem.services;

import com.canteen.canteenManagementSystem.entities.Menu;
import com.canteen.canteenManagementSystem.models.MenuModel;
import com.canteen.canteenManagementSystem.repositories.MenuRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import java.util.ArrayList;
import java.util.List;

@Service
public class MenuService {
    @Autowired
    MenuRepository menuRepository;
    @Autowired
    EntityManager entityManager;

    public ResponseEntity saveMenuAllDetails(MenuModel menuModel) {
        Menu menu = new Menu();
        menu.setMenuName(menuModel.getMenuName());
        menu.setMenuDcription(menuModel.getMenuDcription());
        menu.setMenuPrice(menuModel.getMenuPrice());
        menu.setVenderId(menuModel.getVenderId());

        menuRepository.save(menu);
        return  new ResponseEntity<>("Data Seved", HttpStatus.OK);
    }


    public ResponseEntity updateMenuById(MenuModel menuModel) {
        entityManager.createNativeQuery("update menu set menu_dcription =:menu_dcription , menu_name =:menu_name , menu_price =:menu_price , vender_id =:vender_id  where menu_id =:menu_id ")
                .setParameter("menu_dcription",menuModel.getMenuDcription())
                .setParameter("menu_name",menuModel.getMenuName())
                .setParameter("menu_price",menuModel.getMenuPrice())
                .setParameter("vender_id", menuModel.getVenderId())
                .setParameter("menu_id",menuModel.getMenuId()).executeUpdate();
        return new ResponseEntity<>("Updated data", HttpStatus.OK);
    }

    public ResponseEntity deleteMenuById(Long menuId) {
        menuRepository.deleteById(menuId);
        return  new ResponseEntity<>("Data Deleted", HttpStatus.OK);
    }

    public List<MenuModel> getMenuDetails() {
        List<MenuModel> menuModelList = new ArrayList<>();
        List<Menu> menuList = menuRepository.findAll();
        menuList.stream().forEach(data->{
            MenuModel model = new MenuModel();
            model.setMenuId(data.getMenuId());
            model.setMenuName(data.getMenuName());
            model.setMenuDcription(data.getMenuDcription());
            model.setMenuPrice(data.getMenuPrice());
            model.setVenderId(data.getVenderId());
            menuModelList.add(model);
        });
        return  menuModelList;
    }
}
