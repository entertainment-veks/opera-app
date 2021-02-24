package opera.app.dao.impl;

import opera.app.dao.StageDao;
import opera.app.exception.DataProcessingException;
import opera.app.model.Stage;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class StageDaoImpl implements StageDao {
    private SessionFactory sessionFactory;

    @Autowired
    public StageDaoImpl(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public Stage add(Stage stage) {
        Transaction transaction = null;
        Session session = null;
        try {
            session = sessionFactory.openSession();
            transaction = session.beginTransaction();
            session.save(stage);
            transaction.commit();
            return stage;
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            throw new DataProcessingException("Can't insert Stage entity " + stage, e);
        } finally {
            if (session != null) {
                session.close();
            }
        }
    }

    @Override
    public List<Stage> getAll() {
        try (Session session = sessionFactory.openSession()) {
            Query<Stage> query = session.createQuery("from Stage", Stage.class);
            return query.getResultList();
        } catch (Exception e) {
            throw new DataProcessingException("Can't get all Stage", e);
        }
    }

    @Override
    public Stage get(Long id) {
        try (Session session = sessionFactory.openSession()) {
            return session.get(Stage.class, id);
        } catch (Exception e) {
            throw new DataProcessingException("Can't find Stage by id: " + id, e);
        }
    }
}
