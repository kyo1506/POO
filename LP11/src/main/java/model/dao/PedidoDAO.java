package model.dao;

import connection.ConnectionFactory;
import model.bean.Historico;

import javax.persistence.EntityManager;
import java.util.List;

public class PedidoDAO {
    public List<Historico> listAll() {
        EntityManager entityManager = new ConnectionFactory().getConnection();
        try {
            return entityManager.createNativeQuery("SELECT * FROM pedido").getResultList();
        } catch (Exception ex) {
            return null;
        } finally {
            entityManager.close();
        }
    }
    public List<Historico> getById(Long id) {
        EntityManager entityManager = new ConnectionFactory().getConnection();
        try {
            return entityManager.createNativeQuery("SELECT * FROM pedido WHERE cliente_id = ?").setParameter(1, id).getResultList();
        } catch (Exception ex) {
            return null;
        } finally {
            entityManager.close();
        }
    }
    public void insertPedido(Historico historico) {
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
    public void updatePedido(Historico historico) {
        EntityManager entityManager = new ConnectionFactory().getConnection();
        try {
            entityManager.getTransaction().begin();
            entityManager.merge(historico);
            entityManager.getTransaction().commit();
        } catch (Exception ex) {
            entityManager.getTransaction().rollback();
        } finally {
            entityManager.close();
        }
    }
}
