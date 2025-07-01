package currency.converter.service;

import currency.converter.dto.ConversionRequest;
import currency.converter.dto.ConversionResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Map;

@Service
public class CurrencyService {
    private final RestTemplate restTemplate;
    private static final String API_URL = "https://api.frankfurter.app/latest?from={from}&to={to}";

    @Autowired
    public CurrencyService(RestTemplateBuilder restTemplateBuilder) {
        this.restTemplate = restTemplateBuilder.build();
    }

    @Cacheable(value = "rates", key = "#request.from + #request.to")
    public ConversionResponse convert(ConversionRequest request) {
        ResponseEntity<Map> response = restTemplate.getForEntity(
                API_URL, Map.class, request.getFrom(), request.getTo()
        );
        Map<String, Object> body = response.getBody();
        Map<String, Double> rates = (Map<String, Double>) body.get("rates");
        double rate = rates.get(request.getTo());
        double result = request.getAmount() * rate;
        return new ConversionResponse(request.getFrom(), request.getTo(), rate, result);
    }
}
