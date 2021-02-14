package demo.assignmet.inventoryapp.service;

import demo.assignmet.inventoryapp.model.Item;
import org.springframework.stereotype.Service;

import java.util.List;


public interface ItemService {
    public List<Item> getAllItems();
    public Item getItemById(Long id);
    public Item addItem(Item item);
    public Item depositItem(Long id, Integer deposit);
    public void removeItem(Long id);
    public boolean itemExists(Long id);
    public boolean itemExists(String inventoryCode);
}
