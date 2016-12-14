package travel.model;
// Generated 16-Nov-2016 14:58:44 by Hibernate Tools 4.3.1

import com.google.gson.annotations.SerializedName;
import java.util.HashSet;
import java.util.List;
import java.util.Objects;
import java.util.Set;
import org.hibernate.Criteria;
import org.hibernate.FetchMode;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.CriteriaSpecification;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.LogicalExpression;
import org.hibernate.criterion.Restrictions;

/**
 * User generated by hbm2java
 */
public class User implements java.io.Serializable, InterfaceEntity {

    private Integer idUser;
    @SerializedName(value = "name")
    private String fullname;
    private String username;
    private String password;
    private String email;
    private int state;
    private String profile;
    private int typeUser;
    @SerializedName(value = "id")
    private String facebookId;
    private Set rankingfestivals = new HashSet(0);
    private Set postsFavorite = new HashSet(0);
    private Set rankingpostses = new HashSet(0);
    private Set landscapeFavorite = new HashSet(0);
    private Set comments = new HashSet(0);
    private Set posts = new HashSet(0);
    private Set rankinglandscapes = new HashSet(0);
    private Set festivalFavorite = new HashSet(0);

    public User() {
    }

    public User(String fullname, String username, String password, String email, int state, int typeUser) {
        this.fullname = fullname;
        this.username = username;
        this.password = password;
        this.email = email;
        this.state = state;
        this.typeUser = typeUser;
    }
    
    public User(String name, int state, int typeUser, String facebookId) {
        this.fullname = name;
        this.username = facebookId;
        this.state = state;
        this.typeUser = typeUser;
        this.facebookId = facebookId;
    }

    public User(String fullname, String username, String password, String email, int state, String profile, int typeUser, Set rankingfestivals, Set postses, Set rankingpostses, Set landscapes, Set comments, Set postses_1, Set rankinglandscapes, Set festivals) {
        this.fullname = fullname;
        this.username = username;
        this.password = password;
        this.email = email;
        this.state = state;
        this.profile = profile;
        this.typeUser = typeUser;
        this.rankingfestivals = rankingfestivals;
        this.postsFavorite = postses;
        this.rankingpostses = rankingpostses;
        this.landscapeFavorite = landscapes;
        this.comments = comments;
        this.posts = postses_1;
        this.rankinglandscapes = rankinglandscapes;
        this.festivalFavorite = festivals;
    }
    
    public User(String name, int state, String profile, int typeUser, String facebookId, Set rankingfestivals, Set postses, Set rankingpostses, Set landscapes, Set comments, Set postses_1, Set rankinglandscapes, Set festivals) {
        this.fullname = name;
        this.username = name;
        this.state = state;
        this.profile = profile;
        this.typeUser = typeUser;
        this.facebookId = facebookId;
        this.rankingfestivals = rankingfestivals;
        this.postsFavorite = postses;
        this.rankingpostses = rankingpostses;
        this.landscapeFavorite = landscapes;
        this.comments = comments;
        this.posts = postses_1;
        this.rankinglandscapes = rankinglandscapes;
        this.festivalFavorite = festivals;
    }

    public Integer getIdUser() {
        return this.idUser;
    }

    public void setIdUser(Integer idUser) {
        this.idUser = idUser;
    }

    public String getFullname() {
        return this.fullname;
    }

    public void setFullname(String fullname) {
        this.fullname = fullname;
    }

