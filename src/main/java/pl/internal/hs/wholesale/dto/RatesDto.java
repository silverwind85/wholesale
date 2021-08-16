
package pl.internal.hs.wholesale.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

public class RatesDto {
    @JsonProperty(value="GBP")
    private Double gbp;
    @JsonProperty(value="USD")
    private Double usd;
    @JsonProperty(value="HKD")
    private Double hkd;

    public Double getGbp() {
        return gbp;
    }

    public void setGbp(Double gbp) {
        this.gbp = gbp;
    }

    public Double getUsd() {
        return usd;
    }

    public void setUsd(Double usd) {
        this.usd = usd;
    }

    public Double getHkd() {
        return hkd;
    }

    public void setHkd(Double hkd) {
        this.hkd = hkd;
    }
}

