package peaksoft.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

import static jakarta.persistence.CascadeType.*;

@Entity
@Table(name = "cars")
@Getter
@Setter
@NoArgsConstructor

public class Car {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private int mark;
    private String producedCountry;

    @ManyToOne(cascade = {DETACH, MERGE, REFRESH, PERSIST, REMOVE}, fetch = FetchType.LAZY)
    private Person person;

    @OneToOne(cascade = {ALL},fetch = FetchType.EAGER)
    private Garage garage;

    public Car(int mark, String producedCountry) {
        this.mark = mark;
        this.producedCountry = producedCountry;
    }

    @Override
    public String toString() {
        return "- - - Car - - -" +
                "ID: " + id +
                "Mark: " + mark +
                "Produced Country: " + producedCountry;
    }
}
