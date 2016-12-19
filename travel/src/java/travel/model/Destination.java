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
 * Destination generated by hbm2java
 */
public class Destination implements java.io.Serializable, InterfaceEntity {

    private Integer idDestination;
    private String title;
    private String nameArea;
    private String discription;
    private String imageProfile;
    private int state;
    private Set imagedetailDestinations = new HashSet(0);
    private Set landscapes = new HashSet(0);
    private Set postses = new HashSet(0);
    private Set festivals = new HashSet(0);

    public Destination() {
    }

    public Destination(String title, String nameArea, String discription, String imageProfile, int state) {
        this.title = title;
        this.nameArea = nameArea;
        this.discription = discription;
        this.imageProfile = imageProfile;
        this.state = state;
    }

    public Destination(String title, String nameArea, String discription, String imageProfile, int state, Set imagedetailDestinations, Set landscapes, Set postses, Set festivals) {
        this.title = title;
        this.nameArea = nameArea;
        this.discription = discription;
        this.imageProfile = imageProfile;
        this.state = state;
        this.imagedetailDestinations = imagedetailDestinations;
        this.landscapes = landscapes;
        this.postses = postses;
        this.festivals = festivals;
    }

    public Integer getIdDestination() {
        return this.idDestination;
    }

    public void setIdDestination(Integer idDestination) {
        this.idDestination = idDestination;
    }

