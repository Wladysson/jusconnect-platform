package com.jusconnect.users.application.dto.request;

import com.jusconnect.users.domain.enums.LawyerSpecialty;

public class SearchLawyerRequest {

    private String name;

    private LawyerSpecialty specialty;

    private String city;

    private Integer page;

    private Integer size;

    public SearchLawyerRequest() {
    }

    public String getName() {
        return name;
    }

    public LawyerSpecialty getSpecialty() {
        return specialty;
    }

    public String getCity() {
        return city;
    }

    public Integer getPage() {
        return page;
    }

    public Integer getSize() {
        return size;
    }
}