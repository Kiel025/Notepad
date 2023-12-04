package com.kiel.notepad;

import android.os.Bundle;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class MainActivity extends AppCompatActivity {

    private AnnotationPreferences preferences;
    private EditText editAnnotation;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        FloatingActionButton fbSave = findViewById(R.id.fbSave);
        editAnnotation = findViewById(R.id.editAnnotation);

        preferences = new AnnotationPreferences(getApplicationContext());

        fbSave.setOnClickListener(v -> {
            String annotation = editAnnotation.getText().toString();
            if (annotation.isEmpty()) {
                Toast.makeText(getApplicationContext(), "Preencha a anotação", Toast.LENGTH_SHORT).show();
            } else {
                preferences.saveAnnotation(annotation);
                Toast.makeText(this, "Anotação salva com sucesso", Toast.LENGTH_SHORT).show();
            }
        });

        String annotation = preferences.getAnnotation();

        if (!annotation.isEmpty()) {
            editAnnotation.setText(annotation);
        }

    }
}