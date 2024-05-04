package com.platzimarket.domain.repository;

import com.platzimarket.domain.PurchaseDTO;

import java.util.List;
import java.util.Optional;

public interface IPurchaseRepository {
    List<PurchaseDTO> getAll();
    Optional<List<PurchaseDTO>> getByClient(String clientId);
    PurchaseDTO save(PurchaseDTO purchase);
}
