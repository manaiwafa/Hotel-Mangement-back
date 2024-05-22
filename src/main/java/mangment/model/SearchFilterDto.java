package mangment.model;

import java.time.LocalDate;

public record SearchFilterDto (Long region, LocalDate dateArrive, LocalDate dateDepart) {
}
