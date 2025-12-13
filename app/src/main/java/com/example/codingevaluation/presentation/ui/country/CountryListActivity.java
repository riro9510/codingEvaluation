package com.example.codingevaluation.presentation.ui.country;

import androidx.appcompat.app.AppCompatActivity;
import com.example.codingevaluation.R;
import com.example.codingevaluation.presentation.viewmodels.CountryViewModel;


import android.content.Intent;
import android.os.Bundle;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;


import java.util.List;


public class CountryListActivity extends AppCompatActivity{
    private RecyclerView recyclerView;
    private CountryViewModel countryViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_country_list);

        recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        countryViewModel = new ViewModelProvider(this).get(CountryViewModel.class);

        countryViewModel.getCountries().observe(this, countries -> {
            CountryAdapter adapter = new CountryAdapter(countries, countryName -> {
                Intent intent = new Intent(CountryListActivity.this, CountryDetailActivity.class);
                intent.putExtra("country_name", countryName);
                startActivity(intent);
            });
            recyclerView.setAdapter(adapter);
        });

        countryViewModel.loadCountries(this);
    }

}
