package in.stackroute.umove.bookingservice.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.persistence.Id;

@Document
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Supervisor {

    @Id
    private String id;
    private String name;
    private String contact;
    private String email;
    private SupervisorStatus supervisorStatus;
}