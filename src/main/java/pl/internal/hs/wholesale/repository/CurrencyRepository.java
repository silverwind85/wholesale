package pl.internal.hs.wholesale.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.internal.hs.wholesale.entity.Currency;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

public interface CurrencyRepository extends JpaRepository<Currency, Long> {
    Optional<Currency> findByDate(LocalDate date);
    List<Currency> findALLByDateBetween(LocalDate startDate, LocalDate endDate);
}
