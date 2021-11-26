package model.dao;

import connection.ConnectionFactory;
import model.bean.Produto;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.Query;
import java.util.List;

public class ProdutoDAO {
    public List<Produto> listAll()  {
        EntityManager entityManager = new ConnectionFactory().getConnection();
        try {
            Query query = entityManager.createNativeQuery("SELECT * FROM produto", Produto.class);
            return (List<Produto>) query.getResultList();
        }catch (NoResultException ex){
            ex.printStackTrace();
        }catch (Exception ex){
            ex.printStackTrace();
        }finally {
            entityManager.close();
        }
        return null;
    }
    public List<Produto> listAllActives()  {
        EntityManager entityManager = new ConnectionFactory().getConnection();
        try {
            Query query = entityManager.createNativeQuery("SELECT * FROM produto WHERE status = 1", Produto.class);
            return (List<Produto>) query.getResultList();
        }catch (NoResultException ex){
            ex.printStackTrace();
        }catch (Exception ex){
            ex.printStackTrace();
        }finally {
            entityManager.close();
        }
        return null;
    }
    public Produto getById(Long id) {
        EntityManager entityManager = new ConnectionFactory().getConnection();
        try {
            Query query = entityManager.createNativeQuery("SELECT * FROM produto WHERE id = ?", Produto.class);
            query.setParameter(1, id);
            return (Produto) query.getSingleResult();
        }catch (NoResultException ex){
            ex.printStackTrace();
        }catch (Exception ex){
            ex.printStackTrace();
        }finally {
            entityManager.close();
        }
        return null;
    }
    public Boolean insertProduto (Produto produto) {
        EntityManager entityManager = new ConnectionFactory().getConnection();
        try{
            entityManager.getTransaction().begin();
            Query query = entityManager.createNativeQuery("INSERT INTO produto (descricao, status, preco, qtd, dtInclusao) VALUES (?, ?, ?, ?, NOW())", Produto.class);
            query.setParameter(1, produto.getDescricao());
            query.setParameter(2, produto.getStatusAtivo().ordinal());
            query.setParameter(3, produto.getPreco());
            query.setParameter(4, produto.getQtd());
            query.executeUpdate();
            entityManager.getTransaction().commit();
            return true;
        }
        catch(Exception ex)
        {
            entityManager.getTransaction().rollback();
        }finally {
            entityManager.close();
        }
        return false;
    }
    public Boolean updateProduto (Produto produto) {
        EntityManager entityManager = new ConnectionFactory().getConnection();
        try{
            entityManager.getTransaction().begin();
            entityManager.merge(produto);
            entityManager.getTransaction().commit();
            return true;
        }
        catch(Exception ex)
        {
            entityManager.getTransaction().rollback();
        }finally {
            entityManager.close();
        }
        return false;
    }
}
