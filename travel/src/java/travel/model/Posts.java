package travel.model;
// Generated 16-Nov-2016 14:58:44 by Hibernate Tools 4.3.1

import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Objects;
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
 * Posts generated by hbm2java
 */
public class Posts implements java.io.Serializable, InterfaceEntity, InterfacePartOfDestination {

    private Integer idPosts;
    private Destination destination;
    private User userPost;
    private String title;
    private String context;
    private int state;
    private Date datePost;
    private Set usersFarvorite = new HashSet(0);
    private Set rankingpostses = new HashSet(0);
    private Set imagedetailPostses = new HashSet(0);
    private Set comments = new HashSet(0);

    public Posts() {
    }

    public Posts(Destination destination, User user, String title, String context, int state, Date datePost) {
        this.destination = destination;
        this.userPost = user;
        this.title = title;
        this.context = context;
        this.state = state;
        this.datePost = datePost;
    }

    public Posts(Destination destination, User user, String title, String context, int state, Date datePost, Set users, Set rankingpostses, Set imagedetailPostses, Set comments) {
        this.destination = destination;
        this.userPost = user;
        this.title = title;
        this.context = context;
        this.state = state;
        this.datePost = datePost;
        this.usersFarvorite = users;
        this.rankingpostses = rankingpostses;
        this.imagedetailPostses = imagedetailPostses;
        this.comments = comments;
    }

    public Integer getIdPosts() {
        return this.idPosts;
    }

    public void setIdPosts(Integer idPosts) {
        this.idPosts = idPosts;
    }

    public Destination getDestination() {
        return this.destination;
    }

    public void setDestination(Destination destination) {
        this.destination = destination;
    }

    public User getUserPost() {
        return this.userPost;
    }

    public void setUserPost(User user) {
        this.userPost = user;
    }

