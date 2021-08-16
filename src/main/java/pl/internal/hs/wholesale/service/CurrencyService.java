package pl.internal.hs.wholesale.service;


import org.springframework.stereotype.Component;
import pl.internal.hs.wholesale.dto.HistoricalDto;
import pl.internal.hs.wholesale.entity.Currency;
import pl.internal.hs.wholesale.entity.Rate;
import pl.internal.hs.wholesale.enums.CurrencyEnum;
import pl.internal.hs.wholesale.exchangerates.cllient.ExchangeRatesClient;
import pl.internal.hs.wholesale.repository.CurrencyRepository;

import java.time.LocalDate;
import java.util.*;
import java.util.stream.Collectors;

@Component
public class CurrencyService {
    private final ExchangeRatesClient exchangeRatesClient;
    private final CurrencyRepository currencyRepository;

    public CurrencyService(ExchangeRatesClient exchangeRatesClient, CurrencyRepository currencyRepository) {
        this.exchangeRatesClient = exchangeRatesClient;
        this.currencyRepository = currencyRepository;
    }


    public void loadedToDB() {
        LocalDate now = LocalDate.now();
        LocalDate startDate = now.minusYears(1);
        List<LocalDate> dates = getDatesBetween(startDate, LocalDate.now());
        dates.forEach(System.out::println);
        List<HistoricalDto> historicalDtos = new ArrayList<>();
        dates.forEach(d -> historicalDtos.add(exchangeRatesClient.getHistorical(d.toString())));

        historicalDtos.forEach(h -> {
            Currency currency = new Currency();
            currency.setBase((CurrencyEnum.valueOf(h.getBase())));
            currency.setDate(LocalDate.parse(h.getDate()));
            Set<Rate> rates = new HashSet<>();
            Rate rateGBP = new Rate();
            Rate rateUSD = new Rate();
            Rate rateHKD = new Rate();

            rateGBP.setCurrency(CurrencyEnum.GBP);
            rateGBP.setPrice(h.getRates().getGbp());
            rateUSD.setCurrency(CurrencyEnum.USD);
            rateUSD.setPrice(h.getRates().getUsd());
            rateHKD.setCurrency(CurrencyEnum.HKD);
            rateHKD.setPrice(h.getRates().getHkd());
            rates.add(rateGBP);
            rates.add(rateUSD);
            rates.add(rateHKD);
            
            currency.setRates(rates);
            currencyRepository.save(currency);
        });


    }


    public List<Currency> fetchData(LocalDate startDate, Optional<LocalDate> endDate) {
        if (endDate.isPresent()) {
            return currencyRepository.findALLByDateBetween(startDate, endDate.get());
        } else {
            List<Currency> currencies = new ArrayList<>();
            if(currencyRepository.findByDate(startDate).isPresent()){
                currencies.add( currencyRepository.findByDate(startDate).get());
            }
            return currencies;
        }

    }

    private static List<LocalDate> getDatesBetween(
            LocalDate startDate, LocalDate endDate) {

        return startDate.datesUntil(endDate)
                .collect(Collectors.toList());
    }

}
