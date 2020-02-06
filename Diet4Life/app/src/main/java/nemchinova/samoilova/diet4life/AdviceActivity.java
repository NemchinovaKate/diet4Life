package nemchinova.samoilova.diet4life;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
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

import java.text.DecimalFormat;

public class AdviceActivity extends AppCompatActivity {

    public SharedPreferences sharedPreferencesFromOther;
    public SharedPreferences sharedPreferencesIMT;

    public final int prot_man_diabet = 125;
    public final int kkal_imt25_30_gipert = 400;
    public final int kkal_imt30_35_gipert = 600;
    public final int kkal_imt35_40_gipert = 800;
    public final int kkal_imt40_gipert = 1000;
    public final int fats_coronary_gramm = 80;
    public final int fats_coronary_kkal = 720;
    public final int carb_coronary_gramm = 350;
    public final int carb_coronary_kkal = 1400;
    public final int fats_coronary_gramm_loss_weight = 60;
    public final int fats_coronary_kkal_loss_weight = 540;
    public final int carb_coronary_gramm_loss_weight = 250;
    public final int carb_coronary_kkal_loss_weight = 1000;
    public final int fats_gipert_gramm = 65;
    public final int fats_gipert_kkal = 595;
    public final float prot_gipert_kofficient = 1.5f;

    public final String key_weight = "Weight";
    public final String key_imt = "IMT";
    public final String key_imt_info ="usersIMT";
    public final String key_high = "High";
    public final String key_age = "Age";
    public final String key_sex = "Sex";
    public final String key_levelActions = "Level_Actions";
    public final String key_timeActions = "Time_Actions";
    public final String key_illness = "Illness";
    public final String key_calculation_info ="infoAboutUser";
    public final String key_users_way ="usersWay";
    public final String key_way = "way";

    public final String key_kkal = "kkal" ;
    public final String key_proteins = "proteins";
    public  final String key_fats = "fats";
    public final String key_carbohydrates = "carbohyd";
    public final String key_water = "water";

    public final String gramm =" грамм";
    public final String litr =" литра";
    public final String bread_one =" хлеб.ед.";

    int weight;
    float k_action;
    int age;
    int high;
    boolean sex; //woman true
    int time_action;


    public TextView advice_kkal ;
    public TextView advice_proteins;
    public TextView advice_fats;
    public TextView advice_carbohydrates;
    public TextView advice_water;
    public TextView advice_way;
    public TableLayout tableLayout;
    public SharedPreferences sharedPreferences;
    public SharedPreferences.Editor editor;
    byte illness;//что-то для болезней - переменная
    TableRow tableRow;
    TextView t1_v;
    TextView t2_v_gramm;
    int kkal, proteins, fats, carbohydrates;
    float water;
    DecimalFormat d = new DecimalFormat("#.###");
    String s;
    public String[] v = {"Витамин А","Кальций","(наименование)"};
    public String[] v_gramm = {"900","1000","(кол-во в сутки)"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_advice);

        sharedPreferencesIMT = getSharedPreferences(key_imt_info,MODE_PRIVATE);

        sharedPreferences = getSharedPreferences(key_users_way,MODE_PRIVATE);
        Intent intentThatStartedThisActivity = getIntent();
        editor = sharedPreferences.edit();
        if (intentThatStartedThisActivity.hasExtra(key_way)){
            editor.putString(key_way,intentThatStartedThisActivity.getStringExtra(key_way));
            editor.apply();
        }
        advice_way = findViewById(R.id.tv_way);
        advice_way.setText(sharedPreferences.getString(key_way,"(название выбранной стратегии)"));

