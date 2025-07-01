package currency.converter.controller;

import currency.converter.dto.ConversionRequest;
import currency.converter.dto.ConversionResponse;
import currency.converter.service.CurrencyService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/currency")
@Tag(name = "Currency Converter API", description = "Конвертация валют")
public class CurrencyController {
    @Autowired
    private CurrencyService currencyService;

    @Operation(summary = "Конвертировать валюту")
    @PostMapping("/convert")
    public ResponseEntity<ConversionResponse> convert(
            @RequestBody ConversionRequest request
    ) {
        return ResponseEntity.ok(currencyService.convert(request));
    }
}