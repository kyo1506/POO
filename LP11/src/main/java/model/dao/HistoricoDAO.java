package model.dao;

import connection.ConnectionFactory;
import model.bean.Historico;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.util.List;

public class HistoricoDAO {
    public List<Historico> getById(Long id) {
        EntityManager entityManager = new ConnectionFactory().getConnection();
        try {
            Query query = entityManager.createNativeQuery("SELECT * FROM historico WHERE produto_id = ?", Historico.class);
            query.setParameter(1, id);
            return (List<Historico>) query.getResultList();
        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            entityManager.close();
        }
        return null;
    }
    public void insertHistorico(Historico historico) {
        EntityManager entityManager = new ConnectionFactory().getConnection();
        try {
            entityManager.getTransaction().begin();
            entityManager.persist(historico);
            entityManager.getTransaction().commit();
        } catch (Exception ex) {
            entityManager.getTransaction().rollback();
        } finally {
            entityManager.close();
        }
    }
}
