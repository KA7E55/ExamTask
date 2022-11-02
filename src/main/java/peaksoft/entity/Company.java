package peaksoft.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

import static jakarta.persistence.CascadeType.*;

@Entity
@Table(name = "companies")
@Getter
@Setter
@NoArgsConstructor

public class Company {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String companyName;
    private String location;

    @ManyToMany(cascade = ALL, fetch = FetchType.EAGER)
    private List<Person> person = new ArrayList<>();

    public Company(String companyName, String location) {
        if (this.companyName.length() > 30) {
            System.out.println("companyName > 30");
        } else this.companyName = companyName;

        this.location = location;
    }

    @Override
    public String toString() {
        return "- - - Company - - -" +
                "ID: " + id +
                "Company Name: " + companyName +
                "Location: " + location ;
    }
}
