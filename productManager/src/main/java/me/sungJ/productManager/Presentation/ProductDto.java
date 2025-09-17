package me.sungJ.productManager.Presentation;

import jakarta.validation.constraints.NotNull;

public class ProductDto {
    private Long id;
    private String name;
    private Integer price;
    private Integer amount;


    //setter
    public void setId(Long id) {
        this.id = id;
    }

    @NotNull
    public void setName(String name) {
        this.name = name;
    }

    @NotNull
    public void setPrice(Integer price) {
        this.price = price;
    }

    @NotNull
    public void setAmount(Integer amount) {
        this.amount = amount;
    }


    //getter
    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Integer getPrice() {
        return price;
    }

    public Integer getAmount() {
        return amount;
    }
}
