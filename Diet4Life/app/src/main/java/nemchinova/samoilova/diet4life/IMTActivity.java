package nemchinova.samoilova.diet4life;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import java.text.DecimalFormat;

public class IMTActivity extends AppCompatActivity {
    public TextView tv_advice_part1;
    public byte way = 0;
    public final String key_way = "way";
    public final String key_weight = "Weight";
    public final String key_high = "High";
    public final String key_imt = "IMT";
    public final String key_percent_fats = "PerFats";
    public final String key_calculation_info ="infoAboutUser";
    public final String key_imt_info ="usersIMT";
    public final String key_waist = "Waist";
    public final String key_hips = "Hips";
    public final String key_neck = "Neck";
    public final String key_sex = "Sex";
    TextView tv_imt;
    TextView tv_fats_size;
    boolean sex;
    int weight, high,waist,hips,neck;
    public SharedPreferences sharedPreferences;
    public SharedPreferences sharedPreferencesFromOther;
    public SharedPreferences.Editor editor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_imt);

        init();
    }

    public void init(){
        sharedPreferences = getSharedPreferences(key_imt_info,MODE_PRIVATE);
        sharedPreferencesFromOther = getSharedPreferences(key_calculation_info,MODE_PRIVATE);

        tv_imt = findViewById(R.id.iv_imt);
        tv_fats_size = findViewById(R.id.tv_fats_size);

        DecimalFormat d = new DecimalFormat("##.##");
        Intent intentThatStartedThisActivity = getIntent();

        if ((intentThatStartedThisActivity.hasExtra("From"))){
            editor = sharedPreferences.edit();
            weight = Integer.parseInt(sharedPreferencesFromOther.getString(key_weight,"0"));
             high = Integer.parseInt(sharedPreferencesFromOther.getString(key_high,"0"));
            waist = Integer.parseInt(sharedPreferencesFromOther.getString(key_waist,"0"));
            hips = Integer.parseInt(sharedPreferencesFromOther.getString(key_hips,"0"));
            neck = Integer.parseInt(sharedPreferencesFromOther.getString(key_neck,"0"));
            if (sharedPreferencesFromOther.getString(key_sex,"0").length()>3){
                sex=true;
            }else{
                sex=false;
            }

            editor.putString(key_imt,(weight/((high/100.0f)*(high/100.0f)))+"");
            String s;
            if (sex){
                s = (495/(1.29579-0.35004*Math.log10(waist+hips-neck)+0.221*Math.log10(high))-450)+"";
                editor.putString(key_percent_fats,s);
            }else{
                s = (495/(1.0324-0.29077*Math.log10(waist-neck)+0.15456*Math.log10(high))-450)+"";
                editor.putString(key_percent_fats,s);
            }

            editor.apply();
            tv_imt.setText(d.format(weight/((high/100.0f)*(high/100.0f))));
            tv_fats_size.setText(d.format(Float.parseFloat(s))+" %");
        }else {
            tv_imt.setText(d.format(Float.parseFloat(sharedPreferences.getString(key_imt,"0"))));
            tv_fats_size.setText(d.format(Float.parseFloat(sharedPreferences.getString(key_percent_fats,"0")))+" %");
        }


        tv_advice_part1 = findViewById(R.id.tv_advice_part1_normal);
        /* */   double lowerWeight = 46.18; double upperWeight = 62.41;
        String s = "Значение расчета индекса массы тела находится в категории 'Норма'. Ваш оптимальный вес от (вставить свое) " +lowerWeight+"до (вставить свое) "+upperWeight+ " кг.";
        tv_advice_part1.setText(s);
    }

    public void onToCalculateButtonClick(View view) {
        intents(IMTActivity.this,CalculationActivity.class,false);
    }

    public void onToInfoButtonClick(View view) {
        intents(IMTActivity.this,InformationActivity.class,false);
    }

    public void onToMainButtonClick(View view) {
        intents(IMTActivity.this,MainActivity.class,false);
    }

    public void intents(Context context, Class c, boolean plus){
        Intent i = new Intent(context,c);

        if (plus){
            if (way == 1){
                i.putExtra(key_way,getText(R.string.imt_save_weight));
                startActivity(i);
            }else if (way == 2){
                i.putExtra(key_way,getText(R.string.imt_weight_loss));
                startActivity(i);
            }else{
                i.putExtra(key_way,getText(R.string.imt_muscle_gain));
                startActivity(i);
            }

        }
        startActivity(i);
    }

    public void onClickAdviceButtonSave(View view) {
        way = 1;
        intents(IMTActivity.this,AdviceActivity.class,true);

    }

    public void onClickAdviceButtonDown(View view) {
        way = 2;
        intents(IMTActivity.this,AdviceActivity.class,true);
    }

    public void onClickAdviceButtonUp(View view) {
        way = 3;
        intents(IMTActivity.this,AdviceActivity.class,true);
    }
}
