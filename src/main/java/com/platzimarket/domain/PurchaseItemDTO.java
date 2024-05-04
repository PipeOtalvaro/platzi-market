package com.platzimarket.domain;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PurchaseItemDTO {
    private int id;
    private Integer quantity;
    private Double total;
    private Boolean active;
}
