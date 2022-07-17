package com.fluxexample.controller;

import com.fluxexample.domain.Vendor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;

@RestController
public interface VendorController {

    @RequestMapping("/api/v1/vendors")
    Flux<Vendor> getVendors();

}
