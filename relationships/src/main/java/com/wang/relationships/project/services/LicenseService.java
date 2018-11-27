package com.wang.relationships.project.services;

import com.wang.relationships.project.models.License;
import com.wang.relationships.project.repositories.LicenseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class LicenseService {
    private int number = 0;
    public int getNumber() {
        return number;
    }
    public void setNumber(int number) {
        this.number = number;
    }

    @Autowired
    private final LicenseRepository licenseRepository;

    public LicenseService (LicenseRepository licenseRepository) {
        this.licenseRepository = licenseRepository;
    }

    public License createLicense(License l) {
        int num = this.getNumber();
        num++;
        this.setNumber(num);
        String numString = String.format("%05d", this.getNumber());
        l.setNumber(numString);
        return licenseRepository.save(l);
    }

    public License findLicense(Long id) {
        Optional<License> optionalLicense = licenseRepository.findById(id);
        if(optionalLicense.isPresent()) {
            return optionalLicense.get();
        } else {
            return null;
        }
    }

}
