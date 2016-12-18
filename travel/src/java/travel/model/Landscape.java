package travel.model;
// Generated 16-Nov-2016 14:58:44 by Hibernate Tools 4.3.1

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import org.hibernate.Criteria;
import org.hibernate.FetchMode;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.CriteriaSpecification;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.LogicalExpression;
import org.hibernate.criterion.Restrictions;

/**
 * Landscape generated by hbm2java
 */
public class Landscape implements java.io.Serializable, InterfaceEntity, InterfacePartOfDestination {

    private Integer idLandscape;
    private Destination destination;
    private String title;
    private String discription;
    private String imageProfile;
    private int state;
    private Set imagedetailLandscapes = new HashSet(0);
    private Set usersFavorite = new HashSet(0);
    private Set rankinglandscapes = new HashSet(0);

    public Landscape() {
    }

    public Landscape(Destination destination, String title, String discription, String imageProfile, int state) {
        this.destination = destination;
        this.title = title;
        this.discription = discription;
        this.imageProfile = imageProfile;
        this.state = state;
    }

    public Landscape(Destination destination, String title, String discription, String imageProfile, int state, Set imagedetailLandscapes, Set users, Set rankinglandscapes) {
        this.destination = destination;
        this.title = title;
        this.discription = discription;
        this.imageProfile = imageProfile;
        this.state = state;
        this.imagedetailLandscapes = imagedetailLandscapes;
        this.usersFavorite = users;
        this.rankinglandscapes = rankinglandscapes;
    }

    public Integer getIdLandscape() {
        return this.idLandscape;
    }

    public void setIdLandscape(Integer idLandscape) {
        this.idLandscape = idLandscape;
    }

    public Destination getDestination() {
        return this.destination;
    }

    public void setDestination(Destination destination) {
        this.destination = destination;
    }

