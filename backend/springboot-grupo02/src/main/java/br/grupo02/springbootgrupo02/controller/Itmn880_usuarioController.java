package br.grupo02.springbootgrupo02.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import br.grupo02.springbootgrupo02.dao.Itmn880_usuarioDAO;
import br.grupo02.springbootgrupo02.model.Itmn880_solic;
import br.grupo02.springbootgrupo02.model.Itmn880_usuario;

@RestController
@CrossOrigin("*")
public class Itmn880_usuarioController {

    @Autowired
    private Itmn880_usuarioDAO dao;

    @PostMapping("/usuario/login")
    public ResponseEntity<Itmn880_usuario> fazerLogin(@RequestBody Itmn880_usuario user) {
        Itmn880_usuario userFinded = dao.findByEmailOrRacf(user.getEmail(), user.getRacf());
        if (userFinded != null) {
            if (userFinded.getSenha().equals(user.getSenha())) {
                userFinded.setSenha("*********");
                return ResponseEntity.ok(userFinded);
            } else {
                return ResponseEntity.status(403).build();
            }
        } else {
            // return ResponseEntity.status(404).build();
            return ResponseEntity.status(403).build();
        }
    }

   

}
