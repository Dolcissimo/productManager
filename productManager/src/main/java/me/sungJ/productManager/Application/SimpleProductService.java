package me.sungJ.productManager.Application;

import me.sungJ.productManager.Domain.Product;
import me.sungJ.productManager.Infrastructure.DatabaseProductRepository;
import me.sungJ.productManager.Presentation.ProductDto;
import me.sungJ.productManager.Infrastructure.ListProductRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SimpleProductService {
    private DatabaseProductRepository databaseProductRepository;
    //private ListProductRepository listProductRepository;
    private ModelMapper modelMapper;
    private ValidationService validationService;

    @Autowired
    SimpleProductService(DatabaseProductRepository databaseProductRepository , ModelMapper modelMapper
    , ValidationService validationService) {
        this.databaseProductRepository = databaseProductRepository;
        this.modelMapper = modelMapper;
        this.validationService = validationService;
    }

    public ProductDto add(ProductDto productDto) {
        // 1. ProductDto를 Product로 변환
        Product product = modelMapper.map(productDto, Product.class);
        //유효성 검사
        validationService.checkvalid(product);

        // 2. 레포지토리를 호출
        Product savedProduct = databaseProductRepository.add(product);

        // 3. Product를 ProductDTO로 변환
        ProductDto savedProductDto = modelMapper.map(savedProduct, ProductDto.class);

        //4. DTO를 반환
        return savedProductDto;
    }

    public ProductDto findById(Long id) {
        Product product = databaseProductRepository.findById(id);
        ProductDto productDto = modelMapper.map(product, ProductDto.class);
        return productDto;
    }

    public List<ProductDto> findAll() {
        List<Product> products =databaseProductRepository.findAll();
        List<ProductDto> productDtos = products.stream()
                .map(product -> modelMapper.map(product, ProductDto.class))
                .toList();
        return productDtos;
    }

    public List<ProductDto> findByNameContaining(String name) {
        List<Product> products = databaseProductRepository.findByNameContaining(name);
        List<ProductDto> productDtos = products.stream()
                .map(product -> modelMapper.map(product, ProductDto.class))
                .toList();
        return productDtos;
    }

    public ProductDto update(ProductDto productDto) {
        Product product = modelMapper.map(productDto , Product.class);
        Product updatedProduct = databaseProductRepository.update(product);
        ProductDto updatedProductDto = modelMapper.map(updatedProduct, ProductDto.class);
        return updatedProductDto;
    }

    public void delete(Long id) {
        databaseProductRepository.delete(id);
    }


}
