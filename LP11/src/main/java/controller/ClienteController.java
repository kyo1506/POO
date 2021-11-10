package controller;


import model.bean.Cliente;
import model.dao.ClienteDAO;

import java.util.List;
import java.util.Optional;

public class ClienteController {
    ClienteDAO clienteDAO = new ClienteDAO();
    public void insertCliente (Cliente cliente) {clienteDAO.insertCliente(cliente);}
    public void updateCliente (Cliente cliente) {clienteDAO.updateCliente(cliente);}
    public List<Cliente> listAll () {return clienteDAO.listAll();}
    public Optional<Cliente> getById (Long id) {return clienteDAO.getById(id);}
}
