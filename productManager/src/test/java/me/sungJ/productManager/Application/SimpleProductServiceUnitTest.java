package me.sungJ.productManager.Application;

import me.sungJ.productManager.Domain.Product;
import me.sungJ.productManager.Domain.ProductRepository;
import me.sungJ.productManager.Presentation.ProductDto;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class SimpleProductServiceUnitTest {

    @Mock
    private ProductRepository productRepository;

    @Mock
    private ValidationService validationService;

    @InjectMocks
    private SimpleProductService simpleProductService;

    @Test
    @DisplayName("상품 추가 후에는 추가된 상품이 반환되어야 합니다.")
    void productAddTest() {
        ProductDto productDto = new ProductDto(null,"연필",300,20);
        Long PRODUCT_ID = 1L;

        Product product = ProductDto.toEntity(productDto);
        product.setId(PRODUCT_ID);
        when(productRepository.add(any())).thenReturn(product);

        ProductDto savedProductDto = simpleProductService.add(productDto);

        assertTrue(savedProductDto.getId().equals(PRODUCT_ID));
        assertTrue(savedProductDto.getName().equals(productDto.getName()));
        assertTrue(savedProductDto.getPrice().equals(productDto.getPrice()));
        assertTrue(savedProductDto.getAmount().equals(productDto.getAmount()));
    }

    @Test
    @DisplayName("상품 ID로 조회하면 해당 상품이 반환되어야 합니다.")
    void productFindByIdTest() {
        Long PRODUCT_ID = 1L;
        Product product = new Product(PRODUCT_ID, "노트", 1000, 50);

        when(productRepository.findById(PRODUCT_ID)).thenReturn(product);

        ProductDto foundProductDto = simpleProductService.findById(PRODUCT_ID);

        assertTrue(foundProductDto.getId().equals(PRODUCT_ID));
        assertTrue(foundProductDto.getName().equals(product.getName()));
        assertTrue(foundProductDto.getPrice().equals(product.getPrice()));
        assertTrue(foundProductDto.getAmount().equals(product.getAmount()));
    }

    @Test
    @DisplayName("상품 수정 후에는 수정된 값이 반영되어야 합니다.")
    void productUpdateTest() {
        Long PRODUCT_ID = 1L;
        ProductDto updateDto = new ProductDto(PRODUCT_ID, "지우개", 500, 30);
        Product updatedProduct = ProductDto.toEntity(updateDto);

        when(productRepository.update(any())).thenReturn(updatedProduct);

        ProductDto resultDto = simpleProductService.update(updateDto);

        assertTrue(resultDto.getId().equals(PRODUCT_ID));
        assertTrue(resultDto.getName().equals(updateDto.getName()));
        assertTrue(resultDto.getPrice().equals(updateDto.getPrice()));
        assertTrue(resultDto.getAmount().equals(updateDto.getAmount()));
    }


}