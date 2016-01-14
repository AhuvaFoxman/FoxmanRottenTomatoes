package foxman.rottenTomatoes;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

/**
 * Created by AFoxman on 1/3/2016.
 */
public class MoviesViewHolder extends RecyclerView.ViewHolder {


    private ImageView image;
    private TextView title;
    private TextView criticScore;
    private TextView audienceScore;
    private TextView cast;
    private TextView rateRuntime;
    private transient Context context;
    private ImageView imageFlixter;
    private ImageView imageRottenTomatoes;

    public MoviesViewHolder(View itemView, Context context) {
        super(itemView);
        this.context = context;
        image = (ImageView) itemView.findViewById(R.id.thumbnail);
        title = (TextView) itemView.findViewById(R.id.title);
        criticScore = (TextView) itemView.findViewById(R.id.critics);
        audienceScore = (TextView) itemView.findViewById(R.id.audience);
        cast = (TextView) itemView.findViewById(R.id.cast);
        rateRuntime = (TextView) itemView.findViewById(R.id.ratingRuntime);
        imageFlixter = (ImageView) itemView.findViewById(R.id.flixterImage);
        imageRottenTomatoes = (ImageView) itemView.findViewById(R.id.rottenTomatoes);


    }

    public void bind(Movie movie) {


        Picasso.with(context)
                .load(movie.getPosters().getProfile()).into(image);


        title.setText(movie.getTitle());
        criticScore.setText(" " + String.valueOf(movie.getRatings().getCritics_score() + "% "));
        audienceScore.setText(" " + String.valueOf(movie.getRatings().getAudience_score() + "% "));


        for (AbridgedCast c : movie.getAbridged_cast()) {
            cast.append(c.getName() + " ");

        }

        rateRuntime.setText(movie.getMpaa_rating() + ", " + movie.getRuntime() + " mins");

        imageRottenTomatoes.setImageResource(R.drawable.rottentomatoes);
        imageFlixter.setImageResource(R.drawable.flixter);


    }
}
