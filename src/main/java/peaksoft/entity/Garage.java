package peaksoft.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Entity
@Table(name = "garages")
@Getter
@Setter
@NoArgsConstructor

public class Garage {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private boolean isEmpty;

    @OneToOne
    private Car car;

    public Garage(String garageName, boolean isEmpty) {
        this.name = garageName;
        this.isEmpty = isEmpty;
    }

    @Override
    public String toString() {
        return "- - - Garage - - -" +
                "ID: " + id +
                "GarageName: " + name +
                "isEmpty: " + isEmpty;
    }
}
