package foxman.rottenTomatoes;

/**
 * Created by AFoxman on 1/12/2016.
 */
public class CurrentUpcoming {

    private CurrentMovies currentMovies;

    private UpcomingMovies upcomingMovies;

    public CurrentUpcoming (CurrentMovies currentMovies, UpcomingMovies upcomingMovies){
        this.currentMovies = currentMovies;
        this.upcomingMovies = upcomingMovies;
    }

    public CurrentMovies getCurrentMovies(){
        return  this.currentMovies;
    }

    public UpcomingMovies getUpcomingMovies(){
        return this.upcomingMovies;
    }
}
