package demo.assignmet.inventoryapp.repository;

import demo.assignmet.inventoryapp.model.Item;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ItemRepository extends JpaRepository<Item, Long> {
    Optional<Item> findByInventoryCode(String inventoryCode);
}
