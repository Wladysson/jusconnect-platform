package com.jusconnect.leads.infrastructure.config;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.enterprise.inject.Produces;

import com.jusconnect.leads.domain.service.LeadDomainService;

@ApplicationScoped
public class LeadConfig {

    @Produces
    @ApplicationScoped
    public LeadDomainService leadDomainService() {

        return new LeadDomainService();
    }
}