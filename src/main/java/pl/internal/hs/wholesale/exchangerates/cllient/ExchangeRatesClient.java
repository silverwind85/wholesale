package pl.internal.hs.wholesale.exchangerates.cllient;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;
import pl.internal.hs.wholesale.config.ExchangeRatesConfig;
import pl.internal.hs.wholesale.dto.HistoricalDto;

import java.net.URI;
import java.util.Collection;

import static java.util.Arrays.asList;

@Component
public class ExchangeRatesClient {
    private static final Logger LOGGER = LoggerFactory.getLogger(ExchangeRatesClient.class);

    private final ExchangeRatesConfig exchangeRatesConfig;
    private final RestTemplate restTemplate;

    public ExchangeRatesClient(ExchangeRatesConfig exchangeRatesConfig, RestTemplate restTemplate) {
        this.exchangeRatesConfig = exchangeRatesConfig;
        this.restTemplate = restTemplate;
    }

    public HistoricalDto getHistorical(String date) {
        Collection<String> symbols = asList("GBP", "USD", "HKD");
        MultiValueMap<String, String> queryParams = new LinkedMultiValueMap<>();
        queryParams.add("access_key", exchangeRatesConfig.getExchangeRatesToken());
        queryParams.add("order", String.join(",", symbols));

        URI url = UriComponentsBuilder.fromHttpUrl(exchangeRatesConfig.getExchangeRatesEndpoint() + "/" + date)
                .queryParams(queryParams)
                .build().encode().toUri();
        System.out.println(url.toString());
        return restTemplate.getForObject(url, HistoricalDto.class);
    }


}




