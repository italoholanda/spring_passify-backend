package passify.app.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotEmpty;

@Data
@AllArgsConstructor
@Entity
@Builder
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
}

