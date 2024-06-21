package br.com.unifil.pontolimpo.entites;

import jakarta.persistence.OneToMany;

import java.util.ArrayList;
import java.util.List;

public class Analyst extends User {

    @OneToMany
    List<Ticket> listaTicket  = new ArrayList();

    //Constructor

    public Analyst(List listaTicket) {
        this.listaTicket = listaTicket;
    }

    //Get SET

    public List getListaTicket() {
        return listaTicket;
    }

    public void setListaTicket(List listaTicket) {
        this.listaTicket = listaTicket;
    }
}
