package com.datta.tvaritfinal.service;

import com.datta.tvaritfinal.entity.Partner;
import com.datta.tvaritfinal.repository.PartnerRepository;
import org.springframework.stereotype.Service;

@Service
public class PartnerService {

    private final PartnerRepository repository;

    public PartnerService(PartnerRepository repository) {
        this.repository = repository;
    }

    public Partner registerPartner(
            Partner partner) {

        return repository.save(partner);
    }

    public Partner getPartner(Long id) {

        return repository.findById(id)
                .orElse(null);
    }

    public Partner loginPartner(
            Partner partner)
    {
        Partner existingPartner =
                repository.findByPartnerEmail(
                        partner.getPartnerEmail());

        if(existingPartner == null)
        {
            return null;
        }

        if(existingPartner.getPassword()
                .equals(partner.getPassword()))
        {
            return existingPartner;
        }

        return null;
    }

    public Partner updatePartner(
            Long id,
            Partner partner) {

        Partner existingPartner =
                repository.findById(id)
                        .orElse(null);

        if(existingPartner == null) {
            return null;
        }

        if(partner.getPartnerName() != null) {
            existingPartner.setPartnerName(
                    partner.getPartnerName());
        }

        if(partner.getPartnerEmail() != null) {
            existingPartner.setPartnerEmail(
                    partner.getPartnerEmail());
        }

        if(partner.getPhoneNumber() != null) {
            existingPartner.setPhoneNumber(
                    partner.getPhoneNumber());
        }

        if(partner.getPassword() != null) {
            existingPartner.setPassword(
                    partner.getPassword());
        }

        return repository.save(existingPartner);
    }
}