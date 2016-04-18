package Entrega;
// Generated 14-abr-2016 8:24:58 by Hibernate Tools 4.3.1

import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;




/**
 * Persona generated by hbm2java
 */
@Entity
@Table(name = "persona")
public class Persona  implements java.io.Serializable {


     private String username;
     private String nom;
     private String email;
     private Set<Reserva> reservas;
     private Set<ReservaAmbNotificacio> notificacions;

    public Persona() {
    }

    public Persona(String username, String nom, String email) {
        this.username = username;
        this.nom = nom;
        this.email = email;
    }
    
    @Id
    
    @Column(name = "username", length = 50, unique = true, nullable = false)
    public String getUsername() {
        return this.username;
    }
    
    public void setUsername(String username) {
        this.username = username;
    }
    
    @Column(name = "nom", length = 50)
    public String getNom() {
        return this.nom;
    }
    
    public void setNom(String nom) {
        this.nom = nom;
    }
    
    @Column(name = "email", length = 50)
    public String getEmail() {
        return this.email;
    }
    
    public void setEmail(String email) {
        this.email = email;
    }
    
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "persona")
    public Set<Reserva> getReservas() {
	return this.reservas;
    }

    public void setReservas(Set<Reserva> reservas) {
	this.reservas = reservas;
    }
    
    @ManyToMany(fetch = FetchType.LAZY, mappedBy = "notificacions")
    public Set<ReservaAmbNotificacio> getNotificacions() {
        return notificacions;
    }

    public void setNotificacions(Set<ReservaAmbNotificacio> notificacions) {
        this.notificacions = notificacions;
    }
	
}

