package com.coachpad.player.dto;
import jakarta.validation.constraints.*;

import java.time.LocalDate;

public record CreatePlayerRequest (
    @NotBlank
    @Size(max = 25)
    String firstName,

    @NotBlank
    @Size(max = 25)
    String lastName,

    @Past
    LocalDate dateOfBirth,

    @Email
    String email,

    String phoneNumber,
    String gender,
    String clubName,

    @DecimalMin("1.0")
    @DecimalMax("23.0")
    double lk
) {
}
