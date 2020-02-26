package cindy.pretest.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;



@Entity
@Table(name = "review")
public class Review {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;
    

    @NotNull (message = "rate this")
    @Column(name = "rate_star")//, nullable = false)
    private int rate_star;

    @NotNull (message = "Tulis nama kamu")//, nullable = false)
    @Column(name = "name")
    private String name;


    @NotNull (message = "Tulis Review terbaikmu")//, nullable = false)
    @Column(name = "my_review")
    private String my_review;

    @NotNull (message = " Upload Gambar")//, nullable= true)
    @Column(name = "image")
    private byte[] image;

   

    
    @CreationTimestamp
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "created_at")
    private Date created_at;

    @UpdateTimestamp
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "updated_at")
    private Date updated_at;

 
   @Column(name = "deleted_at")
    private Date deleted_at;

    

  public void setId(Long id){
      this.id=id;
  }

  public void setRateStar(int rate_star){
      this.rate_star=rate_star;
  }

  public int getRateStar(){
      return rate_star;
  }


  public Long getId(){
      return id;
  }

  public void setName(String name){
      this.name=name;

  }

  public String getName(){
      return name;
  }

  public void setReview(String my_review){
      this.my_review=my_review;
  }

  public String getReview(){
      return my_review;
  }

  public void setImage(byte[] image){
      this.image=image;
  }

  public byte[] getImage(){
      return image;
  }

  public Date getCreated_At() {
        return created_at;
    }

    public void setCreated_At(Date created_at) {
        this.created_at = created_at;
    }

    public Date getUpdated_At() {
        return updated_at;
    }

    public void setUpdated_At(Date updated_at) {

        this.updated_at = updated_at;
    }

    public Date getDeleted_At() {
        return deleted_at;
    }
    
    public void setDeleted_At(Date deleted_at) {

        this.deleted_at = deleted_at;
    }



  
}