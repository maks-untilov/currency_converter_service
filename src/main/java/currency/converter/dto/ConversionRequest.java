package currency.converter.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Positive;
import lombok.Data;

@Data
public class ConversionRequest {
    @NotBlank(message = "Source currency is required")
    private String from;
    @NotBlank(message = "Target currency is required")
    private String to;
    @Positive(message = "Amount must be positive")
    private double amount;
}