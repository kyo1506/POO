package model.dao;

import connection.ConnectionFactory;
import model.bean.Historico;

import javax.persistence.EntityManager;
import java.util.List;

public class HistoricoDAO {
    public List<Historico> listAll() {
        EntityManager entityManager = new ConnectionFactory().getConnection();
        try {
            return entityManager.createNativeQuery("SELECT * FROM historico").getResultList();
        } catch (Exception ex) {
            return null;
        } finally {
            entityManager.close();
        }
    }
    public List<Historico> getById(Long id) {
        EntityManager entityManager = new ConnectionFactory().getConnection();
        try {
            return entityManager.createNativeQuery("SELECT * FROM historico WHERE produto_id = ?").setParameter(1, id).getResultList();
        } catch (Exception ex) {
            return null;
        } finally {
            entityManager.close();
        }
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
