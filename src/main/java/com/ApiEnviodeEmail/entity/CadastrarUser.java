package com.ApiEnviodeEmail.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table ( name = "tb_userSistema")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class CadastrarUser {

    @Id
    @GeneratedValue ( strategy = GenerationType.IDENTITY)
    private Long id;

    private String nomeCompleto;
    @NotEmpty
    @Column (unique = true)
    private String Cpf;
    @NotEmpty
    private String cep;

    private int nCasa;
    @Email
    private String email;

}
