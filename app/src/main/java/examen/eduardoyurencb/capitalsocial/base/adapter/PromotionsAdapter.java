package examen.eduardoyurencb.capitalsocial.base.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.List;

import examen.eduardoyurencb.capitalsocial.R;
import examen.eduardoyurencb.capitalsocial.promotion.model.PromotionView;
import examen.eduardoyurencb.capitalsocial.utils.Constans;

public class PromotionsAdapter extends BaseAdapter{

    private List<PromotionView> items;
    private Context context;
    private TextView name;
    private TextView promotion;
    private LinearLayout linearLayout;

    public PromotionsAdapter(Context context, List<PromotionView> items) {
        this.context = context;
        this.items = items;
    }

    //OK
    @Override
    public int getCount() {
        return items.size();
    }

    @Override
    public Object getItem(int position) {
        return items.get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if (convertView == null) {
            LayoutInflater inflater = (LayoutInflater) context
                    .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = inflater.inflate(R.layout.layout_promotion, parent, false);
        }

        name = (TextView)convertView.findViewById(R.id.textViewNamePlacePromotion);
        promotion = (TextView)convertView.findViewById(R.id.textViewPromo);
        linearLayout = (LinearLayout)convertView.findViewById(R.id.contentPromotion);

        name.setText(items.get(position).getNamePlace());
        promotion.setText(items.get(position).getPromotion());
        linearLayout.setBackgroundResource(Constans.ids[position]);

        return convertView;
    }
}
