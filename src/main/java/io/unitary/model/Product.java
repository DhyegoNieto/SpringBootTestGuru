package io.unitary.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@Data
public class Product {

    private Long id;
    private String name;
    private String description;
    private String code;
}
