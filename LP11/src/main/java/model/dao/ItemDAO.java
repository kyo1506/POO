package model.dao;

import connection.ConnectionFactory;
import model.bean.Item;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.Query;
import javax.transaction.Transactional;
import java.util.List;

public class ItemDAO {
    public List<Item> listAll(Long id) {
        EntityManager entityManager = new ConnectionFactory().getConnection();
        try {
            Query query = entityManager.createNativeQuery("SELECT * FROM item WHERE pedido_id = ?", Item.class);
            query.setParameter(1, id);
            return (List<Item>) query.getResultList();
        }catch (NoResultException ex){
            ex.printStackTrace();
        }catch (Exception ex) {
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
        }catch (NoResultException ex){
            ex.printStackTrace();
        }catch (Exception ex) {
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
        }catch (NoResultException ex){
            ex.printStackTrace();
        }catch (Exception ex) {
            ex.printStackTrace();
        }
        return null;
    }

    public Boolean insertItem(Item item) {
        EntityManager entityManager = new ConnectionFactory().getConnection();
        try {
            entityManager.getTransaction().begin();
            entityManager.merge(item);
            entityManager.getTransaction().commit();
            return true;
        } catch (Exception ex) {
            entityManager.getTransaction().rollback();
        } finally {
            entityManager.close();
        }
        return false;
    }
    public Boolean updateItem(Item item) {
        EntityManager entityManager = new ConnectionFactory().getConnection();
        try {
            entityManager.getTransaction().begin();
            entityManager.merge(item);
            entityManager.getTransaction().commit();
            return true;
        } catch (Exception ex) {
            entityManager.getTransaction().rollback();
        } finally {
            entityManager.close();
        }
        return false;
    }
    public Boolean deleteById(Long id) {
        EntityManager entityManager = new ConnectionFactory().getConnection();
        Item item = getById(id, entityManager);
        if (item != null) {
            try {
                entityManager.getTransaction().begin();
                entityManager.remove(item);
                entityManager.getTransaction().commit();
                return true;
            } catch (Exception ex) {
                entityManager.getTransaction().rollback();
            } finally {
                entityManager.close();
            }
        }
        return false;
    }
}
