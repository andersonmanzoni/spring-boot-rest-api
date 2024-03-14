package app.rest.controller;

import app.rest.entity.Item;
import org.springframework.web.bind.annotation.*;
import app.rest.repository.ItemRepository;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/item")
public class ItemRestController {

    private final ItemRepository repository;

    public ItemRestController(ItemRepository repository) {
        this.repository = repository;
    }

    @GetMapping("/all")
    public List<Item> findAll() {
        return repository.findAll();
    }

    @GetMapping("/findById/{id}")
    public Item findById(@PathVariable Integer id) {
        Optional<Item> item = repository.findById(id);
        return (item.orElse(null));
    }

    @GetMapping("/findBySku/{sku}")
    public Item findBySku(@PathVariable String sku) {
        return repository.findBySku(sku);
    }

    @PostMapping("/save")
    public Item save(@RequestBody Item item) {
        return repository.save(item);
    }

}

