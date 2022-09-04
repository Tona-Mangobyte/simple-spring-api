package com.mb.article.api.request;

import javax.validation.constraints.NotBlank;

public record AuthRequest(@NotBlank(message = "Username is required") String username,
                          @NotBlank(message = "Password is required") String password){}
