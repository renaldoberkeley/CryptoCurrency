package com.example.cryptocurrency;

import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private RadioGroup radioGroupFrom;
    private RadioGroup radioGroupTo;
    int fromIDselected = 0;
    int toIDselected = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.cryptocurrency);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);


        final EditText fromText = (EditText) findViewById(R.id.fromInput);
        final EditText toText = (EditText) findViewById(R.id.toInput);

        fromText.addTextChangedListener(new TextWatcher() {

            @Override
            public void afterTextChanged(Editable s) {
                Log.i("info", "FROM afterTextChanged: " + fromText.getText());

                findCombination(fromText, toText, s.toString());

            }

            @Override
            public void beforeTextChanged(CharSequence s, int start,
                                          int count, int after) {
            }

            @Override
            public void onTextChanged(CharSequence s, int start,
                                      int before, int count) {
            }
        });


        radioGroupFrom = (RadioGroup)findViewById(R.id.radioGroup_From);

        radioGroupFrom.check(R.id.radioButtonUSD_From);

//        radioGroupTo = (RadioGroup)findViewById(R.id.radioGroup_To);

        radioGroupFrom.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {

            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {

                View radioButton = radioGroupFrom.findViewById(checkedId);
                int index = radioGroupFrom.indexOfChild(radioButton);

                switch (index) {
                    case 0:
//                        Toast.makeText(MainActivity.this,"0",Toast.LENGTH_SHORT).show();
                        fromIDselected = 0;
                        findCombination(fromText, toText, "text");
                        // perform your action here
                        break;
                    case 1:
//                        Toast.makeText(MainActivity.this,"1",Toast.LENGTH_SHORT).show();
                        fromIDselected = 1;
                        findCombination(fromText, toText, "text");
                        // perform your action here
                        break;
                    case 2:
//                        Toast.makeText(MainActivity.this,"2",Toast.LENGTH_SHORT).show();
                        fromIDselected = 2;
                        findCombination(fromText, toText, "text");
                        // perform your action here
                        break;
                }
            }
        });

        radioGroupTo = (RadioGroup)findViewById(R.id.radioGroup_To);

        radioGroupTo.check(R.id.radioButtonBTC_To);

//        radioGroupTo = (RadioGroup)findViewById(R.id.radioGroup_To);

        radioGroupTo.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {

            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {

                View radioButton = radioGroupTo.findViewById(checkedId);
                int index = radioGroupTo.indexOfChild(radioButton);
                switch (index) {
                    case 0:
                        Toast.makeText(MainActivity.this,"3",Toast.LENGTH_SHORT).show();
                        toIDselected = 0;
                        findCombination(fromText, toText, "text");

                        // perform your action here
                        break;
                    case 1:
                        Toast.makeText(MainActivity.this,"4",Toast.LENGTH_SHORT).show();
                        toIDselected = 1;
                        findCombination(fromText, toText, "text");

                        // perform your action here
                        break;
                    case 2:
                        Toast.makeText(MainActivity.this,"5",Toast.LENGTH_SHORT).show();
                        toIDselected = 2;
                        findCombination(fromText, toText, "text");

                        // perform your action here
                        break;
                }
            }
        });





//        FloatingActionButton fab = findViewById(R.id.fab);
//        fab.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
//                        .setAction("Action", null).show();
//            }
//        });
    }

    private void findCombination(EditText fromText, EditText toText, String sText) {

        if(fromIDselected == 0 && toIDselected == 0) {
            fromUSDToUSD(fromText, toText, sText);
        }

        if(fromIDselected == 0 && toIDselected == 1) {
            fromUSDToBTC(fromText, toText, sText);
        }

        if(fromIDselected == 0 && toIDselected == 2) {
            fromUSDToDOGE(fromText, toText, sText);
        }

        if(fromIDselected == 1 && toIDselected == 0) {
            fromBTCToUSD(fromText, toText, sText);
        }

        if(fromIDselected == 1 && toIDselected == 1) {
            fromBTCToBTC(fromText, toText, sText);
        }

        if(fromIDselected == 1 && toIDselected == 2) {
            fromBTCToDOGE(fromText, toText, sText);
        }

        if(fromIDselected == 2 && toIDselected == 0) {
            fromDOGEToUSD(fromText, toText, sText);
        }

        if(fromIDselected == 2 && toIDselected == 1) {
            fromDOGEToBTC(fromText, toText, sText);
        }

        if(fromIDselected == 2 && toIDselected == 2) {
            fromDOGEToDOGE(fromText, toText, sText);
        }
    }

    private void fromUSDToUSD(EditText fromText, EditText toText, String sText) {



        int fromInputNumber = 0;

        if(!sText.equals("")) {
            fromInputNumber = Integer.parseInt(fromText.getText().toString());

        }
//        double result = fromInputNumber * 0.00010;

        double result = fromInputNumber * 1;

        toText.setText(String.format("%.6f", result));


    }

    private void fromUSDToBTC(EditText fromText, EditText toText,  String sText) {


        int fromInputNumber = 0;

        if(!sText.toString().equals("")) {
            fromInputNumber = Integer.parseInt(fromText.getText().toString());

        }

        double result = fromInputNumber * 0.00010;

        toText.setText(String.format("%.6f", result));


    }

    private void fromUSDToDOGE(EditText fromText, EditText toText, String sText) {


        int fromInputNumber = 0;

        if(!sText.equals("")) {
            fromInputNumber = Integer.parseInt(fromText.getText().toString());

        }

        double result = fromInputNumber * 384.28;

        toText.setText(String.format("%.6f", result));


    }

    private void fromBTCToUSD(EditText fromText, EditText toText, String sText) {



        int fromInputNumber = 0;

        if(!sText.equals("")) {
            fromInputNumber = Integer.parseInt(fromText.getText().toString());

        }
        double result = fromInputNumber * 9658.60;

        toText.setText(String.format("%.6f", result));


    }

    private void fromBTCToBTC(EditText fromText, EditText toText,  String sText) {


        int fromInputNumber = 0;

        if(!sText.equals("")) {
            fromInputNumber = Integer.parseInt(fromText.getText().toString());

        }

        double result = fromInputNumber * 1;

        toText.setText(String.format("%.6f", result));


    }

    private void fromBTCToDOGE(EditText fromText, EditText toText, String sText) {


        int fromInputNumber = 0;

        if(!sText.equals("")) {
            fromInputNumber = Integer.parseInt(fromText.getText().toString());

        }

        double result = fromInputNumber * 3609308;

        toText.setText(String.format("%.6f", result));


    }

    private void fromDOGEToUSD(EditText fromText, EditText toText, String sText) {



        int fromInputNumber = 0;

        if(!sText.equals("")) {
            fromInputNumber = Integer.parseInt(fromText.getText().toString());

        }
        double result = fromInputNumber * 0.0025;

        toText.setText(String.format("%.6f", result));


    }

    private void fromDOGEToBTC(EditText fromText, EditText toText,  String sText) {


        int fromInputNumber = 0;

        if(!sText.equals("")) {
            fromInputNumber = Integer.parseInt(fromText.getText().toString());

        }

        double result = fromInputNumber * 0.00000027;

        toText.setText(String.format("%.6f", result));


    }

    private void fromDOGEToDOGE(EditText fromText, EditText toText, String sText) {


        int fromInputNumber = 0;

        if(!sText.equals("")) {
            fromInputNumber = Integer.parseInt(fromText.getText().toString());

        }

        double result = fromInputNumber * 1;

        toText.setText(String.format("%.6f", result));


    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
