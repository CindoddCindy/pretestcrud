package cindy.pretest.repository;

import java.util.List;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import cindy.pretest.model.Review;

public interface ReviewInterface {

    Long size();
    List<Review> findAll (int page, int limit);
    Review findById (@NotNull Long id);
    boolean save(@NotNull Review review);
    boolean update(@NotNull Long id,@NotBlank int rate_star, @NotBlank String name, @NotBlank String my_review, @NotBlank byte[] image); // @NotNull int grade);
    boolean destroy(@NotNull Long id);
}