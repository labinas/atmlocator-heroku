package dians.atmlocator.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.Data;

import javax.persistence.*;

@Data
@Entity
public class Review {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    @ManyToOne
    ApplicationUser user;
    @Column(length = 4000)
    String reviewText;
    int rating;
    @ManyToOne
    Atm atm;

    public Review() {
    }

    public Review(ApplicationUser user, String reviewText, int rating, Atm atm) {
        this.user = user;
        this.reviewText = reviewText;
        this.rating = rating;
        this.atm = atm;
    }

    public String getReviewerUsername(){
        return user.getUsername();
    }

    @JsonBackReference
    public ApplicationUser getUser() {
        return user;
    }

    @JsonBackReference
    public Atm getAtm() {
        return atm;
    }

}
