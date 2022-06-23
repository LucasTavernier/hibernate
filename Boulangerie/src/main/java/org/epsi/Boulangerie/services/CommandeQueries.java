package org.epsi.Boulangerie.services;

import org.epsi.Boulangerie.HibernateUtils;
import org.epsi.Boulangerie.entities.Client;
import org.epsi.Boulangerie.entities.Commande;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;

import java.util.List;

public class CommandeQueries {

    public static List<Commande> getCommandesByClient(Session session, int clientId) {
        String sql = "Select c from " + Commande.class.getName() + " c "
                + " where c.client.id= :clientId";
        Query<Commande> query = session.createQuery(sql);
        query.setParameter("clientId", clientId);
        return query.getResultList();
    }

    public static Commande getLastCommande(Session session, int clientId) {
        String sql = "Select c from " + Commande.class.getName() + " c "//
                + " where c.client.id= :clientId order by COMMANDE_DATE DESC";
        Query<Commande> query = session.createQuery(sql);
        query.setMaxResults(1);
        query.setParameter("clientId", clientId);
        return (Commande) query.uniqueResult();
    }

    public static void main(String[] args) {
        SessionFactory factory = HibernateUtils.getSessionFactory();

        Session session = factory.getCurrentSession();
        session.getTransaction().begin();


        //Commande laDerniereCommande = getLastCommande(session, 0);
        List<Commande> commandesDuClient = getCommandesByClient(session, 0);
        session.getTransaction().commit();

        for(Commande c : commandesDuClient){
            System.out.println(c.toString());
        }

        session.close();

    }
}
