package passify.app.request;

import lombok.Builder;
import lombok.Data;

import javax.persistence.ElementCollection;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.Map;

@Data
@Builder
public class EventPutRequestBody {
    @NotNull
    @NotEmpty(message = "ID field cannot be empty")
    private Long id;

    private String name;
    private String description;
    private double price;

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
