package com.canteen.canteenManagementSystem.resources;

import com.canteen.canteenManagementSystem.models.MenuModel;
import com.canteen.canteenManagementSystem.services.MenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;
import java.util.List;

@RestController
@RequestMapping("/abc")
public class MenuResource {
    @Autowired
    MenuService menuService;
    @Autowired
    EntityManager entityManager;

    @Transactional
    @PostMapping("/saveMenuAllDetails")
    public ResponseEntity saveMenuAllDetails (@RequestBody MenuModel menuModel){
        return menuService.saveMenuAllDetails(menuModel);
    }
    @Transactional
    @PostMapping("/updateMenuById")
    public ResponseEntity updateMenuById (@RequestBody MenuModel menuModel){
        return menuService.updateMenuById(menuModel);
    }
    @PostMapping("/deleteMenuById/{menuId}")
    public ResponseEntity deleteMenuById (@PathVariable ("menuId") Long menuId){
        return menuService.deleteMenuById(menuId);
    }
    @GetMapping("/getMenuDetails")
    public List<MenuModel> getMenuDetails(){
        return menuService.getMenuDetails();
    }
}
