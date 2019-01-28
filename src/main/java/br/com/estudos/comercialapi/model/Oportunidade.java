package br.com.estudos.comercialapi.model;

import javax.persistence.*;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;
import java.math.BigDecimal;
import java.util.Objects;

@Entity
public class Oportunidade {

    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private  Long id;
    @NotEmpty    //Validação para não deixa o campo em branco
    @Size(min = 4 , max = 80)  //Validação para não passar do tamanho maximo do campo e ter um tamanho minimo se quiser
    @Column(name ="nome_prospecto" )
    private String nomeProspecto;
    @NotEmpty
    @Size (min = 4 , max = 200)
    private String descricao;
    @Min(0) // No minimo o valor e 0 por que não poderia informa um valor negativo.
    private BigDecimal valor;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNomeProspecto() {
        return nomeProspecto;
    }

    public void setNomeProspecto(String nomeProspecto) {
        this.nomeProspecto = nomeProspecto;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public BigDecimal getValor() {
        return valor;
    }

    public void setValor(BigDecimal valor) {
        this.valor = valor;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Oportunidade that = (Oportunidade) o;
        return Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
