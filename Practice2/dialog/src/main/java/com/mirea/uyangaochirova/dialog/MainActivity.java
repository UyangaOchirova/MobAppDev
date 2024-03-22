package com.mirea.uyangaochirova.dialog;

import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.os.Bundle;
import android.view.View;
import android.widget.DatePicker;
import android.widget.TimePicker;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.fragment.app.DialogFragment;

import com.google.android.material.snackbar.Snackbar;


public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
//        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
//            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
//            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
//            return insets;
//        });
    }
    public void onClickShowDialog(View view) {
        MyDialogFragment dialogFragment = new MyDialogFragment();
        dialogFragment.show(getSupportFragmentManager(), "mirea");
    }
    public void onOkClicked() {
        Toast.makeText(getApplicationContext(), "Вы выбрали кнопку \"Иду дальше\"!",
                Toast.LENGTH_LONG).show();
    }
    public void onCancelClicked() {
        Toast.makeText(getApplicationContext(), "Вы выбрали кнопку \"Нет\"!",
                Toast.LENGTH_LONG).show();
    }
    public void onNeutralClicked() {
        Toast.makeText(getApplicationContext(), "Вы выбрали кнопку \"На паузе\"!",
                Toast.LENGTH_LONG).show();
    }

    public void onClickTimeDialog(View view){
        MyTimeDialogFragment timePicker = new MyTimeDialogFragment(this, new TimePickerDialog.OnTimeSetListener() {
            @Override
            public void onTimeSet(TimePicker timePicker1, int hourOfDay, int minute) {
                Snackbar.make(view, hourOfDay+":"+minute, Snackbar.LENGTH_LONG).show();
            }
        }, 16, 30, true);
        timePicker.show();
        Snackbar snackbar = Snackbar.make(view, "time opened", Snackbar.LENGTH_LONG);
        snackbar.show();
    }

    public void onClickDateDialog(View view){
        MyDateDialogFragment datePicker = new MyDateDialogFragment(this, new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker datePicker1, int year, int month, int dayOfMonth) {
                Snackbar.make(view, dayOfMonth+"."+month+"."+year, Snackbar.LENGTH_LONG).show();
            }
        }, 2024, 3, 9);
        datePicker.show();
        Snackbar.make(view, "date opened", Snackbar.LENGTH_LONG).show();
    }

    public void onClickProgressDialog(View view){
        MyProgressDialogFragment progressDialog = new MyProgressDialogFragment(this);
        progressDialog.setTitle("Progress Dialog");
        progressDialog.setMessage("Loading...");
        progressDialog.show();
    }
}