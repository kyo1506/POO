package controller;

import model.bean.Pedido;
import model.dao.PedidoDAO;

import java.util.List;

public class PedidoController {
    PedidoDAO pedidoDAO = new PedidoDAO();
    public List<Pedido> getById(Long id){return pedidoDAO.getById(id);}
    public void insertPedido(Pedido pedido){pedidoDAO.insertPedido(pedido);}
    public void updatePedido(Pedido pedido){pedidoDAO.updatePedido(pedido);}
}
