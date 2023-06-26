package peaksoft.dto;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CheckoutForm {
    @NotNull
    @Min(4)
    private Integer amount;
    @NotNull
    @Max(200)
    private String featureRequest;
}
