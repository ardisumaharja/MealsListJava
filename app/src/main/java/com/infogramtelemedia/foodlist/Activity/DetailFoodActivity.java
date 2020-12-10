package com.infogramtelemedia.foodlist.Activity;

import androidx.annotation.Nullable;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.google.android.material.tabs.TabLayout;
import com.infogramtelemedia.foodlist.Adapter.AdapterListString;
import com.infogramtelemedia.foodlist.Adapter.AdapterPages;
import com.infogramtelemedia.foodlist.BaseAndContract.ActivityContract;
import com.infogramtelemedia.foodlist.BaseAndContract.BaseActivity;
import com.infogramtelemedia.foodlist.Fragments.IngredientsFragments;
import com.infogramtelemedia.foodlist.Fragments.InstructionsFragments;
import com.infogramtelemedia.foodlist.Model.ModelDetailFood;
import com.infogramtelemedia.foodlist.Presenter.PresenterDetailFood;
import com.infogramtelemedia.foodlist.R;
import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.PlayerConstants;
import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.YouTubePlayer;
import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.listeners.AbstractYouTubePlayerListener;
import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.views.YouTubePlayerView;
import com.squareup.picasso.Picasso;

import java.util.List;

import butterknife.BindView;

public class DetailFoodActivity extends BaseActivity implements ActivityContract.BaseActivityView<PresenterDetailFood> {

    @BindView(R.id.imgFood)
    ImageView imgFood;
    @BindView(R.id.tvFoodName)
    TextView tvFoodName;
    @BindView(R.id.rvIngredients)
    RecyclerView recyclerView;
    @BindView(R.id.playButton)
    ImageButton playButton;
    @BindView(R.id.containerMealsName)
    RelativeLayout foodTitle;
    @BindView(R.id.youtubePlayer)
    YouTubePlayerView youtubePlayer;

    @BindView(R.id.viewPager)
    ViewPager viewPager;
    @BindView(R.id.tabLayout)
    TabLayout tabLayout;
//    @BindView(R.id.tabIngredient)
//    TabItem tabIngredients;
//    @BindView(R.id.tabInstructions)
//    TabItem tabInstructor;

    PresenterDetailFood presenterDetailFood;
    AdapterListString adapterListString;
    public String videoId = null;
    public ModelDetailFood.DetailFood modelDetailFood_;

    AdapterPages adapterPages;

    @Override
    public int getLayoutID() {
        return R.layout.activity_detail_food;
    }

    @Override
    public void initListenerView() {
        adapterPages = new AdapterPages(getSupportFragmentManager(), FragmentPagerAdapter.BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT,2);
        viewPager.setAdapter(adapterPages);
        tabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                viewPager.setCurrentItem(tab.getPosition());
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {
            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {
            }
        });
        viewPager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(tabLayout));

        playButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                imgFood.setVisibility(View.GONE);
                foodTitle.setVisibility(View.GONE);
                playButton.setVisibility(View.GONE);
                youtubePlayer.getYouTubePlayerWhenReady(
                        YouTubePlayer::play
                );
            }
        });

        youtubePlayer.addYouTubePlayerListener(new AbstractYouTubePlayerListener() {
            @Override
            public void onReady(YouTubePlayer youTubePlayer) {
                super.onReady(youTubePlayer);
                String linkYoutube = videoId.substring(32, videoId.length());
                Log.e("LinkYoutube", linkYoutube);
                youTubePlayer.cueVideo(linkYoutube,0);
            }
            @Override
            public void onStateChange(YouTubePlayer youTubePlayer, PlayerConstants.PlayerState state) {
                super.onStateChange(youTubePlayer, state);
                Log.e("youtube_asuma", state.toString());
                if(state.toString().equals("PAUSED")){
                    imgFood.setVisibility(View.VISIBLE);
                    foodTitle.setVisibility(View.VISIBLE);
                    playButton.setVisibility(View.VISIBLE);
                }
            }
        });
    }

    @Override
    public void setPresenter(PresenterDetailFood presenterDetailFood) {
        this.presenterDetailFood = presenterDetailFood;
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.presenterDetailFood = new PresenterDetailFood(this);
        this.presenterDetailFood.detailFood(getIntent().getStringExtra("idFood"));
    }

    public void initView(ModelDetailFood.DetailFood modelDetailFood){

        FragmentTransaction fragmentTransaction1 = getSupportFragmentManager().beginTransaction();
        FragmentTransaction fragmentTransaction2 = getSupportFragmentManager().beginTransaction();

        IngredientsFragments ingredientsFragments = new IngredientsFragments();
        ingredientsFragments.initDataIngredients(modelDetailFood);
        InstructionsFragments instructionsFragments = new InstructionsFragments();
        instructionsFragments.initDataInstructions(modelDetailFood.getInstructions());

        fragmentTransaction1.replace(R.id.fragmentIngredients, ingredientsFragments);
        fragmentTransaction1.commit();
        fragmentTransaction2.replace(R.id.fragmentInstructions, instructionsFragments);
        fragmentTransaction2.commit();


        Picasso.get()
                .load(modelDetailFood.getMealsImage())
                .into(imgFood);

        tvFoodName.setText(modelDetailFood.getMealsName());

        ModelDetailFood ingredients = new ModelDetailFood();
        listDetailFood(ingredients.listIngerdients(modelDetailFood), ingredients.listMeasure(modelDetailFood));

        Log.e("listIngredients", ingredients.listIngerdients(modelDetailFood).size()+"");

    }

    private void listDetailFood(List<String> ingredients, List<String> measure){
        adapterListString = new AdapterListString(ingredients, measure);
        recyclerView.setLayoutManager(new LinearLayoutManager(getApplicationContext()));
        recyclerView.setAdapter(adapterListString);
    }
}
