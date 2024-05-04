package com.platzimarket.persistence.crud;

import com.platzimarket.persistence.entity.Purchase;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

public interface PurchaseCRUDRepository extends CrudRepository<Purchase, Integer> {
    Optional<List<Purchase>> findPurchaseByIdClient(String clientId);
}
