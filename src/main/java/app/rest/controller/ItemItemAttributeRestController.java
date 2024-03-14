package app.rest.controller;

import org.springframework.web.bind.annotation.*;
import app.rest.entity.ItemItemAttribute;
import app.rest.repository.ItemItemAttributeRepository;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/item-item-attribute")
public class ItemItemAttributeRestController {

    private final ItemItemAttributeRepository repository;

    public ItemItemAttributeRestController(ItemItemAttributeRepository repository) {
        this.repository = repository;
    }

    @GetMapping("/all")
    public List<ItemItemAttribute> findAll() {
        return repository.findAll();
    }

    @GetMapping("/findById/{id}")
    public ItemItemAttribute findById(@PathVariable Integer id) {
        Optional<ItemItemAttribute> itemItemAttribute = repository.findById(id);
        return (itemItemAttribute.orElse(null));
    }

    @PostMapping("/save")
    public ItemItemAttribute save(@RequestBody ItemItemAttribute itemItemAttribute) {
        return repository.save(itemItemAttribute);
    }


}
