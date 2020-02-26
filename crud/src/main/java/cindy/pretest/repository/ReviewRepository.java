package cindy.pretest.repository;

import java.util.Date;
import java.util.List;

import javax.inject.Singleton;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import io.micronaut.configuration.hibernate.jpa.scope.CurrentSession;
import io.micronaut.spring.tx.annotation.Transactional;
import cindy.pretest.model.Review;

@Singleton
public class ReviewRepository implements ReviewInterface {

    @PersistenceContext
    private EntityManager manager;

    public ReviewRepository(@CurrentSession EntityManager manager){
        this.manager = manager;
    }

    @Override
    @Transactional(readOnly = true)
    public Long size() {
        Long count = manager.createQuery("select count(*) from review where deleted_at IS NULL", Long.class).getSingleResult();
        return count;
    }

    @Override
    @Transactional
    public List<Review> findAll(int page, int limit) {
        TypedQuery<Review> query = manager
                .createQuery("from Review where deleted_at IS NULL", Review.class)
                .setFirstResult(page > 1 ? page * limit - limit : 0)
                .setMaxResults(limit);
        return query.getResultList();
    }

    @Override
    @Transactional(readOnly = true)
    public Review findById(@NotNull Long id) {
        Review query = manager.find(Review.class, id);
        return query;
    }

    @Override
    @Transactional
    public boolean save(@NotNull Review review) {
        try {
            manager.persist(review);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    @Override
    @Transactional
    public boolean update(@NotNull Long id, int rate_star,String name, String my_review, byte[] image) {
        try {

            Review review = manager.find(Review.class, id);
            //if(rate_star.equals("-")==false)review.setRateStar(rate_star);
            if (name.equals("-")==false) review.setName(name);
            if (my_review.equals("-")==false) review.setReview(my_review);
            if (image.equals("-")==false) review.setImage(image);
            
            
          //  if (grade != 0) c.setGrade(grade);
            review.setUpdated_At(new Date());
            return true;
        } catch (Exception e){
            return false;
        }
    }

    @Override
    @Transactional
    public boolean destroy(@NotNull Long id) {
    try {
        Review review = manager.find(Review.class, id); // diganti 
        if(review != null){
            manager.remove(review);
        }
        review.setDeleted_At(new Date());
        return true;
        } catch (Exception e) {
            return false;
        }
    }

}