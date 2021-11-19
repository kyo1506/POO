package controller;

import model.bean.Pedido;
import model.dao.PedidoDAO;

import java.util.List;

public class PedidoController {
    PedidoDAO pedidoDAO = new PedidoDAO();
    public List<Pedido> getById(Long id){return pedidoDAO.getById(id);}
    public Boolean insertPedido(Pedido pedido){return pedidoDAO.insertPedido(pedido);}
    public Boolean updatePedido(Pedido pedido){return pedidoDAO.updatePedido(pedido);}
}
