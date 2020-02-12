package nemchinova.samoilova.diet4life;

import android.content.Context;
import android.graphics.Paint;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class RecycleAdapter extends RecyclerView.Adapter<RecycleAdapter.ViewHolderForList> {

    private LayoutInflater inflater;
    private List<ItemClass> list;

    boolean[] cheched;

    public RecycleAdapter ( Context parent, List<ItemClass> list,boolean[] bool){
        this.inflater = LayoutInflater.from(parent);
        this.list = list;
        this.cheched = bool;
    }

    @NonNull
    @Override
    public ViewHolderForList onCreateViewHolder(@NonNull ViewGroup viewGroup, int viewType) {

        View view = inflater.inflate(R.layout.item_list_food, viewGroup, false);
        return new ViewHolderForList(view);
    }

    @Override
    public void onBindViewHolder(@NonNull final ViewHolderForList holder, final int position) {

        ItemClass itemClass = list.get(position);
        holder.protein.setText(itemClass.getProtein());
        holder.name.setText(itemClass.getName());
        holder.fats.setText(itemClass.getFats());
        holder.carb.setText(itemClass.getCarb());
        holder.gramm.setText(itemClass.getGramm());
        holder.kkal.setText(itemClass.getKkal());

        holder.cb.setChecked(cheched[position]);
        if (holder.cb.isChecked()){
            holder.name.setPaintFlags(holder.name.getPaintFlags() | Paint.STRIKE_THRU_TEXT_FLAG);
        }

        holder.cb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                cheched[position] = !cheched[position];
            }
        });
        holder.cb.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked){
                    holder.name.setPaintFlags(holder.name.getPaintFlags() | Paint.STRIKE_THRU_TEXT_FLAG);
                }else{
                    holder.name.setPaintFlags(holder.name.getPaintFlags() & ~Paint.STRIKE_THRU_TEXT_FLAG);
                }
            }
        });
    }

    public boolean[] getChecked() {
        return cheched;

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

        CheckBox cb;

        public ViewHolderForList(@NonNull View itemView) {
            super(itemView);
           protein = itemView.findViewById(R.id.list_tv_protein);
            name = itemView.findViewById(R.id.list_tv_title);
            fats = itemView.findViewById(R.id.list_tv_fats);
            carb = itemView.findViewById(R.id.list_tv_carb);
            gramm = itemView.findViewById(R.id.list_tv_gramm);
            kkal = itemView.findViewById(R.id.list_tv_kkal);

            cb = itemView.findViewById(R.id.cb_list);
        }
    }
}
