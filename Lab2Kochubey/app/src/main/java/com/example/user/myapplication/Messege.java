package com.example.user.myapplication;


import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Spinner;
import android.widget.TextView;


/**
 * A simple {@link Fragment} subclass.
 */
public class Messege extends Fragment {

    private EditText editText;
    private  Button OK;
    private RadioButton first,second,third;
    private  TextView textView;
    private  Spinner combobox;
    OnMessageReadListener messageReadListener;
    public Messege() {
        // Required empty public constructor
    }

    public interface OnMessageReadListener
    {
        public void onMessageRead(String message);

    }
    //String[] cities = {"Москва", "Самара", "Вологда", "Волгоград", "Саратов", "Воронеж"};

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment



        View view =inflater.inflate(R.layout.fragment_messege, container, false);

        Spinner spinner =view.findViewById(R.id.combobox);
        spinner.setPrompt("Title");
// Create an ArrayAdapter using the string array and a default spinner layout  /Создание ArrayAdapter с использование строкового массива и слоя спиннера по-умолчанию
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(getActivity(),
                R.array.Autor, android.R.layout.simple_spinner_item);
// Specify the layout to use when the list of choices appears /Указание слоя для использования когда лист данных показывается
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
// Apply the adapter to the spinner  /Применение адаптера к спиннеру
        spinner.setAdapter(adapter);



       // Spinner spinner = view.findViewById(R.id.combobox);
        // Создаем адаптер ArrayAdapter с помощью массива строк и стандартной разметки элемета spinner
       // ArrayAdapter<String> adapter = new ArrayAdapter<String>(, android.R.layout.simple_spinner_item, cities);
        // Определяем разметку для использования при выборе элемента
      // adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        // Применяем адаптер к элементу spinner
      //  spinner.setAdapter(adapter);


        OK = view.findViewById(R.id.OK);
        first = view.findViewById(R.id.first);
        second = view.findViewById(R.id.second);

        third = view.findViewById(R.id.third);
        combobox = view.findViewById(R.id.combobox);
        OK.setOnClickListener(new View.OnClickListener() {
            @Override

            public void onClick(View v) {
                String messega = "qwerty";

                String name1 = "Arthur_Conan_Doyle";
                String name2 = "Agata_Cristi";
                String name3 = "Shevchenko_Taras";
                String var= combobox.getSelectedItem().toString();
                int i=1;

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
                            messega="«Подвиги бригадира Жерара»";
                            messageReadListener.onMessageRead(messega);

                        }
                        else if(second.isChecked()){
                            messega="Человеческая личность ";
                            messageReadListener.onMessageRead(messega);
                        }else if(third.isChecked()){
                            messega="Інформація відсутня";
                            messageReadListener.onMessageRead(messega);
                        }
                        break;
                    case 2:
                        if(first.isChecked()){
                            messega="Інформація відсутня";
                            messageReadListener.onMessageRead(messega);
                        }
                        else if(second.isChecked()){
                            messega="Таинственное происшествие";
                            messageReadListener.onMessageRead(messega);
                        }else if(third.isChecked()){
                            messega="Інформація відсутня";
                            messageReadListener.onMessageRead(messega);
                        }
                        break;
                    case 3:
                        if(first.isChecked()){
                            messega="Інформація відсутня";
                            messageReadListener.onMessageRead(messega);
                        }
                        else if(second.isChecked()){
                            messega="Інформація відсутня";
                            messageReadListener.onMessageRead(messega);
                        }else if(third.isChecked()){
                            messega="нове видання «Кобзаря»";
                            messageReadListener.onMessageRead(messega);
                        };
                        break;


                }







                messageReadListener.onMessageRead(messega);
            }
        });

        return  view;
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        Activity activity=(Activity)context;
    try{
        messageReadListener =(OnMessageReadListener) activity;

    }catch (ClassCastException e){
        throw new ClassCastException(activity.toString()+"Must ovveride onMessageRead....");
    }
}}
