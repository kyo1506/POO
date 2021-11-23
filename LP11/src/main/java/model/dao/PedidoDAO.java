package model.dao;

import connection.ConnectionFactory;
import model.bean.Pedido;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.Query;
import java.util.List;

public class PedidoDAO {
    public List<Pedido> getById(Long id) {
        EntityManager entityManager = new ConnectionFactory().getConnection();
        try {
            Query query = entityManager.createNativeQuery("SELECT * FROM pedido WHERE cliente_id = ?", Pedido.class);
            query.setParameter(1, id);
            return (List<Pedido>) query.getResultList();
        }catch (NoResultException ex){
            ex.printStackTrace();
        }catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            entityManager.close();
        }
        return null;
    }
    public Pedido getPedido(Long id){
        EntityManager entityManager = new ConnectionFactory().getConnection();
        try {
            Query query = entityManager.createNativeQuery("SELECT * FROM pedido WHERE id = ?", Pedido.class);
            query.setParameter(1, id);
            return (Pedido) query.getSingleResult();
        }catch (NoResultException ex){
            ex.printStackTrace();
        }catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            entityManager.close();
        }
        return null;
    }
    public Boolean insertPedido(Pedido pedido) {
        EntityManager entityManager = new ConnectionFactory().getConnection();
        try {
            entityManager.getTransaction().begin();
            entityManager.persist(pedido);
            entityManager.getTransaction().commit();
            return true;
        } catch (Exception ex) {
            entityManager.getTransaction().rollback();
        } finally {
            entityManager.close();
        }
        return false;
    }
    public Boolean updatePedido(Pedido pedido) {
        EntityManager entityManager = new ConnectionFactory().getConnection();
        try {
            entityManager.getTransaction().begin();
            entityManager.merge(pedido);
            entityManager.getTransaction().commit();
            return true;
        } catch (Exception ex) {
            entityManager.getTransaction().rollback();
        } finally {
            entityManager.close();
        }
        return false;
    }
}