    public String getTitle() {
        return this.title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getNameArea() {
        return this.nameArea;
    }

    public void setNameArea(String nameArea) {
        this.nameArea = nameArea;
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

    public Set getImagedetailDestinations() {
        return this.imagedetailDestinations;
    }

    public void setImagedetailDestinations(Set imagedetailDestinations) {
        this.imagedetailDestinations = imagedetailDestinations;
    }

    public Set getLandscapes() {
        return this.landscapes;
    }

    public void setLandscapes(Set landscapes) {
        this.landscapes = landscapes;
    }

    public Set getPostses() {
        return this.postses;
    }

    public void setPostses(Set postses) {
        this.postses = postses;
    }

    public Set getFestivals() {
        return this.festivals;
    }

    public void setFestivals(Set festivals) {
        this.festivals = festivals;
    }
    public ArrayList<Landscape> getLandscapeInstance(){
        int size=this.landscapes.size();
        Object arrl[]=this.landscapes.toArray();
        ArrayList listlandinstance=new ArrayList();
        for(int i=0;i<size;i++){
            Landscape temp=(Landscape)arrl[i];
            if(temp.getState()==1){
                listlandinstance.add(temp);
            }
        }
        return listlandinstance;
    }
    public ArrayList<Festival> getFestivalInstance(){
        int size=this.festivals.size();
        Object arrl[]=this.festivals.toArray();
        ArrayList listFesinstance=new ArrayList();
        for(int i=0;i<size;i++){
            Festival temp=(Festival)arrl[i];
            if(temp.getState()==1){
                listFesinstance.add(temp);
            }
        }
        return listFesinstance;
    }
    public ArrayList<Posts> getPostsInstance(){
        int size=this.postses.size();
        Object arrl[]=this.postses.toArray();
        ArrayList listPosinstance=new ArrayList();
        for(int i=0;i<size;i++){
            Posts temp=(Posts)arrl[i];
            if(temp.getState()==1){
                listPosinstance.add(temp);
            }
        }
        return listPosinstance;
    }
    @Override
    public int hashCode() {
        int hash = 3;
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
        final Destination other = (Destination) obj;
        int id1 = this.idDestination;
        int id2 = other.idDestination;
        return !(id1 != id2 && this.title.compareTo(other.title) != 0);
    }

    @Override
    public int add() {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = null;
        Integer id = -2;
        if (this.title != null && this.nameArea != null && this.discription != null) {
            Destination d = getDesByTitle(this.title);
            if (d == null) {
                try {
                    this.state = 1;
                    tx = session.beginTransaction();
                    id = (Integer) session.save(this);
                    tx.commit();
                    this.idDestination = id;
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
    public void delete() {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = null;
        if (this.title != null && this.nameArea != null && this.discription != null && this.idDestination != null) {
            try {
                // delete logic all landscape, Post, Festival
                for (Object l : this.landscapes) {
                    Landscape temp = (Landscape) l;
                    temp.delete();
                }
                for (Object f : this.festivals) {
                    Festival temp = (Festival) f;
                    temp.delete();
                }
                for (Object p : this.postses) {
                    Posts temp = (Posts) p;
                    temp.delete();
                }
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
        if (this.title != null && this.nameArea != null && this.discription != null && this.idDestination != null) {
            try {
                // delete logic all landscape, Post, Festival
                for (Object l : this.landscapes) {
                    Landscape temp = (Landscape) l;
                    temp.restore();
                }
                for (Object f : this.festivals) {
                    Festival temp = (Festival) f;
                    temp.restore();
                }
                for (Object p : this.postses) {
                    Posts temp = (Posts) p;
                    temp.restore();
                }
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
    public void update() {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = null;
        if (this.title != null && this.nameArea != null && this.discription != null && this.idDestination != null) {
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
        }
        session.close();
    }

    public static List getAllListDes() {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Criteria cr = session.createCriteria(Destination.class).setFetchMode("imagedetailDestinations", FetchMode.EAGER)
                .setFetchMode("postses", FetchMode.EAGER).setFetchMode("landscapes", FetchMode.EAGER)
                .setFetchMode("festivals", FetchMode.EAGER)
                .setResultTransformer(CriteriaSpecification.DISTINCT_ROOT_ENTITY);
        List lDes = null;
        try {
            lDes = cr.list();
        } catch (HibernateException e) {
            e.printStackTrace();
        } finally {
            session.close();
        }
        return lDes;
    }
    
        public static List getAllListDesIstance() {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Criteria cr = session.createCriteria(Destination.class).setFetchMode("imagedetailDestinations", FetchMode.EAGER)
                .setFetchMode("postses", FetchMode.EAGER).setFetchMode("landscapes", FetchMode.EAGER)
                .setFetchMode("festivals", FetchMode.EAGER)
                .setResultTransformer(CriteriaSpecification.DISTINCT_ROOT_ENTITY);
        cr.add(Restrictions.eq("state", 1));
        List lDes = null;
        try {
            lDes = cr.list();
        } catch (HibernateException e) {
            e.printStackTrace();
        } finally {
            session.close();
        }
        return lDes;
    }
    public static List getLazyAllListDes() {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Criteria cr = session.createCriteria(Destination.class)
                .setResultTransformer(CriteriaSpecification.DISTINCT_ROOT_ENTITY);
        
        List lDes = null;
        try {
            lDes = cr.list();
        } catch (HibernateException e) {
            e.printStackTrace();
        } finally {
            session.close();
        }
        return lDes;
    }
    public static List getLazyAllListDesInstance() {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Criteria cr = session.createCriteria(Destination.class)
                .setResultTransformer(CriteriaSpecification.DISTINCT_ROOT_ENTITY);
        cr.add(Restrictions.eq("state", 1));
        List lDes = null;
        try {
            lDes = cr.list();
        } catch (HibernateException e) {
            e.printStackTrace();
        } finally {
            session.close();
        }
        return lDes;
    }

    /**
     * get destination by region
     *
     * @param region 1 means region='miền bắc' , 2 means region='miền trung', 3
     * means 'miền nam'
     * @return
     */
    public static List getLazyAllListDesByRegion(int region) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Criteria cr = session.createCriteria(Destination.class)
                .setResultTransformer(CriteriaSpecification.DISTINCT_ROOT_ENTITY);
        String strregion;
        if (region == 1) {
            strregion = "%Miền Bắc%";
        } else if (region == 2) {
            strregion = "%Miền Trung%";
        } else {
            strregion = "%Miền Nam%";
        }
        cr.add(Restrictions.like("nameArea", strregion));
        List lDes = null;

        try {
            lDes = cr.list();
        } catch (HibernateException e) {
            e.printStackTrace();
        } finally {
            session.close();
        }
        return lDes;
    }

    public static Destination getDesById(int id) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        List lDes = null;

        try {
            Criteria cr = session.createCriteria(Destination.class).setFetchMode("imagedetailDestinations", FetchMode.EAGER)
                    .setFetchMode("postses", FetchMode.EAGER).setFetchMode("landscapes", FetchMode.EAGER)
                    .setFetchMode("festivals", FetchMode.EAGER)
                    .setResultTransformer(CriteriaSpecification.DISTINCT_ROOT_ENTITY);
            cr.add(Restrictions.eq("idDestination", id));
            lDes = cr.list();
        } catch (HibernateException e) {
            e.printStackTrace();
        }
        if (lDes != null && !lDes.isEmpty()) {
            Destination temp = (Destination) lDes.get(0);
            session.close();
            return temp;
        } else {
            session.close();
            return null;
        }
    }

    public static Destination getDesByTitle(String titleintput) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Criteria cr = session.createCriteria(Destination.class).setFetchMode("imagedetailDestinations", FetchMode.EAGER)
                    .setFetchMode("postses", FetchMode.EAGER).setFetchMode("landscapes", FetchMode.EAGER)
                    .setFetchMode("festivals", FetchMode.EAGER)
                    .setResultTransformer(CriteriaSpecification.DISTINCT_ROOT_ENTITY);
        
        cr.add(Restrictions.eq("title",titleintput));
        System.out.println(cr.toString());
        List listLand = cr.list();
        if (listLand != null && !listLand.isEmpty()) {
            Destination temp = (Destination) listLand.get(0);
            session.close();
            return temp;
        } else {
            session.close();
            return null;
        }

    }

    public List search(String input) {

        Session session = HibernateUtil.getSessionFactory().openSession();
        Criteria cr = session.createCriteria(Destination.class);
        Criterion title = Restrictions.like("title", "%" + input + "%");
        Criterion description = Restrictions.like("discription", "%" + input + "%");
        LogicalExpression orExp = Restrictions.or(title, description);
        cr.add(orExp);
        cr.setFetchMode("imagedetailDestinations", FetchMode.EAGER)
                .setFetchMode("postses", FetchMode.EAGER).setFetchMode("landscapes", FetchMode.EAGER)
                .setFetchMode("festivals", FetchMode.EAGER).setResultTransformer(CriteriaSpecification.DISTINCT_ROOT_ENTITY);
        List lDes = null;
        try {
            lDes = cr.list();
        } catch (HibernateException e) {
            e.printStackTrace();
        }
        session.close();
        return lDes;
    }
    
    public static long getCountAll() {
        String sql = "SELECT count(*)  FROM Destination";
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
                + "\"idDestination\":" + getIdDestination() + ","
                + "\"nameArea\":\"" + getNameArea() + "\","
                + "\"title\":\"" + getTitle() + "\","
                + "\"discription\":\"" + getDiscription() + "\","
                + "\"imageProfile\":\"" + getImageProfile() + "\","
                + "\"state\":" + getState()
                + "}";

        return json;
    }

}
