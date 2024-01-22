package com.ApiEnviodeEmail.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table( name ="tb_cadUsuarios")
public class UsuarioEntity {


    @Id
    @GeneratedValue (strategy = GenerationType.AUTO)
    private Long id;

    @Column ( unique = true)
    @NotEmpty
    private String login;

    @NotEmpty
    private String senha;

    @Email
    @Column ( unique = true)
    @NotEmpty
    private String email;

}
