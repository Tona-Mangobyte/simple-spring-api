package com.mb.article.api.request;

import com.mb.article.common.UserRole;

import javax.validation.constraints.NotBlank;

public record UserRequest(Long id,
                          @NotBlank(message = "Username is required") String username,
                          @NotBlank(message = "Password is required") String password,
                          @NotBlank(message = "Role is required") UserRole role){
}
