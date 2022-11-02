package peaksoft.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

import static jakarta.persistence.CascadeType.*;
import static jakarta.persistence.FetchType.*;

@Entity
@Table(name = "people")
@Getter
@Setter
@NoArgsConstructor

public class Person {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private int age;
    @Column(unique = true)
    private String email;
    @Column(nullable = false)
    private String gender;

    @OneToOne(cascade = {DETACH, MERGE, REFRESH, PERSIST}, fetch = EAGER)
    private Company company;

    @OneToMany(cascade = ALL, fetch = EAGER, mappedBy = "person")
    private List<SocialMedia> socialMedia;

    @OneToMany(cascade = ALL, fetch = EAGER, mappedBy = "person")
    private List<Car> cars;

    public Person(String name, int age, String email, String gender) {
        if (this.name.length() > 25) {
            System.out.println("name > 25");
        } else this.name = name;
        this.age = age;
        this.email = email;
        this.gender = gender;
    }

    @Override
    public String toString() {
        return "- - - Person - - -" +
                "ID: " + id +
                "Name: " + name +
                "Age: " + age +
                "Email: " + email +
                "Gender: " + gender;
    }
}
