package peaksoft.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import static jakarta.persistence.CascadeType.*;
import static jakarta.persistence.FetchType.LAZY;

@Entity
@Table(name = "social_media")
@Getter
@Setter
@NoArgsConstructor

public class SocialMedia {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(unique = true)
    private String socialMedia;

    @ManyToOne(cascade = {DETACH,MERGE,REFRESH,PERSIST},fetch = LAZY)
    private Person person;

    public SocialMedia(String socialMedia) {
        if(this.socialMedia == null){
            this.socialMedia = "NOT PROVIDED!";
        }
    }
}
