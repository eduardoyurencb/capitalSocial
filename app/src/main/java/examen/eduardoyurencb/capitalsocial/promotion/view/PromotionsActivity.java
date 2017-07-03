package examen.eduardoyurencb.capitalsocial.promotion.view;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;

import java.util.ArrayList;
import java.util.List;

import examen.eduardoyurencb.capitalsocial.R;
import examen.eduardoyurencb.capitalsocial.base.adapter.PromotionsAdapter;
import examen.eduardoyurencb.capitalsocial.det_promotion.view.DetPromotionActivity;
import examen.eduardoyurencb.capitalsocial.promotion.model.PromotionView;

public class PromotionsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_promotions);

        final List items = new ArrayList();
        items.add(new PromotionView("Papa John's", "20 % en pizzas grandes y extragrandes"));
        items.add(new PromotionView("Idea Interior", "Obten 3 % en tu compra total"));
        items.add(new PromotionView("Burguer King", "Cafe americano chico gratis"));
        items.add(new PromotionView("Farmacias Benavides", "10 % en medicamentos"));
        items.add(new PromotionView("El Tizoncito", "2x1 en ¡Ah dorados!"));
        items.add(new PromotionView("Chilli's", "Ahorra 10% en tu cuenta"));
        items.add(new PromotionView("Zona Fitness", "Precio especial anualidad"));
        items.add(new PromotionView("Cinépolis", "Gratis una entrada cada mes"));
        items.add(new PromotionView("Windstop", "$50 de descuento en la compra de $250"));
        items.add(new PromotionView("Itallianni's", "10% en tu cuenta"));

        GridView gridView;
        PromotionsAdapter promotionsAdapter;

        gridView = (GridView) findViewById(R.id.grid);
        promotionsAdapter = new PromotionsAdapter(this, items);
        gridView.setAdapter(promotionsAdapter);

        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            public void onItemClick(AdapterView<?> parent, View v, int position, long id) {
                Intent mainIntent = new Intent().setClass(PromotionsActivity.this, DetPromotionActivity.class);
                mainIntent.putExtra("idImage", position);
                startActivity(mainIntent);
            }
        });
    }
}
