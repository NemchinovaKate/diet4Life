package nemchinova.samoilova.diet4life;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.util.Log;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;

public class AdviceActivity extends AppCompatActivity {

    public TextView advice_kkal ;
    public TextView advice_proteins;
    public TextView advice_fats;
    public TextView advice_carbohydrates;
    public TextView advice_water;
    public TextView advice_way;
    public TableLayout tableLayout;
    TableRow tableRow;
    TextView t1_v;
    TextView t2_v_gramm;
    int kkal, proteins, fats, carbohydrates, water;
    String s;
    public String[] v = {"Витамин А","Кальций","(наименование)"};
    public String[] v_gramm = {"900","1000","(кол-во в сутки)"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_advice);

        init();

        Intent intentThatStartedThisActivity = getIntent();
        if (intentThatStartedThisActivity.hasExtra("way")){
           // String textEntered = intentThatStartedThisActivity.getStringExtra("way");
            advice_way.setText(intentThatStartedThisActivity.getStringExtra("way"));
        }




        kkal = 1000;
        proteins = 100;
        carbohydrates = 100;
        fats = 100;
        water = 100;

        s = kkal + " грамм";
        advice_kkal.setText(s);
        s = proteins + " грамм";
        advice_proteins.setText(s);
        s = carbohydrates + " грамм";
        advice_carbohydrates.setText(s);
        s = fats + " грамм";
        advice_fats.setText(s);
        s = water + " грамм";
        advice_water.setText(s);

       for (int j = 0;j<v.length;j++){
              tableRow = new TableRow(this);
              tableRow.setBackgroundColor(getColor(R.color.color_black));
              tableRow.setLayoutParams(new TableRow.LayoutParams(
                   ViewGroup.LayoutParams.MATCH_PARENT,
                   ViewGroup.LayoutParams.WRAP_CONTENT
           ));

               t1_v = new TextView(this);
               t1_v.setText(v[j]);
               t1_v.setTextColor(getColor(R.color.color_black));
               t1_v.setBackground(getDrawable(R.drawable.style_btn_rectangle_white));
               t1_v.setPadding(4,1,1,1);

               tableRow.addView(t1_v);

               t2_v_gramm = new TextView(this);
               t2_v_gramm.setText(v_gramm[j]);
              t2_v_gramm.setBackground(getDrawable(R.drawable.style_btn_rectangle_white));
              t2_v_gramm.setPadding(4,1,1,1);

             t2_v_gramm.setTextColor(getColor(R.color.color_black));

               tableRow.addView(t2_v_gramm);
               tableLayout.addView(tableRow);
       }
    }

    public void init(){

        advice_carbohydrates = findViewById(R.id.advice_carbohydrates);
        advice_fats = findViewById(R.id.advice_fats);
        advice_proteins = findViewById(R.id.advice_proteins);
        advice_kkal = findViewById(R.id.tv_norna_kkal);
        advice_water = findViewById(R.id.advice_water);
        tableLayout = findViewById(R.id.advice_table);
        advice_way = findViewById(R.id.tv_way);
    }

    public void onToCalculateButtonClick(View view) {
        intents(AdviceActivity.this,CalculationActivity.class);
    }

    public void onToInfoButtonClick(View view) {
        intents(AdviceActivity.this,InformationActivity.class);
    }

    public void onToMainButtonClick(View view) {
        intents(AdviceActivity.this,MainActivity.class);
    }

    public void intents(Context context, Class c){
        Intent i = new Intent(context,c);
        startActivity(i);
    }

    public void onFoodButtonClick(View view) {
        intents(AdviceActivity.this,FoodActivity.class);
    }
}
