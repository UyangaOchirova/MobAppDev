package com.mirea.uyangaochirova.dialog;

import android.app.DatePickerDialog;
import android.content.Context;

public class MyDateDialogFragment extends DatePickerDialog {
    public MyDateDialogFragment(Context context, DatePickerDialog.OnDateSetListener listener, int year, int month, int dayOfMonth) {
        super(context, listener, year, month, dayOfMonth);
    }

}
