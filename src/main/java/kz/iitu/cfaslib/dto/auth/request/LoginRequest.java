package kz.iitu.cfaslib.dto.auth.request;

import lombok.Data;

@Data
public class LoginRequest {
    private String username;
    private String password;
}