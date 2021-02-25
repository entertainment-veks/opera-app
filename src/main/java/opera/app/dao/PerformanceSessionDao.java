package opera.app.dao;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import opera.app.model.PerformanceSession;

public interface PerformanceSessionDao {
    List<PerformanceSession> findAvailableSessions(Long performanceId, LocalDate date);

    PerformanceSession add(PerformanceSession performanceSession);

    Optional<PerformanceSession> get(Long id);

    PerformanceSession update(PerformanceSession performanceSession);

    boolean delete(Long id);
}
