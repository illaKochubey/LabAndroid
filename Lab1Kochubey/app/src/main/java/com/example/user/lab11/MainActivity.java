package com.example.user.lab11;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    Button OK;
    RadioButton first,second,third;
    TextView textView;
    Spinner combobox;
    TextView  vALUE;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Spinner Size = (Spinner) findViewById(R.id.combobox);

        ArrayAdapter<String> MyAdapter = new ArrayAdapter<String>(MainActivity.this,
                android.R.layout.simple_list_item_1, getResources().getStringArray(R.array.Autor));
        MyAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        Size.setAdapter(MyAdapter);

        OK = (Button)findViewById(R.id.OK);
        textView = (TextView)findViewById(R.id.textView);
        first = (RadioButton)findViewById(R.id.first);
        second = (RadioButton)findViewById(R.id.second);
        third = (RadioButton)findViewById(R.id.third);
        combobox = (Spinner) findViewById(R.id.combobox);
        //combobox.getSelectedItem().toString().compareTo("</item>")==1
       // combobox.getSelectedItem().toString().compareTo(var.toString())==1
        OK.setOnClickListener(new View.OnClickListener() {
            @Override

            public void onClick(View v) {


                String name1 = "Arthur_Conan_Doyle";
                String name2 = "Agata_Cristi";
                String name3 = "Shevchenko_Taras";

                String var= combobox.getSelectedItem().toString();
                int i=99;

                if(name1.equals(var)==true)
                {
                    i=1;
                }
                if(name2.equals(var)==true)
                {
                    i=2;
                }
                if(name3.equals(var)==true)
                {
                    i=3;
                }


                switch (i) {
                    case 1:
                        if(first.isChecked()){
                            textView.setText("«Подвиги бригадира Жерара»");
                        }
                        else if(second.isChecked()){
                            textView.setText("Человеческая личность ");
                        }else if(third.isChecked()){
                            textView.setText("Інформація відсутня");
                        }
                    break;
                    case 2:
                        if(first.isChecked()){
                            textView.setText("Інформація відсутня");
                        }
                        else if(second.isChecked()){
                            textView.setText("Таинственное происшествие");
                        }else if(third.isChecked()){
                            textView.setText("Інформація відсутня");
                        }
                        break;
                    case 3:
                        if(first.isChecked()){
                            textView.setText("Інформація відсутня");
                        }
                        else if(second.isChecked()){
                            textView.setText("Інформація відсутня");
                        }else if(third.isChecked()){
                            textView.setText("нове видання «Кобзаря»");
                        };
                        break;


                }


            }
        });


    }
}
