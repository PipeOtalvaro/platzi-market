package com.platzimarket.persistence;

import com.platzimarket.domain.PurchaseDTO;
import com.platzimarket.domain.repository.IPurchaseRepository;
import com.platzimarket.persistence.crud.PurchaseCRUDRepository;
import com.platzimarket.persistence.entity.Purchase;
import com.platzimarket.persistence.mapper.PurchaseMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class PurchaseRepository implements IPurchaseRepository {

    private final PurchaseCRUDRepository purchaseCRUDRepository;
    private final PurchaseMapper purchaseMapper;
    @Autowired
    public PurchaseRepository(PurchaseCRUDRepository purchaseCRUDRepository, PurchaseMapper purchaseMapper) {
        this.purchaseCRUDRepository = purchaseCRUDRepository;
        this.purchaseMapper = purchaseMapper;
    }

    @Override
    public List<PurchaseDTO> getAll() {
        List<Purchase> purchases = (List<Purchase>) purchaseCRUDRepository.findAll();
        return purchases.stream().map(purchaseMapper::toPurchaseDTO).toList();
    }

    @Override
    public Optional<List<PurchaseDTO>> getByClient(String clientId) {
        return purchaseCRUDRepository.findPurchaseByIdClient(clientId)
                .map(purchases ->
                    purchases.stream().map(purchaseMapper::toPurchaseDTO).toList()
                );
    }

    @Override
    public PurchaseDTO save(PurchaseDTO purchaseDTO) {
        Purchase purchase = purchaseMapper.toPurchaseEntity(purchaseDTO);
        purchase.getProducts().forEach(product -> product.setPurchase(purchase));
        return purchaseMapper.toPurchaseDTO(purchaseCRUDRepository.save(purchase));
    }
}
