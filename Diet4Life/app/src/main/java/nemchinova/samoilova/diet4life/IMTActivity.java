package nemchinova.samoilova.diet4life;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

public class IMTActivity extends AppCompatActivity {
    public TextView tv_advice_part1;
    public byte way = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_imt);

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

        if (plus == true){
            if (way == 1){
                i.putExtra("way",getText(R.string.imt_save_weight));
                startActivity(i);
            }else if (way == 2){
                i.putExtra("way",getText(R.string.imt_weight_loss));
                startActivity(i);
            }else{
                i.putExtra("way",getText(R.string.imt_muscle_gain));
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
