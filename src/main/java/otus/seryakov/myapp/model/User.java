package otus.seryakov.myapp.model;

import lombok.*;

import javax.persistence.*;

@Data
@Entity
@Table(name = "USERS")
public class User {

    @Id
    @Column(name = "USER_ID")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "users_seq_gen")
    @SequenceGenerator(name = "users_seq_gen", sequenceName = "users_id_seq")
    private long id;

    @Column(name = "USER_NAME")
    private String username;

    @Column(name = "FIRST_NAME")
    private String firstName;

    @Column(name = "LAST_NAME")
    private String lastName;

    @Column(name = "EMAIl_NAME")
    private String email;

    @Column(name = "PHONE")
    private String phone;

}
