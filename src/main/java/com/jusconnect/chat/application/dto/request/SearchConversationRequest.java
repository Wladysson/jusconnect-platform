package com.jusconnect.chat.application.dto.request;

import jakarta.validation.constraints.NotNull;

import java.time.LocalDateTime;
import java.util.UUID;

public class SearchConversationRequest {

    // Identificador do usuário
    @NotNull(message = "O identificador do usuário é obrigatório.")
    private UUID userId;

    // Texto utilizado na pesquisa
    private String searchTerm;

    // Filtra apenas conversas arquivadas
    private Boolean archived;

    // Filtra apenas conversas com mensagens não lidas
    private Boolean unreadOnly;

    // Data inicial para pesquisa
    private LocalDateTime startDate;

    // Data final para pesquisa
    private LocalDateTime endDate;

    // Número da página
    private Integer page = 0;

    // Quantidade de registros por página
    private Integer size = 20;

    public SearchConversationRequest() {
    }

    public UUID getUserId() {
        return userId;
    }

    public void setUserId(UUID userId) {
        this.userId = userId;
    }

    public String getSearchTerm() {
        return searchTerm;
    }

    public void setSearchTerm(String searchTerm) {
        this.searchTerm = searchTerm;
    }

    public Boolean getArchived() {
        return archived;
    }

    public void setArchived(Boolean archived) {
        this.archived = archived;
    }

    public Boolean getUnreadOnly() {
        return unreadOnly;
    }

    public void setUnreadOnly(Boolean unreadOnly) {
        this.unreadOnly = unreadOnly;
    }

    public LocalDateTime getStartDate() {
        return startDate;
    }

    public void setStartDate(LocalDateTime startDate) {
        this.startDate = startDate;
    }

    public LocalDateTime getEndDate() {
        return endDate;
    }

    public void setEndDate(LocalDateTime endDate) {
        this.endDate = endDate;
    }

    public Integer getPage() {
        return page;
    }

    public void setPage(Integer page) {
        this.page = page;
    }

    public Integer getSize() {
        return size;
    }

    public void setSize(Integer size) {
        this.size = size;
    }
}