    public String getTitle() {
        return this.title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContext() {
        return this.context;
    }

    public void setContext(String context) {
        this.context = context;
    }

    public int getState() {
        return this.state;
    }

    public void setState(int state) {
        this.state = state;
    }

    public Date getDatePost() {
        return this.datePost;
    }

    public void setDatePost(Date datePost) {
        this.datePost = datePost;
    }

    public Set getUsersFarvorite() {
        return this.usersFarvorite;
    }

    public void setUsersFarvorite(Set users) {
        this.usersFarvorite = users;
    }

    public Set getRankingpostses() {
        return this.rankingpostses;
    }

    public void setRankingpostses(Set rankingpostses) {
        this.rankingpostses = rankingpostses;
    }

    public Set getImagedetailPostses() {
        return this.imagedetailPostses;
    }

    public void setImagedetailPostses(Set imagedetailPostses) {
        this.imagedetailPostses = imagedetailPostses;
    }

    public Set getComments() {
        return this.comments;
    }

    public void setComments(Set comments) {
        this.comments = comments;
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
        final Posts other = (Posts) obj;
        if (!Objects.equals(this.idPosts, other.idPosts)) {
            return false;
        }
        if (!Objects.equals(this.title, other.title)) {
            return false;
        }
        int id1 = this.idPosts;
        int id2 = other.idPosts;
        return (id1==id2);
    }

    @Override
    public int add() {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = null;
        Integer id = -2;
        if (this.title != null && this.destination != null
                && this.context != null && this.userPost != null) {

            //Posts p = getPostsByTitle(this.title);
            System.out.println("ducvu: no null all");
            Posts p=null;
            
            if (p == null) {

                try {
                    this.datePost = new Date();
                    this.state = 0;
                    tx = session.beginTransaction();
                    id = (Integer) session.save(this);
                    this.idPosts = id;
                    tx.commit();
                    this.idPosts = id;
                } catch (HibernateException e) {
                    if (tx != null) {
                        tx.rollback();
                    }
                    e.printStackTrace();
                }
            } else {
                id = -1;
            }
        }else{
        }
        session.close();
        return id;
    }

    @Override
    public void update() {
        if (this.title != null && this.destination != null && this.context != null && this.idPosts != null) {
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
        if (this.title != null && this.destination != null && this.context != null && this.idPosts != null) {
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
        if (this.title != null && this.destination != null && this.context != null && this.idPosts != null) {
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
        if (!this.usersFarvorite.contains(u)) {
            this.usersFarvorite.add(u);
            u.getPostsFavorite().add(this);
            this.update();
            u.update();
        } 
    }

    @Override
    public void deleteFavorite(User u) {
        this.getUsersFarvorite().remove(u);
        u.getPostsFavorite().remove(this);
        this.update();
        u.update();
    }

    @Override
    public float getRank() {
        int sizeRank = this.rankingpostses.size();
        float rank = 0;
        for (Object rl : this.rankingpostses) {
            Rankingposts rlt = (Rankingposts) rl;
            rank += rlt.getRank();
        }
        if (sizeRank != 0) {
            return rank/sizeRank;
        } else {
            return 0;
        }
    }

    @Override
    public List getTop(int numberTop) {
        String sql = "SELECT R.posts  FROM Rankingposts R WHERE R.posts.state=1 GROUP BY R.posts ORDER BY avg(rank) DESC";
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
            Posts temp = (Posts) results.get(i);
            listTop.add(Posts.getPostsById(temp.getIdPosts()));
                    
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
        Criteria cr = session.createCriteria(Posts.class);
        Criterion title = Restrictions.like("title", "%" + input + "%");
        Criterion description = Restrictions.like("context", "%" + input + "%");
        LogicalExpression orExp = Restrictions.or(title, description);
        cr.add(orExp);
        cr.setFetchMode("destination", FetchMode.EAGER)
                .setFetchMode("usersFarvorite", FetchMode.EAGER)
                .setFetchMode("rankingpostses", FetchMode.EAGER)
                .setFetchMode("imagedetailPostses", FetchMode.EAGER)
                .setFetchMode("comments", FetchMode.EAGER)
                .setFetchMode("userPost", FetchMode.EAGER)
                .setResultTransformer(CriteriaSpecification.DISTINCT_ROOT_ENTITY);
        List lDes = cr.list();
        session.close();
        return lDes;
    }
    
    public static List getAllInstance(int limitnumber) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Criteria cr = session.createCriteria(Posts.class);
        List lPosts = null;
        cr.setMaxResults(limitnumber);
        cr.setFirstResult(0);
        cr.add(Restrictions.eq("state", 1));
        try {
            lPosts = cr.list();
        } catch (HibernateException e) {
            e.printStackTrace();
        }
        session.close();
        return lPosts;
    }
    
    public static List getAll() {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Criteria cr = session.createCriteria(Posts.class);
        List lPosts = null;
        cr.setFetchMode("destination", FetchMode.EAGER)
                .setFetchMode("usersFarvorite", FetchMode.EAGER)
                .setFetchMode("rankingpostses", FetchMode.EAGER)
                .setFetchMode("imagedetailPostses", FetchMode.EAGER)
                .setFetchMode("comments", FetchMode.EAGER)
                .setFetchMode("userPost", FetchMode.EAGER)
                .setResultTransformer(CriteriaSpecification.DISTINCT_ROOT_ENTITY);
        try {
            lPosts = cr.list();
        } catch (HibernateException e) {
            e.printStackTrace();
        }
        session.close();
        return lPosts;
    }
public static List getAllInstance() {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Criteria cr = session.createCriteria(Posts.class);
        List lPosts = null;
        cr.setFetchMode("destination", FetchMode.EAGER)
                .setFetchMode("usersFarvorite", FetchMode.EAGER)
                .setFetchMode("rankingpostses", FetchMode.EAGER)
                .setFetchMode("imagedetailPostses", FetchMode.EAGER)
                .setFetchMode("comments", FetchMode.EAGER)
                .setFetchMode("userPost", FetchMode.EAGER)
                .setResultTransformer(CriteriaSpecification.DISTINCT_ROOT_ENTITY);
        cr.add(Restrictions.eq("state", 1));
        try {
            lPosts = cr.list();
        } catch (HibernateException e) {
            e.printStackTrace();
        }
        session.close();
        return lPosts;
    }

    public void accept() {
        this.state = 1;
        this.update();
    }

    public static List getListPostNeedApprove() {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Criteria cr = session.createCriteria(Posts.class);
        cr.add(Restrictions.eq("state", 0));
        List lPosts = null;
        cr.setFetchMode("destination", FetchMode.EAGER)
                .setFetchMode("usersFarvorite", FetchMode.EAGER)
                .setFetchMode("rankingpostses", FetchMode.EAGER)
                .setFetchMode("imagedetailPostses", FetchMode.EAGER)
                .setFetchMode("comments", FetchMode.EAGER)
                .setFetchMode("userPost", FetchMode.EAGER)
                .setResultTransformer(CriteriaSpecification.DISTINCT_ROOT_ENTITY);
        try {
            lPosts = cr.list();
        } catch (HibernateException e) {
            e.printStackTrace();
        }
        session.close();
        return lPosts;
    }

    public static Posts getPostsByTitle(String title) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Criteria cr = session.createCriteria(Posts.class);
        cr.setFetchMode("destination", FetchMode.EAGER)
                .setFetchMode("usersFarvorite", FetchMode.EAGER)
                .setFetchMode("rankingpostses", FetchMode.EAGER)
                .setFetchMode("imagedetailPostses", FetchMode.EAGER)
                .setFetchMode("comments", FetchMode.EAGER)
                .setFetchMode("userPost", FetchMode.EAGER)
                .setResultTransformer(CriteriaSpecification.DISTINCT_ROOT_ENTITY);
        cr.add(Restrictions.eq("title", title));
        List listLand = cr.list();
        if (listLand != null && !listLand.isEmpty()) {
            Posts temp = (Posts) listLand.get(0);
            session.close();
            return temp;
        } else {
            session.close();
            return null;
        }
    }

    public static Posts getPostsById(int id) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Criteria cr = session.createCriteria(Posts.class);
        cr.setFetchMode("destination", FetchMode.EAGER)
                .setFetchMode("usersFarvorite", FetchMode.EAGER)
                .setFetchMode("rankingpostses", FetchMode.EAGER)
                .setFetchMode("imagedetailPostses", FetchMode.EAGER)
                .setFetchMode("comments", FetchMode.EAGER)
                .setFetchMode("userPost", FetchMode.EAGER)
                .setResultTransformer(CriteriaSpecification.DISTINCT_ROOT_ENTITY);
        cr.add(Restrictions.eq("idPosts", id));

        List listLand = cr.list();
        if (listLand != null && !listLand.isEmpty()) {
            Posts temp = (Posts) listLand.get(0);
            session.close();
            return temp;
        } else {
            session.close();
            return null;
        }
    }

    public void removeComment(Comment comment) {
        this.comments.remove(comment);
        this.update();

    }
    public static long getCountAll() {
        String sql = "SELECT count(*)  FROM Posts";
        Session session = HibernateUtil.getSessionFactory().openSession();
        Query query = session.createQuery(sql);
        List results = query.list();
        session.close();
        long number = (Long)results.get(0);
        return number;
    }
    public static long getCountAllInstance() {
        String sql = "SELECT count(*)  FROM Posts p WHERE p.state=1";
        Session session = HibernateUtil.getSessionFactory().openSession();
        Query query = session.createQuery(sql);
        List results = query.list();
        session.close();
        long number = (Long)results.get(0);
        return number;
    }
    public static long getCountNeedApprove() {
        String sql = "SELECT count(*)  FROM Posts p WHERE p.state=0";
        Session session = HibernateUtil.getSessionFactory().openSession();
        Query query = session.createQuery(sql);
        List results = query.list();
        session.close();
        long number = (Long)results.get(0);
        return number;
    }
    public static long getCountDeleted() {
        String sql = "SELECT count(*)  FROM Posts p WHERE p.state=0";
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
                + "\"idPosts\":" + getIdPosts() + ","
                + "\"idDestination\":" + getDestination().getIdDestination() + ","
                + "\"idUserPost\":" + getUserPost().getIdUser() + ","
                + "\"title\":\"" + getTitle() + "\","
                + "\"context\":\"" + getContext() + "\","
                + "\"state\":" + getState() + ","
                + "\"datePost\":\"" + getDatePost() + "\""
                + "}";

        return json;
    }
    public static void main(String args[]){
        System.out.println(getCountNeedApprove());
    }
}
