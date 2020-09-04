package br.grupo02.springbootgrupo02.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import br.grupo02.springbootgrupo02.dao.Itmn880_solicDAO;
import br.grupo02.springbootgrupo02.model.Itmn880_solic;

@RestController
@CrossOrigin("*")


public class Itmn880_solicController {

    @Autowired 
    private Itmn880_solicDAO dao;
    
    @PostMapping("/solicitacao/nova")
    public ResponseEntity<Itmn880_solic> novaSolicitacao(@RequestBody Itmn880_solic user) {
        
        try {
            user.setStatus('I');
            Itmn880_solic nova = dao.save(user); // salva a solic no BD
            return ResponseEntity.ok(nova); // retorna os dados do usuário inserido no BD
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
            System.out.println(ex.getStackTrace());
            return ResponseEntity.status(400).build(); // 400 = bad request (dados incorretos)
        }
    }
    

}
