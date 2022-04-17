package id.ac.uin.student.entity;

import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;
import java.time.LocalDate;

@Data
@Entity
@Table(name = "student")
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @NotEmpty
    @Column(name = "first_name")
    private String firstName;

    @NotEmpty
    @Column(name = "last_name")
    private String lastName;

    @NotNull(message = "Please enter birth date")
    @Past(message = "Birth date should be less than current date!!")
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
    private LocalDate birthDate;

    @NotEmpty
    @Column(name = "email", unique = true)
    private String email;

    @NotEmpty
    @Column(name = "phone_number", unique = true)
    private String phoneNumber;

    @NotEmpty
    @Column(nullable = false, unique = true)
    private String jurusan;

}
