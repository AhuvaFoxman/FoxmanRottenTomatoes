package foxman.rottenTomatoes;

import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;

import java.io.Serializable;


public class DetailActivity extends AppCompatActivity implements Serializable {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);


        ViewPager viewPager = (ViewPager) findViewById(R.id.viewPager);

        Movie[] movies = (Movie[]) getIntent().getSerializableExtra("MOVIES");
        int position = getIntent().getIntExtra("POSITION", 0);

        MoviesDetailPagerAdapter adapter = new MoviesDetailPagerAdapter(movies);
        viewPager.setAdapter(adapter);
        viewPager.setCurrentItem(position);

    }
}
