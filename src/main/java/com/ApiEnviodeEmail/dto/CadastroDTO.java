package com.ApiEnviodeEmail.dto;

import org.springframework.validation.annotation.Validated;

public record CadastroDTO(@Validated String nomeCompleto,String cpf,String cep,int nCasa,
                          String email) {
}
