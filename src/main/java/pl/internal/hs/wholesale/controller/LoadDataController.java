package pl.internal.hs.wholesale.controller;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import pl.internal.hs.wholesale.entity.Currency;
import pl.internal.hs.wholesale.service.CurrencyService;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@RestController
public class LoadDataController {
    private final CurrencyService currencyService;


    public LoadDataController(CurrencyService currencyService) {
        this.currencyService = currencyService;
    }

    @PostMapping("/currencies/load")
    public String loadedDate() {
        currencyService.loadedToDB();
        return "data loaded successful";

    }

    @GetMapping(value = {"/currencies/{startDate}", "/currencies/{startDate}/{endDate}"})
    public ResponseEntity<List<Currency>> fetchDate(@PathVariable @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate startDate, @PathVariable
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) Optional<LocalDate> endDate) {

        return ResponseEntity.ok(currencyService.fetchData(startDate, endDate));

    }
}
