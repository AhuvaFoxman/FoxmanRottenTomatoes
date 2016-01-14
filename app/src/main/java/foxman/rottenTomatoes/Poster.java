package foxman.rottenTomatoes;

import java.io.Serializable;

/**
 * Created by AFoxman on 1/3/2016.
 */
public class Poster implements Serializable {
    private String thumbnail;
    private String profile;

    public String getThumbnail() {
        return this.thumbnail;
    }

    public String getProfile() {
        return this.profile;
    }
}
