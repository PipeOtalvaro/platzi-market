package com.platzimarket.domain;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.List;

@Getter
@Setter
public class PurchaseDTO {

    private Integer id;
    private String clientId;
    private LocalDateTime date;
    private String paymentMethod;
    private String active;
    private List<PurchaseItemDTO> items;
}
