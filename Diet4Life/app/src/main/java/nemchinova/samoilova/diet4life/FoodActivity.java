package nemchinova.samoilova.diet4life;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;

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

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
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
