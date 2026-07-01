package com.datta.tvaritfinal.controller;

import com.datta.tvaritfinal.entity.Partner;
import com.datta.tvaritfinal.service.PartnerService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/partner")
public class PartnerController {

    private final PartnerService service;

    public PartnerController(PartnerService service) {
        this.service = service;
    }

    @PostMapping("/register")
    public Partner registerPartner(
            @RequestBody Partner partner) {

        return service.registerPartner(partner);
    }

    @PostMapping("/login")
    public Partner loginPartner(
            @RequestBody Partner partner) {

        return service.loginPartner(partner);
    }

    @GetMapping("/profile/{id}")
    public Partner getPartner(
            @PathVariable Long id) {

        return service.getPartner(id);
    }

    @PutMapping("/profile/{id}")
    public Partner updatePartner(
            @PathVariable Long id,
            @RequestBody Partner partner) {

        return service.updatePartner(id, partner);
    }
}