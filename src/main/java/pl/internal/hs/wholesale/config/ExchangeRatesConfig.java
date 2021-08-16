package pl.internal.hs.wholesale.config;

import lombok.Getter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
@Getter
public class ExchangeRatesConfig {

    @Value("${exchangerates.api.endpoint}")
    private String ExchangeRatesEndpoint;

    @Value("${exchangerates.app.token}")
    private String ExchangeRatesToken;

}
