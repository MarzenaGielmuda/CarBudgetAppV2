package spring.Type;

import lombok.*;
import org.springframework.format.annotation.DateTimeFormat;
import spring.hibernate.HibernateEntity;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "Partses")
@Data
@RequiredArgsConstructor
@AllArgsConstructor
public class Parts implements HibernateEntity {

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
    @DateTimeFormat(pattern = "yyyy-mm-dd")
    private Date date;

    public Parts() {
    }
}

