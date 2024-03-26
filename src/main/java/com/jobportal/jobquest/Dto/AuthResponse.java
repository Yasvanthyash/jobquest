package com.jobportal.jobquest.Dto;

import com.jobportal.jobquest.Model.*;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class AuthResponse {
    private String token;
    private UserModel user;
}