package com.canteen.canteenManagementSystem.resources;

import com.canteen.canteenManagementSystem.entities.User;
import com.canteen.canteenManagementSystem.models.UserModel;
import com.canteen.canteenManagementSystem.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;
import java.util.List;

@RestController
@RequestMapping("/abc")
public class UserResource {
    @Autowired
    UserService userService;
    @Autowired
    EntityManager entityManager;

    @Transactional
    @PostMapping("/saveUserAllDetails")
    public ResponseEntity saveUserAllDetails (@RequestBody UserModel userModel){
        return userService.saveUserAllDetails(userModel);
    }
    @Transactional
    @PostMapping("/updateUserById")
    public ResponseEntity updateUserById(@RequestBody UserModel userModel){
        return userService.updateUserById(userModel);
    }
    @PostMapping("/deleteUserById/{userId}")
    public ResponseEntity deleteUserById (@PathVariable ("userId") Long userId){
        return userService.deleteUserById(userId);
    }

    @GetMapping("/getUserDetails")
    public List<UserModel> getUserDetails(){
        return userService.getUserDetails();
    }
}
