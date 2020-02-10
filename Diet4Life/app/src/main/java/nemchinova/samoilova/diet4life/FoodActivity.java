package nemchinova.samoilova.diet4life;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
<<<<<<< Updated upstream
=======
import android.widget.CheckBox;
import android.widget.ListView;
>>>>>>> Stashed changes
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;

<<<<<<< Updated upstream
public class FoodActivity extends AppCompatActivity {

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

    String[] array0 = {"1","2"};
    String[] array1 = {"Рис","Масло подсолнечное"};
    String[] array2 = {"100","100"};
    String[] array3 = {"344","344"};
    String[] array4 = {"6.7","6.7"};
    String[] array5 = {"0.7","0.7"};
    String[] array6 = {"78.9","78.9"};
    String[][] arr = {array0,array1,array2,array3,array4,array5,array6};
    public TableRow.LayoutParams weightParams;
=======
import com.google.gson.Gson;

import java.util.ArrayList;
import java.util.List;

public class FoodActivity extends AppCompatActivity {

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

   // String[] array0 = {"1","2","1","2","2"};
    String[] array1 = {"Рис","Масло подсолнечное","Рис","Масло подсолнечное","Масло подсолнечное"};
    String[] array2 = {"100","100","100","100","100"};
    String[] array3 = {"344","344","344","344","344"};
    String[] array4 = {"6.7","6.7","6.7","6.7","6.7"};
    String[] array5 = {"0.7","0.7","0.7","0.7","0.7"};
    String[] array6 = {"78.9","78.9","78.9","78.9","78.9"};
  //  String[] array7 = {"1","2","2"};
    String[] array8 = {"Рис","Масло подсолнечное","Масло подсолнечное"};
    String[] array9 = {"100","100","100"};
    String[] array10 = {"344","344","344"};
    String[] array11 = {"6.7","6.7","6.7"};
    String[] array12 = {"0.7","0.7","0.7"};
    String[] array13 = {"78.9","78.9","78.9"};
    String[][] arr = {array1,array2,array3,array4,array5,array6};
    String[][] arr1 = {array8,array9,array10,array11,array12,array13};
    boolean[] checked1;
    boolean[] checked2;
    boolean[] checked3;
    boolean[] checked4;
    boolean[] checked5;
    public final String key_cb1 ="cbBreakfast";
    public final String key_cb2 = "cbDinner";
    public final String key_cb3 = "cbEvening";
    public final String key_cb4 = "cbSnack1";
    public final String key_cb5 = "cbSnack2";
    public final String key_food = "foodAll";

    RecyclerView recyclerView1;
    RecyclerView recyclerView2;
    RecyclerView recyclerView3;
    RecyclerView recyclerView4;
    RecyclerView recyclerView5;

    public SharedPreferences sharedPreferences;
    public SharedPreferences.Editor editor;
    Gson gson = new Gson();
>>>>>>> Stashed changes

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
<<<<<<< Updated upstream
        setContentView(R.layout.activity_food);

        Array r = new Array();
       weightParams = new TableRow.LayoutParams();
        weightParams.weight = 1;

        for (int j = 0; j < tables; j++) {
            addToTable(r.table_food[j]);
        }
    }


    public void addToTable(int t){

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


    }

=======
        setContentView(R.layout.activity_food3);

         listItemClassBreak = new ArrayList<>();
      listItemClassDinner = new ArrayList<>();
        listItemClassEvening = new ArrayList<>();
        listItemClassSnack1 = new ArrayList<>();
        listItemClassSnack2 = new ArrayList<>();


