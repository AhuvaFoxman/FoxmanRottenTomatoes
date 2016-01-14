package foxman.rottenTomatoes;

import java.io.Serializable;

/**
 * Created by AFoxman on 1/3/2016.
 */
public class Movie implements Serializable {

    private String title;
    private int year;
    private String mpaa_rating;
    private String runtime;
    private ReleaseDate release_dates;
    private Rating ratings;
    private String synopsis;
    private Poster posters;
    private AbridgedCast[] abridged_cast;
    private Link links;

    public Link getLinks() {
        return links;
    }

    public String getTitle() {
        return title;
    }

    public int getYear() {
        return year;
    }

    public String getMpaa_rating() {
        return mpaa_rating;
    }

    public String getRuntime() {
        return runtime;
    }

    public ReleaseDate getRelease_dates() {
        return release_dates;
    }

    public Rating getRatings() {
        return ratings;
    }

    public String getSynopsis() {
        return synopsis;
    }

    public Poster getPosters() {
        return this.posters;
    }

    public AbridgedCast[] getAbridged_cast() {
        return abridged_cast;
    }


}
