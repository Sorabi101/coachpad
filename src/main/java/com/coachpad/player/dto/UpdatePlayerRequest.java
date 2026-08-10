package com.coachpad.player.dto;

import jakarta.validation.constraints.*;

import java.time.LocalDate;

public record UpdatePlayerRequest(
    @Pattern(regexp = ".*\\S.*", message = "First name must not be blank")
    @Size(max = 25)
    String firstName,

    @Pattern(regexp = ".*\\S.*", message = "Last name must not be blank")
    @Size(max = 25)
    String lastName,

    @Past
    LocalDate dateOfBirth,

    @Email
    String email,

    String phoneNumber,
    String clubName,

    @DecimalMin("1.0")
    @DecimalMax("23.0")
    Double lk
) {
}
