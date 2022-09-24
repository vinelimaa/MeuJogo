package com.example.meujogo;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import androidx.annotation.ColorInt;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;
import androidx.core.content.res.ResourcesCompat;
import androidx.gridlayout.widget.GridLayout;

import com.google.android.material.textfield.TextInputEditText;

import java.lang.reflect.Parameter;

public class MainActivity extends AppCompatActivity {


    GridLayout grid;
    Button button;
    TextInputEditText input;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        grid = findViewById(R.id.grid_layout);
        button = findViewById(R.id.button_guess);
        input = findViewById(R.id.input_text_guess);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                addPalavra(input.getText().toString());
            }
        });
    }

    private void addPalavra(String palavra) {
        if (palavra.trim().length() != 5) {
            return;
        }
        for (char letra: palavra.toCharArray()) {
            grid.addView(createLabelView(Character.toString(letra)));

        }
    }

    protected TextView createLabelView(String texto) {
        TextView labelView = new TextView(this);
        labelView.setText(texto);
        labelView.setWidth(grid.getWidth()/5);
        labelView.setTextAlignment(View.TEXT_ALIGNMENT_CENTER);
        labelView.setTextSize(48);
        labelView.setBackgroundResource(R.drawable.textview_border);
        return labelView;
    }
}