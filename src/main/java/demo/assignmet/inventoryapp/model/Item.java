package demo.assignmet.inventoryapp.model;

import javax.persistence.*;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import java.io.Serializable;

@Entity
@Table(name = "item")
public class Item implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id; //item no.

    @Min(0)
    private Integer quantity = 0;// TODO: consider moving to the SQL layer
    private String name; // item name
    private String description; // item description

    @Column(unique = true)
    @NotEmpty
    private String inventoryCode; // inventory code

    public Item(){
    }

    public Item(String _name, String _description, String _inventoryCode)
    {
        name = _name;
        description = _description;
        inventoryCode = _inventoryCode;
    }

    public long getId() {
        return id;
    }

    @Column(name = "name", nullable = false)
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }

    public void setInventoryCode(String inventoryCode) {
        this.inventoryCode = inventoryCode;
    }

    public String getInventoryCode() {
        return inventoryCode;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }
}
