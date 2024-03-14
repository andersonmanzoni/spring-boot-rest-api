package app.rest.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "item_item_atribute") // I kept the wrong name "atribute" as was created in the db script
public class ItemItemAttribute {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "item_id")
    private Item item;

    @ManyToOne
    @JoinColumn(name = "item_attribute_id")
    private ItemAttribute itemAttribute;

    @Column(name = "value", length = 50)
    private String value;

    public ItemItemAttribute() {
    }

    public ItemItemAttribute(Item item, ItemAttribute attribute, String value) {
        this.item = item;
        this.itemAttribute = attribute;
        this.value = value;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Item getItem() {
        return item;
    }

    public void setItem(Item item) {
        this.item = item;
    }

    public ItemAttribute getItemAttribute() {
        return itemAttribute;
    }

    public void setItemAttribute(ItemAttribute itemAttribute) {
        this.itemAttribute = itemAttribute;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }
}
