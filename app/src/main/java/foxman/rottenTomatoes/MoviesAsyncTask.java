package foxman.rottenTomatoes;

import android.content.Context;
import android.support.v4.view.ViewPager;

import com.google.gson.Gson;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 * Created by AFoxman on 1/3/2016.
 */

public class MoviesAsyncTask extends android.os.AsyncTask<String, Void, CurrentUpcoming> {

    private ViewPager viewPager;
    private Context context;

    public MoviesAsyncTask(ViewPager viewPager, Context context) {
        this.viewPager = viewPager;
        this.context = context;
    }


    /*run method - gets called in a separate thread*/
    @Override
    protected CurrentUpcoming doInBackground(String... params) {
        CurrentMovies movies = null;
        UpcomingMovies upcomingMovies = null;
        CurrentUpcoming currentUpcoming = null;

        try {
            URL url = new URL("http://api.rottentomatoes.com/api/public/v1.0/lists/movies/box_office.json?apikey=cart6246nbex6fqchrj5t4b8&limit=30");
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            InputStream in = connection.getInputStream();


            BufferedReader reader = new BufferedReader(
                    new InputStreamReader(in));
            Gson gson = new Gson();

            movies = gson.fromJson(reader, CurrentMovies.class);

            url = new URL("http://api.rottentomatoes.com/api/public/v1.0/lists/movies/upcoming.json?apikey=cart6246nbex6fqchrj5t4b8&limit=30");
            connection = (HttpURLConnection) url.openConnection();
            in = connection.getInputStream();


            reader = new BufferedReader(
                    new InputStreamReader(in));


            upcomingMovies = gson.fromJson(reader, UpcomingMovies.class);

            currentUpcoming = new CurrentUpcoming(movies, upcomingMovies);

        } catch (IOException e) {
            e.printStackTrace();
        }


        return currentUpcoming;
    }

    /*what to do when the MoviesAsyncTask completes
    * gets called on the UIThread. all text views can only be modified on the UIThread*/
    @Override
    protected void onPostExecute(CurrentUpcoming currentUpcoming) {
        super.onPostExecute(currentUpcoming);
        Movie[] movies = currentUpcoming.getCurrentMovies().getMovies();
        MoviesMainPagerAdapter adapter = new MoviesMainPagerAdapter(currentUpcoming, context);

        viewPager.setAdapter(adapter);


    }


}



