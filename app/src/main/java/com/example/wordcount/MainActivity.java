package com.example.wordcount;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

import com.example.wordcount.CountUtility;
import com.example.wordcount.R;

public class MainActivity extends AppCompatActivity {
    private EditText editText;
    private Spinner countTypeSpinner;
    private Button countButton;
    private TextView resultTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editText = findViewById(R.id.editText);
        countTypeSpinner = findViewById(R.id.countTypeSpinner);
        countButton = findViewById(R.id.countButton);
        resultTextView = findViewById(R.id.resultTextView);

        countButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String inputText = editText.getText().toString();
                String selectedCountType = countTypeSpinner.getSelectedItem().toString();

                if (inputText.isEmpty()) {
                    Toast.makeText(MainActivity.this, R.string.empty_text_warning, Toast.LENGTH_SHORT).show();
                } else {
                    int count = 0;
                    if (selectedCountType.equals("Words")) {
                        count = CountUtility.countWords(inputText);
                    } else if (selectedCountType.equals("Characters")) {
                        count = CountUtility.countCharacters(inputText);
                    }
                    resultTextView.setText("Count: " + count);
                }
            }
        });

    }
}
