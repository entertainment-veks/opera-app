package hibernate.dao.impl;

import hibernate.dao.TicketDao;
import hibernate.exception.DataProcessingException;
import hibernate.lib.Dao;
import hibernate.model.Ticket;
import hibernate.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;

@Dao
public class TicketDaoImpl implements TicketDao {
    @Override
    public Ticket add(Ticket ticket) {
        Transaction transaction = null;
        Session session = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            transaction = session.beginTransaction();
            session.save(ticket);
            transaction.commit();
            return ticket;
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            throw new DataProcessingException("Can't insert Ticket entity " + ticket, e);
        } finally {
            if (session != null) {
                session.close();
            }
        }
    }
}
