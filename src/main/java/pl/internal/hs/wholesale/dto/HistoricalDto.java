
package pl.internal.hs.wholesale.dto;

public class HistoricalDto {


    private String Base;

    private String Date;

    private Boolean Historical;

    private RatesDto Rates;

    private Boolean Success;

    private Long Timestamp;

    public String getBase() {
        return Base;
    }

    public void setBase(String base) {
        Base = base;
    }

    public String getDate() {
        return Date;
    }

    public void setDate(String date) {
        Date = date;
    }

    public Boolean getHistorical() {
        return Historical;
    }

    public void setHistorical(Boolean historical) {
        Historical = historical;
    }

    public RatesDto getRates() {
        return Rates;
    }

    public void setRates(RatesDto rates) {
        Rates = rates;
    }

    public Boolean getSuccess() {
        return Success;
    }

    public void setSuccess(Boolean success) {
        Success = success;
    }

    public Long getTimestamp() {
        return Timestamp;
    }

    public void setTimestamp(Long timestamp) {
        Timestamp = timestamp;
    }
}
