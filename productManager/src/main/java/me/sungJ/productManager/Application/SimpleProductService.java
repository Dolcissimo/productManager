package me.sungJ.productManager.Application;

import me.sungJ.productManager.Domain.Product;
import me.sungJ.productManager.Domain.ProductRepository;
import me.sungJ.productManager.Infrastructure.DatabaseProductRepository;
import me.sungJ.productManager.Presentation.ProductDto;
import me.sungJ.productManager.Infrastructure.ListProductRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SimpleProductService {
    private ProductRepository productRepository;
    private ModelMapper modelMapper;
    private ValidationService validationService;

    @Autowired
    SimpleProductService(ProductRepository productRepository , ModelMapper modelMapper
    , ValidationService validationService) {
        this.productRepository = productRepository;
        this.modelMapper = modelMapper;
        this.validationService = validationService;
    }

    public ProductDto add(ProductDto productDto) {
        // 1. ProductDto를 Product로 변환
        Product product = modelMapper.map(productDto, Product.class);
        //유효성 검사
        validationService.checkvalid(product);

        // 2. 레포지토리를 호출
        Product savedProduct = productRepository.add(product);

        // 3. Product를 ProductDTO로 변환
        ProductDto savedProductDto = modelMapper.map(savedProduct, ProductDto.class);

        //4. DTO를 반환
        return savedProductDto;
    }

    public ProductDto findById(Long id) {
        Product product = productRepository.findById(id);
        ProductDto productDto = modelMapper.map(product, ProductDto.class);
        return productDto;
    }

    public List<ProductDto> findAll() {
        List<Product> products =productRepository.findAll();
        List<ProductDto> productDtos = products.stream()
                .map(product -> modelMapper.map(product, ProductDto.class))
                .toList();
        return productDtos;
    }

    public List<ProductDto> findByNameContaining(String name) {
        List<Product> products = productRepository.findByNameContaining(name);
        List<ProductDto> productDtos = products.stream()
                .map(product -> modelMapper.map(product, ProductDto.class))
                .toList();
        return productDtos;
    }

    public ProductDto update(ProductDto productDto) {
        Product product = modelMapper.map(productDto , Product.class);
        Product updatedProduct = productRepository.update(product);
        ProductDto updatedProductDto = modelMapper.map(updatedProduct, ProductDto.class);
        return updatedProductDto;
    }

    public void delete(Long id) {
        productRepository.delete(id);
    }


}
