package com.platzimarket.domain.service;

import com.platzimarket.domain.PurchaseDTO;
import com.platzimarket.domain.repository.IPurchaseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class PurchaseServices {
    private final IPurchaseRepository purchaseRepository;
    @Autowired
    public PurchaseServices(IPurchaseRepository purchaseRepository) {
        this.purchaseRepository = purchaseRepository;
    }

    public List<PurchaseDTO> getAll(){
        return purchaseRepository.getAll();
    }
    public List<PurchaseDTO> getByClient(String clientId){
        return purchaseRepository.getByClient(clientId).orElse(new ArrayList<>());
    }
    public PurchaseDTO save(PurchaseDTO purchaseDTO){
        return purchaseRepository.save(purchaseDTO);
    }
}
