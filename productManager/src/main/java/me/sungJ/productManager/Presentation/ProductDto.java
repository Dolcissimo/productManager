package me.sungJ.productManager.Presentation;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import me.sungJ.productManager.Domain.Product;

public class ProductDto {
    private Long id;

    @NotNull
    @Size(min =1 , max=100)
    private String name;


    @NotNull
    @Max(1_000_000) @Min(0)
    private Integer price;

    @Max(9_999) @Min(1)
    private Integer amount;

    public ProductDto() {

    }


    public ProductDto(Long id, String name, Integer price, Integer amount) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.amount = (amount==null)? 1 : amount;
    }


    //setter
    public void setId(Long id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    public void setAmount(Integer amount) {
        this.amount = (amount == null) ? 1 : amount;
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


    public static Product toEntity(ProductDto productDto) {
        Product product = new Product();

        product.setId(productDto.getId());
        product.setName(productDto.getName());
        product.setPrice(productDto.getPrice());
        product.setAmount(productDto.getAmount());

        return product;
    }

    public static ProductDto toDto(Product product) {
        ProductDto productDto = new ProductDto(
                product.getId(),
                product.getName(),
                product.getPrice(),
                product.getAmount()
        );

        productDto.setId(product.getId());

        return productDto;
    }

}
