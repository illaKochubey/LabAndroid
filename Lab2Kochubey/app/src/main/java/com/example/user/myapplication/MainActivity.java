package com.example.user.myapplication;

import android.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.Spinner;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements Messege.OnMessageReadListener{
    Button OK;
    RadioButton first,second,third;
   private TextView textView;
    Spinner combobox;
    TextView  vALUE;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

       // Spinner Size = (Spinner) findViewById(R.id.combobox);

       // ArrayAdapter<String> MyAdapter = new ArrayAdapter<String>(MainActivity.this,
         //       android.R.layout.simple_list_item_1, getResources().getStringArray(R.array.Autor));
        //MyAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
      //  Size.setAdapter(MyAdapter);

        if(findViewById(R.id.Fragment_container)!=null)
        {
            if(savedInstanceState!=null)
            {
                return;
            }




            Messege messageFragment =new Messege();
            android.support.v4.app.FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction().add(R.id.Fragment_container,messageFragment,null);
            fragmentTransaction.commit();
        }
    }

    @Override
    public void onMessageRead(String message) {


        textView=findViewById(R.id.txt_display_messege);
        textView.setText(message);
    }
}
