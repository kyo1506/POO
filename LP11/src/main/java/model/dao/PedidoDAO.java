package model.dao;

import connection.ConnectionFactory;
import model.bean.Pedido;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.util.List;

public class PedidoDAO {
    public List<Pedido> getById(Long id) {
        EntityManager entityManager = new ConnectionFactory().getConnection();
        try {
            Query query = entityManager.createNativeQuery("SELECT * FROM pedido WHERE cliente_id = ?", Pedido.class);
            query.setParameter(1, id);
            return (List<Pedido>) query.getResultList();
        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            entityManager.close();
        }
        return null;
    }
    public void insertPedido(Pedido pedido) {
        EntityManager entityManager = new ConnectionFactory().getConnection();
        try {
            entityManager.getTransaction().begin();
            entityManager.persist(pedido);
            entityManager.getTransaction().commit();
        } catch (Exception ex) {
            entityManager.getTransaction().rollback();
        } finally {
            entityManager.close();
        }
    }
    public void updatePedido(Pedido pedido) {
        EntityManager entityManager = new ConnectionFactory().getConnection();
        try {
            entityManager.getTransaction().begin();
            entityManager.merge(pedido);
            entityManager.getTransaction().commit();
        } catch (Exception ex) {
            entityManager.getTransaction().rollback();
        } finally {
            entityManager.close();
        }
    }
}
