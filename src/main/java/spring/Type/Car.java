//package spring.Type;
//
//import lombok.*;
//import org.springframework.format.annotation.DateTimeFormat;
//
//
//import javax.persistence.*;
//import java.util.Date;
//import java.util.Objects;
//
//@AllArgsConstructor
//@RequiredArgsConstructor
//@Entity
//public class Car  implements  HibernateEntity{
//
//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    @Setter @Getter
//    @Column(name = "ID")
//    private long id;
//
//    @NonNull
//    @Setter @Getter
//    @Column(name = "value")
//    private double value;
//
//    @NonNull
//    @Setter @Getter
//    @Column(name = "description")
//    private String description;
//
//    @Column(name = "date")
//    @NonNull
//    @Setter @Getter
//    @DateTimeFormat(pattern = "dd-MM-yyyy")
//    private Date date;
//
//
//
//}
