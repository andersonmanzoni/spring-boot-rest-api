package app.rest.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "item")
public class Item {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column(name = "sku", length = 50)
    private String sku;

    @Column(name = "description")
    private String description;

    @Column(name = "external_product_number", length = 50)
    private String externalProductNumber;

    @Column(name = "external_reference_sku", length = 15)
    private String externalReferenceSku;

    @Column(name = "available")
    private Double available;

    @OneToMany(mappedBy = "item")
    @JsonIgnore
    private List<ItemItemAttribute> itemItemAttributes = new ArrayList<>();

    public Item() {
    }

    public Item(String sku, String description, String externalProductNumber, String externalReferenceSku, Double available) {
        this.sku = sku;
        this.description = description;
        this.externalProductNumber = externalProductNumber;
        this.externalReferenceSku = externalReferenceSku;
        this.available = available;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getSku() {
        return sku;
    }

    public void setSku(String sku) {
        this.sku = sku;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getExternalProductNumber() {
        return externalProductNumber;
    }

    public void setExternalProductNumber(String externalProductNumber) {
        this.externalProductNumber = externalProductNumber;
    }

    public String getExternalReferenceSku() {
        return externalReferenceSku;
    }

    public void setExternalReferenceSku(String externalReferenceSku) {
        this.externalReferenceSku = externalReferenceSku;
    }

    public Double getAvailable() {
        return available;
    }

    public void setAvailable(Double available) {
        this.available = available;
    }

    public List<ItemItemAttribute> getItemItemAttributes() {
        return itemItemAttributes;
    }

    public void setItemItemAttributes(List<ItemItemAttribute> itemItemAttributes) {
        this.itemItemAttributes = itemItemAttributes;
    }
}
