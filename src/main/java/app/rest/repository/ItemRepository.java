package app.rest.repository;

import app.rest.entity.Item;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ItemRepository extends JpaRepository<Item, Integer> {

    public Item findBySku(String sku);

}
