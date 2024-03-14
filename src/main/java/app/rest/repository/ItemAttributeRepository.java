package app.rest.repository;

import app.rest.entity.ItemAttribute;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ItemAttributeRepository extends JpaRepository<ItemAttribute, Integer> {

}
