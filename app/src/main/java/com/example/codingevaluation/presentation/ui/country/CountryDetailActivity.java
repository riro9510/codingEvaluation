package com.example.codingevaluation.presentation.ui.country;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.bumptech.glide.Glide;
import com.example.codingevaluation.R;
import com.example.codingevaluation.network.CountryNetwork;
import com.example.codingevaluation.domain.models.CountryDetail;

import java.text.NumberFormat;
import java.util.Locale;

public class CountryDetailActivity extends AppCompatActivity {

    // Views
    private ImageView ivFlag;
    private TextView tvCountryName;
    private TextView tvCapital;
    private TextView tvPopulation;
    private TextView tvArea;
    private TextView tvRegion;
    private TextView tvSubregion;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_country_detail);

        // Bind views
        ivFlag = findViewById(R.id.iv_flag);
        tvCountryName = findViewById(R.id.tv_country_name);
        tvCapital = findViewById(R.id.tv_capital);
        tvPopulation = findViewById(R.id.tv_population);
        tvArea = findViewById(R.id.tv_area);
        tvRegion = findViewById(R.id.tv_region);
        tvSubregion = findViewById(R.id.tv_subregion);

        // Obtener el nombre del país del Intent
        String countryName = getIntent().getStringExtra("country_name");
        if (countryName == null || countryName.isEmpty()) {
            Toast.makeText(this, "No country selected", Toast.LENGTH_LONG).show();
            finish();
            return;
        }

        // Cargar datos del país
        loadCountryDetail(countryName);
    }

    private void loadCountryDetail(String countryName) {
        CountryNetwork repo = new CountryNetwork();
        repo.fetchCountryDetail(countryName, new CountryNetwork.Callback() {
            @Override
            public void onSuccess(CountryDetail country) {
                runOnUiThread(() -> bindCountryToUI(country));
            }

            @Override
            public void onError(String error) {
                runOnUiThread(() -> {
                    Toast.makeText(CountryDetailActivity.this,
                            "Error loading country: " + error,
                            Toast.LENGTH_LONG).show();
                });
            }
        });
    }

    private void bindCountryToUI(CountryDetail country) {
        // Nombre grande
        tvCountryName.setText(country.getName());

        // Datos con formato bonito
        tvCapital.setText("Capital: " + country.getCapital());

        // Formato con comas para población
        NumberFormat formatter = NumberFormat.getInstance(Locale.getDefault());
        tvPopulation.setText("Population: " + formatter.format(country.getPopulation()));

        // Área con separador de miles y sin decimales si es entero
        tvArea.setText("Area: " + formatter.format(country.getArea()) + " km²");

        tvRegion.setText("Region: " + country.getRegion());
        tvSubregion.setText("Sub-region: " + country.getSubregion());

        // Bandera con Glide (con placeholder y error)
        Glide.with(this)
                .load(country.getFlagUrl())
                .placeholder(R.drawable.ic_launcher_foreground)  // mientras carga
                .error(R.drawable.ic_launcher_background)        // si falla
                .into(ivFlag);
    }
}