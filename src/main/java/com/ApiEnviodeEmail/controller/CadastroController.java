package com.ApiEnviodeEmail.controller;

import com.ApiEnviodeEmail.dto.CadastroDTO;

import com.ApiEnviodeEmail.entity.CadastrarUser;

import com.ApiEnviodeEmail.repository.CadastroRepository;

import com.ApiEnviodeEmail.service.EmailService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;
@RestController
@CrossOrigin
@RequestMapping("/cadastro")
public class CadastroController {
    @Autowired
    private CadastroRepository CadastroRepository;
    @Autowired
    private EmailService emailService;

    @GetMapping ("/listar")
    public ResponseEntity<?> listarTodos(){
        return new ResponseEntity<>(CadastroRepository.findAll(), HttpStatus.OK);
    }
    @PostMapping
    public ResponseEntity<CadastrarUser> cadastrarUsuario(@RequestBody CadastroDTO cadastroDTO){
        CadastrarUser cadastrarUser = new CadastrarUser();
        BeanUtils.copyProperties(cadastroDTO, cadastrarUser);
        CadastroRepository.save(cadastrarUser);

        emailService.enviarEmail(cadastrarUser.getEmail(),"API-SAMUEL",
                "Sucesso ao cadastrar-se.");
        return new ResponseEntity<>( cadastrarUser,HttpStatus.CREATED);
    }
    @GetMapping ("/{id}")
    public ResponseEntity<?> listarPorId(@PathVariable("id") Long id){
        Optional<CadastrarUser> CadastrarUser = CadastroRepository.findById(id);
        if (CadastrarUser.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Usuario não encontrado");
        } else {
            return new ResponseEntity(CadastrarUser, HttpStatus.OK);
        }
    }
    @DeleteMapping( "/{id}")
    public  ResponseEntity<?> deletarUsuario(@PathVariable ("id") Long id) {
        Optional<CadastrarUser> CadastrarUser = CadastroRepository.findById(id);
        if (CadastrarUser.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Usuario não encontrado");
        } else {
            emailService.enviarEmail(CadastrarUser.get().getEmail(), "API-SAMUEL",
                    "Seu usuario foi deletado com sucesso.");
            CadastroRepository.deleteById(id);
            return new ResponseEntity(HttpStatus.OK);

        }




    }
}
