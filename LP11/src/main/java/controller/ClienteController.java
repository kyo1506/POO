package controller;


import model.bean.Cliente;
import model.dao.ClienteDAO;

import java.util.List;

public class ClienteController {
    ClienteDAO clienteDAO = new ClienteDAO();
    public Boolean insertCliente (Cliente cliente) {return clienteDAO.insertCliente(cliente);}
    public Boolean updateCliente (Cliente cliente) {return clienteDAO.updateCliente(cliente);}
    public List<Cliente> listAll () {return clienteDAO.listAll();}
    public Cliente getById (Long id) {return clienteDAO.getById(id);}
    public Cliente getByEmail (String email) {return clienteDAO.getByEmail(email);}
}
