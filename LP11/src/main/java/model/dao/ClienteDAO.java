package model.dao;

import connection.ConnectionFactory;
import model.bean.Cliente;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.util.List;

public class ClienteDAO {
    public List<Cliente> listAll()  {
        EntityManager entityManager = new ConnectionFactory().getConnection();
        try {
            Query query = entityManager.createNativeQuery("SELECT * FROM cliente", Cliente.class);
            return (List<Cliente>) query.getResultList();
        }catch (Exception ex){
            ex.printStackTrace();
        }finally {
            entityManager.close();
        }
        return null;
    }
    public Cliente getById(Long id) {
        EntityManager entityManager = new ConnectionFactory().getConnection();
        try {
            Query query = entityManager.createNativeQuery("SELECT * FROM cliente WHERE id = ?", Cliente.class);
            query.setParameter(1, id);
            return (Cliente) query.getSingleResult();
        }catch (Exception ex){
            ex.printStackTrace();
        }finally {
            entityManager.close();
        }
        return null;
    }
    public Cliente getByEmail(String email) {
        EntityManager entityManager = new ConnectionFactory().getConnection();
        try {
            Query query = entityManager.createNativeQuery("SELECT * FROM cliente WHERE email = ?", Cliente.class);
            query.setParameter(1, email);
            return (Cliente) query.getSingleResult();
        }catch (Exception ex){
            ex.printStackTrace();
        }finally {
            entityManager.close();
        }
        return null;
    }
    public void insertCliente (Cliente cliente) {
        EntityManager entityManager = new ConnectionFactory().getConnection();
        try{
            entityManager.getTransaction().begin();
            entityManager.persist(cliente);
            entityManager.getTransaction().commit();
        }
        catch(Exception ex)
        {
            entityManager.getTransaction().rollback();
        }finally {
            entityManager.close();
        }
    }
    public void updateCliente (Cliente cliente) {
        EntityManager entityManager = new ConnectionFactory().getConnection();
        try{
            entityManager.getTransaction().begin();
            entityManager.merge(cliente);
            entityManager.getTransaction().commit();
        }
        catch(Exception ex)
        {
            entityManager.getTransaction().rollback();
        }finally {
            entityManager.close();
        }
    }
}
