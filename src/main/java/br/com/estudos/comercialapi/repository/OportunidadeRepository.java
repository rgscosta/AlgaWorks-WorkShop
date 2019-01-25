package br.com.estudos.comercialapi.repository;

import br.com.estudos.comercialapi.model.Oportunidade;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OportunidadeRepository extends JpaRepository<Oportunidade, Long> {
}
