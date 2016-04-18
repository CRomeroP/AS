/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entrega;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

/**
 *
 * @author carlos
 */
@Entity
@Table(name = "ReservaAmbNotificacio")
public class ReservaAmbNotificacio extends Reserva{
    
    private Set<Persona> notificacions = new HashSet<Persona>(0);

    public ReservaAmbNotificacio() {
    }

    public ReservaAmbNotificacio(Date data, Integer horainici, Integer horafi, String comentaris, Persona persona, Recurs recurs) {
        this.data = data;
        this.horainici = horainici;
        this.horafi = horafi;
        this.comentaris = comentaris;
        this.persona = persona;
        this.recurs = recurs;
    }

    public ReservaAmbNotificacio(Set<Persona> notificacions) {
        this.notificacions = notificacions;
    }
    

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "notificacio_persona", joinColumns = {
        @JoinColumn(name = "recurs", nullable = false),
        @JoinColumn(name = "horaIni", nullable = false),
        @JoinColumn(name = "datar", nullable = false)},
        inverseJoinColumns = {@JoinColumn(name = "username", nullable = false)})
    public Set<Persona> getNotificacions() {
        return notificacions;
    }

    public void setNotificacions(Set<Persona> notificacions) {
        this.notificacions = notificacions;
    }
    
    
    
}
