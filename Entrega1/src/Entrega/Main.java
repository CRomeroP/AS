package Entrega;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

public class Main {

	public static void main(String[] args) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction transaction = null;
		try {
			transaction = session.beginTransaction();
			Persona persona = new Persona("Ransen", "Carlos", "lituslitus16@gmail.com");
                        Persona persona2 = new Persona();
                        persona2.setUsername("Juan21");
                        persona2.setNom("Juan");
                        persona2.setEmail("juan21@gmail.com");
                        Recurs recurs = new Recurs("PC");
                        Recurs recurs2 = new Recurs();
                        recurs2.setNom("projector");
                        Date data1 = new Date(116,4,14);
                        Date data2 = new Date(116,4,15);
                        Date data3 = new Date(116,4,16);
			Reserva reserva1 = new Reserva(data1, 8, 10,null,persona, recurs);
			Reserva reserva2 = new Reserva();
                        ReservaAmbNotificacio reservaAN = new ReservaAmbNotificacio(data3, 10,18,null,persona,recurs2);
                        Set<Persona> notificacions = new HashSet<Persona>();
                        notificacions.add(persona);
                        notificacions.add(persona2);
                        reservaAN.setNotificacions(notificacions);
                        reserva2.setData(data2);
                        reserva2.setHorainici(15);
                        reserva2.setHorafi(19);
                        reserva2.setPersona(persona2);
                        reserva2.setRecurs(recurs2);
                        System.out.println("Username: " + persona2.getUsername() + 
                                ", nom: " + persona2.getNom() + ", email:" + 
                                persona2.getEmail());
                        System.out.println("Nom recurs: " + recurs2.getNom());
                        System.out.println("Data: " + reserva2.getData() + ", hora inici: "
                                + reserva2.getHorainici() + ", hora fi: " + reserva2.getHorafi()
                                + ", comentari: " + reserva2.getComentaris()
                                + ", persona: " + (reserva2.getPersona()).getUsername()
                                + ", recurs: " + (reserva2.getRecurs()).getNom());
                        session.save(persona);
                        session.save(recurs);
                        session.save(persona2);
                        session.save(recurs2);
			session.save(reserva1);
			session.save(reserva2);
                        session.save(reservaAN);
			transaction.commit();
		} catch (HibernateException e) {
			transaction.rollback();
			e.printStackTrace();
		} finally {
			session.close();
		}

	}

}