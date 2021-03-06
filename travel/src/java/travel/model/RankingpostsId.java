package travel.model;
// Generated 16-Nov-2016 14:58:44 by Hibernate Tools 4.3.1



/**
 * RankingpostsId generated by hbm2java
 */
public class RankingpostsId  implements java.io.Serializable {


     private int idPosts;
     private int idUser;

    public RankingpostsId() {
    }

    public RankingpostsId(int idPosts, int idUser) {
       this.idPosts = idPosts;
       this.idUser = idUser;
    }
   
    public int getIdPosts() {
        return this.idPosts;
    }
    
    public void setIdPosts(int idPosts) {
        this.idPosts = idPosts;
    }
    public int getIdUser() {
        return this.idUser;
    }
    
    public void setIdUser(int idUser) {
        this.idUser = idUser;
    }


   public boolean equals(Object other) {
         if ( (this == other ) ) return true;
		 if ( (other == null ) ) return false;
		 if ( !(other instanceof RankingpostsId) ) return false;
		 RankingpostsId castOther = ( RankingpostsId ) other; 
         
		 return (this.getIdPosts()==castOther.getIdPosts())
 && (this.getIdUser()==castOther.getIdUser());
   }
   
   public int hashCode() {
         int result = 17;
         
         result = 37 * result + this.getIdPosts();
         result = 37 * result + this.getIdUser();
         return result;
   }   


}