    public String getTitle() {
        return this.title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDiscription() {
        return this.discription;
    }

    public void setDiscription(String discription) {
        this.discription = discription;
    }

    public String getImageProfile() {
        return this.imageProfile;
    }

    public void setImageProfile(String imageProfile) {
        this.imageProfile = imageProfile;
    }

    public int getState() {
        return this.state;
    }

    public void setState(int state) {
        this.state = state;
    }

    public Set getImagedetailLandscapes() {
        return this.imagedetailLandscapes;
    }

    public void setImagedetailLandscapes(Set imagedetailLandscapes) {
        this.imagedetailLandscapes = imagedetailLandscapes;
    }

    public Set getUsersFavorite() {
        return this.usersFavorite;
    }

    public void setUsersFavorite(Set users) {

        this.usersFavorite = users;
    }

    public Set getRankinglandscapes() {
        return this.rankinglandscapes;
    }

    public void setRankinglandscapes(Set rankinglandscapes) {
        this.rankinglandscapes = rankinglandscapes;
    }

    @Override
    public int hashCode() {
        int hash = 5;
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
        final Landscape other = (Landscape) obj;
        int id1 = this.idLandscape;
        int id2 = other.idLandscape;

        return (id1 == id2);
    }

    @Override
    public int add() {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = null;
        Integer id = -2;
        if (this.title != null && this.destination != null && this.discription != null) {

            Landscape l = getLandscapeByTitle(this.title);
            if (l == null) {
                try {
                    this.state = 1;
                    tx = session.beginTransaction();
                    id = (Integer) session.save(this);
                    tx.commit();
                    this.idLandscape = id;
                } catch (HibernateException e) {
                    if (tx != null) {
                        tx.rollback();
                    }
                    e.printStackTrace();
                }
            } else {
                id = -1;
            }
        }
        session.close();
        return id;
    }

    @Override
    public void update() {

        if (this.title != null && this.destination != null && this.discription != null && this.idLandscape != null) {
            Session session = HibernateUtil.getSessionFactory().openSession();
            Transaction tx = null;
            try {
                tx = session.beginTransaction();
                session.update(this);
                tx.commit();
            } catch (HibernateException e) {
                if (tx != null) {
                    tx.rollback();
                }
                e.printStackTrace();
            }
            session.close();
        }
    }

    @Override
    public void delete() {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = null;
        if (this.title != null && this.destination != null && this.discription != null && this.idLandscape != null) {
            try {
                tx = session.beginTransaction();
                this.state = -1;
                session.update(this);
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

    public void restore() {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = null;
        if (this.title != null && this.destination != null && this.discription != null && this.idLandscape != null) {
            try {
                tx = session.beginTransaction();
                this.state = 1;
                session.update(this);
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

    public static Landscape getLandscapeByTitle(String title) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Criteria cr = session.createCriteria(Landscape.class).setFetchMode("imagedetailLandscapes", FetchMode.EAGER)
                .setFetchMode("usersFavorite", FetchMode.EAGER).setFetchMode("rankinglandscapes", FetchMode.EAGER)
                .setFetchMode("destination", FetchMode.EAGER)
                .setResultTransformer(CriteriaSpecification.DISTINCT_ROOT_ENTITY);

        cr.add(Restrictions.eq("title", title));
        System.out.println(cr.toString());
        List listLand = cr.list();
        if (listLand != null && !listLand.isEmpty()) {
            Landscape temp = (Landscape) listLand.get(0);
            session.close();
            return temp;
        } else {
            session.close();
            return null;
        }
    }

    public static Landscape getLandscapeById(int id) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Criteria cr = session.createCriteria(Landscape.class).setFetchMode("imagedetailLandscapes", FetchMode.EAGER)
                .setFetchMode("usersFavorite", FetchMode.EAGER).setFetchMode("rankinglandscapes", FetchMode.EAGER)
                .setFetchMode("destination", FetchMode.EAGER)
                .setResultTransformer(CriteriaSpecification.DISTINCT_ROOT_ENTITY);
        cr.add(Restrictions.eq("idLandscape", id));
        List listLand = cr.list();
        if (listLand != null && !listLand.isEmpty()) {
            Landscape temp = (Landscape) listLand.get(0);
            session.close();
            return temp;
        } else {
            session.close();
            return null;
        }
    }

    @Override
    public void addToUserFavorite(User u) {
        if (!this.usersFavorite.contains(u)) {
            this.getUsersFavorite().add(u);
            u.getLandscapeFavorite().add(this);
            this.update();
            u.update();
        }
    }

    @Override
    public void deleteFavorite(User u) {
        this.getUsersFavorite().remove(u);
        u.getLandscapeFavorite().remove(this);
        u.update();
        this.update();
    }



    @Override
    public float getRank() {
        int sizeRank = this.rankinglandscapes.size();
        float rank = 0;
        for (Object rl : this.rankinglandscapes) {
            Rankinglandscape rlt = (Rankinglandscape) rl;
            rank += rlt.getRank();
        }
        if (sizeRank != 0) {
            return rank / sizeRank;
        } else {
            return 0;
        }
    }

    @Override
    public List getTop(int numberTop) {
        String sql
                = "SELECT R.landscape  FROM Rankinglandscape R WHERE R.landscape.state=1 GROUP BY R.landscape ORDER BY avg(R.rank) DESC";
        Session session = HibernateUtil.getSessionFactory().openSession();
        Query query = session.createQuery(sql);
        List results = query.list();
        List listTop = new ArrayList();
        int loop;
        if (results.size() > numberTop) {
            loop = numberTop;
        } else {
            loop = results.size();
        }
        for (int i = 0; i < loop; i++) {
            Landscape temp = (Landscape) results.get(i);
            listTop.add(Landscape.getLandscapeById(temp.getIdLandscape()));
        }
        
        session.close();
        if(listTop.size()<numberTop){
            listTop.addAll(getAllInstance(numberTop-listTop.size()));
        }
        return listTop;
    }

    @Override
    public List search(String input) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Criteria cr = session.createCriteria(Landscape.class);
        Criterion title = Restrictions.like("title", "%" + input + "%");
        Criterion description = Restrictions.like("discription", "%" + input + "%");
        LogicalExpression orExp = Restrictions.or(title, description);
        cr.add(orExp);
        cr.setFetchMode("imagedetailLandscapes", FetchMode.EAGER)
                .setFetchMode("usersFavorite", FetchMode.EAGER).setFetchMode("rankinglandscapes", FetchMode.EAGER)
                .setFetchMode("destination", FetchMode.EAGER)
                .setResultTransformer(CriteriaSpecification.DISTINCT_ROOT_ENTITY);
        List lLand = cr.list();
        session.close();
        return lLand;
    }
    public static List getAllInstance(int limitnumber) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Criteria cr = session.createCriteria(Landscape.class);
        cr.setMaxResults(limitnumber);
        cr.add(Restrictions.eq("state", 1));
        cr.setFirstResult(0);
        List lDes = cr.list();
        
        session.close();
        return lDes;
    }
        public static void main(String args[]) {
         List t=getAllInstance(4);
         
         System.out.println(t.size());
         for(int i=0;i<t.size();i++){
             Landscape temp=(Landscape)t.get(i);
             System.out.println(temp.getIdLandscape());
         }
    }

    public static List getAll() {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Criteria cr = session.createCriteria(Landscape.class);
        cr.setFetchMode("imagedetailLandscapes", FetchMode.EAGER)
                .setFetchMode("usersFavorite", FetchMode.EAGER).setFetchMode("rankinglandscapes", FetchMode.EAGER)
                .setFetchMode("destination", FetchMode.EAGER)
                .setResultTransformer(CriteriaSpecification.DISTINCT_ROOT_ENTITY);
        List lDes = cr.list();
        session.close();
        return lDes;
    }

    public static List getAllInstance() {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Criteria cr = session.createCriteria(Landscape.class);
        cr.setFetchMode("imagedetailLandscapes", FetchMode.EAGER)
                .setFetchMode("usersFavorite", FetchMode.EAGER).setFetchMode("rankinglandscapes", FetchMode.EAGER)
                .setFetchMode("destination", FetchMode.EAGER)
                .setResultTransformer(CriteriaSpecification.DISTINCT_ROOT_ENTITY);
        cr.add(Restrictions.eq("state", 1));
        List lDes = cr.list();
        session.close();
        return lDes;
    }

    @Override
    public String getJson() {
        String json = "";

        json += "{"
                + "\"idLandscape\":" + getIdLandscape() + ","
                + "\"idDestination\":" + getDestination().getIdDestination() + ","
                + "\"title\":\"" + getTitle() + "\","
                + "\"discription\":\"" + getDiscription() + "\","
                + "\"imageProfile\":\"" + getImageProfile() + "\","
                + "\"state\":" + getState()
                + "}";

        return json;
    }

}
