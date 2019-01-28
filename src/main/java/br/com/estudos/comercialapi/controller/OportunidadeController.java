package br.com.estudos.comercialapi.controller;

import br.com.estudos.comercialapi.model.Oportunidade;
import br.com.estudos.comercialapi.repository.OportunidadeRepository;
import net.bytebuddy.implementation.bytecode.Throw;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;
import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@CrossOrigin
@RestController
@RequestMapping("/oportunidades")
public class OportunidadeController {

    @Autowired
    private OportunidadeRepository oportunidades;

    @GetMapping
    //findAll vai mostrar tudo que eu tenho em oportunidades que foi cadastrado no banco
    public List<Oportunidade> listar(){
        return oportunidades.findAll();
    }

    @GetMapping("/{id}")
    //findById vai mostrar os valores do que tem no banco a parti do id gerado pelo sistema ex, oportunidades/1 ou /2/3/4 ....
    private ResponseEntity<Oportunidade> buscar(@PathVariable Long id){
        Optional<Oportunidade>  oportunidade = oportunidades.findById(id);
        //Não veio a opção de oportunidade.isEmpty ? por que?
        //Se a oportunidade procurada vinher então ele mostrar o valor no get
        //Se ele não tiver nada vazio então ela mostra NotFound
        if(oportunidade.isPresent()) {
            return ResponseEntity.ok(oportunidade.get());
        }
        return ResponseEntity.notFound().build();
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)//para verificar o status do codigo do retorno de 200 OK para 201 Created //
    //@Valid server para validar as premissas que foram imposta de TAM max e min e ate valores null e tudo mais, devido a isso
    //vai validar antes de passar.
    public Oportunidade adicionar(@Valid @RequestBody Oportunidade oportunidade){
        //Feito isso vou buscar no bando uma descrição e um nome igual quando for adicionar no banco e se existir ele vai da erro
        //e apresenta a mensagem de throw.
        Optional<Oportunidade> oportunidadeExistente =
                oportunidades.findByDescricaoAndNomeProspecto(oportunidade.getDescricao(), oportunidade.getNomeProspecto());
          //Se tiver com valor presente na busca então procura e verifica se tem e manda a MSG do throw informando a duplicidade.
          if(oportunidadeExistente.isPresent()){
              throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Já existe uma oportunidade para este prospecto com a mesma descrição");
          }
        return oportunidades.save(oportunidade);
    }

//    @GetMapping("/remover/{id}")
//    public String remover(@PathVariable("id") Long id, RedirectAttributes ra) {
//       oportunidades.deleteById(id);
//        ra.addFlashAttribute("mensagemSucesso", "Oportunidade Removida com sucesso.");
//        return "redirect:/oportunidades";
//    }

}

