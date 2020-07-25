package com.example.shamithhshetty.userprofile_android;

import android.os.Build;
import android.support.v4.content.ContextCompat;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;

import com.example.shamithhshetty.userprofile_android.Model.CardItem;

import de.hdodenhof.circleimageview.CircleImageView;

public class MainActivity extends AppCompatActivity {

    //img picker
    private static final String TAG = MainActivity.class.getSimpleName();
    public static final int REQUEST_IMAGE = 100;

    private Button mButton;
    private ViewPager mViewPager;
    private CardPagerAdapter mCardAdapter;
    private ShadowTransformer mCardShadowTransformer;
    private ShadowTransformer mFragmentCardShadowTransformer;

    private boolean mShowingFragments = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mViewPager = (ViewPager) findViewById(R.id.viewPager);

        if (Build.VERSION.SDK_INT >= 21) {
            getWindow().setStatusBarColor(ContextCompat.getColor(this,R.color.mainColor)); //status bar or the time bar at the top
        }

        mCardAdapter = new CardPagerAdapter(this);
        mCardAdapter.addCardItem(new CardItem("Name","shamith","Phone","9008809863","personal info",R.drawable.ic_name,R.drawable.ic_phone));
        mCardAdapter.addCardItem(new CardItem("Phone","9008809863","Address","Mangalore","private info",R.drawable.ic_phone,R.drawable.ic_addr));
        mCardAdapter.addCardItem(new CardItem("Gender","Male","Color","red","education",R.drawable.ic_name,R.drawable.ic_phone));
        mCardAdapter.addCardItem(new CardItem("Height","30HHP","Weight","305gram","Body Info",R.drawable.ic_name,R.drawable.ic_phone));


        mCardShadowTransformer = new ShadowTransformer(mViewPager, mCardAdapter);
        mCardShadowTransformer.enableScaling(true);

        mViewPager.setAdapter(mCardAdapter);
        mViewPager.setPageTransformer(false, mCardShadowTransformer);
        mViewPager.setOffscreenPageLimit(3);

    }

}
