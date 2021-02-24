package opera.app.service;

import opera.app.model.Performance;

import java.util.List;

public interface PerformanceService {
    Performance add(Performance performance);

    List<Performance> getAll();

    Performance get(Long id);
}
