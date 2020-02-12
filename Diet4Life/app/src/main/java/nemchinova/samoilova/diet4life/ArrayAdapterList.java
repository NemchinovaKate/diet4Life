package nemchinova.samoilova.diet4life;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.ArrayList;
import java.util.List;

public class ArrayAdapterList extends ArrayAdapter<ItemClass>{
    private LayoutInflater inflater;
    private List<ItemClass> list = new ArrayList<>();
    private Context context;

    public ArrayAdapterList(@NonNull Context context, int resource, List<ItemClass> listItem,LayoutInflater inflater) {
        super(context, resource,listItem);
        this.inflater = inflater;
        this.list = listItem;
        this.context = context;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        ViewHolder viewHolder;
        ItemClass itemClass = list.get(position);
        if (convertView == null){
            convertView = inflater.inflate(R.layout.item_list_food, null, false);
            viewHolder = new ViewHolder();
            viewHolder.protein = convertView.findViewById(R.id.list_tv_protein);
            viewHolder.name = convertView.findViewById(R.id.list_tv_title);
            viewHolder.fats = convertView.findViewById(R.id.list_tv_fats);
            viewHolder.carb = convertView.findViewById(R.id.list_tv_carb);
            viewHolder.gramm = convertView.findViewById(R.id.list_tv_gramm);
            viewHolder.kkal = convertView.findViewById(R.id.list_tv_kkal);
            convertView.setTag(viewHolder);
        }else{
            viewHolder = (ViewHolder) convertView.getTag();
        }
        viewHolder.protein.setText(itemClass.getProtein());
        viewHolder.name.setText(itemClass.getName());
        viewHolder.fats.setText(itemClass.getFats());
        viewHolder.carb.setText(itemClass.getCarb());
        viewHolder.gramm.setText(itemClass.getGramm());
        viewHolder.kkal.setText(itemClass.getKkal());
        return convertView;
    }

    private class ViewHolder{
        TextView name;
        TextView kkal;
        TextView protein;
        TextView fats;
        TextView carb;
        TextView gramm;
        CheckBox checkBox;
    }




}
