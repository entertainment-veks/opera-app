package opera.app.service;

import java.time.LocalDate;
import java.util.List;
import opera.app.model.PerformanceSession;

public interface PerformanceSessionService {
    List<PerformanceSession> findAvailableSessions(Long performanceId, LocalDate date);

    PerformanceSession add(PerformanceSession session);

    PerformanceSession get(Long id);

    PerformanceSession update(PerformanceSession performanceSession);

    boolean delete(Long id);
}
