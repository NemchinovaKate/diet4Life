package nemchinova.samoilova.diet4life;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.icu.text.IDNA;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void onExitClick(View view) {
        finish();
    }

    public void onInfoClick(View view) {
        intents(MainActivity.this, InformationActivity.class);
    }

    public void onAdviceClick(View view) {
        intents(MainActivity.this, AdviceActivity.class);
    }

    public void onFoodClick(View view) {
        intents(MainActivity.this, FoodActivity.class);
        //intents(MainActivity.this, IMTActivity.class);
    }

    public void onCalculationClick(View view) {
        intents(MainActivity.this, CalculationActivity.class);
    }

    public void intents(Context context,Class c){
        Intent i = new Intent(context,c);
        startActivity(i);
    }
}
