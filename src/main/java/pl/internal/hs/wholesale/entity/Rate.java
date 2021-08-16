package pl.internal.hs.wholesale.entity;

import pl.internal.hs.wholesale.enums.CurrencyEnum;

import javax.persistence.*;

@Entity
public class Rate {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long Id;
    @Enumerated(EnumType.STRING)
    private CurrencyEnum Currency;
    private Double price;

    public Long getId() {
        return Id;
    }

    public void setId(Long id) {
        Id = id;
    }

    public CurrencyEnum getCurrency() {
        return Currency;
    }

    public void setCurrency(CurrencyEnum currency) {
        Currency = currency;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }
}
