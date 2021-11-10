package model.dao;

import connection.ConnectionFactory;
import model.bean.Item;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.util.List;

public class ItemDAO {
    public List<Item> listAll(Long id) {
        EntityManager entityManager = new ConnectionFactory().getConnection();
        try {
            Query query = entityManager.createNativeQuery("SELECT * FROM item WHERE pedido_id = ?", Item.class);
            query.setParameter(1, id);
            return (List<Item>) query.getResultList();
        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            entityManager.close();
        }
        return null;
    }
    public Item getById(Long id) {
        EntityManager entityManager = new ConnectionFactory().getConnection();
        try {
            Query query = entityManager.createNativeQuery("SELECT * FROM item WHERE id = ?", Item.class);
            query.setParameter(1, id);
            return (Item) query.getSingleResult();
        } catch (Exception ex) {
            ex.printStackTrace();
        }finally {
            entityManager.close();
        }
        return null;
    }
    public Item getById(Long id, EntityManager entityManager) {
        try {
            Query query = entityManager.createNativeQuery("SELECT * FROM item WHERE id = ?", Item.class);
            query.setParameter(1, id);
            return (Item) query.getSingleResult();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return null;
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
        Item item = getById(id, entityManager);
        if (item != null) {
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
