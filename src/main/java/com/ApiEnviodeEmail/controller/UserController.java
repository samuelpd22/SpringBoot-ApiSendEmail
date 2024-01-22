package com.ApiEnviodeEmail.controller;



import java.util.Optional;
/*@CrossOrigin
@RestController
@RequestMapping ("/user/cadastro")
public class UserController {

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
}*/

