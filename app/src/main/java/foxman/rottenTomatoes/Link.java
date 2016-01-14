package foxman.rottenTomatoes;

import java.io.Serializable;

/**
 * Created by AFoxman on 1/3/2016.
 */
public class Link implements Serializable {

    private String self;
    private String alternate;
    private String cast;
    private String reviews;
    private String similar;

    public String getSelf() {
        return self;
    }

    public String getCast() {
        return cast;
    }

    public String getAlternate() {
        return alternate;
    }

    public String getReviews() {
        return reviews;
    }

    public String getSimilar() {
        return similar;
    }
}
