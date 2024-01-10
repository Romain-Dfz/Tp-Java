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

    public List<Object[]> getProductsInfoByStockLessThan(int stockThreshold) {
        try (Session session = factory.openSession()) {
            Query<Object[]> query = session.createQuery("SELECT P.id, P.reference FROM Produit P WHERE P.stock < :stockThreshold", Object[].class);
            query.setParameter("stockThreshold", stockThreshold);
            return query.list();
        } catch (HibernateException e) {
            e.printStackTrace();
            return null;
        }
    }

    public int getStockValueByBrand(String brand) {
        try (Session session = factory.openSession()) {
            Query<Integer> query = session.createQuery("SELECT SUM(P.stock) FROM Produit P WHERE P.marque = :brand", Integer.class);
            query.setParameter("brand", brand);
            return query.uniqueResult();
        } catch (HibernateException e) {
            e.printStackTrace();
            return -1;
        }
    }

    public double calculateAveragePrice() {
        try (Session session = factory.openSession()) {
            Query<Double> query = session.createQuery("SELECT AVG(P.prix) FROM Produit P", Double.class);
            return query.uniqueResult();
        } catch (HibernateException e) {
            e.printStackTrace();
            return -1.0;
        }
    }

    public List<Produit> getProductsByBrand(String brand) {
        try (Session session = factory.openSession()) {
            Query<Produit> query = session.createQuery("FROM Produit P WHERE P.marque = :brand", Produit.class);
            query.setParameter("brand", brand);
            return query.list();
        } catch (HibernateException e) {
            e.printStackTrace();
            return null;
        }
    }

    public void deleteProductsByBrand(String brand) {
        try (Session session = factory.openSession()) {
            Transaction tx = session.beginTransaction();
            Query<?> query = session.createQuery("DELETE FROM Produit P WHERE P.marque = :brand");
            query.setParameter("brand", brand);
            query.executeUpdate();
            tx.commit();
        } catch (HibernateException e) {
            e.printStackTrace();
        }
    }

    public void shutdown() {
    }

    public void addImageToProduit(int produitId, Image image) {
        try (Session session = factory.openSession()) {
            Produit produit = session.get(Produit.class, produitId);
            produit.getImages().add(image);
            Transaction tx = session.beginTransaction();
            session.saveOrUpdate(produit);
            tx.commit();
        } catch (HibernateException e) {
            e.printStackTrace();
        }
    }

    public void addCommentaireToProduit(int produitId, Commentaire commentaire) {
        try (Session session = factory.openSession()) {
            Produit produit = session.get(Produit.class, produitId);
            produit.getCommentaires().add(commentaire);
            Transaction tx = session.beginTransaction();
            session.saveOrUpdate(produit);
            tx.commit();
        } catch (HibernateException e) {
            e.printStackTrace();
        }
    }
}
