package br.grupo02.springbootgrupo02.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
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

    // listar todas as solicitações por status
    @GetMapping("/solicitacao/status/{status}")

    public List<Itmn880_solic> buscaPorStatus(@PathVariable char status) {
        List<Itmn880_solic> lista;
        if (status == 'T') {
            lista = (List<Itmn880_solic>) dao.findAll();
        } else {
            lista = (List<Itmn880_solic>) dao.findByStatus(status);
        }
        return lista;
    }

    // atualizar o status da solicitação
    @PutMapping("/solicitacao/status")
    public ResponseEntity<Boolean> alterarStatus(@RequestBody Itmn880_solic solicTecnico) {
        Itmn880_solic itmn880_solic = dao.findById(solicTecnico.getNumSeq()).orElse(null);

        if (itmn880_solic != null) {
            itmn880_solic.setStatus(solicTecnico.getStatus());
            dao.save(itmn880_solic);
            return ResponseEntity.ok(true);
        } else {
            return ResponseEntity.ok(false);
        }
    }

        //listar todas as solicitações
        @GetMapping("/solicitacoes")
        public List<Itmn880_solic> listarTodos(){
            List<Itmn880_solic> lista = (List<Itmn880_solic>) dao.findAll();
            return lista;
        }
}


