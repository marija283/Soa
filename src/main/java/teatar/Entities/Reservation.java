package teatar.Entities;

import javax.jws.soap.SOAPBinding;
import javax.persistence.*;

/**
 * Created by 135026 on 3/7/2017.
 */

@Entity
public class Reservation {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Long id;

    @ManyToOne
    private Play play;

    private boolean isPaid;

    @ManyToOne
    private Users user;

}
