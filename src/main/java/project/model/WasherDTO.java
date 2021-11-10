package project.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@ToString
public class WasherDTO {
    private int id;
    private int weight;
    private int volume;
    private String brand;
    private String ownerName;
    private String password;
}
