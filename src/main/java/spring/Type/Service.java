package spring.Type;

import lombok.*;
import org.springframework.format.annotation.DateTimeFormat;
import spring.hibernate.HibernateEntity;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "Services")
@Data
@RequiredArgsConstructor
@AllArgsConstructor
public class Service implements HibernateEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Setter
    @Getter
    @Column(name = "ID")
    private int id;

    @NonNull
    @Setter @Getter
    @Column(name = "value")
    private double value;

    @NonNull
    @Setter @Getter
    @Column(name = "description")
    private String description;

    @Column(name = "date")
    @NonNull
    @Setter @Getter
    @DateTimeFormat(pattern = "dd-MM-yyyy")
    private Date date;


    public Service() {
    }
}
