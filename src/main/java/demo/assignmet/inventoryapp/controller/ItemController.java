package demo.assignmet.inventoryapp.controller;

import demo.assignmet.inventoryapp.exception.InvalidTransactionArgumentException;
import demo.assignmet.inventoryapp.model.Item;
import demo.assignmet.inventoryapp.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/inventory")
public class ItemController {
    // all business logic done in service layer
    private final ItemService itemService;

    @Autowired
    public ItemController(ItemService itemService) {
       this.itemService = itemService;
    }

    @GetMapping
    public List<Item> findAll(){
        return itemService.getAllItems();
    }

    @GetMapping("item/{id}")
    @ResponseStatus(HttpStatus.FOUND)
    public Item getItem(@PathVariable("id") Long id){
        return itemService.getItemById(id);
    }

    @PostMapping("item/add")
    @ResponseStatus(HttpStatus.CREATED)
    public Item addItem(@Valid @RequestBody Item item){
        return itemService.addItem(item);
    }



    @PutMapping(value = {"item/deposit/{id}"})
    public Item depositItem(@PathVariable("id") Long id,@RequestParam Integer n){
        if(n > 0)
            return itemService.depositItem(id, n);
        else
            throw new InvalidTransactionArgumentException();
    }

    @PutMapping(value = {"item/withdraw/{id}"})
    public Item withdrawItem(@PathVariable("id") Long id, @RequestParam Integer n){
        if(n > 0)
            return itemService.depositItem(id, (-n));//withdraw is a negative deposit
        else
            throw new InvalidTransactionArgumentException();
    }

    @DeleteMapping("item/remove/{id}")
    public void removeItem(@PathVariable("id") Long id) {
        itemService.removeItem(id);
    }
}
