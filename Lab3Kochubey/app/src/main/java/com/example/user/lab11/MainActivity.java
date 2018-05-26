package com.example.user.lab11;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class MainActivity extends AppCompatActivity
{
    public static final String EXTRA_TEXT = "Text", EXTRA_SIZE="Size";
    Button OK,save,open;
    RadioButton first,second,third;
    TextView textView,textView2;
    Spinner combobox;
    TextView  vALUE;
    String messega = "qwerty";
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Spinner Size = (Spinner) findViewById(R.id.combobox);

        ArrayAdapter<String> MyAdapter = new ArrayAdapter<String>(MainActivity.this,
                android.R.layout.simple_list_item_1, getResources().getStringArray(R.array.Autor));
        MyAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        Size.setAdapter(MyAdapter);

        OK = (Button)findViewById(R.id.OK);
        textView = (TextView)findViewById(R.id.textView);
        textView2 = (TextView)findViewById(R.id.textView2);
        save= (Button)findViewById(R.id.save);
        open= (Button)findViewById(R.id.open);
       // open.setOnClickListener(this);
        first = (RadioButton)findViewById(R.id.first);
        second = (RadioButton)findViewById(R.id.second);
        third = (RadioButton)findViewById(R.id.third);
        combobox = (Spinner) findViewById(R.id.combobox);




        //combobox.getSelectedItem().toString().compareTo("</item>")==1
       // combobox.getSelectedItem().toString().compareTo(var.toString())==1
        OK.setOnClickListener(new View.OnClickListener()
                              {
            @Override

            public void onClick(View v)
            {


                String name1 = "Arthur_Conan_Doyle";
                String name2 = "Agata_Cristi";
                String name3 = "Shevchenko_Taras";
                 messega = "qwerty";



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
                            messega="Подвиги бригадира Жерара";
                        }
                        else if(second.isChecked()){
                            messega="Человеческая личность ";
                            textView.setText("Человеческая личность ");
                        }else if(third.isChecked()){
                            messega="Інформація відсутня";
                            textView.setText("Інформація відсутня");
                        }
                    break;
                    case 2:
                        if(first.isChecked()){messega="Інформація відсутня";
                            textView.setText("Інформація відсутня");
                        }
                        else if(second.isChecked()){messega="Таинственное происшествие";
                            textView.setText("Таинственное происшествие");
                        }else if(third.isChecked()){messega="Інформація відсутня";
                            textView.setText("Інформація відсутня");
                        }
                        break;
                    case 3:
                        if(first.isChecked()){messega="Інформація відсутня";
                            textView.setText("Інформація відсутня");
                        }
                        else if(second.isChecked()){messega="Інформація відсутня";
                            textView.setText("Інформація відсутня");
                        }else if(third.isChecked()){messega="нове видання «Кобзаря»";
                            textView.setText("нове видання «Кобзаря»");
                        };
                        break;


                }





            }



        }


        );
        save.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                saveData("OutPut",messega);

                textView2.setText(messega);
            }



        });


    }



    public void openClick(View v) {

        try {
            // открываем поток для чтения
            BufferedReader br = new BufferedReader(new InputStreamReader(
                    openFileInput("OutPut")));
            String str = "", str2 = "";
            // читаем содержимое
            str = br.readLine();
            str2 = br.readLine();
            if(str2 == "")
            {
                Toast.makeText(this, "File is empty!", Toast.LENGTH_LONG).show();
            }
            else
            {
                try {
                    Intent intent = new Intent(this, Main3Activity.class);
                    intent.putExtra(EXTRA_TEXT, str);
                    intent.putExtra(EXTRA_SIZE, str2);
                    startActivity(intent);
                }
                catch (Exception e){
                    Toast.makeText(this, e.toString(), Toast.LENGTH_LONG).show();
                }
            }
        }
        catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }




    }









    public void saveData(String fileName,String data){
            try {
                BufferedWriter writer =new BufferedWriter(new OutputStreamWriter(openFileOutput(fileName,MODE_PRIVATE)));

                writer.write(data);

                writer.close();
                Toast.makeText(this, "Файл записан", Toast.LENGTH_LONG).show();


            } catch (FileNotFoundException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }


    }


}