        sharedPreferences = getSharedPreferences(key_food,MODE_PRIVATE);
        if (sharedPreferences.getString(key_cb1,"0").length() >1){
            String cb1 = sharedPreferences.getString(key_cb1,"");
            String cb2 = sharedPreferences.getString(key_cb2,"");
            String cb3 = sharedPreferences.getString(key_cb3,"");
            String cb4 = sharedPreferences.getString(key_cb4,"");
            String cb5 = sharedPreferences.getString(key_cb5,"");

            checked1 = gson.fromJson(cb1,boolean[].class);
            checked2 = gson.fromJson(cb2,boolean[].class);
            checked3 = gson.fromJson(cb3,boolean[].class);
            checked4 = gson.fromJson(cb4,boolean[].class);
            checked5 = gson.fromJson(cb5,boolean[].class);
        } else{

            checked1 = new boolean[array1.length];
            checked2 = new boolean[array1.length];
            checked3 = new boolean[array1.length];
            checked4 = new boolean[array1.length];
            checked5 = new boolean[array1.length];
        }


      /*  editor = sharedPreferences.edit();
        Gson gson = new Gson();
        String cb_bool = gson.toJson(checked1);
        boolean[] checked = filterAdapter.getChecked(); */


        fillArray(listItemClassBreak,arr);
       fillArray(listItemClassDinner,arr);
        fillArray(listItemClassEvening,arr);
        fillArray(listItemClassSnack1,arr);
        fillArray(listItemClassSnack2,arr); /* */

         recyclerView1 = findViewById(R.id.list_breakfast);
         recyclerView2 = findViewById(R.id.list_dinner);
         recyclerView3 = findViewById(R.id.list_lastbig);
         recyclerView4 = findViewById(R.id.list_snack1);
         recyclerView5 = findViewById(R.id.list_snack2);


       adapter1 = new RecycleAdapter(this, listItemClassBreak,checked1);
    adapter2 = new RecycleAdapter(this,listItemClassDinner,checked2);
        adapter3 = new RecycleAdapter(this,listItemClassEvening,checked3);
        adapter4 = new RecycleAdapter(this,listItemClassSnack1,checked4);
        adapter5 = new RecycleAdapter(this,listItemClassSnack2,checked5);  /**/
        /* */

        recyclerView1.setAdapter(adapter1);
        recyclerView2.setAdapter(adapter2);
        recyclerView3.setAdapter(adapter3);
        recyclerView4.setAdapter(adapter4);
        recyclerView5.setAdapter(adapter5);

    }

    public void update(){
        Log.i("!!!1111111","ddedwed");
        checked1 = adapter1.getChecked();
        checked2 = adapter2.getChecked();
        checked3 = adapter3.getChecked();
        checked4 = adapter4.getChecked();
        checked5 = adapter5.getChecked();


        String cb_bool = gson.toJson(checked1);
        String cb_boo2 = gson.toJson(checked2);
        String cb_boo3 = gson.toJson(checked3);
        String cb_boo4 = gson.toJson(checked4);
        String cb_boo5 = gson.toJson(checked5);
        Log.i("!!!1111111","ddedwed "+cb_boo2);

        editor = sharedPreferences.edit();
        editor.putString(key_cb1,cb_bool);
        editor.putString(key_cb2,cb_boo2);
        editor.putString(key_cb3,cb_boo3);
        editor.putString(key_cb4,cb_boo4);
        editor.putString(key_cb5,cb_boo5);

        editor.apply();
    }

    @Override
    protected void onPause() {
        super.onPause();
        update();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
       update();
    }

    private void fillArray(List<ItemClass> listItemClass, String[][] arrayCustom )
    {

        for(int i = 0; i < arrayCustom[0].length; i++)
        {
            itemClass = new ItemClass();
            itemClass.setName(arrayCustom[0][i]);
            itemClass.setProtein(arrayCustom[3][i]);
            itemClass.setFats(arrayCustom[4][i]);
            itemClass.setCarb(arrayCustom[5][i]);
            itemClass.setKkal(arrayCustom[2][i]);
            itemClass.setGramm(arrayCustom[1][i]);

            listItemClass.add(itemClass);
        }


    }


>>>>>>> Stashed changes
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
        finish();
    }

}
