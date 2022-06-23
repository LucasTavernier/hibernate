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
        String sql = "Select * from " + Commande.class.getName() + " c "//
                + " where c.CLNT_ID= :clientId;";
        Query<Commande> query = session.createQuery(sql);
        query.setParameter("clientId", clientId);
        return query.getResultList();
    }

    public static Commande getLastCommande(Session session, int clientId) {
        String sql = "Select * from " + Commande.class.getName() + " c "//
                + " where c.CLNT_ID= :clientId order by COMMANDE_DATE DESC";
        Query<Commande> query = session.createQuery(sql);
        query.setMaxResults(1);
        query.setParameter("clientId", clientId);
        return (Commande) query.uniqueResult();
    }

    public static void main(String[] args) {
        SessionFactory factory = HibernateUtils.getSessionFactory();

        Session session = factory.getCurrentSession();


        Client client1 = new Client(0,"Tavernier", "Lucas","0102030405");

        Commande laDerniereCommande = getLastCommande(session, client1.getId());

        List<Commande> toutesMesCommandes = getCommandesByClient(session, client1.getId());

    }
}
