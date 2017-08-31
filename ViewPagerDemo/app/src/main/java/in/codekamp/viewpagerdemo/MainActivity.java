package in.codekamp.viewpagerdemo;

import android.support.v4.app.FragmentManager;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ViewPager pager = (ViewPager)findViewById(R.id.my_pager);

        FragmentManager fm = getSupportFragmentManager();
        ProfilePagerAdapter adapter = new ProfilePagerAdapter(fm);
        pager.setAdapter(adapter);
    }
}
