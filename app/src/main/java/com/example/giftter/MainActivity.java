package com.example.giftter;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.database.SQLException;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.AbsoluteLayout;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.example.giftter.DatabaseHelper;

import java.io.IOException;

public class MainActivity extends AppCompatActivity {
    Spinner spinnerage,spinnerage2;
    Spinner spinnerper;
    Spinner spinnerocc,spinnerocc3;
    Spinner spinnerpri;
    Animation animbounce;
    Cursor c=null;
    String[] age={"0-2yrs","3-5yrs","6-9yrs","10-15yrs","16-20yrs","21-30yrs","31-40yrs","41-55yrs","55+yrs"};
    String[] age1={"16-20yrs","21-30yrs","31-40yrs","41-55yrs","55+yrs"};
    String[] per={"Aesthete(Toy Lovers)","Home Proud","Gadget/Pc mad","Diy Enthusiast","Intellectual","Adventurous","Fashion"};
    String[] occ3={"Birthday","Anniversary","Valentine","New year/Christmas/Diwali"};
    String[] occ={"Birthday","New year/Christmas/Diwali"};
    String[] pri={"100-500","500-1000","1000-2500","2500-5000","5000-10000","10000-15000","15000-20000","20000+"};
    String For="Him",Age,Person,Occasion,Price;
    TextView tx1,tx2,tx3,tx4,tx5;
    Button bt,bt2;
    String[] sp;
    String[] li;
    String id="2";



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


