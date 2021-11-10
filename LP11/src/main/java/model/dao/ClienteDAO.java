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
<<<<<<< HEAD
            return (Optional<Cliente>) entityManager.createNativeQuery("SELECT * FROM cliente WHERE id = ?").setParameter(1, id).getSingleResult();
=======
            return (Optional<Cliente>) entityManager.createNativeQuery("SELECT * FROM cliente c WHERE c.id = ?").setParameter(1, id).getSingleResult();
>>>>>>> origin/main
        }catch (Exception ex){
            return null;
        }finally {
            entityManager.close();
        }
    }
<<<<<<< HEAD
=======
    public Optional<Cliente> getById(Long id, EntityManager entityManager) {
        try {
            return (Optional<Cliente>) entityManager.createNativeQuery("SELECT * FROM cliente c WHERE c.id = ?").setParameter(1, id).getSingleResult();
        }catch (Exception ex){
            return null;
        }
    }
>>>>>>> origin/main
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
<<<<<<< HEAD
=======
    public void deleteById (Long id) {
        EntityManager entityManager = new ConnectionFactory().getConnection();
        Optional<Cliente> cliente = getById(id, entityManager);
        if(cliente.isPresent()){
            try{
                entityManager.getTransaction().begin();
                entityManager.remove(cliente);
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
>>>>>>> origin/main
}
