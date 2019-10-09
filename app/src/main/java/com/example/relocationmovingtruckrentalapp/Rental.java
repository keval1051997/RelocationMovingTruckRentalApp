package com.example.relocationmovingtruckrentalapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.widget.ImageView;
import android.widget.TextView;

import java.text.DecimalFormat;

public class Rental extends AppCompatActivity {
    double tenFootTruckCost = 19.95;
    double  seventeenFootTruckCost = 29.95;
    double  twentySixFootTruckCost = 39.95;
    double costPerMile = 0.99;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rental);
        TextView totalRental = (TextView)findViewById(R.id.txttotalrental);
        ImageView image = (ImageView)findViewById(R.id.imgSize);
        SharedPreferences sharedPref = PreferenceManager.getDefaultSharedPreferences(this);
        int truckSize = sharedPref.getInt("key1", 0);
        int totalMiles = sharedPref.getInt("key2", 0);
        double decTotalRental;
        DecimalFormat currency = new DecimalFormat("$###,###.##");


        if (truckSize == 10) {
            image.setImageResource(R.drawable.tenfoot);
            decTotalRental = tenFootTruckCost + (totalMiles * costPerMile);
            totalRental.setText("Total Rental is: " + currency.format(decTotalRental));

        } else if (truckSize == 17) {
            image.setImageResource(R.drawable.seventeenfoot);
            decTotalRental = seventeenFootTruckCost + (totalMiles * costPerMile);
            totalRental.setText("Total Rental is: " + currency.format(decTotalRental));

        } else if (truckSize == 26) {
            image.setImageResource(R.drawable.twentysixfoot);
            decTotalRental = twentySixFootTruckCost + (totalMiles * costPerMile);
            totalRental.setText("Total Rental is: " + currency.format(decTotalRental));

        } else {
            totalRental.setText("Enter 10, 17, or 26 foot");
        }



    }
}
