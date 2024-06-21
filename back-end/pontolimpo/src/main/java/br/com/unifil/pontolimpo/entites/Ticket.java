package br.com.unifil.pontolimpo.entites;

import java.io.Serializable;
import java.time.LocalDateTime;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import org.hibernate.annotations.CreationTimestamp;

@Entity
@Table(name = "tb_ticket")
public class Ticket implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String localizacao;
    private String referencia;
    private String titulo;
    private String descricao;
    private String status;
    private boolean ativo;
    @CreationTimestamp
    private LocalDateTime createdAt;
    

    //Constructor


    public Ticket(Long id, String localizacao, String referencia, String titulo, String descricao, String status, boolean ativo, LocalDateTime createdAt) {
        this.id = id;
        this.localizacao = localizacao;
        this.referencia = referencia;
        this.titulo = titulo;
        this.descricao = descricao;
        this.status = status;
        this.ativo = ativo;
        this.createdAt = createdAt;
    }

    public Ticket(String localizacao, String referencia, String titulo, String descricao, String status, boolean ativo, LocalDateTime createdAt) {
        this.localizacao = localizacao;
        this.referencia = referencia;
        this.titulo = titulo;
        this.descricao = descricao;
        this.status = status;
        this.ativo = ativo;
        this.createdAt = createdAt;
    }

    public Ticket() {
    }
    //GETTER SETTER

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getLocalizacao() {
        return localizacao;
    }

    public void setLocalizacao(String localizacao) {
        this.localizacao = localizacao;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public boolean isAtivo() {
        return ativo;
    }

    public void setAtivo(boolean ativo) {
        this.ativo = ativo;
    }

    public String getReferencia() {
        return referencia;
    }

    public void setReferencia(String referencia) {
        this.referencia = referencia;
    }

    //toString


    @Override
    public String toString() {
        return "Ticket{" +
                "id=" + id +
                ", localizacao='" + localizacao + '\'' +
                ", referencia='" + referencia + '\'' +
                ", titulo='" + titulo + '\'' +
                ", descricao='" + descricao + '\'' +
                ", status='" + status + '\'' +
                ", ativo=" + ativo +
                ", createdAt=" + createdAt +
                '}';
    }

    //Hash and Equals
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((id == null) ? 0 : id.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Ticket other = (Ticket) obj;
        if (id == null) {
            if (other.id != null)
                return false;
        } else if (!id.equals(other.id))
            return false;
        return true;
    }
}
