package nemchinova.samoilova.diet4life;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class RecycleAdapter extends RecyclerView.Adapter<RecycleAdapter.ViewHolderForList> {

    private LayoutInflater inflater;
    private List<ItemClass> list;

    public RecycleAdapter ( Context parent, List<ItemClass> list){
        this.inflater = LayoutInflater.from(parent);
        this.list = list;
    }

    @NonNull
    @Override
    public ViewHolderForList onCreateViewHolder(@NonNull ViewGroup viewGroup, int viewType) {

        View view = inflater.inflate(R.layout.item_list_food, viewGroup, false);
        return new ViewHolderForList(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolderForList holder, int position) {
        ItemClass itemClass = list.get(position);
        holder.protein.setText(itemClass.getProtein());
        holder.name.setText(itemClass.getName());
        holder.fats.setText(itemClass.getFats());
        holder.carb.setText(itemClass.getCarb());
        holder.gramm.setText(itemClass.getGramm());
        holder.kkal.setText(itemClass.getKkal());
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    class ViewHolderForList extends RecyclerView.ViewHolder{

        TextView name;
        TextView kkal;
        TextView protein;
        TextView fats;
        TextView carb;
        TextView gramm;

        public ViewHolderForList(@NonNull View itemView) {
            super(itemView);
           protein = itemView.findViewById(R.id.list_tv_protein);
            name = itemView.findViewById(R.id.list_tv_title);
            fats = itemView.findViewById(R.id.list_tv_fats);
            carb = itemView.findViewById(R.id.list_tv_carb);
            gramm = itemView.findViewById(R.id.list_tv_gramm);
            kkal = itemView.findViewById(R.id.list_tv_kkal);
        }
    }
}
