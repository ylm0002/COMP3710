package com.example.unitconverter;


import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
//import android.view.View;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
    EditText txtF, txtC, txtMi, txtKm, txtLb, txtKg, txtGal, txtLiter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        txtF = findViewById(R.id.txtF);
        txtC = findViewById(R.id.txtC);
        txtMi = findViewById(R.id.txtMi);
        txtKm = findViewById(R.id.txtKm);
        txtLb = findViewById(R.id.txtLb);
        txtKg = findViewById(R.id.txtKg);
        txtGal = findViewById(R.id.txtGal);
        txtLiter = findViewById(R.id.txtLiter);

        txtF.addTextChangedListener(new TextWatcher() {
            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) { }

            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) { }

            @Override
            public void afterTextChanged(Editable s) {
                String strF = s.toString();
                Log.i("UnitConverter", "Value in txtF = " + strF);

                if (!txtF.isFocused()) return;
                if (strF.length() == 0) return;


                try {
                    double valF = Double.parseDouble(strF);
                    double valC = (valF - 32.0)*5/9;
                    String strC = Double.toString(valC);
                    Log.i("UnitConverter", "Value in txtC = " + strC);

                    MainActivity.this.txtC.setText(strC);

                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        } );

        txtC.addTextChangedListener(new TextWatcher() {
            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) { }

            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) { }

            @Override
            public void afterTextChanged(Editable s) {
                String strC = s.toString();
                Log.i("UnitConverter", "Value in txtC = " + strC);

                if (!txtC.isFocused()) return;
                if (strC.length() == 0) return;


                try {
                    double valC = Double.parseDouble(strC);
                    double valF = (valC*1.8) + 32;
                    String strF = Double.toString(valF);
                    Log.i("UnitConverter", "Value in txtF = " + strF);

                    MainActivity.this.txtF.setText(strF);

                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        } );

        txtMi.addTextChangedListener(new TextWatcher() {
            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) { }

            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) { }

            @Override
            public void afterTextChanged(Editable s) {
                String strMi = s.toString();
                Log.i("UnitConverter", "Value in txtMi = " + strMi);

                if (!txtMi.isFocused()) return;
                if (strMi.length() == 0) return;

                try {
                    double valMi = Double.parseDouble(strMi);
                    double valKm = valMi*1.60934;
                    String strKm = Double.toString(valKm);
                    Log.i("UnitConverter", "Value in txtKm = " + strKm);

                    MainActivity.this.txtKm.setText(strKm);

                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        } );

        txtKm.addTextChangedListener(new TextWatcher() {
            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) { }

            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) { }

            @Override
            public void afterTextChanged(Editable s) {
                String strKm = s.toString();
                Log.i("UnitConverter", "Value in txtKm = " + strKm);

                if (!txtKm.isFocused()) return;
                if (strKm.length() == 0) return;

                try {
                    double valKm = Double.parseDouble(strKm);
                    double valMi = valKm/1.60934;
                    String strMi = Double.toString(valMi);
                    Log.i("UnitConverter", "Value in txtKm = " + strMi);

                    MainActivity.this.txtMi.setText(strMi);

                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        } );

        txtLb.addTextChangedListener(new TextWatcher() {
            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) { }

            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) { }

            @Override
            public void afterTextChanged(Editable s) {
                String strLb = s.toString();
                Log.i("UnitConverter", "Value in txtLb = " + strLb);

                if (!txtLb.isFocused()) return;
                if (strLb.length() == 0) return;

                try {
                    double valLb = Double.parseDouble(strLb);
                    double valKg = valLb/2.2046;
                    String strKg = Double.toString(valKg);
                    Log.i("UnitConverter", "Value in txtKg = " + strKg);

                    MainActivity.this.txtKg.setText(strKg);

                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        } );

        txtKg.addTextChangedListener(new TextWatcher() {
            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) { }

            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) { }

            @Override
            public void afterTextChanged(Editable s) {
                String strKg = s.toString();
                Log.i("UnitConverter", "Value in txtKg = " + strKg);

                if (!txtKg.isFocused()) return;
                if (strKg.length() == 0) return;

                try {
                    double valKg = Double.parseDouble(strKg);
                    double valLb = valKg*2.2046;
                    String strLb = Double.toString(valLb);
                    Log.i("UnitConverter", "Value in txtLb = " + strLb);

                    MainActivity.this.txtLb.setText(strLb);

                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        } );

        txtGal.addTextChangedListener(new TextWatcher() {
            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) { }

            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) { }

            @Override
            public void afterTextChanged(Editable s) {
                String strGal = s.toString();
                Log.i("UnitConverter", "Value in txtGal = " + strGal);

                if (!txtGal.isFocused()) return;
                if (strGal.length() == 0) return;

                try {
                    double valGal = Double.parseDouble(strGal);
                    double valLiter = valGal*3.78541;
                    String strLiter = Double.toString(valLiter);
                    Log.i("UnitConverter", "Value in txtLiter = " + strLiter);

                    MainActivity.this.txtLiter.setText(strLiter);

                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        } );

        txtLiter.addTextChangedListener(new TextWatcher() {
            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) { }

            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) { }

            @Override
            public void afterTextChanged(Editable s) {
                String strLiter = s.toString();
                Log.i("UnitConverter", "Value in txtLiter = " + strLiter);

                if (!txtLiter.isFocused()) return;
                if (strLiter.length() == 0) return;

                try {
                    double valLiter = Double.parseDouble(strLiter);
                    double valGal = valLiter/3.78541;
                    String strGal = Double.toString(valGal);
                    Log.i("UnitConverter", "Value in txtGal = " + strGal);

                    MainActivity.this.txtGal.setText(strGal);

                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        } );

    }
}