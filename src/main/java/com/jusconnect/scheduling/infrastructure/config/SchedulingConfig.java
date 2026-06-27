package com.jusconnect.scheduling.infrastructure.config;

import jakarta.enterprise.context.ApplicationScoped;
import org.eclipse.microprofile.config.inject.ConfigProperty;

import java.time.Duration;

@ApplicationScoped
public class SchedulingConfig {

    // buffer entre reuniões (jurídico precisa disso)
    @ConfigProperty(name = "scheduling.buffer.minutes", defaultValue = "15")
    int bufferMinutes;

    // duração padrão de consulta
    @ConfigProperty(name = "scheduling.default.duration.minutes", defaultValue = "60")
    int defaultDurationMinutes;

    // horário mínimo de agendamento antecipado
    @ConfigProperty(name = "scheduling.min.advance.hours", defaultValue = "24")
    int minAdvanceHours;

    // horário máximo futuro permitido
    @ConfigProperty(name = "scheduling.max.advance.days", defaultValue = "30")
    int maxAdvanceDays;

    public Duration buffer() {
        return Duration.ofMinutes(bufferMinutes);
    }

    public Duration defaultDuration() {
        return Duration.ofMinutes(defaultDurationMinutes);
    }

    public int minAdvanceHours() {
        return minAdvanceHours;
    }

    public int maxAdvanceDays() {
        return maxAdvanceDays;
    }
}