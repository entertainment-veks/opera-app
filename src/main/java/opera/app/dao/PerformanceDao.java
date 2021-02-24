package opera.app.dao;

import opera.app.model.Performance;
import java.util.List;

public interface PerformanceDao {
    Performance add(Performance performance);

    List<Performance> getAll();

    Performance get(Long id);
}
