package model.dao;

import connection.ConnectionFactory;
import model.bean.Item;

import javax.persistence.EntityManager;
import java.util.List;
import java.util.Optional;

public class ItemDAO {
    public List<Item> listAll(Long id) {
        EntityManager entityManager = new ConnectionFactory().getConnection();
        try {
            return entityManager.createNativeQuery("SELECT * FROM item WHERE pedido_id = ?").setParameter(1, id).getResultList();
        } catch (Exception ex) {
            return null;
        } finally {
            entityManager.close();
        }
    }
    public Optional<Item> getById(Long id, EntityManager entityManager) {
        try {
            return (Optional<Item>) entityManager.createNativeQuery("SELECT * FROM item WHERE id = ?").setParameter(1, id).getSingleResult();
        } catch (Exception ex) {
            return null;
        }
    }
    public void insertItem(Item item) {
        EntityManager entityManager = new ConnectionFactory().getConnection();
        try {
            entityManager.getTransaction().begin();
            entityManager.persist(item);
            entityManager.getTransaction().commit();
        } catch (Exception ex) {
            entityManager.getTransaction().rollback();
        } finally {
            entityManager.close();
        }
    }
    public void updateItem(Item item) {
        EntityManager entityManager = new ConnectionFactory().getConnection();
        try {
            entityManager.getTransaction().begin();
            entityManager.merge(item);
            entityManager.getTransaction().commit();
        } catch (Exception ex) {
            entityManager.getTransaction().rollback();
        } finally {
            entityManager.close();
        }
    }
    public void deleteById(Long id) {
        EntityManager entityManager = new ConnectionFactory().getConnection();
        Optional<Item> item = getById(id, entityManager);
        if (item.isPresent()) {
            try {
                entityManager.getTransaction().begin();
                entityManager.remove(item);
                entityManager.getTransaction().commit();
            } catch (Exception ex) {
                entityManager.getTransaction().rollback();
            } finally {
                entityManager.close();
            }
        }
    }
}
