package com.example.codingevaluation.presentation.ui.country;

import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.codingevaluation.R;
import com.example.codingevaluation.presentation.ui.country.CountryDetailActivity;

import java.util.List;

public class CountryAdapter extends RecyclerView.Adapter<CountryAdapter.CountryViewHolder> {

    private final List<String> countries;
    private final OnCountryClickListener listener;


    public interface OnCountryClickListener {
        void onCountryClick(String countryName);
    }

    public CountryAdapter(List<String> countries, OnCountryClickListener listener) {
        this.countries = countries;
        this.listener = listener;
    }

    @NonNull
    @Override
    public CountryViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_country, parent, false);
        return new CountryViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull CountryViewHolder holder, int position) {
        String country = countries.get(position);
        holder.countryName.setText(country);

        holder.itemView.setOnClickListener(v -> {
            if (listener != null) {
                listener.onCountryClick(country);
            }
        });
    }

    @Override
    public int getItemCount() {
        return countries.size();
    }

    public static class CountryViewHolder extends RecyclerView.ViewHolder {
        TextView countryName;

        public CountryViewHolder(@NonNull View itemView) {
            super(itemView);
            countryName = itemView.findViewById(R.id.country_name);
        }
    }
}