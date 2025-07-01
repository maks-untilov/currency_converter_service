package currency.converter.dto;

import lombok.Data;

@Data
public class ConversionResponse {
    private String from;
    private String to;
    private double rate;
    private double result;

    public ConversionResponse(String from, String to, double rate, double result) {
        this.from = from;
        this.to = to;
        this.rate = rate;
        this.result = result;
    }
}