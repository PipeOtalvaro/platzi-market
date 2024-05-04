package com.platzimarket.persistence.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Embeddable
@Getter
@Setter
public class PurchasesProductPK implements Serializable {
    @Column(name = "id_compra")
    private Integer idPurchase;
    @Column(name = "id_producto")
    private Integer idProduct;
}