        if (intentThatStartedThisActivity.hasExtra(key_way)){
            registr();
        }else{
            change();
        }
        init();
    }

    public void change(){
        kkal = Integer.parseInt(sharedPreferences.getString(key_kkal,"0"));
        proteins = Integer.parseInt(sharedPreferences.getString(key_proteins,"0"));
        carbohydrates = Integer.parseInt(sharedPreferences.getString(key_carbohydrates,"0"));
        fats = Integer.parseInt(sharedPreferences.getString(key_fats,"0"));
        water = Float.parseFloat(sharedPreferences.getString(key_water,"0"));

    }

    public void registr(){
        sharedPreferencesFromOther = getSharedPreferences(key_calculation_info,MODE_PRIVATE);
        weight = Integer.parseInt(sharedPreferencesFromOther.getString(key_weight,"0"));
        high = Integer.parseInt(sharedPreferencesFromOther.getString(key_high,"0"));
        age = Integer.parseInt(sharedPreferencesFromOther.getString(key_age,"0"));
        time_action = Integer.parseInt(sharedPreferencesFromOther.getString(key_timeActions,"0"));

        if (sharedPreferencesFromOther.getString(key_sex,"0").length()>4){
            sex = true;
        }else {
            sex = false;
        }

        switch (sharedPreferencesFromOther.getString(key_levelActions,"9")){
            case "0":
                k_action = 1.2f;
                break;
            case "1":
                k_action = 1.375f;
                break;
            case "2":
                k_action = 1.55f;
                break;
            case "3":
                k_action = 1.7f;
                break;
            case "4":
                k_action = 1.9f;
                break;
        }

        switch (sharedPreferencesFromOther.getString(key_illness,"9")){
            case "0":
                //человек здоровый
                illness =0;
                break;
            case "1":
                //диабет
                illness =1;
                break;
            case "2":
                illness =2;
                //вич
                break;
            case "3":
                illness =3;
                //ишемическая болезнь сердца
                break;
            case "4":
                illness =4;
                //гипертония
                break;
            case "5":
                illness =5;
                //гастрит
                break;
        }


            switch (illness){
                case 0:
                    //ok
                    if (advice_way.getText().toString().equals(getText(R.string.imt_save_weight))) {
                        if (sex) {
                            kkal = (int) (k_action * (10 * weight + 6.25 * high - 5 * age - 161));
                            WaterW();
                        } else {
                            kkal = (int) (k_action * (10 * weight + 6.25 * high - 5 * age + 5));
                            WaterM();
                        }
                        proteins = (int) (0.3 * kkal) / 4;
                        fats = (int) (0.2 * kkal) / 9;
                        carbohydrates = (int) (0.5 * kkal) / 4;
                    }else if(advice_way.getText().toString().equals(getText(R.string.imt_weight_loss))){
                    if (sex){
                        kkal= (int)(0.8*k_action*(10*weight+6.25*high-5*age-161));
                        if (8*weight/0.45 >= kkal){
                            kkal = (int)(8*weight/0.45);
                        }
                        WaterW();
                    }else{
                        kkal = (int)(0.8*k_action*(10*weight+6.25*high-5*age+5));
                        if (8*weight/0.45 >= kkal){
                            kkal = (int)(8*weight/0.45);
                        }
                        WaterM();
                    }
                    proteins = (int)(0.4*kkal)/4;
                    fats = (int)(0.2*kkal)/9;
                    carbohydrates = (int)(0.4*kkal)/4;
                }else{
                    if (sex){
                        kkal= (int)(1.2*k_action*(10*weight+6.25*high-5*age-161));
                        WaterW();
                    }else{
                        kkal = (int)(1.2*k_action*(10*weight+6.25*high-5*age+5));
                        WaterM();
                    }
                    proteins = (int)(0.3*kkal)/4;
                    fats = (int)(0.2*kkal)/9;
                    carbohydrates = (int)(0.5*kkal)/4;
                }
                    break;
                case 2:
                    //not ok
                    if (advice_way.getText().toString().equals(getText(R.string.imt_save_weight))) {
                        if (sex) {
                            WaterW();
                        } else {
                            WaterM();
                        }
                        kkal = ((weight*1000)/450)*17;
                        proteins = (int) (0.3 * kkal) / 4;
                        fats = (int) (0.2 * kkal) / 9;
                        carbohydrates = (int) (0.5 * kkal) / 4;
                    }else if(advice_way.getText().toString().equals(getText(R.string.imt_weight_loss))){
                        kkal = ((weight*1000)/450)*25;
                        if (sex){
                            WaterW();
                            proteins = 30*(kkal/100);

                            //if ()
                        }else{
                            WaterM();
                            proteins = prot_man_diabet;
                        }

                        fats = (int)(0.2*kkal)/9;
                        carbohydrates = (int)(0.4*kkal)/4;
                    }else{
                        if (sex){
                            kkal= (int)(1.2*k_action*(10*weight+6.25*high-5*age-161));
                            WaterW();
                        }else{
                            kkal = (int)(1.2*k_action*(10*weight+6.25*high-5*age+5));
                            WaterM();
                        }
                        proteins = (int)(0.3*kkal)/4;
                        fats = (int)(0.2*kkal)/9;
                        carbohydrates = (int)(0.5*kkal)/4;
                    }
                    break;
                case 3:
                    //согласовано с инфой
                    if (advice_way.getText().toString().equals(getText(R.string.imt_save_weight))) {
                        if (sex) {
                            kkal = (int) (k_action * (10 * weight + 6.25 * high - 5 * age - 161));
                            WaterW();
                        } else {
                            kkal = (int) (k_action * (10 * weight + 6.25 * high - 5 * age + 5));
                            WaterM();
                        }
                        fats = fats_coronary_gramm;
                        carbohydrates = carb_coronary_gramm;
                        proteins = (kkal - fats_coronary_kkal - carb_coronary_kkal)/4;
                    }else if(advice_way.getText().toString().equals(getText(R.string.imt_weight_loss))){
                        if (sex){
                            kkal= (int)(0.8*k_action*(10*weight+6.25*high-5*age-161));
                            if (8*weight/0.45 >= kkal){
                                kkal = (int)(8*weight/0.45);
                            }
                            WaterW();
                        }else{
                            kkal = (int)(0.8*k_action*(10*weight+6.25*high-5*age+5));
                            if (8*weight/0.45 >= kkal){
                                kkal = (int)(8*weight/0.45);
                            }
                            WaterM();
                        }
                        fats = fats_coronary_gramm_loss_weight;
                        carbohydrates = carb_coronary_gramm_loss_weight;
                        proteins = (kkal-fats_coronary_kkal_loss_weight-carb_coronary_kkal_loss_weight)/4;
                    }else{
                        //без изменений с норм здоровьем, нет инфы
                        if (sex){
                            kkal= (int)(1.2*k_action*(10*weight+6.25*high-5*age-161));
                            WaterW();
                        }else{
                            kkal = (int)(1.2*k_action*(10*weight+6.25*high-5*age+5));
                            WaterM();
                        }
                        proteins = (int)(0.3*kkal)/4;
                        fats = (int)(0.2*kkal)/9;
                        carbohydrates = (int)(0.5*kkal)/4;
                    }

                    break;
                case 4:
                    if (advice_way.getText().toString().equals(getText(R.string.imt_save_weight))) {
                        if (sex) {
                            kkal = (int) (k_action * (10 * weight + 6.25 * high - 5 * age - 161));
                            WaterW();
                        } else {
                            kkal = (int) (k_action * (10 * weight + 6.25 * high - 5 * age + 5));
                            WaterM();
                        }
                        int imt = Integer.parseInt(sharedPreferencesIMT.getString(key_imt,"0"));
                        if (imt>=25) {
                            if (imt < 30) {
                                kkal -= kkal_imt25_30_gipert;
                            } else if (imt >= 30 && imt < 35) {
                                kkal -= kkal_imt30_35_gipert;
                            } else if (imt >= 35 && imt < 40) {
                                kkal -= kkal_imt35_40_gipert;
                            } else if (imt >= 40) {
                                kkal -= kkal_imt40_gipert;
                            }
                        }

                        fats = fats_gipert_gramm;
                        proteins = (int) prot_gipert_kofficient*weight;
                        carbohydrates = kkal-fats_gipert_kkal-proteins*4;
                    }else if(advice_way.getText().toString().equals(getText(R.string.imt_weight_loss))){
                        //без изменений нет инфы
                        if (sex){
                            kkal= (int)(0.8*k_action*(10*weight+6.25*high-5*age-161));
                            if (8*weight/0.45 >= kkal){
                                kkal = (int)(8*weight/0.45);
                            }
                            WaterW();
                        }else{
                            kkal = (int)(0.8*k_action*(10*weight+6.25*high-5*age+5));
                            if (8*weight/0.45 >= kkal){
                                kkal = (int)(8*weight/0.45);
                            }
                            WaterM();
                        }
                        proteins = (int)(0.4*kkal)/4;
                        fats = (int)(0.2*kkal)/9;
                        carbohydrates = (int)(0.4*kkal)/4;
                    }else{
                        //без изменений нет инфы
                        if (sex){
                            kkal= (int)(1.2*k_action*(10*weight+6.25*high-5*age-161));
                            WaterW();
                        }else{
                            kkal = (int)(1.2*k_action*(10*weight+6.25*high-5*age+5));
                            WaterM();
                        }
                        proteins = (int)(0.3*kkal)/4;
                        fats = (int)(0.2*kkal)/9;
                        carbohydrates = (int)(0.5*kkal)/4;
                    }

                    break;
                case 5:
                    //согласовано
                    if (advice_way.getText().toString().equals(getText(R.string.imt_save_weight))) {
                        if (sex) {
                            kkal = (int) (k_action * (10 * weight + 6.25 * high - 5 * age - 161));
                            WaterW();
                        } else {
                            kkal = (int) (k_action * (10 * weight + 6.25 * high - 5 * age + 5));
                            WaterM();
                        }
                        proteins = (int) prot_gipert_kofficient*weight;
                        fats = (int) (0.95*((0.2 * kkal) / 9));
                        carbohydrates = kkal - proteins*4-fats*9;
                    }else if(advice_way.getText().toString().equals(getText(R.string.imt_weight_loss))){
                        //без изменений
                        if (sex){
                            kkal= (int)(0.8*k_action*(10*weight+6.25*high-5*age-161));
                            if (8*weight/0.45 >= kkal){
                                kkal = (int)(8*weight/0.45);
                            }
                            WaterW();
                        }else{
                            kkal = (int)(0.8*k_action*(10*weight+6.25*high-5*age+5));
                            if (8*weight/0.45 >= kkal){
                                kkal = (int)(8*weight/0.45);
                            }
                            WaterM();
                        }
                        proteins = (int)(0.4*kkal)/4;
                        fats = (int)(0.2*kkal)/9;
                        carbohydrates = (int)(0.4*kkal)/4;
                    }else{
                        //без изменений
                        if (sex){
                            kkal= (int)(1.2*k_action*(10*weight+6.25*high-5*age-161));
                            WaterW();
                        }else{
                            kkal = (int)(1.2*k_action*(10*weight+6.25*high-5*age+5));
                            WaterM();
                        }
                        proteins = (int)(0.3*kkal)/4;
                        fats = (int)(0.2*kkal)/9;
                        carbohydrates = (int)(0.5*kkal)/4;
                    }

                    break;
                case 1:
                    //брать ли в расчет таблицу
                    if (advice_way.getText().toString().equals(getText(R.string.imt_save_weight))) {
                        if (sex) {
                            kkal = (int) (k_action * (10 * weight + 6.25 * high - 5 * age - 161));
                            WaterW();
                        } else {
                            kkal = (int) (k_action * (10 * weight + 6.25 * high - 5 * age + 5));
                            WaterM();
                        }
                        proteins = (int) (0.2 * kkal) / 4;
                        fats = (int) (0.3 * kkal) / 9;
                        carbohydrates = (int) ((0.5 * kkal) / 4)/12;
                    }else if(advice_way.getText().toString().equals(getText(R.string.imt_weight_loss))){
                        //без изменений
                        if (sex){
                            kkal= (int)(0.8*k_action*(10*weight+6.25*high-5*age-161));
                            if (8*weight/0.45 >= kkal){
                                kkal = (int)(8*weight/0.45);
                            }
                            WaterW();
                        }else{
                            kkal = (int)(0.8*k_action*(10*weight+6.25*high-5*age+5));
                            if (8*weight/0.45 >= kkal){
                                kkal = (int)(8*weight/0.45);
                            }
                            WaterM();
                        }
                        proteins = (int)(0.4*kkal)/4;
                        fats = (int)(0.2*kkal)/9;
                        carbohydrates = (int)(0.4*kkal)/4;
                    }else{
                        //без изменений
                        if (sex){
                            kkal= (int)(1.2*k_action*(10*weight+6.25*high-5*age-161));
                            WaterW();
                        }else{
                            kkal = (int)(1.2*k_action*(10*weight+6.25*high-5*age+5));
                            WaterM();
                        }
                        proteins = (int)(0.3*kkal)/4;
                        fats = (int)(0.2*kkal)/9;
                        carbohydrates = (int)(0.5*kkal)/4;
                    }
                    break;
            }

        editor.putString(key_kkal,kkal+"");
        editor.putString(key_water,water+"");
        editor.putString(key_proteins,proteins+"");
        editor.putString(key_carbohydrates,carbohydrates+"");
        editor.putString(key_fats,fats+"");
        editor.apply();

    }

    public void init(){

        advice_carbohydrates = findViewById(R.id.advice_carbohydrates);
        advice_fats = findViewById(R.id.advice_fats);
        advice_proteins = findViewById(R.id.advice_proteins);
        advice_kkal = findViewById(R.id.tv_norna_kkal);
        advice_water = findViewById(R.id.advice_water);
        tableLayout = findViewById(R.id.advice_table);


        s = kkal + gramm;
        advice_kkal.setText(s);
        s = proteins + gramm;
        advice_proteins.setText(s);
        if (illness != 1) {
            s = carbohydrates + gramm;
        }else{
            s = carbohydrates + bread_one;
        }
        advice_carbohydrates.setText(s);
        s = fats + gramm;
        advice_fats.setText(s);
        s = d.format(water) + litr;
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

    public void WaterM() {
        water = (float) (weight*0.04 + time_action*0.6);
    }

    public void WaterW() {
        water = (float)(weight*0.03 + time_action*0.4);
    }



    public void onToCalculateButtonClick(View view) {
        intents(AdviceActivity.this,IMTActivity.class);
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
