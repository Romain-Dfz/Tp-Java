package org.example;

import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.Date;
import java.util.List;

public class ProduitDAO {
    private static List<Produit> allProduits;

    public static List<Produit> getAllProduits() {
        return allProduits;
    }

    public static void setAllProduits(List<Produit> allProduits) {
        ProduitDAO.allProduits = allProduits;
    }

    public static List<Produit> getProductsByPriceGreaterThan(double v) {
        return null;
    }

    public static List<Produit> getProductsBetweenDates(Date startDate, Date endDate) {
        return null;
    }

    public Produit getProduitById(int id) {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            return session.get(Produit.class, id);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public void deleteProduitById(int id) {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            Transaction transaction = session.beginTransaction();
            Produit produit = session.get(Produit.class, id);
            if (produit != null) {
                session.delete(produit);
            }
            transaction.commit();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void updateProduit(Produit produit) {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            Transaction transaction = session.beginTransaction();
            session.update(produit);
            transaction.commit();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void createProduit(Produit produit) {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            Transaction transaction = session.beginTransaction();
            session.save(produit);
            transaction.commit();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
