package controller;

import model.bean.Produto;
import model.dao.ProdutoDAO;

import java.util.List;

public class ProdutoController {
    ProdutoDAO produtoDAO = new ProdutoDAO();
    public List<Produto> listAll(){return produtoDAO.listAll();}
    public List<Produto> listAllActives(){return produtoDAO.listAllActives();}
    public Produto getById(Long id){return produtoDAO.getById(id);}
    public Boolean insertProduto(Produto produto){return produtoDAO.insertProduto(produto);}
    public Boolean updateProduto(Produto produto){return produtoDAO.updateProduto(produto);}
}
