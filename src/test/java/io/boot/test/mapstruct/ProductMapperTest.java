package io.boot.test.mapstruct;

import io.boot.test.mapper.ProductMapper;
import io.boot.test.model.Product;
import io.boot.test.model.ProductDto;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mapstruct.factory.Mappers;

import static org.assertj.core.api.Assertions.assertThat;

public class ProductMapperTest {

    private ProductMapper mapper = Mappers.getMapper(ProductMapper.class);

    private Product entity;

    private ProductDto dto;

    @BeforeEach
    public void setup() {
        entity = Product.builder()
                .id(1L)
                .description("description")
                .price(100.0)
                .name("shoes")
                .code("p001")
                .build();

        dto = ProductDto.builder()
                .id(1L)
                .description("description")
                .price(100.0)
                .name("shoes")
                .code("p001")
                .build();
    }

    @Test
    public void entityToDtoTest() {
        ProductDto dto = mapper.entityToDto(entity);

        assertThat(dto.getCode()).isEqualTo(entity.getCode());
        assertThat(dto.getDescription()).isEqualTo(entity.getDescription());
    }

    @Test
    public void dtoToEntityTest() {
        Product entity = mapper.dtoToEntity(dto);

        assertThat(entity.getCode()).isEqualTo(dto.getCode());
        assertThat(entity.getDescription()).isEqualTo(dto.getDescription());
    }
}
