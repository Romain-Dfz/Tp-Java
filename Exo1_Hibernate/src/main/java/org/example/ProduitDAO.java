package org.example;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.util.List;

public class ProduitDAO {

    private static SessionFactory factory;

    public ProduitDAO() {
        try {
            factory = HibernateUtil.getSessionFactory();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public List<Produit> getAllProduits() {
        try (Session session = factory.openSession()) {
            Query<Produit> query = session.createQuery("FROM Produit", Produit.class);
            return query.list();
        } catch (HibernateException e) {
            e.printStackTrace();
            return null;
        }
    }

    public List<Produit> getProduitsByPriceGreaterThan(double priceThreshold) {
        try (Session session = factory.openSession()) {
            Query<Produit> query = session.createQuery("FROM Produit P WHERE P.prix > :priceThreshold", Produit.class);
            query.setParameter("priceThreshold", priceThreshold);
            return query.list();
        } catch (HibernateException e) {
            e.printStackTrace();
            return null;
        }
    }

    public List<Produit> getProduitsBetweenDates(String startDate, String endDate) {
        try (Session session = factory.openSession()) {
            Query<Produit> query = session.createQuery("FROM Produit P WHERE P.dateAchat BETWEEN :startDate AND :endDate", Produit.class);
            query.setParameter("startDate", startDate);
            query.setParameter("endDate", endDate);
            return query.list();
        } catch (HibernateException e) {
            e.printStackTrace();
            return null;
        }
    }

    public void shutdown() {
    }

    public List<Object[]> getProductsInfoByStockLessThan(int maxStockValue) {
        List<Object[]> o = null;
        return o;
    }
}
