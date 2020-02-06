package nemchinova.samoilova.diet4life;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Space;
import android.widget.Spinner;

public class CalculationActivity extends AppCompatActivity {


    public Spinner spinner;
    public CheckBox ch_diabetes;
    public CheckBox ch_HIV;
    public CheckBox ch_coronary;
    public CheckBox ch_hyper;
    public CheckBox ch_gastrites;
    public CheckBox ch_null;

    public RadioButton rMan;
    public RadioButton rWoman;

    public EditText et_weight;
    public EditText et_high;
    public EditText et_age;
    public EditText et_waist;
    public EditText et_hips;
    public EditText et_neck;
    //public boolean sex; //правда - женщина
    public int levelActions;
    public EditText et_time;
    public String illness="";

    public final String key_weight = "Weight";
    public final String key_high = "High";
    public final String key_age = "Age";
    public final String key_waist = "Waist";
    public final String key_hips = "Hips";
    public final String key_neck = "Neck";
    public final String key_sex = "Sex";
    public final String key_levelActions = "Level_Actions";
    public final String key_timeActions = "Time_Actions";
    public final String key_illness = "Illness";
    public final String key_info = "infoAboutUser";
    public final String key_sex_w = "woman";
    public final String key_sex_m = "man";


    private SharedPreferences sharedPreferences;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calculation);

        spinnerAdd();

        init();
    }

    public  void init(){
        rMan = findViewById(R.id.rb_man);
        rWoman = findViewById(R.id.rb_woman);

        ch_diabetes = findViewById(R.id.cb_diabetes);

        ch_diabetes.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(isChecked)
                   ch_null.setEnabled(false);
                else {
                    if (!ch_gastrites.isChecked() && !ch_HIV.isChecked() &&!ch_hyper.isChecked() && !ch_coronary.isChecked()) {
                        ch_null.setEnabled(true);
                    }
                }
            }
        });
        ch_HIV = findViewById(R.id.cb_HIV);
        ch_HIV.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(isChecked)
                    ch_null.setEnabled(false);
                else {
                    if (!ch_gastrites.isChecked() && !ch_diabetes.isChecked() &&!ch_hyper.isChecked() && !ch_coronary.isChecked()) {
                        ch_null.setEnabled(true);
                    }
                }
            }
        });
        ch_coronary = findViewById(R.id.cb_coronary_heart_disease);
        ch_coronary.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(isChecked)
                    ch_null.setEnabled(false);
                else {
                    if (!ch_gastrites.isChecked() && !ch_HIV.isChecked() &&!ch_hyper.isChecked() && !ch_diabetes.isChecked()) {
                        ch_null.setEnabled(true);
                    }
                }
            }
        });
        ch_hyper = findViewById(R.id.cb_hypertension);
        ch_hyper.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(isChecked)
                    ch_null.setEnabled(false);
                else {
                    if (!ch_gastrites.isChecked() && !ch_HIV.isChecked() &&!ch_diabetes.isChecked() && !ch_coronary.isChecked()) {
                        ch_null.setEnabled(true);
                    }
                }
            }
        });
        ch_gastrites = findViewById(R.id.cb_gastritis);
        ch_gastrites.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(isChecked)
                    ch_null.setEnabled(false);
                else {
                    if (!ch_diabetes.isChecked() && !ch_HIV.isChecked() &&!ch_hyper.isChecked() && !ch_coronary.isChecked()) {
                        ch_null.setEnabled(true);
                    }
                }
            }
        });
        ch_null = findViewById(R.id.cb_null_illness);
        ch_null.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    ch_diabetes.setEnabled(false);
                    ch_HIV.setEnabled(false);
                    ch_coronary.setEnabled(false);
                    ch_hyper.setEnabled(false);
                    ch_gastrites.setEnabled(false);
                } else {
                    ch_diabetes.setEnabled(true);
                    ch_HIV.setEnabled(true);
                    ch_coronary.setEnabled(true);
                    ch_hyper.setEnabled(true);
                    ch_gastrites.setEnabled(true);
                }
            }
        });

        sharedPreferences = getSharedPreferences(key_info,MODE_PRIVATE);
        et_high = findViewById(R.id.et_high);
        et_weight = findViewById(R.id.et_weight);
        et_age = findViewById(R.id.et_age);
        et_time = findViewById(R.id.et_time);
        et_waist = findViewById(R.id.et_size_waist);
        et_hips = findViewById(R.id.et_size_hips);
        et_neck = findViewById(R.id.et_size_neck);

        if (sharedPreferences.getString(key_weight,"0").length() >1){
            et_high.setText(sharedPreferences.getString(key_high,"0"));
            et_weight.setText(sharedPreferences.getString(key_weight,"0"));
            et_age.setText(sharedPreferences.getString(key_age,"0"));
            et_hips.setText(sharedPreferences.getString(key_hips,"0"));
            et_waist.setText(sharedPreferences.getString(key_waist,"0"));
            et_neck.setText(sharedPreferences.getString(key_neck,"0"));
            et_time.setText(sharedPreferences.getString(key_timeActions,"0"));

            if (sharedPreferences.getString(key_sex,"").length()<4){
                rMan.setChecked(true);
            }else{
                rWoman.setChecked(true);
            }

            spinner.setSelection(Integer.parseInt(sharedPreferences.getString(key_levelActions,"0")));
            String s = sharedPreferences.getString(key_illness,"0");
            for (int i = 0;i<s.length();i++){
                switch (s.charAt(i)){
                    case '0':
                        ch_null.setChecked(true);
                        break;
                    case '1':
                        ch_diabetes.setChecked(true);
                        break;
                    case '2':
                        ch_HIV.setChecked(true);
                        break;
                    case '3':
                        ch_coronary.setChecked(true);
                        break;
                    case '4':
                        ch_hyper.setChecked(true);
                        break;
                    case '5':
                        ch_gastrites.setChecked(true);
                        break;
                }
            }
        }
    }

    public void onToInfoButtonClick(View view) {
        intents(CalculationActivity.this,InformationActivity.class,false);
    }

    public void onToMainButtonClick(View view) {
        intents(CalculationActivity.this,MainActivity.class,false);
    }

    public void intents(Context context, Class c,boolean flag){
        Intent i = new Intent(context,c);
        if (flag){
            i.putExtra("From","yes");
        }
        startActivity(i);
    }

    public void spinnerAdd() {
        spinner = findViewById(R.id.spinner_level_action);
        ArrayAdapter<?> adapter =
                ArrayAdapter.createFromResource(this, R.array.level_action, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);

        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
               // String[] choose = getResources().getStringArray(R.array.level_action);   et_save.setText(sharedPreferences.getString(key,"Ничего не найдено"));
                levelActions = position;
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
    }


    public void onAdviceCliclButton(View view) {
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString(key_weight,et_weight.getText().toString());
        editor.putString(key_high,et_high.getText().toString());
        editor.putString(key_age,et_age.getText().toString());
        editor.putString(key_waist,et_waist.getText().toString());
        editor.putString(key_hips,et_hips.getText().toString());
        editor.putString(key_neck,et_neck.getText().toString());
        if (rMan.isChecked()){
            editor.putString(key_sex,key_sex_m);
        }else{
            editor.putString(key_sex,key_sex_w);
        }
        editor.putString(key_levelActions,levelActions+"");
        editor.putString(key_timeActions,et_time.getText().toString());
        if (ch_null.isChecked()){
            illness = illness+"0";
        }else {
            if (ch_diabetes.isChecked()){
                illness = illness+"1";
            }
            if (ch_HIV.isChecked()){
                illness = illness+"2";
            }
            if (ch_coronary.isChecked()){
                illness = illness+"3";
            }
            if (ch_hyper.isChecked()){
                illness = illness+"4";
            }
            if (ch_gastrites.isChecked()){
                illness = illness+"5";
            }
        }
        editor.putString(key_illness,illness);
        editor.apply();

        intents(CalculationActivity.this,IMTActivity.class,true);
    }
}
