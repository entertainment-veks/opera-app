package opera.app.dao.impl;

import java.util.List;
import javax.persistence.criteria.CriteriaQuery;
import opera.app.dao.PerformanceDao;
import opera.app.exception.DataProcessingException;
import opera.app.model.Performance;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class PerformanceDaoImpl implements PerformanceDao {
    private SessionFactory sessionFactory;

    @Autowired
    public PerformanceDaoImpl(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public Performance add(Performance performance) {
        Transaction transaction = null;
        Session session = null;
        try {
            session = sessionFactory.openSession();
            transaction = session.beginTransaction();
            session.save(performance);
            transaction.commit();
            return performance;
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            throw new DataProcessingException("Can't insert Performance entity " + performance, e);
        } finally {
            if (session != null) {
                session.close();
            }
        }
    }

    @Override
    public List<Performance> getAll() {
        try (Session session = sessionFactory.openSession()) {
            CriteriaQuery<Performance> criteriaQuery = session.getCriteriaBuilder()
                    .createQuery(Performance.class);
            criteriaQuery.from(Performance.class);
            return session.createQuery(criteriaQuery).getResultList();
        } catch (Exception e) {
            throw new DataProcessingException("Can't get all", e);
        }
    }

    @Override
    public Performance get(Long id) {
        try (Session session = sessionFactory.openSession()) {
            return session.get(Performance.class, id);
        } catch (Exception e) {
            throw new DataProcessingException("Can't find Performance by id: " + id, e);
        }
    }
}
