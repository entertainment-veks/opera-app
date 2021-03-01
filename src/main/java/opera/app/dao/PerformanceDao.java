package opera.app.dao;

import java.util.List;
import opera.app.model.Performance;

public interface PerformanceDao {
    Performance add(Performance performance);

    List<Performance> getAll();

    Performance get(Long id);
}
