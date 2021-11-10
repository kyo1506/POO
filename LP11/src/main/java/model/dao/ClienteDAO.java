package model.dao;

import connection.ConnectionFactory;
import model.bean.Cliente;

import javax.persistence.EntityManager;
import java.util.List;
import java.util.Optional;

public class ClienteDAO {
    public List<Cliente> listAll()  {
        EntityManager entityManager = new ConnectionFactory().getConnection();
        try {
            return entityManager.createNativeQuery("SELECT * FROM cliente").getResultList();
        }catch (Exception ex){
            return null;
        }finally {
            entityManager.close();
        }
    }
    public Optional<Cliente> getById(Long id) {
        EntityManager entityManager = new ConnectionFactory().getConnection();
        try {
            return (Optional<Cliente>) entityManager.createNativeQuery("SELECT * FROM cliente WHERE id = ?").setParameter(1, id).getSingleResult();
        }catch (Exception ex){
            return null;
        }finally {
            entityManager.close();
        }
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
