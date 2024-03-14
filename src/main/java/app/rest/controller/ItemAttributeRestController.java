package app.rest.controller;

import app.rest.entity.ItemAttribute;
import org.springframework.web.bind.annotation.*;
import app.rest.repository.ItemAttributeRepository;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/item-attribute")
public class ItemAttributeRestController {

    private final ItemAttributeRepository repository;

    public ItemAttributeRestController(ItemAttributeRepository repository) {
        this.repository = repository;
    }

    @GetMapping("/all")
    public List<ItemAttribute> findAll() {
        return repository.findAll();
    }

    @GetMapping("/findById/{id}")
    public ItemAttribute findById(@PathVariable Integer id) {
        Optional<ItemAttribute> itemAttribute = repository.findById(id);
        return (itemAttribute.orElse(null));
    }

    @PostMapping("/save")
    public ItemAttribute save(@RequestBody ItemAttribute itemAttribute) {
        return repository.save(itemAttribute);
    }

}
