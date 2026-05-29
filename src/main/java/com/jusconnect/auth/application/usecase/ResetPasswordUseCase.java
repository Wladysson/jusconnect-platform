package com.jusconnect.auth.application.usecase;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import com.jusconnect.auth.application.dto.request.ResetPasswordRequest;
import com.jusconnect.auth.domain.model.PasswordResetToken;
import com.jusconnect.auth.domain.model.UserCredential;
import com.jusconnect.auth.domain.repository.PasswordResetRepository;
import com.jusconnect.auth.domain.repository.AuthRepository;
import com.jusconnect.auth.infrastructure.security.PasswordEncoder;
import com.jusconnect.shared.kernel.exceptions.BusinessException;

import java.time.LocalDateTime;

@ApplicationScoped
public class ResetPasswordUseCase {

    @Inject
    PasswordResetRepository passwordResetRepository;

    @Inject
    AuthRepository authRepository;

    @Inject
    PasswordEncoder passwordEncoder;

    public void execute(ResetPasswordRequest request) {

        PasswordResetToken resetToken =
                passwordResetRepository.findByToken(
                        request.getToken()
                ).orElseThrow(
                        () -> new BusinessException("Token inválido")
                );

        if (resetToken == null) {
            throw new BusinessException("Token inválido");
        }

        if (resetToken.getUsedAt() != null) {
            throw new BusinessException("Token já utilizado");
        }

        if (resetToken.getExpiresAt().isBefore(LocalDateTime.now())) {
            throw new BusinessException("Token expirado");
        }

        UserCredential credential =
                authRepository.findById(
                        resetToken.getUserCredentialId()
                ).orElseThrow(
                        () -> new BusinessException("Usuário não encontrado")
                );

        credential.setPasswordHash(
                passwordEncoder.encode(
                        request.getNewPassword()
                )
        );

        authRepository.save(credential);

        resetToken.setUsedAt(LocalDateTime.now());
        passwordResetRepository.save(resetToken);
    }
}