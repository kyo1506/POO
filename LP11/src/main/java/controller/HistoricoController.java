package controller;

import model.bean.Historico;
import model.dao.HistoricoDAO;

import java.util.List;

public class HistoricoController {
    HistoricoDAO historicoDAO = new HistoricoDAO();
    public List<Historico> getById(Long id){return historicoDAO.getById(id);}
    public void insertHistorico(Historico historico){historicoDAO.insertHistorico(historico);}
}
