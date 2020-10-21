package com.stmlab.android.testapp;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.annotation.IntRange;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private final int noColdStartApp = 3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
//        Task3
        SharedPreferences sharedPreferences = getSharedPreferences(MyApp.STORAGE_NAME, MODE_PRIVATE);
        if ( sharedPreferences.getInt(MyApp.COUNTER_TAG, 0) == noColdStartApp ) {
            Toast.makeText(MainActivity.this, "Third cold start", Toast.LENGTH_LONG).show();
        }
//        Task2
        decryptData(new int[]{5, 101, 20, 66, 16}, 1, 0, 3);

    }
    public @Nullable int[] decryptData(@NonNull int[] price,@IntRange(from = 1) int discount,@IntRange(from = 0) int offset,@IntRange(from = 1) int readLength) {
        //Узнаем длину конечного массива с учетом выхода за границы исходного массива
        int resultLength = (offset + readLength < price.length) ? readLength : price.length - offset;
        //Если длинна меньше единицы (условие при котором offset больше длины массива), то вернем нулевой массив
        if ( resultLength < 1 ) {
            return new int[0];
        }
        int[] result = new int[resultLength];
        //расчет новой цены
        for (int i = 0; i < resultLength; i++) {
            result[i] = (int) ((1 - ((float) discount / 100))*price[offset+i]);
        }
        return result;
    }
}