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
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.CriteriaSpecification;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.LogicalExpression;
import org.hibernate.criterion.Restrictions;

/**
 * Festival generated by hbm2java
 */
public class Festival implements java.io.Serializable, InterfaceEntity, InterfacePartOfDestination {

    private Integer idFestival;
    private Destination destination;
    private String title;
    private String discription;
    private String imageProfile;
    private int state;
    private Set rankingfestivals = new HashSet(0);
    private Set usersFavorite = new HashSet(0);
    private Set imagedetailFestivals = new HashSet(0);

    public Festival() {
    }

    public Festival(Destination destination, String title, String discription, String imageProfile, int state) {
        this.destination = destination;
        this.title = title;
        this.discription = discription;
        this.imageProfile = imageProfile;
        this.state = state;
    }

    public Festival(Destination destination, String title, String discription, String imageProfile, int state, Set rankingfestivals, Set users, Set imagedetailFestivals) {
        this.destination = destination;
        this.title = title;
        this.discription = discription;
        this.imageProfile = imageProfile;
        this.state = state;
        this.rankingfestivals = rankingfestivals;
        this.usersFavorite = users;
        this.imagedetailFestivals = imagedetailFestivals;
    }

    public Integer getIdFestival() {
        return this.idFestival;
    }

    public void setIdFestival(Integer idFestival) {
        this.idFestival = idFestival;
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

    public Set getRankingfestivals() {
        return this.rankingfestivals;
    }

    public void setRankingfestivals(Set rankingfestivals) {
        this.rankingfestivals = rankingfestivals;
    }

    public Set getUsersFavorite() {
        return this.usersFavorite;
    }

    public void setUsersFavorite(Set users) {
        this.usersFavorite = users;
    }

    public Set getImagedetailFestivals() {
        return this.imagedetailFestivals;
    }

    public void setImagedetailFestivals(Set imagedetailFestivals) {
        this.imagedetailFestivals = imagedetailFestivals;
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
        final Festival other = (Festival) obj;
        int id1 = this.idFestival;
        int id2 = other.idFestival;
        return (id1==id2);
    }

    @Override
    public int add() {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = null;
        Integer id = -2;
        if (this.title != null && this.destination != null && this.discription != null) {

            Festival f = getFesByTitle(this.title);
            if (f == null) {
                try {
                    this.state = 1;
                    tx = session.beginTransaction();
                    id = (Integer) session.save(this);
                    tx.commit();
                    this.idFestival = id;
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
        if (this.title != null && this.destination != null && this.discription != null && this.idFestival != null) {
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
        if (this.title != null && this.destination != null && this.discription != null && this.idFestival != null) {
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
        if (this.title != null && this.destination != null && this.discription != null && this.idFestival != null) {
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

    @Override
    public void addToUserFavorite(User u) {
        if (!this.usersFavorite.contains(u)) {
            this.getUsersFavorite().add(u);
            u.getFestivalFavorite().add(this);
            this.update();
            u.update();
        }
    }

    @Override
    public void deleteFavorite(User u) {
        this.getUsersFavorite().remove(u);
        u.getFestivalFavorite().remove(this);
        this.update();
        u.update();
    }

    @Override
    public float getRank() {
        int sizeRank = this.rankingfestivals.size();
        float rank = 0;
        for (Object rl : this.rankingfestivals) {
            Rankingfestival rlt = (Rankingfestival) rl;
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
        String sql = "SELECT R.festival  FROM Rankingfestival R WHERE R.festival.state=1 GROUP BY R.festival ORDER BY avg(R.rank) DESC";
        Session session = HibernateUtil.getSessionFactory().openSession();
        Query query = session.createQuery(sql);
        List results = query.list();
        if (results.size() > numberTop) {
            results = results.subList(0, numberTop);
        }
        List listTop = new ArrayList();
        int loop;
        if (results.size() > numberTop) {
            loop = numberTop;
        } else {
            loop = results.size();
        }
        for (int i = 0; i < loop; i++) {
            Festival temp = (Festival) results.get(i);
            listTop.add(Festival.getFestivalById(temp.getIdFestival()));
        }
        
        session.close();
        if(listTop.size()<numberTop){
            List additionItem=getAllInstance(numberTop-listTop.size());
            listTop.addAll(additionItem);
        }
        return listTop;
    }

    public static Festival getFesByTitle(String title) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Criteria cr = session.createCriteria(Festival.class).setFetchMode("rankingfestivals", FetchMode.EAGER)
                .setFetchMode("usersFavorite", FetchMode.EAGER)
                .setFetchMode("imagedetailFestivals", FetchMode.EAGER)
                .setFetchMode("destination", FetchMode.EAGER)
                .setResultTransformer(CriteriaSpecification.DISTINCT_ROOT_ENTITY);
        cr.add(Restrictions.eq("title", title));
        List listFes = cr.list();
        if (listFes != null && !listFes.isEmpty()) {
            Festival temp = (Festival) listFes.get(0);
            session.close();
            return temp;
        } else {
            session.close();
            return null;
        }
    }

    public static Festival getFestivalById(int id) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Criteria cr = session.createCriteria(Festival.class).setFetchMode("rankingfestivals", FetchMode.EAGER)
                .setFetchMode("usersFavorite", FetchMode.EAGER)
                .setFetchMode("imagedetailFestivals", FetchMode.EAGER)
                .setFetchMode("destination", FetchMode.EAGER)
                .setResultTransformer(CriteriaSpecification.DISTINCT_ROOT_ENTITY);
        cr.add(Restrictions.eq("idFestival", id));
        List listFes = cr.list();
        if (listFes != null && !listFes.isEmpty()) {
            Festival temp = (Festival) listFes.get(0);
            session.close();
            return temp;
        } else {
            session.close();
            return null;
        }
    }

    @Override
    public List search(String input) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Criteria cr = session.createCriteria(Festival.class);
        Criterion title = Restrictions.like("title", "%" + input + "%");
        Criterion description = Restrictions.like("discription", "%" + input + "%");
        LogicalExpression orExp = Restrictions.or(title, description);
        cr.add(orExp);
        cr.setFetchMode("rankingfestivals", FetchMode.EAGER)
                .setFetchMode("usersFavorite", FetchMode.EAGER)
                .setFetchMode("imagedetailFestivals", FetchMode.EAGER)
                .setFetchMode("destination", FetchMode.EAGER)
                .setResultTransformer(CriteriaSpecification.DISTINCT_ROOT_ENTITY);
        List lFes = cr.list();
        session.close();
        return lFes;
    }
        public static List getAllInstance(int limitnumber) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Criteria cr = session.createCriteria(Festival.class);
        cr.setMaxResults(limitnumber);
        cr.setFirstResult(0);
        cr.add(Restrictions.eq("state", 1));
        List lDes = cr.list();
        session.close();
        return lDes;

    }

    public static List getAll() {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Criteria cr = session.createCriteria(Festival.class);
        cr.setFetchMode("rankingfestivals", FetchMode.EAGER)
                .setFetchMode("usersFavorite", FetchMode.EAGER)
                .setFetchMode("imagedetailFestivals", FetchMode.EAGER)
                .setFetchMode("destination", FetchMode.EAGER)
                .setResultTransformer(CriteriaSpecification.DISTINCT_ROOT_ENTITY);
        List lDes = cr.list();
        session.close();
        return lDes;

    }
    public static List getAllInstance() {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Criteria cr = session.createCriteria(Festival.class);
        cr.setFetchMode("rankingfestivals", FetchMode.EAGER)
                .setFetchMode("usersFavorite", FetchMode.EAGER)
                .setFetchMode("imagedetailFestivals", FetchMode.EAGER)
                .setFetchMode("destination", FetchMode.EAGER)
                .setResultTransformer(CriteriaSpecification.DISTINCT_ROOT_ENTITY);
        cr.add(Restrictions.eq("state", 1));
        List lDes = cr.list();
        session.close();
        return lDes;

    }
    public static long getCountAll() {
        String sql = "SELECT count(*)  FROM Festival";
        Session session = HibernateUtil.getSessionFactory().openSession();
        Query query = session.createQuery(sql);
        List results = query.list();
        session.close();
        long number = (Long)results.get(0);
        return number;
    }
    public static long getCountAllInstance() {
        String sql = "SELECT count(*)  FROM Festival f WHERE f.state=1";
        Session session = HibernateUtil.getSessionFactory().openSession();
        Query query = session.createQuery(sql);
        List results = query.list();
        session.close();
        long number = (Long)results.get(0);
        return number;
    }
    public static long getCountDeleted() {
        String sql = "SELECT count(*)  FROM Festival f WHERE f.state=-1";
        Session session = HibernateUtil.getSessionFactory().openSession();
        Query query = session.createQuery(sql);
        List results = query.list();
        session.close();
        long number = (Long)results.get(0);
        return number;
    }
    @Override
    public String getJson() {
        String json = "";

        json += "{"
                + "\"idFestival\":" + getIdFestival() + ","
                + "\"idDestination\":" + getDestination().getIdDestination() + ","
                + "\"title\":\"" + getTitle() + "\","
                + "\"discription\":\"" + getDiscription() + "\","
                + "\"imageProfile\":\"" + getImageProfile() + "\","
                + "\"state\":" + getState()
                + "}";

        return json;
    }
    public static void main(String args[]){
        System.out.println(getCountDeleted());
    }
}
