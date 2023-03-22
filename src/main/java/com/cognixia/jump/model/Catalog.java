package com.cognixia.jump.model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonProperty.Access;

/*
 * This class/entity describes the art catalog which are the art pieces being
 * sold through the online store. Relates to orders
 */

@Entity
public class Catalog implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @NotBlank
    @Column(nullable = false)
    private String name;

    @NotBlank
    @Min(0)
    @Column(nullable = false)
    private Double price;

    @JsonProperty(access = Access.WRITE_ONLY)
    @OneToMany(mappedBy = "catalog", cascade = CascadeType.ALL)
    private List<CatalogOrder> catalogOrder;

    public Catalog() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public List<CatalogOrder> getCatalogOrder() {
        return catalogOrder;
    }

    public void setCatalogOrder(List<CatalogOrder> catalogOrder) {
        this.catalogOrder = catalogOrder;
    }

    @Override
    public String toString() {
        return "Catalog [id=" + id + ", name=" + name + ", price=" + price + ", catalogOrder=" + catalogOrder + "]";
    }

    

    

}
