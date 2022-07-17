package com.fluxexample.controller;

import com.fluxexample.domain.Vendor;
import com.fluxexample.repositories.VendorRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Flux;

@RequiredArgsConstructor
@Component
public class VendorControllerImpl implements VendorController {

    private final VendorRepository vendorRepository;


    @Override
    public Flux<Vendor> getVendors() {
        return vendorRepository.findAll();
    }
}
