package com.ApiEnviodeEmail.dto;


import org.springframework.validation.annotation.Validated;

public record UsuarioDTO(@Validated String login, String senha,String email)  {
}
