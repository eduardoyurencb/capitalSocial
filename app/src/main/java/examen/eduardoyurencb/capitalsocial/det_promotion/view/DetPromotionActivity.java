package examen.eduardoyurencb.capitalsocial.det_promotion.view;

import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.widget.ImageView;

import examen.eduardoyurencb.capitalsocial.R;
import examen.eduardoyurencb.capitalsocial.utils.Constans;

/**
 * Created by eduardoyurencb on 6/14/17.
 */

public class DetPromotionActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_det_promotion);

        ImageView imageViewPromotion = (ImageView)findViewById(R.id.imageViewPromotion);

        Bundle bundle = getIntent().getExtras();
        imageViewPromotion.setBackgroundResource(Constans.ids[bundle.getInt("idImage")]);

        ActionBar actionBar = getSupportActionBar();
        actionBar.setDisplayHomeAsUpEnabled(true);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        finish();
        return super.onOptionsItemSelected(item);
    }
}
