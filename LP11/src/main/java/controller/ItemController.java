package controller;

import model.bean.Item;
import model.dao.ItemDAO;

import java.util.List;

public class ItemController {
    ItemDAO itemDAO = new ItemDAO();
    public List<Item> listAll(Long id){return itemDAO.listAll(id);}
    public Item getById(Long id){return itemDAO.getById(id);}
    public void insertItem(Item item){itemDAO.insertItem(item);}
    public void updateItem(Item item){itemDAO.updateItem(item);}
    public void deleteById(Long id){itemDAO.deleteById(id);}
}
