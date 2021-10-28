package io.boot.test.model;

import lombok.*;


@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class ProductDto {
    private Long id;
    private String code;
    private String name;
    private double price;
    private String description;
}
