package com.jusconnect.intake.domain.repository;

import com.jusconnect.intake.domain.model.Intake;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface IntakeRepository {

    void save(Intake intake);

    void update(Intake intake);

    void delete(UUID id);

    Optional<Intake> findById(UUID id);

    List<Intake> findAll();

    List<Intake> findByLeadId(UUID leadId);

}