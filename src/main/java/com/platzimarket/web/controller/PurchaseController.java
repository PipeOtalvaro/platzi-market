package com.platzimarket.web.controller;

import com.platzimarket.domain.PurchaseDTO;
import com.platzimarket.domain.service.PurchaseServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/purchase")
public class PurchaseController {
    private final PurchaseServices purchaseServices;

    @Autowired
    public PurchaseController(PurchaseServices purchaseServices) {
        this.purchaseServices = purchaseServices;
    }
    @GetMapping("/getPurchases")
    public ResponseEntity<List<PurchaseDTO>> getAll() {
        return new ResponseEntity<>(purchaseServices.getAll(), HttpStatus.OK);
    }
    @GetMapping("/getPurchasesByClient/{idClient}")
    public ResponseEntity<List<PurchaseDTO>> getByClient(@PathVariable("idClient") String clientId) {
        return new ResponseEntity<>(purchaseServices.getByClient(clientId), HttpStatus.OK);
    }
    @PostMapping("/savePurchase")
    public ResponseEntity<PurchaseDTO> save(@RequestBody PurchaseDTO purchaseDTO) {
        return new ResponseEntity<>(purchaseServices.save(purchaseDTO), HttpStatus.OK);
    }
}