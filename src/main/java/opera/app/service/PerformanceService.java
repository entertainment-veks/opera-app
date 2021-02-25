package opera.app.service;

import java.util.List;
import opera.app.model.Performance;

public interface PerformanceService {
    Performance add(Performance performance);

    List<Performance> getAll();

    Performance get(Long id);
}
