package project.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;

@Entity
@Setter
@Getter
@ToString
public class Washer {
    @Id
    /*
    @SequenceGenerator(
            name = "washer_sequence",
            sequenceName = "washer_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "washer_sequence"
    )*/
    @GeneratedValue(
            strategy = GenerationType.IDENTITY
    )
    private int id;
    private int weight;
    private int volume;

    @Column(nullable = false, columnDefinition = "text")
    private String brand;
    @Column(nullable = false, name = "owner_name", columnDefinition = "text")
    private String ownerName;
    @Column(nullable = false, columnDefinition = "text")
    private String password;

    public Washer() {
        this.brand = "brand";
        this.ownerName = "ownerName";
        this.password = "password";
    }

    public Washer(int weight,
                  int volume,
                  String brand,
                  String ownerName,
                  String password) {
        this.weight = weight;
        this.volume = volume;
        this.brand = brand;
        this.ownerName = ownerName;
        this.password = password;
    }
}
