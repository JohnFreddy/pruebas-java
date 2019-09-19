package CRUD;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@RequiredArgsConstructor
@AllArgsConstructor
@Builder
public class Car {

    private String id;
    private String brandId;
    private String model;
    private String plate;
    private String reference;
    private Integer km;
    private Boolean isNew;
    private String color;
    private Float buyPrice;
    private Float salePrice;
    private String lastOwnerId;
}
