package teatar.Repository;

import org.springframework.data.repository.CrudRepository;
import teatar.Entities.Users;

/**
 * Created by Marija on 3/14/2017.
 */
public interface UserRepo extends CrudRepository<Users, Long> {
}