        setContentView(R.layout.activity_main);
        RadioGroup rg=(RadioGroup)findViewById(R.id.radiogroup);
        spinnerage=(Spinner)findViewById(R.id.spinnerage);
        spinnerage2=(Spinner)findViewById(R.id.spinnerage2);
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,android.R.layout.simple_spinner_dropdown_item,age);
        spinnerage.setAdapter(adapter);
        ArrayAdapter<String> adapter5=new ArrayAdapter<String>(this,android.R.layout.simple_spinner_dropdown_item,age1);
        spinnerage2.setAdapter(adapter5);
        spinnerper=(Spinner)findViewById(R.id.spinnerper);
        ArrayAdapter<String> adapter1 = new ArrayAdapter<String>(this,android.R.layout.simple_spinner_dropdown_item,per);
        spinnerper.setAdapter(adapter1);
        spinnerper.setVisibility(View.INVISIBLE);
        spinnerage.setVisibility(View.VISIBLE);
        Age=spinnerage.getItemAtPosition(0).toString();

        spinnerage.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                Age=age[position];
                if(position<2){
                    spinnerper.setVisibility(View.INVISIBLE);
                }
                else {
                    spinnerper.setVisibility(View.VISIBLE);
                    spinnerper.setSelection(0);
                    Person=spinnerper.getItemAtPosition(0).toString();
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
        spinnerage2.setVisibility(View.INVISIBLE);
        spinnerocc=(Spinner)findViewById(R.id.spinnerocc);
        ArrayAdapter<String> adapter2 = new ArrayAdapter<String>(this,android.R.layout.simple_spinner_dropdown_item,occ);
        spinnerocc.setAdapter(adapter2);
        spinnerocc3=(Spinner)findViewById(R.id.spinnerocc3);
        ArrayAdapter<String> adapter6 = new ArrayAdapter<String>(this,android.R.layout.simple_spinner_dropdown_item,occ3);
        spinnerocc3.setAdapter(adapter6);
        spinnerocc3.setVisibility(View.INVISIBLE);
        spinnerocc.setVisibility(View.VISIBLE);
        Occasion=spinnerocc.getItemAtPosition(0).toString();
        spinnerocc.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                Occasion=occ[position];
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
        rg.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int i) {
                switch (i){
                    case R.id.radioButton12:
                        For="Him";

                        spinnerage.setVisibility(View.VISIBLE);
                        spinnerage2.setVisibility(View.INVISIBLE);
                        spinnerage.setSelection(0);
                        Age=spinnerage.getItemAtPosition(0).toString();
                        spinnerocc.setSelection(0);
                        Occasion=spinnerocc.getItemAtPosition(0).toString();
                        spinnerpri.setSelection(0);
                        Price=spinnerpri.getItemAtPosition(0).toString();
                        spinnerper.setSelection(0);
                        Person=spinnerper.getItemAtPosition(0).toString();
                        spinnerper.setVisibility(View.INVISIBLE);
                        spinnerocc3.setVisibility(View.INVISIBLE);
                        spinnerocc.setVisibility(View.VISIBLE);
                        spinnerage.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                            @Override
                            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                                Age=age[position];

                                if(position<2){
                                    spinnerper.setVisibility(View.INVISIBLE);
                                }
                                else {
                                    spinnerper.setVisibility(View.VISIBLE);
                                    spinnerper.setSelection(0);
                                    Person=spinnerper.getItemAtPosition(0).toString();
                                }
                                if(position>3){
                                    spinnerocc.setVisibility(View.INVISIBLE);
                                    spinnerocc3.setVisibility(View.VISIBLE);
                                    spinnerocc3.setSelection(0);
                                    Occasion=spinnerocc3.getItemAtPosition(0).toString();
                                    spinnerocc3.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                                        @Override
                                        public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                                            Occasion=occ3[position];
                                        }

                                        @Override
                                        public void onNothingSelected(AdapterView<?> parent) {

                                        }
                                    });

                                }
                                else if(position<=3) {
                                    spinnerocc.setVisibility(View.VISIBLE);
                                    spinnerocc.setSelection(0);
                                    spinnerocc3.setVisibility(View.INVISIBLE);
                                    Occasion=spinnerocc.getItemAtPosition(0).toString();
                                    spinnerocc.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                                        @Override
                                        public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                                            Occasion=occ[position];
                                        }

                                        @Override
                                        public void onNothingSelected(AdapterView<?> parent) {

                                        }
                                    });
                                }

                            }

                            @Override
                            public void onNothingSelected(AdapterView<?> parent) {

                            }
                        });

                        break;
                    case R.id.radioButton13:
                        For="Her";

                        spinnerage.setVisibility(View.VISIBLE);
                        spinnerage2.setVisibility(View.INVISIBLE);
                        spinnerage.setSelection(0);
                        Age=spinnerage.getItemAtPosition(0).toString();
                        spinnerocc.setSelection(0);
                        Occasion=spinnerocc.getItemAtPosition(0).toString();
                        spinnerpri.setSelection(0);
                        Price=spinnerpri.getItemAtPosition(0).toString();
                        spinnerper.setSelection(0);
                        Person=spinnerper.getItemAtPosition(0).toString();
                        spinnerper.setVisibility(View.INVISIBLE);
                        spinnerocc3.setVisibility(View.INVISIBLE);
                        spinnerocc.setVisibility(View.VISIBLE);
                        spinnerage.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                            @Override
                            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                                Age=age[position];
                                if(position<2) {
                                    spinnerper.setVisibility(View.INVISIBLE);
                                }
                                else {
                                    spinnerper.setVisibility(View.VISIBLE);
                                    spinnerper.setSelection(0);
                                    Person=spinnerper.getItemAtPosition(0).toString();
                                    }
                                if(position>3){
                                    spinnerocc.setVisibility(View.INVISIBLE);
                                    spinnerocc3.setVisibility(View.VISIBLE);
                                    spinnerocc3.setSelection(0);
                                    Occasion=spinnerocc3.getItemAtPosition(0).toString();
                                    spinnerocc3.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                                        @Override
                                        public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                                            Occasion=occ3[position];
                                        }

                                        @Override
                                        public void onNothingSelected(AdapterView<?> parent) {

                                        }
                                    });

                                }
                                else if(position<=3) {
                                    spinnerocc.setVisibility(View.VISIBLE);
                                    spinnerocc3.setVisibility(View.INVISIBLE);
                                    spinnerocc.setSelection(0);
                                    Occasion=spinnerocc.getItemAtPosition(0).toString();
                                    spinnerocc.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                                        @Override
                                        public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                                            Occasion=occ[position];
                                        }

                                        @Override
                                        public void onNothingSelected(AdapterView<?> parent) {

                                        }
                                    });
                                }

                            }

                            @Override
                            public void onNothingSelected(AdapterView<?> parent) {

                            }
                        });

                        break;
                    case R.id.radioButton14:
                        For="Couple";
                        spinnerage.setVisibility(View.INVISIBLE);
                        spinnerage2.setVisibility(View.VISIBLE);
                        spinnerage2.setSelection(0);
                        Age=spinnerage2.getItemAtPosition(0).toString();

                        spinnerper.setVisibility(View.VISIBLE);
                        spinnerper.setSelection(0);
                        Person=spinnerper.getItemAtPosition(0).toString();
                        spinnerocc3.setVisibility(View.VISIBLE);
                        spinnerocc3.setSelection(0);
                        Occasion=spinnerocc3.getItemAtPosition(0).toString();
                        spinnerpri.setSelection(0);
                        Price=spinnerpri.getItemAtPosition(0).toString();
                        spinnerper.setSelection(0);
                        Person=spinnerper.getItemAtPosition(0).toString();
                        spinnerocc.setVisibility(View.INVISIBLE);
                        spinnerage2.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                            @Override
                            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                                Age=age1[position];

                            }

                            @Override
                            public void onNothingSelected(AdapterView<?> parent) {

                            }
                        });
                        spinnerocc3.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                            @Override
                            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                                Occasion=occ3[position];
                            }

                            @Override
                            public void onNothingSelected(AdapterView<?> parent) {

                            }
                        });
                        break;
                }

            }
        });




        spinnerpri=(Spinner)findViewById(R.id.spinnerpri);
        ArrayAdapter<String> adapter3 = new ArrayAdapter<String>(this,android.R.layout.simple_spinner_dropdown_item,pri);
        spinnerpri.setAdapter(adapter3);
        Price=spinnerpri.getItemAtPosition(0).toString();

        spinnerper.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                Person=per[position];

            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
        spinnerpri.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                Price=pri[position];
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
        bt2=(Button)findViewById(R.id.button);
        bt2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(),For+"\n"+Age+"\n"+Price+"\n"+Occasion+"\n"+Person,Toast.LENGTH_SHORT).show();
            }
        });
        bt =(Button)findViewById(R.id.button2);
        bt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DatabaseHelper myDbHelper=new DatabaseHelper(MainActivity.this);
                try{
                    myDbHelper.createDataBase();
                }catch (IOException ioe){
                    throw new Error("Unable to create database");
                }
                try {
                    myDbHelper.openDataBase();
                }catch (SQLException sqle){
                    throw sqle;
                }
                Toast.makeText(MainActivity.this,"Success",Toast.LENGTH_SHORT).show();
                c=myDbHelper.getData(For,Age,Price,Occasion,Person);
                if(c.moveToFirst()){
                    do{
                        sp=c.getString(6).split(",");
                        li=c.getString(7).split(",");
                    }while(c.moveToNext());
                }
                Intent intent=new Intent(MainActivity.this,ListActivity.class);
                intent.putExtra("Sp",sp);
                intent.putExtra("Li",li);
                startActivity(intent);
            }
        });

    }
    protected void onStart(){
        super.onStart();
        animbounce=AnimationUtils.loadAnimation(getApplicationContext(),R.anim.bouncing);
        bt=(Button)findViewById(R.id.button2);
        bt.setVisibility(View.VISIBLE);
        bt.startAnimation(animbounce);
        tx1=(TextView)findViewById(R.id.textView10);
        tx1.setVisibility(View.VISIBLE);
        tx1.startAnimation(animbounce);
        tx2=(TextView)findViewById(R.id.textView12);
        tx2.setVisibility(View.VISIBLE);
        tx2.startAnimation(animbounce);
        tx3=(TextView)findViewById(R.id.textView13);
        tx3.setVisibility(View.VISIBLE);
        tx3.startAnimation(animbounce);
        tx4=(TextView)findViewById(R.id.textView14);
        tx4.setVisibility(View.VISIBLE);
        tx4.startAnimation(animbounce);
        tx5=(TextView)findViewById(R.id.textView15);
        tx5.setVisibility(View.VISIBLE);
        tx5.startAnimation(animbounce);

    }
}
