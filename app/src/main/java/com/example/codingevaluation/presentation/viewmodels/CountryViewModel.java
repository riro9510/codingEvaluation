package com.example.codingevaluation.presentation.viewmodels;

import android.content.Context;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.codingevaluation.R;
import java.util.Arrays;
import java.util.List;

public class CountryViewModel extends ViewModel {

    private MutableLiveData<List<String>> countriesList = new MutableLiveData<>();

    public  void loadCountries(Context context){
        String[] countries = context.getResources().getStringArray(R.array.countries_array);
        countriesList.setValue(Arrays.asList(countries));
    }

    public LiveData<List<String>> getCountries() {
        return countriesList;
    }

}
