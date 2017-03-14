package hello;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by 135026 on 3/7/2017.
 */

@RestController
public class CustomerController {

    @Autowired
    CustomerRepository customerRepository;


    @RequestMapping("/getById")
    public Customer getById(@RequestParam(value = "id", defaultValue = "-1") long id){
        return customerRepository.findOne(id);
    }


    @RequestMapping("/createNew")
    public Customer CreateNew(@RequestParam(value = "name") String name, @RequestParam String surname){
        Customer cust = new Customer(name, surname);
        customerRepository.save(cust);
        return cust;
    }
}
