package foxman.rottenTomatoes;


import java.io.Serializable;

public class CurrentMovies implements Serializable {

    private Movie[] movies;

    public Movie[] getMovies() {
        return this.movies;
    }

}
