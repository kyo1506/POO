package controller;

import model.bean.Item;
import model.dao.ItemDAO;

import java.util.List;

public class ItemController {
    ItemDAO itemDAO = new ItemDAO();
    public List<Item> listAll(Long id){return itemDAO.listAll(id);}
    public Item getById(Long id){return itemDAO.getById(id);}
    public Boolean insertItem(Item item){return itemDAO.insertItem(item);}
    public Boolean updateItem(Item item){return itemDAO.updateItem(item);}
    public Boolean deleteById(Long id){return itemDAO.deleteById(id);}
}