    public String getUsername() {
        return this.username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return this.password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return this.email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getState() {
        return this.state;
    }

    public void setState(int state) {
        this.state = state;
    }

    public String getProfile() {
        return this.profile;
    }

    public void setProfile(String profile) {
        this.profile = profile;
    }

    public int getTypeUser() {
        return this.typeUser;
    }

    public void setTypeUser(int typeUser) {
        this.typeUser = typeUser;
    }

    public String getFacebookId() {
        return facebookId;
    }

    public void setFacebookId(String facebookId) {
        this.facebookId = facebookId;
    }
    
    public Set getRankingfestivals() {
        return this.rankingfestivals;
    }

    public void setRankingfestivals(Set rankingfestivals) {
        this.rankingfestivals = rankingfestivals;
    }

    public Set getPostsFavorite() {
        return this.postsFavorite;
    }

    public void setPostsFavorite(Set postsUserFavorite) {
        this.postsFavorite = postsUserFavorite;
    }

    public Set getRankingpostses() {
        return this.rankingpostses;
    }

    public void setRankingpostses(Set rankingpostses) {
        this.rankingpostses = rankingpostses;
    }

    public Set getLandscapeFavorite() {
        return this.landscapeFavorite;
    }

    public void setLandscapeFavorite(Set landscapeFavorite) {
        this.landscapeFavorite = landscapeFavorite;
    }

    public Set getComments() {
        return this.comments;
    }

    public void setComments(Set comments) {
        this.comments = comments;
    }

    public Set getPosts() {
        return this.posts;
    }

    public void setPosts(Set posts) {
        this.posts = posts;
    }

    public Set getRankinglandscapes() {
        return this.rankinglandscapes;
    }

    public void setRankinglandscapes(Set rankinglandscapes) {
        this.rankinglandscapes = rankinglandscapes;
    }

    public Set getFestivalFavorite() {
        return this.festivalFavorite;
    }

    public void setFestivalFavorite(Set festivalFavorite) {
        this.festivalFavorite = festivalFavorite;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 37 * hash + Objects.hashCode(this.idUser);
        hash = 37 * hash + Objects.hashCode(this.fullname);
        hash = 37 * hash + Objects.hashCode(this.username);
        hash = 37 * hash + Objects.hashCode(this.password);
        hash = 37 * hash + Objects.hashCode(this.email);
        hash = 37 * hash + this.state;
        hash = 37 * hash + Objects.hashCode(this.profile);
        hash = 37 * hash + this.typeUser;
        hash = 37 * hash + Objects.hashCode(this.facebookId);
        hash = 37 * hash + Objects.hashCode(this.rankingfestivals);
        hash = 37 * hash + Objects.hashCode(this.postsFavorite);
        hash = 37 * hash + Objects.hashCode(this.rankingpostses);
        hash = 37 * hash + Objects.hashCode(this.landscapeFavorite);
        hash = 37 * hash + Objects.hashCode(this.comments);
        hash = 37 * hash + Objects.hashCode(this.posts);
        hash = 37 * hash + Objects.hashCode(this.rankinglandscapes);
        hash = 37 * hash + Objects.hashCode(this.festivalFavorite);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        int id1 = this.idUser;
        if (obj == null) {
            return false;
        }
        final User other = (User) obj;
        int id2 = other.idUser;
        return (id1 == id2||this.username.compareTo(other.getUsername())==0);
    }

    @Override
    public int add() {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = null;
        Integer id = -2;
        if (this.fullname != null && this.username != null) {
            User t = getUserByUserName(this.username);
            User t2 = getUserByEmail(this.email);
            if (t == null && t2 == null) {
                try {
                    this.state = 1;
                    tx = session.beginTransaction();
                    id = (Integer) session.save(this);
                    tx.commit();
                    this.idUser = id;
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
        if (this.fullname != null && this.username != null && this.password != null && this.email != null && this.idUser != null) {
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

    @Override
    public void update() {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = null;
        if (this.fullname != null && this.username != null && this.password != null && this.email != null && this.idUser != null) {
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

    public static List getAllListUser() {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Criteria cr = session.createCriteria(User.class).setResultTransformer(CriteriaSpecification.DISTINCT_ROOT_ENTITY);
        List user = null;
        try {
            user = cr.list();
        } catch (HibernateException e) {
            e.printStackTrace();
        }
        session.close();
        return user;
    }

    public static User getUserById(int id) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Criteria cr = session.createCriteria(User.class).setFetchMode("rankingfestivals", FetchMode.EAGER)
                .setFetchMode("postsFavorite", FetchMode.EAGER).setFetchMode("rankingpostses", FetchMode.EAGER)
                .setFetchMode("landscapeFavorite", FetchMode.EAGER).setFetchMode("posts", FetchMode.EAGER)
                .setFetchMode("rankinglandscapes", FetchMode.EAGER).setFetchMode("festivalFavorite", FetchMode.EAGER)
                .setFetchMode("comments", FetchMode.EAGER)
                .setResultTransformer(CriteriaSpecification.DISTINCT_ROOT_ENTITY);
        cr.add(Restrictions.eq("idUser", id));
        List user = null;
        try {
            user = cr.list();
        } catch (HibernateException e) {
            e.printStackTrace();
        }
        if (user != null && !user.isEmpty()) {
            User temp = (User) user.get(0);
            session.close();
            return temp;
        } else {
            session.close();
            return null;
        }
    }

    public static User getUserByUserName(String username) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Criteria cr = session.createCriteria(User.class).setFetchMode("rankingfestivals", FetchMode.EAGER)
                .setFetchMode("postsFavorite", FetchMode.EAGER).setFetchMode("rankingpostses", FetchMode.EAGER)
                .setFetchMode("landscapeFavorite", FetchMode.EAGER).setFetchMode("posts", FetchMode.EAGER)
                .setFetchMode("rankinglandscapes", FetchMode.EAGER).setFetchMode("festivalFavorite", FetchMode.EAGER)
                .setFetchMode("comments", FetchMode.EAGER)
                .setResultTransformer(CriteriaSpecification.DISTINCT_ROOT_ENTITY);
        cr.add(Restrictions.eq("username", username));
        List listuser = null;
        try {
            listuser = cr.list();
        } catch (HibernateException e) {
            e.printStackTrace();
        }
        if (listuser != null && !listuser.isEmpty()) {
            User temp = (User) listuser.get(0);
            session.close();
            return temp;
        } else {
            session.close();
            return null;
        }
    }

    public static User getUserByEmail(String email) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Criteria cr = session.createCriteria(User.class).setFetchMode("rankingfestivals", FetchMode.EAGER)
                .setFetchMode("postsFavorite", FetchMode.EAGER).setFetchMode("rankingpostses", FetchMode.EAGER)
                .setFetchMode("landscapeFavorite", FetchMode.EAGER).setFetchMode("posts", FetchMode.EAGER)
                .setFetchMode("rankinglandscapes", FetchMode.EAGER).setFetchMode("festivalFavorite", FetchMode.EAGER)
                .setFetchMode("comments", FetchMode.EAGER)
                .setResultTransformer(CriteriaSpecification.DISTINCT_ROOT_ENTITY);
        cr.add(Restrictions.eq("email", email));
        List user = cr.list();
        if (user != null && !user.isEmpty()) {
            User temp = (User) user.get(0);
            session.close();
            return temp;
        } else {
            session.close();
            return null;
        }
    }

    public void lock() {
        this.state = -1;
        this.update();
    }

    public void unlock() {
        this.state = 1;
        this.update();
    }

    public static int login(String username, String password) {
        User u = User.getUserByUserName(username);
        if (u == null) {
            return -1;
        } else {
            if (u.getPassword().compareTo(password) == 0) {
                return 1;
            } else {
                return -2;
            }
        }
    }
    
    public static User checkLoginFb(String facebookId){
        Session session = HibernateUtil.getSessionFactory().openSession();
        Criteria cr = session.createCriteria(User.class);
        cr.add(Restrictions.eq("facebookId", facebookId));

        List user = cr.list();
        if (user != null && !user.isEmpty()) {
            User temp = (User) user.get(0);
            session.close();
            return temp;
        } else {
            session.close();
            return null;
        }
    }

    public List search(String input) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Criteria cr = session.createCriteria(User.class);
        Criterion username = Restrictions.like("username", "%" + input + "%");
        Criterion fullname = Restrictions.like("fullname", "%" + input + "%");
        LogicalExpression orExp = Restrictions.or(username, fullname);
        cr.setFetchMode("rankingfestivals", FetchMode.EAGER)
                .setFetchMode("postsFavorite", FetchMode.EAGER).setFetchMode("rankingpostses", FetchMode.EAGER)
                .setFetchMode("landscapeFavorite", FetchMode.EAGER).setFetchMode("posts", FetchMode.EAGER)
                .setFetchMode("rankinglandscapes", FetchMode.EAGER).setFetchMode("festivalFavorite", FetchMode.EAGER)
                .setFetchMode("comments", FetchMode.EAGER);
        cr.add(orExp).setResultTransformer(CriteriaSpecification.DISTINCT_ROOT_ENTITY);
        List user = cr.list();
        return user;
    }

    @Override
    public String getJson() {
        String json = "";

        json += "{"
                + "\"idUser\":" + getIdUser() + ","
                + "\"fullname\":\"" + getFullname() + "\","
                + "\"username\":\"" + getUsername() + "\","
                + "\"password\":\"" + getPassword() + "\","
                + "\"email\":\"" + getEmail() + "\","
                + "\"profile\":\"" + getProfile() + "\","
                + "\"state\":" + getState() + ","
                + "\"typeUser\":" + getTypeUser()
                + "}";

        return json;
    }
}
