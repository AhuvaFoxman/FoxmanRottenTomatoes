package foxman.rottenTomatoes;

import java.io.Serializable;

/**
 * Created by AFoxman on 1/3/2016.
 */
public class Rating implements Serializable {

    private String critics_rating;
    private int critics_score;
    private String audience_rating;
    private int audience_score;

    public String getCritics_rating() {
        return this.critics_rating;
    }

    public int getCritics_score() {
        return this.critics_score;
    }

    public String getAudience_rating() {
        return this.audience_rating;
    }

    public int getAudience_score() {
        return this.audience_score;
    }
}
