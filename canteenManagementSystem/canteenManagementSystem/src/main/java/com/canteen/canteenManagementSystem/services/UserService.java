package com.canteen.canteenManagementSystem.services;

import com.canteen.canteenManagementSystem.entities.User;
import com.canteen.canteenManagementSystem.models.UserModel;
import com.canteen.canteenManagementSystem.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import java.util.ArrayList;
import java.util.List;

@Service
public class UserService {
    @Autowired
    UserRepository userRepository;
    @Autowired
    EntityManager entityManager;

    public ResponseEntity saveUserAllDetails(UserModel userModel) {
        User user = new User();
        user.setUserName(userModel.getUserName());
        user.setUserEmailId(userModel.getUserEmailId());
        user.setUserPassword(userModel.getUserPassword());
        user.setRole(userModel.getRole());

        userRepository.save(user);
        return  new ResponseEntity<>("Saved Data", HttpStatus.OK);
    }

    public ResponseEntity updateUserById(UserModel userModel) {
        entityManager.createNativeQuery("update user set role =:role , user_email_id =:user_email_id , user_name =:user_name , user_password =:user_password where user_id =:user_id ")
                .setParameter("role", userModel.getRole())
                .setParameter("user_email_id",userModel.getUserEmailId())
                .setParameter("user_name",userModel.getUserName())
                .setParameter("user_password",userModel.getUserPassword())
                .setParameter("user_id",userModel.getUserId()).executeUpdate();
        return new ResponseEntity<>("Data Updated", HttpStatus.OK);
    }

    public ResponseEntity deleteUserById(Long userId) {
        userRepository.deleteById(userId);
        return new ResponseEntity<>("data Deleted" , HttpStatus.OK);
    }

    public List<UserModel> getUserDetails() {
        List<UserModel> userModelList = new ArrayList<>();
        List<User>userList = userRepository.findAll();
        userList.stream().forEach(data->{
            UserModel model = new UserModel();
            model.setUserId(data.getUserId());
            model.setRole(data.getRole());
            model.setUserPassword(data.getUserPassword());
            model.setUserName(data.getUserName());
            model.setUserEmailId(data.getUserEmailId());

            userModelList.add(model);
        });
        return  userModelList;
    }
}
