package passify.app.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Data
@Builder
public class EventPostRequestBody {
    @NotNull
    @NotEmpty(message = "Name field cannot be empty")
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
