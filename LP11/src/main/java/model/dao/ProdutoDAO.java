package model.dao;

import connection.ConnectionFactory;
import model.bean.Produto;

import javax.persistence.EntityManager;
import java.util.List;
import java.util.Optional;

public class ProdutoDAO {
    public List<Produto> listAll()  {
        EntityManager entityManager = new ConnectionFactory().getConnection();
        try {
            return entityManager.createNativeQuery("SELECT * FROM produto").getResultList();
        }catch (Exception ex){
            return null;
        }finally {
            entityManager.close();
        }
    }
    public Optional<Produto> getById(Long id) {
        EntityManager entityManager = new ConnectionFactory().getConnection();
        try {
            return (Optional<Produto>) entityManager.createNativeQuery("SELECT * FROM produto WHERE id = ?").setParameter(1, id).getSingleResult();
        }catch (Exception ex){
            return null;
        }finally {
            entityManager.close();
        }
    }
    public Optional<Produto> getById(Long id, EntityManager entityManager) {
        try {
            return (Optional<Produto>) entityManager.createNativeQuery("SELECT * FROM produto WHERE id = ?").setParameter(1, id).getSingleResult();
        }catch (Exception ex){
            return null;
        }
    }
    public void insertProduto (Produto produto) {
        EntityManager entityManager = new ConnectionFactory().getConnection();
        try{
            entityManager.getTransaction().begin();
            entityManager.persist(produto);
            entityManager.getTransaction().commit();
        }
        catch(Exception ex)
        {
            entityManager.getTransaction().rollback();
        }finally {
            entityManager.close();
        }
    }
    public void updateProduto (Produto produto) {
        EntityManager entityManager = new ConnectionFactory().getConnection();
        try{
            entityManager.getTransaction().begin();
            entityManager.merge(produto);
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
