package com.ApiEnviodeEmail.controller;

import com.ApiEnviodeEmail.dto.UsuarioDTO;
import com.ApiEnviodeEmail.entity.UsuarioEntity;
import com.ApiEnviodeEmail.repository.UsuarioRepository;
import com.ApiEnviodeEmail.service.EmailService;
import jakarta.validation.constraints.Email;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping ("/user/cadastro")
public class CadastroDeUserController {

    @Autowired
    private UsuarioRepository usuarioRepository;
    @Autowired
    private EmailService emailService;

    @GetMapping
    public ResponseEntity<?> listarTodos(){
        return new ResponseEntity<>(usuarioRepository.findAll(), HttpStatus.OK);
    }
    @PostMapping
    public ResponseEntity<UsuarioEntity> cadastrarUsuario(@RequestBody UsuarioDTO usuarioDTO){
        UsuarioEntity usuarioEntity = new UsuarioEntity();
        BeanUtils.copyProperties(usuarioDTO, usuarioEntity);
        usuarioRepository.save(usuarioEntity);

        emailService.enviarEmail(usuarioEntity.getEmail(),"API-SAMUEL",
                "Sucesso ao cadastrar-se.");
        return new ResponseEntity<>( usuarioEntity,HttpStatus.CREATED);
    }
    @GetMapping ("/{id}")
    public ResponseEntity<?> listarPorId(@PathVariable ("id") Long id){
        Optional<UsuarioEntity> usuarioEntity = usuarioRepository.findById(id);
        if (usuarioEntity.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Usuario não encontrado");
        } else {
            return new ResponseEntity(usuarioEntity, HttpStatus.OK);
        }
    }
    @DeleteMapping( "/{id}")
    public  ResponseEntity<?> deletarUsuario(@PathVariable ("id") Long id) {
        Optional<UsuarioEntity> usuarioEntity = usuarioRepository.findById(id);
        if (usuarioEntity.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Usuario não encontrado");
        } else {
            emailService.enviarEmail(usuarioEntity.get().getEmail(), "API-SAMUEL",
                    "Seu usuario foi deletado com sucesso.");
            usuarioRepository.deleteById(id);
            return new ResponseEntity(HttpStatus.OK);

        }




    }
}
