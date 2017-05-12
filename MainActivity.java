package extracredit.jridi.com.extracredit;

import android.content.DialogInterface;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.view.View;
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.text.TextWatcher;


public class MainActivity extends AppCompatActivity {

    private Spinner spinner1;
    private EditText value;
    private SharedPreferences savedValues;
    private TextView result;
    private TextView toBeConverted;
    private TextView converted;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        spinner1 = (Spinner) findViewById(R.id.spinner1);
        value = (EditText) findViewById(R.id.value);
        savedValues = getSharedPreferences("SavedValues", MODE_PRIVATE);
        result = (TextView) findViewById(R.id.result);

        toBeConverted = (TextView) findViewById(R.id.toBeConverted);
        converted = (TextView) findViewById(R.id.converted);

        value.addTextChangedListener(new TextWatcher() {

            public void afterTextChanged(Editable s) {
                calculate();

            }

            public void beforeTextChanged(CharSequence s, int start, int count, int after) {}

            public void onTextChanged(CharSequence s, int start, int before, int count) {
                calculate();
            }
        });

        spinner1.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parentView, View selectedItemView, int position, long id) {
                // your code here

                String choice = String.valueOf(spinner1.getSelectedItem());

                String[] array = choice.split(" ");

                toBeConverted.setText(array[0]);
                converted.setText(array[2]);

                calculate();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parentView) {
                // your code here
            }

        });

        savedValues = getSharedPreferences("SavedValues", MODE_PRIVATE);

    }



        public void calculate() {

            String inval = value.getText().toString();
            float input;
            if (inval.equals("")) {
                input = 0;
            }
            else {
                input = Float.parseFloat(inval);
            }

            String choice = String.valueOf(spinner1.getSelectedItem());
            double output=0.0;
            switch(choice) {
                case "Miles to Kilometers":
                    output = input * 1.6093;
                    break;
                case "Kilometers to Miles":
                    output = input * 0.6214;
                    break;
                case "Inches to Centimeters":
                    output = input * 2.54;
                    break;
                case "Centimeters to Inches":
                    output = input * 0.3937;
                    break;
            }

            result.setText(Double.toString(output));


        }




}








