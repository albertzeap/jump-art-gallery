package com.cognixia.jump.model;

import java.io.Serializable;
import java.time.LocalDate;
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

@Entity
public class Order implements Serializable {
    
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @NotBlank
    @Min(0)
    @Column(nullable = false)
    private Double price;

    @NotBlank
    @Column(nullable = false)
    private LocalDate orderDate;

    @JsonProperty(access = Access.WRITE_ONLY)
    @OneToMany(mappedBy = "order", cascade = CascadeType.ALL)
    private List<CatalogOrder> catalogOrder;

    @JsonProperty(access = Access.WRITE_ONLY)
    @OneToMany(mappedBy = "order", cascade = CascadeType.ALL)
    private List<CustomerOrder> customerOrder;

    public Order() {

    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public LocalDate getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(LocalDate orderDate) {
        this.orderDate = orderDate;
    }

    public List<CatalogOrder> getCatalogOrder() {
        return catalogOrder;
    }

    public void setCatalogOrder(List<CatalogOrder> catalogOrder) {
        this.catalogOrder = catalogOrder;
    }

    public List<CustomerOrder> getCustomerOrder() {
        return customerOrder;
    }

    public void setCustomerOrder(List<CustomerOrder> customerOrder) {
        this.customerOrder = customerOrder;
    }

    @Override
    public String toString() {
        return "Order [id=" + id + ", price=" + price + ", orderDate=" + orderDate + ", catalogOrder=" + catalogOrder
                + ", customerOrder=" + customerOrder + "]";
    }

    
    

    

}
