package travel.model;
// Generated 16-Nov-2016 14:58:44 by Hibernate Tools 4.3.1

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 * ImagedetailLandscape generated by hbm2java
 */
public class ImagedetailLandscape implements java.io.Serializable, InterfaceEntity {

    private Integer idImage;
    private Landscape landscape;

    public ImagedetailLandscape() {
    }

    public ImagedetailLandscape(Landscape landscape) {
        this.landscape = landscape;
    }

    public Integer getIdImage() {
        return this.idImage;
    }

    public void setIdImage(Integer idImage) {
        this.idImage = idImage;
    }

    public Landscape getLandscape() {
        return this.landscape;
    }

    public void setLandscape(Landscape landscape) {
        this.landscape = landscape;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final ImagedetailLandscape other = (ImagedetailLandscape) obj;
        int id1=this.idImage;
        int id2=other.idImage;
        return (id1==id2);
    }

    @Override
    public int add() {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = null;
        if (this.landscape != null) {
            try {
                tx = session.beginTransaction();
                this.idImage = (Integer) session.save(this);
                tx.commit();
            } catch (HibernateException e) {
                if (tx != null) {
                    tx.rollback();
                }
                e.printStackTrace();
            }
        }
        session.close();
        return this.idImage;
    }

    @Override
    public void update() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void delete() {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = null;
        if (this.landscape != null) {
            try {
                tx = session.beginTransaction();
                session.delete(this);
                tx.commit();
            } catch (HibernateException e) {
                if (tx != null) {
                    tx.rollback();
                }
                e.printStackTrace();
            }
        }
        session.close();
    }

    @Override
    public String getJson() {
        String json = "";

        json += "{"
                + "\"idImage\":" + getIdImage() + ","
                + "\"idLandscape\":" + getLandscape().getIdLandscape()
                + "}";

        return json;
    }

}