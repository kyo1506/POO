package model.dao;

import connection.ConnectionFactory;
import model.bean.Historico;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.Query;
import java.util.List;

public class HistoricoDAO {
    public List<Historico> getById(Long id) {
        EntityManager entityManager = new ConnectionFactory().getConnection();
        try {
            Query query = entityManager.createNativeQuery("SELECT * FROM historico WHERE produto_id = ?", Historico.class);
            query.setParameter(1, id);
            return (List<Historico>) query.getResultList();
        }catch (NoResultException ex){
            ex.printStackTrace();
        }catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            entityManager.close();
        }
        return null;
    }
    public Boolean insertHistorico(Historico historico) {
        EntityManager entityManager = new ConnectionFactory().getConnection();
        try {
            entityManager.getTransaction().begin();
            Query query = entityManager.createNativeQuery("INSERT INTO historico (produto_id, status, qtdSolicitada, qtdAtual, dtInclusao) VALUES(?,?,?,?,NOW())", Historico.class);
            query.setParameter(1, historico.getProduto().getId());
            query.setParameter(2, historico.getStatusHistorico().ordinal());
            query.setParameter(3, historico.getQtdSolicitada());
            query.setParameter(4, historico.getQtdAtual());
            query.executeUpdate();
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
