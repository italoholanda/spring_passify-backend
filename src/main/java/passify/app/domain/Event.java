package passify.app.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import java.util.Map;

@Data
@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Event {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotEmpty(message = "The event name cannot be empty")
    private String name;
    private String description;
    private double price;
    private double rate;

    private String addressStreetName;
    private String addressStreetNumber;
    private String addressAdditional;
    private String addressCity;
    private String addressState;
    private String addressZip;

    private String ownerId;
    private String ownerName;
    private String ownerImage;

    @ElementCollection
    private Map<Integer, String> imageList;
}


