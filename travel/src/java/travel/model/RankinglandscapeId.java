package travel.model;
// Generated 16-Nov-2016 14:58:44 by Hibernate Tools 4.3.1



/**
 * RankinglandscapeId generated by hbm2java
 */
public class RankinglandscapeId  implements java.io.Serializable {


     private int idLandscape;
     private int idUser;

    public RankinglandscapeId() {
    }

    public RankinglandscapeId(int idLandscape, int idUser) {
       this.idLandscape = idLandscape;
       this.idUser = idUser;
    }
   
    public int getIdLandscape() {
        return this.idLandscape;
    }
    
    public void setIdLandscape(int idLandscape) {
        this.idLandscape = idLandscape;
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
		 if ( !(other instanceof RankinglandscapeId) ) return false;
		 RankinglandscapeId castOther = ( RankinglandscapeId ) other; 
         
		 return (this.getIdLandscape()==castOther.getIdLandscape())
 && (this.getIdUser()==castOther.getIdUser());
   }
   
   public int hashCode() {
         int result = 17;
         
         result = 37 * result + this.getIdLandscape();
         result = 37 * result + this.getIdUser();
         return result;
   }   


}


