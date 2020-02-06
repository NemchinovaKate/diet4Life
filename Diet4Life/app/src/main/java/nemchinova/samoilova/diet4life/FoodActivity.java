package nemchinova.samoilova.diet4life;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class FoodActivity extends AppCompatActivity {

    private ListView list_breakf;
    private ListView list_dinner;
    private ListView list_evening;
    private ListView list_snack1;
    private ListView list_snack2;
    private RecycleAdapter adapter1;
    private RecycleAdapter adapter2;
    private RecycleAdapter adapter3;
    private RecycleAdapter adapter4;
    private RecycleAdapter adapter5;

    private List<ItemClass> listItemClassBreak;
    private List<ItemClass> listItemClassDinner;
    private List<ItemClass> listItemClassEvening;
    private List<ItemClass> listItemClassSnack1;
    private List<ItemClass> listItemClassSnack2;
    private ItemClass itemClass;

    public TableRow tableRow;
    final int tables = 5;
    final int column = 7;
    public TextView t1_food;
    public TextView t2_food;
    public TextView t3_food;
    public TextView t4_food;
    public TextView t5_food;
    public TextView t6_food;
    public TextView t7_food;

    String[] array0 = {"1","2","1","2","2"};
    String[] array1 = {"Рис","Масло подсолнечное","Рис","Масло подсолнечное","Масло подсолнечное"};
    String[] array2 = {"100","100","100","100","100"};
    String[] array3 = {"344","344","344","344","344"};
    String[] array4 = {"6.7","6.7","6.7","6.7","6.7"};
    String[] array5 = {"0.7","0.7","0.7","0.7","0.7"};
    String[] array6 = {"78.9","78.9","78.9","78.9","78.9"};
    String[] array7 = {"1","2","2"};
    String[] array8 = {"Рис","Масло подсолнечное","Масло подсолнечное"};
    String[] array9 = {"100","100","100"};
    String[] array10 = {"344","344","344"};
    String[] array11 = {"6.7","6.7","6.7"};
    String[] array12 = {"0.7","0.7","0.7"};
    String[] array13 = {"78.9","78.9","78.9"};
    String[][] arr = {array0,array1,array2,array3,array4,array5,array6};
    String[][] arr1 = {array7,array8,array9,array10,array11,array12,array13};
    public TableRow.LayoutParams weightParams;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_food3);



         listItemClassBreak = new ArrayList<>();
      listItemClassDinner = new ArrayList<>();
        listItemClassEvening = new ArrayList<>();
        listItemClassSnack1 = new ArrayList<>();
        listItemClassSnack2 = new ArrayList<>();/**/


     /* list_breakf = findViewById(R.id.list_breakfast);
        list_dinner = findViewById(R.id.list_dinner);
        list_evening = findViewById(R.id.list_evening);
        list_snack1 = findViewById(R.id.list_snack1);
        list_snack2 = findViewById(R.id.list_snack2);*/

        fillArray(listItemClassBreak,arr);
       fillArray(listItemClassDinner,arr);
        fillArray(listItemClassEvening,arr);
        fillArray(listItemClassSnack1,arr1);
        fillArray(listItemClassSnack2,arr1); /* */

        RecyclerView recyclerView1 = findViewById(R.id.list_breakfast);
        RecyclerView recyclerView2 = findViewById(R.id.list_dinner);
        RecyclerView recyclerView3 = findViewById(R.id.list_lastbig);
        RecyclerView recyclerView4 = findViewById(R.id.list_snack1);
        RecyclerView recyclerView5 = findViewById(R.id.list_snack2);


       adapter1 = new RecycleAdapter(this, listItemClassBreak);
    adapter2 = new RecycleAdapter(this,listItemClassDinner);
        adapter3 = new RecycleAdapter(this,listItemClassEvening);
        adapter4 = new RecycleAdapter(this,listItemClassSnack1);
        adapter5 = new RecycleAdapter(this,listItemClassSnack2);  /**/
        /* */

        recyclerView1.setAdapter(adapter1);
        recyclerView2.setAdapter(adapter2);
        recyclerView3.setAdapter(adapter3);
        recyclerView4.setAdapter(adapter4);
        recyclerView5.setAdapter(adapter5);

        //adapter = new ArrayAdapter<>(this,android.R.layout.simple_list_item_1,new ArrayList<String>(Arrays.asList(array)));
       /* list_breakf.setAdapter(adapter1);
      list_dinner.setAdapter(adapter2);
        list_evening.setAdapter(adapter3);
        list_snack1.setAdapter(adapter4);
        list_snack2.setAdapter(adapter5);  */




    /*Array r = new Array();
       weightParams = new TableRow.LayoutParams();
        weightParams.weight = 1;

        for (int j = 0; j < tables; j++) {
          addToTable(r.table_food[j]);
        }   */
    }

    private void fillArray( List<ItemClass> listItemClass, String[][] arrayCustom )
    {
       // if(adapter != null)  adapter.clear();

        for(int i = 0; i < arrayCustom[0].length; i++)
        {
            itemClass = new ItemClass();
            itemClass.setName(array1[i]);
            Log.d("!!!!!!",itemClass.getName());
            itemClass.setProtein(array4[i]);
            itemClass.setFats(array5[i]);
            itemClass.setCarb(array6[i]);
            itemClass.setKkal(array3[i]);
            itemClass.setGramm(array2[i]);
            Log.d("!!!!!!",itemClass.getGramm());

            listItemClass.add(itemClass);
        }

      //  if(adapter != null) adapter.notifyDataSetChanged();

    }


   /**/ public void addToTable(int t){

        TableLayout tableLayout = findViewById(t);
        for (int j = 0;j<array0.length;j++) {
            tableRow = new TableRow(this);
            tableRow.setBackgroundColor(getColor(R.color.color_black));
            tableRow.setLayoutParams(new TableRow.LayoutParams(
                    ViewGroup.LayoutParams.MATCH_PARENT,
                    ViewGroup.LayoutParams.WRAP_CONTENT
            ));

            for (int i = 0;i<column;i++) {

                t1_food = new TextView(this);
                t1_food.setText(arr[i][j]);
                t1_food.setLayoutParams(weightParams);
                t1_food.setTextColor(getColor(R.color.color_black));
                t1_food.setBackground(getDrawable(R.drawable.style_btn_rectangle_white));

                t1_food.setPadding(4, 1, 1, 1);

                tableRow.addView(t1_food);
            }

          /*  t2_food = new TextView(this);
            t2_food.setText(array1[j]);
            t2_food.setLayoutParams(weightParams);
          t2_food.setTextColor(getColor(R.color.color_black));
            t2_food.setBackground(getDrawable(R.drawable.style_btn_rectangle_white));
            t2_food.setPadding(4, 1, 1, 1);

            tableRow.addView(t2_food);

            t3_food = new TextView(this);
            t3_food.setText(array2[j]);
            t3_food.setLayoutParams(weightParams);
            t3_food.setTextColor(getColor(R.color.color_black));
            t3_food.setBackground(getDrawable(R.drawable.style_btn_rectangle_white));
            t3_food.setPadding(4, 1, 1, 1);

            tableRow.addView(t3_food);

            t4_food = new TextView(this);
            t4_food.setText(array3[j]);
            t4_food.setLayoutParams(weightParams);
            t4_food.setTextColor(getColor(R.color.color_black));
            t4_food.setBackground(getDrawable(R.drawable.style_btn_rectangle_white));
            t4_food.setPadding(4, 1, 1, 1);

            tableRow.addView(t4_food);

            t5_food = new TextView(this);
            t5_food.setText(array4[j]);
            t5_food.setLayoutParams(weightParams);
            t5_food.setTextColor(getColor(R.color.color_black));
            t5_food.setBackground(getDrawable(R.drawable.style_btn_rectangle_white));
            t5_food.setPadding(4, 1, 1, 1);

            tableRow.addView(t5_food);

            t6_food = new TextView(this);
            t6_food.setText(array5[j]);
            t6_food.setLayoutParams(weightParams);
            t6_food.setTextColor(getColor(R.color.color_black));
            t6_food.setBackground(getDrawable(R.drawable.style_btn_rectangle_white));
            t6_food.setPadding(4, 1, 1, 1);

            tableRow.addView(t6_food);

            t7_food = new TextView(this);
            t7_food.setText(array6[j]);
            t7_food.setLayoutParams(weightParams);
            t7_food.setTextColor(getColor(R.color.color_black));
            t7_food.setBackground(getDrawable(R.drawable.style_btn_rectangle_white));
            t7_food.setPadding(4, 1, 1, 1);

            tableRow.addView(t7_food);*/

            tableLayout.addView(tableRow);
        }


    }/**/

    public void onToAdviceButtonClick(View view) {
        intents(FoodActivity.this,AdviceActivity.class);
    }

    public void onToInfoButtonClick(View view) {
        intents(FoodActivity.this,InformationActivity.class);
    }

    public void onToMainButtonClick(View view) {
        intents(FoodActivity.this,MainActivity.class);
    }

    public void intents(Context context, Class c){
        Intent i = new Intent(context,c);
        startActivity(i);
    }
}
