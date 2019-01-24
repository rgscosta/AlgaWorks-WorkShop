package br.com.estudos.comercialapi;

import br.com.estudos.comercialapi.model.Oportunidade;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("/oportunidades")
public class OportunidadeController {

    @GetMapping
    public List<Oportunidade> listar(){
        Oportunidade oportunidade = new Oportunidade();
        oportunidade.setId(1L);
        oportunidade.setNomePropecto("Desenvolvimento de ERP com Angula e Spring");
        oportunidade.setDescricao("Accenture Pernambuco");
        oportunidade.setValor(new BigDecimal(2000));

        return Arrays.asList(oportunidade);
    }
}
