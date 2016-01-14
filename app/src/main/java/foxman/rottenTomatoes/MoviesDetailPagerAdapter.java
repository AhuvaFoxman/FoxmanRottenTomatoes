package foxman.rottenTomatoes;

import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.io.Serializable;

/**
 * Created by AFoxman on 1/4/2016.
 */
public class MoviesDetailPagerAdapter extends android.support.v4.view.PagerAdapter implements Serializable {

    private Movie[] movies;


    public MoviesDetailPagerAdapter(Movie[] movies) {
        this.movies = movies;
    }


    public Object instantiateItem(ViewGroup container, int position) {

        LayoutInflater inflater = LayoutInflater.from(container.getContext());
        View view = inflater.inflate(R.layout.rotten_tomatoes_pager_item, null);

        TextView name = (TextView) view.findViewById(R.id.name);
        TextView audience = (TextView) view.findViewById(R.id.audience);
        TextView critics = (TextView) view.findViewById(R.id.critic);
        TextView summary = (TextView) view.findViewById(R.id.summary);
        TextView rated = (TextView) view.findViewById(R.id.rated);
        TextView time = (TextView) view.findViewById(R.id.runtime);
        TextView released = (TextView) view.findViewById(R.id.released);
        ImageView image = (ImageView) view.findViewById(R.id.image);
        ImageView smallImage = (ImageView) view.findViewById(R.id.imageTwo);
        ImageView rottenTomatoesImage = (ImageView) view.findViewById(R.id.rottenTomatoes);
        ImageView flixter = (ImageView) view.findViewById(R.id.criticImage);
        TextView cScore = (TextView) view.findViewById(R.id.cScore);
        TextView aScore = (TextView) view.findViewById(R.id.aScore);


        Movie movie = movies[position];


        Picasso.with(container.getContext())
                .load(movie.getPosters().getProfile()).into(image);


        Picasso.with(container.getContext())
                .load(movie.getPosters().getProfile()).into(smallImage);

        rottenTomatoesImage.setImageResource(R.drawable.rottentomatoes);
        flixter.setImageResource(R.drawable.flixter);

        name.setTextColor(Color.WHITE);
        name.setText(movie.getTitle());

        critics.setTextColor(Color.WHITE);
        critics.setText("Rotten Tomatoes\nCritic Score: ");
        cScore.setTextColor(Color.WHITE);
        cScore.setText(" " + movie.getRatings().getCritics_score() + "%");

        audience.setTextColor(Color.WHITE);
        audience.setText("Flixster\nUser Score: ");
        aScore.setTextColor(Color.WHITE);
        aScore.setText(" " + movie.getRatings().getAudience_score() + "%");


        summary.setText(movie.getSynopsis());
        rated.setText("Rated " + movie.getMpaa_rating());
        time.setText("Running Time " + movie.getRuntime() + " minutes");
        released.setText("Theature Released Date " + movie.getRelease_dates().getTheater());

        container.addView(view);
        return view;

    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        container.removeView((View) object);
    }

    @Override
    public int getCount() {
        return movies.length;
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return view == object;
    }
}
