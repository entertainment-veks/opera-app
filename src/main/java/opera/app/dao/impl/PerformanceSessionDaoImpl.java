package opera.app.dao.impl;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import opera.app.dao.PerformanceSessionDao;
import opera.app.exception.DataProcessingException;
import opera.app.model.PerformanceSession;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class PerformanceSessionDaoImpl implements PerformanceSessionDao {
    private SessionFactory sessionFactory;

    @Autowired
    public PerformanceSessionDaoImpl(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public List<PerformanceSession> findAvailableSessions(Long performanceId, LocalDate date) {
        try (Session session = sessionFactory.openSession()) {
            Query<PerformanceSession> query = session.createQuery("from PerformanceSession"
                    + " WHERE performanceId.id = :performanceId"
                    + " AND DATE_FORMAT(showTime, '%Y-%m-%d') = :date",
                    PerformanceSession.class);
            query.setParameter("performanceId", performanceId);
            query.setParameter("date", date.toString());
            return query.getResultList();
        } catch (Exception e) {
            throw new DataProcessingException("Can't find Performance session by params: "
                    + "\n" + performanceId + "\n" + date.toString(), e);
        }
    }

    @Override
    public PerformanceSession add(PerformanceSession performanceSession) {
        Transaction transaction = null;
        Session session = null;
        try {
            session = sessionFactory.openSession();
            transaction = session.beginTransaction();
            session.save(performanceSession);
            transaction.commit();
            return performanceSession;
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            throw new DataProcessingException("Can't insert Performance session entity "
                    + performanceSession, e);
        } finally {
            if (session != null) {
                session.close();
            }
        }
    }

    @Override
    public Optional<PerformanceSession> get(Long id) {
        try (Session session = sessionFactory.openSession()) {
            return Optional.ofNullable(session.get(PerformanceSession.class, id));
        } catch (Exception e) {
            throw new DataProcessingException("Can't get Performance session by id: " + id, e);
        }
    }

    @Override
    public PerformanceSession update(PerformanceSession performanceSession) {
        Transaction transaction = null;
        Session session = null;
        try {
            session = sessionFactory.openSession();
            transaction = session.beginTransaction();
            session.update(performanceSession);
            transaction.commit();
            return performanceSession;
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            throw new DataProcessingException("Can't update Performance session entity "
                    + performanceSession, e);
        } finally {
            if (session != null) {
                session.close();
            }
        }
    }

    @Override
    public boolean delete(Long id) {
        try (Session session = sessionFactory.openSession()) {
            Query<PerformanceSession> query = session.createQuery("delete from PerformanceSession"
                            + " WHERE id = :id", PerformanceSession.class);
            query.setParameter("id", id);
            return true;
        } catch (Exception e) {
            throw new DataProcessingException("Can't delete Performance session by id: " + id, e);
        }
    }
}
