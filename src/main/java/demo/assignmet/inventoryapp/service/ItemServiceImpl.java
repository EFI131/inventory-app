package demo.assignmet.inventoryapp.service;

import demo.assignmet.inventoryapp.exception.ExistingInventoryCodeException;
import demo.assignmet.inventoryapp.exception.ItemNotFoundException;
import demo.assignmet.inventoryapp.exception.WithdrawalExceedingBalanceException;
import demo.assignmet.inventoryapp.model.Item;
import demo.assignmet.inventoryapp.repository.ItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ItemServiceImpl implements ItemService {
    private ItemRepository itemRepository;

    @Autowired
    public ItemServiceImpl(ItemRepository itemRepository) {
        this.itemRepository = itemRepository;
    }

    @Override
    public List<Item> getAllItems() {
        return itemRepository.findAll();
    }

    @Override
    public Item getItemById(Long id) {
        return itemRepository.findById(id)
                .orElseThrow(ItemNotFoundException::new);
    }

    // TODO: CONSIDER RETURNING THE NEWLY ADDED ITEM
    // TODO: RETURN A ENUM DESCRIBING SUCCESS OR FAILURE REASON
    // TODO: CONSIDER CHANGING RESPONSE TO ResponseEntity<?> and return accordingly
    @Override
    public Item addItem(Item item) {
        if(itemExists(item.getInventoryCode()))
            throw new ExistingInventoryCodeException();

        return itemRepository.save(item);
    }

    @Override
    public void removeItem(Long id) {
        if(!itemExists(id))
            throw new ItemNotFoundException();

        itemRepository.deleteById(id);
    }

    // WILL BE USED BOTH FOR WITHDRAW(-) AND DEPOSIT(+)
    @Override
    public Item depositItem(Long id, Integer quantity) {
        Item item = itemRepository.findById(id)
                .orElseThrow(()->new ItemNotFoundException());

        int newQuantity = item.getQuantity() + quantity;

        if((newQuantity) < 0)
            throw new WithdrawalExceedingBalanceException();

        item.setQuantity(newQuantity);
        return itemRepository.save(item);
    }

    @Override
    public boolean itemExists(Long id) {
        Optional<Item> itemById =  itemRepository.findById(id);
        if(!itemById.isPresent())
            return false;

        return true;
    }

    @Override
    public  boolean itemExists(String inventoryCode){
        Optional<Item> itemByInventoryCode =  itemRepository.findByInventoryCode(inventoryCode);
        if(!itemByInventoryCode.isPresent())
            return false;

        return true;
    }


}
