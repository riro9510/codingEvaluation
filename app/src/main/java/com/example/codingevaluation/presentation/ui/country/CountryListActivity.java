package com.example.codingevaluation.presentation.ui.country;

import androidx.appcompat.app.AppCompatActivity;
import com.example.codingevaluation.R;
import com.example.codingevaluation.presentation.viewmodels.CountryViewModel;


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

        countryViewModel.getCountries().observe(this, new Observer<List<String>>() {
            @Override
            public void onChanged(List<String> countries) {
                CountryAdapter adapter = new CountryAdapter(countries);
                recyclerView.setAdapter(adapter);
            }
        });

        countryViewModel.loadCountries(this);
    }

}
