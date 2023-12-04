package com.kiel.notepad;

import android.content.Context;
import android.content.SharedPreferences;

public class AnnotationPreferences {

    private Context context;
    private SharedPreferences preferences;
    private SharedPreferences.Editor editor;
    private final String ARCHIVE_NAME = "annotation.preferences";
    private final String CHAVE_NOME = "nome";

    public AnnotationPreferences(Context context) {
        this.context = context;
        preferences = context.getSharedPreferences(ARCHIVE_NAME, 0);
        editor = preferences.edit();
    }

    public void saveAnnotation(String annotation) {
        editor.putString(CHAVE_NOME, annotation);
        editor.commit();
    }

    public String getAnnotation() {
        return preferences.getString(CHAVE_NOME, "");
    }

}
