package com.unifil.pontolimpo.entites;

public class Ticket {

    private Long id;
    private String localização;
    private String titulo;
    private String descrição;
    

    //Constructor
    public Ticket(Long id, String localização, String titulo, String descrição) {
        this.id = id;
        this.localização = localização;
        this.titulo = titulo;
        this.descrição = descrição;
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

    public String getLocalização() {
        return localização;
    }

    public void setLocalização(String localização) {
        this.localização = localização;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getDescrição() {
        return descrição;
    }

    public void setDescrição(String descrição) {
        this.descrição = descrição;
    }
    //toString

    @Override
    public String toString() {
        return "Ticket [id=" + id + ", localização=" + localização + ", titulo=" + titulo + ", descrição=" + descrição
                + "]";
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
