package foxman.rottenTomatoes;

import android.content.Context;
import android.support.v4.view.PagerAdapter;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by AFoxman on 1/12/2016.
 */
public class MoviesMainPagerAdapter extends PagerAdapter{

    private UpcomingMovies upcomingMovies;
    private CurrentMovies currentMovies;
    private transient Context context;
    private Movie[] movies;



    public MoviesMainPagerAdapter(CurrentUpcoming currentUpcoming, Context context) {

        this.upcomingMovies = currentUpcoming.getUpcomingMovies();
        this.currentMovies = currentUpcoming.getCurrentMovies();
    }


    public Object instantiateItem(ViewGroup container, int position) {

        LayoutInflater inflater = LayoutInflater.from(container.getContext());
        View itemView = inflater.inflate(R.layout.rotten_tomatoes_list_item, null);


        RecyclerView recyclerView = (RecyclerView) itemView.findViewById(R.id.recyclerView);
        if(position == 0) {
            this.movies = currentMovies.getMovies();
            MoviesRecyclerViewAdapter recyclerViewAdapter = new MoviesRecyclerViewAdapter(movies);
            recyclerView.setAdapter(recyclerViewAdapter);
        }
        else if(position == 1) {
            this.movies = upcomingMovies.getMovies();
            MoviesRecyclerViewAdapter recyclerViewAdapter = new MoviesRecyclerViewAdapter(movies);
            recyclerView.setAdapter(recyclerViewAdapter);
        }

        LinearLayoutManager layoutManager = new LinearLayoutManager(context);
        layoutManager.setOrientation((LinearLayoutManager.VERTICAL));
        recyclerView.setLayoutManager(layoutManager);

        container.addView(itemView);
        return itemView;

    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        container.removeView((View)object);
    }

    @Override
    public int getCount() {
        return 2;
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return view == object;
    }



}

