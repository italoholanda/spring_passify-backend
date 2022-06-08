package passify.app.request;

import lombok.Builder;
import lombok.Data;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

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
}
