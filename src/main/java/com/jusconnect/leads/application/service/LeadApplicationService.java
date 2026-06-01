package com.jusconnect.leads.application.service;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;

import com.jusconnect.leads.application.dto.request.AssignLeadRequest;
import com.jusconnect.leads.application.dto.request.CreateLeadRequest;
import com.jusconnect.leads.application.dto.request.SearchLeadRequest;
import com.jusconnect.leads.application.dto.request.UpdateLeadPriorityRequest;
import com.jusconnect.leads.application.dto.request.UpdateLeadRequest;

import com.jusconnect.leads.application.usecase.AssignLeadUseCase;
import com.jusconnect.leads.application.usecase.CalculateLeadScoreUseCase;
import com.jusconnect.leads.application.usecase.CreateLeadUseCase;
import com.jusconnect.leads.application.usecase.DeleteLeadUseCase;
import com.jusconnect.leads.application.usecase.GetLeadByIdUseCase;
import com.jusconnect.leads.application.usecase.GetLeadHistoryUseCase;
import com.jusconnect.leads.application.usecase.SearchLeadsUseCase;
import com.jusconnect.leads.application.usecase.UpdateLeadPriorityUseCase;
import com.jusconnect.leads.application.usecase.UpdateLeadUseCase;

import com.jusconnect.leads.domain.model.Lead;
import com.jusconnect.leads.domain.model.LeadAssignment;
import com.jusconnect.leads.domain.model.LeadHistory;
import com.jusconnect.leads.domain.model.LeadScore;

import java.util.List;
import java.util.UUID;

@ApplicationScoped
public class LeadApplicationService {

    @Inject
    CreateLeadUseCase createLeadUseCase;

    @Inject
    UpdateLeadUseCase updateLeadUseCase;

    @Inject
    GetLeadByIdUseCase getLeadByIdUseCase;

    @Inject
    SearchLeadsUseCase searchLeadsUseCase;

    @Inject
    AssignLeadUseCase assignLeadUseCase;

    @Inject
    UpdateLeadPriorityUseCase updateLeadPriorityUseCase;

    @Inject
    CalculateLeadScoreUseCase calculateLeadScoreUseCase;

    @Inject
    GetLeadHistoryUseCase getLeadHistoryUseCase;

    @Inject
    DeleteLeadUseCase deleteLeadUseCase;

    public Lead create(
            CreateLeadRequest request
    ) {

        return createLeadUseCase.execute(
                request
        );
    }

    public Lead update(
            UUID leadId,
            UpdateLeadRequest request
    ) {

        return updateLeadUseCase.execute(
                leadId,
                request
        );
    }

    public Lead findById(
            UUID leadId
    ) {

        return getLeadByIdUseCase.execute(
                leadId
        );
    }

    public List<Lead> search(
            SearchLeadRequest request
    ) {

        return searchLeadsUseCase.execute(
                request
        );
    }

    public LeadAssignment assign(
            UUID leadId,
            AssignLeadRequest request
    ) {

        return assignLeadUseCase.execute(
                leadId,
                request
        );
    }

    public Lead updatePriority(
            UUID leadId,
            UpdateLeadPriorityRequest request
    ) {

        return updateLeadPriorityUseCase.execute(
                leadId,
                request
        );
    }

    public LeadScore calculateScore(
            UUID leadId
    ) {

        return calculateLeadScoreUseCase.execute(
                leadId
        );
    }

    public List<LeadHistory> history(
            UUID leadId
    ) {

        return getLeadHistoryUseCase.execute(
                leadId
        );
    }

    public void delete(
            UUID leadId
    ) {

        deleteLeadUseCase.execute(
                leadId
        );
    }
}