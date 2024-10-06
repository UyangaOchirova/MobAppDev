package com.mirea.uyangaochirova.employeedb;

import static android.content.ContentValues.TAG;

import android.os.Bundle;
import android.util.Log;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;
public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        AppDatabase db = App.getInstance().getDatabase();
        EmployeeDao employeeDao = db.employeeDao();
        Employee employee = new Employee();

        employee.id = 1;
        employee.name = "Super-hero";
        employee.salary = 1000;
        employeeDao.insert(employee);
        employee.id = 2;
        employee.name = "Super-hero";
        employee.salary = 1000;
        employeeDao.update(employee);
        employee.id = 3;
        employee.name = "A";
        employee.salary = 100;
        employeeDao.insert(employee);
        employee.id = 4;
        employee.name = "B";
        employee.salary = 40000;
        employeeDao.insert(employee);

        // Загрузка всех работников
//        List<Employee> employees = employeeDao.getAll();
        // Получение определенного работника с id = 1
//        employee = employeeDao.getById(1);
        // Обновление полей объекта
//        employee.salary = 20000;
//        employeeDao.update(employee);
//        Log.d(TAG, employee.name + " " + employee.salary);

        List<Employee> employees = employeeDao.getAll();
        for (Employee emp : employees) {
            Log.d(TAG, "ID: " + emp.id + ", Name: " + emp.name + ", Salary: " + emp.salary);
        }

    }
}