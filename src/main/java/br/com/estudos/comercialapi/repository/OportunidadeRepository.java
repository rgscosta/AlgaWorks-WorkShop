package br.com.estudos.comercialapi.repository;

import br.com.estudos.comercialapi.model.Oportunidade;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface OportunidadeRepository extends JpaRepository<Oportunidade, Long> {

    //Criou um forma de não adicionar o valor com a mesma descrição e o mesmo nome no banco.
    Optional<Oportunidade> findByDescricaoAndNomeProspecto(String descricao, String nomeProspecto);
}
