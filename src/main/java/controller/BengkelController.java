/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import java.util.List;
import model.HibernateUtil;
import model.ModelBengkel;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

/**
 *
 * @author azizb
 */
public class BengkelController {
    public void addBkl(ModelBengkel bkl){
        Transaction trx = null;

        try (Session session = HibernateUtil.getSessionFactory().openSession()){
            trx = session.beginTransaction();
            session.save(bkl);
            trx.commit();
        }catch (Exception e){
            if (trx != null){
                trx.rollback();
            }
            e.printStackTrace();
        }
    }
    
    public void updateBkl(ModelBengkel bkl) {
        Transaction trx = null;

        try (Session session = HibernateUtil.getSessionFactory().openSession()){
            trx = session.beginTransaction();
            session.update(bkl);
            trx.commit();
        } catch (Exception e){
            if (trx != null){
                trx.rollback();
            }
            e.printStackTrace();
        }
    }
    
    public void deleteBkl(int no) {
        Transaction trx = null;

        try (Session session = HibernateUtil.getSessionFactory().openSession()){
            trx = session.beginTransaction();
            ModelBengkel bkl = session.get(ModelBengkel.class, no);
            if(bkl != null){
                session.delete(bkl);
                System.out.println("Berhasil hapus");
            }
            trx.commit();
        } catch (Exception e){
            if (trx != null){
                trx.rollback();
            }
            e.printStackTrace();
        }
    }
    
    public List<ModelBengkel> getAllBengkel() {
        Transaction trx = null;
        List<ModelBengkel> listBkl = null;

        try (Session session = HibernateUtil.getSessionFactory().openSession()){
            trx = session.beginTransaction();
                        Query<ModelBengkel> query = session.createQuery("from ModelBengkel", ModelBengkel.class);
            listBkl = query.list();

            trx.commit(); // Commit transaction
        } catch (Exception e) {
            if (trx != null) {
                trx.rollback();             }
            e.printStackTrace();
        }

        return listBkl;
    }
}
