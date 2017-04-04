package teatar.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import teatar.Entities.Users;
import teatar.Repository.UserRepo;

/**
 * Created by Marija on 3/14/2017.
 */
@RestController
public class UserController {

    @Autowired
    UserRepo userRepo;

    @RequestMapping("/createNewUser")
    public Users CreateNew(@RequestParam(value = "name") String name, @RequestParam String surname
            ,@RequestParam String username, @RequestParam String password){
        Users user = new Users(name,surname,username, password);
        userRepo.save(user);
        return user;
    }

    @RequestMapping("/getbyid")
    public Users getById(@RequestParam(value="id", defaultValue = "-1") Long id) {
        Users foundCustomer = userRepo.findOne(id);
        return foundCustomer;
    }
}
