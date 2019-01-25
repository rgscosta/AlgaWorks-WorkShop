package br.com.estudos.comercialapi.controller;

import br.com.estudos.comercialapi.model.Oportunidade;
import br.com.estudos.comercialapi.repository.OportunidadeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/oportunidades")
public class OportunidadeController {

    @Autowired
    private OportunidadeRepository oportunidades;

    @GetMapping
    public List<Oportunidade> listar(){

        return oportunidades.findAll();
    }

    @GetMapping("/{id}")
    private ResponseEntity<Oportunidade> buscar(@PathVariable Long id){
        Optional<Oportunidade>  oportunidade = oportunidades.findById(id);
        //Não veio a opção de oportunidade.isEmpty ? por que?
        if(oportunidade.isPresent()) {
            return ResponseEntity.ok(oportunidade.get());
        }
        return ResponseEntity.notFound().build();
    }
}
