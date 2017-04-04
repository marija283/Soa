package teatar.Controllers;

import hello.Greeting;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import teatar.Entities.Users;
import teatar.Repository.UserRepo;

import java.util.concurrent.atomic.AtomicLong;

/**
 * Created by Marija on 3/14/2017.
 */
@RestController
public class UserController {

    @Autowired
    UserRepo userRepo;

    private static final String template = "Hello, %s!";
    private final AtomicLong counter = new AtomicLong();

    @RequestMapping("/greeting")
    public Greeting greeting(@RequestParam(value="name", defaultValue="World") String name) {
        return new Greeting(counter.incrementAndGet(),
                String.format(template, name));
    }

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
