package com.platzimarket.persistence.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity()
@Table(name = "compras_productos")
@Getter
@Setter
public class PurchasesProduct {

    @EmbeddedId
    private PurchasesProductPK id;

    @Column(name = "cantidad")
    private Integer quantity;

    private Double total;

    @Column(name = "estado")
    private Boolean state;

    @ManyToOne
    @MapsId("idPurchase")
    @JoinColumn(name = "id_compra", updatable = false, insertable = false)
    private Purchase purchase;

    @ManyToOne
    @JoinColumn(name = "id_producto", insertable = false, updatable = false)
    private Product product;

}
