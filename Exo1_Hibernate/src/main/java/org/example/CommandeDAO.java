package org.example;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.util.Date;
import java.util.List;

public class CommandeDAO {

    private static SessionFactory factory;

    public CommandeDAO() {
        try {
            factory = HibernateUtil.getSessionFactory();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void addProduitToCommande(int commandeId, Produit produit) {
        try (Session session = factory.openSession()) {
            Commande commande = session.get(Commande.class, commandeId);
            commande.getProduits().add(produit);
            Transaction tx = session.beginTransaction();
            session.saveOrUpdate(commande);
            tx.commit();
        } catch (HibernateException e) {
            e.printStackTrace();
        }
    }

    public void addAdresseToCommande(int commandeId, Adresse adresse) {
        try (Session session = factory.openSession()) {
            Commande commande = session.get(Commande.class, commandeId);
            commande.setAdresseLivraison(adresse);
            Transaction tx = session.beginTransaction();
            session.saveOrUpdate(commande);
            tx.commit();
        } catch (HibernateException e) {
            e.printStackTrace();
        }
    }

    public List<Commande> getAllCommandes() {
        try (Session session = factory.openSession()) {
            Query<Commande> query = session.createQuery("FROM Commande", Commande.class);
            return query.list();
        } catch (HibernateException e) {
            e.printStackTrace();
            return null;
        }
    }

    public List<Commande> getCommandesDuJour() {
        try (Session session = factory.openSession()) {
            Query<Commande> query = session.createQuery("FROM Commande C WHERE DATE(C.dateCommande) = CURRENT_DATE", Commande.class);
            return query.list();
        } catch (HibernateException e) {
            e.printStackTrace();
            return null;
        }
    }

    public void shutdown() {
    }
}
