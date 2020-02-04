package spring.Type;

import lombok.*;
import org.springframework.format.annotation.DateTimeFormat;
import spring.hibernate.HibernateEntity;

import javax.persistence.*;
import java.util.Date;


@Entity
@Table(name = "Others")
@Data
@RequiredArgsConstructor
@AllArgsConstructor
public class Other implements HibernateEntity {

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


//        @Override
//        public String toString() {
//                return "Other{" +
//                        "id=" + id +
//                        ", value=" + value +
//                        ", description='" + description + '\'' +
//                        ", date=" + date +
//                        '}';
//        }

        public Other() {
        }
}

