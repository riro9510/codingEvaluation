package com.example.codingevaluation.domain.models;

public class CountryDetail {
    private final String name;
    private final String capital;
    private final long population;
    private final double area;
    private final String region;
    private final String subregion;
    private final String flagUrl;

    // Constructor principal (usado en parsing)
    public CountryDetail(String name, String capital, long population, double area,
                         String region, String subregion, String flagUrl) {
        this.name = name;
        this.capital = capital;
        this.population = population;
        this.area = area;
        this.region = region;
        this.subregion = subregion;
        this.flagUrl = flagUrl;
    }

    // Getters (solo lectura → inmutable)
    public String getName() { return name; }
    public String getCapital() { return capital; }
    public long getPopulation() { return population; }
    public double getArea() { return area; }
    public String getRegion() { return region; }
    public String getSubregion() { return subregion; }
    public String getFlagUrl() { return flagUrl; }

    @Override
    public String toString() {
        return "CountryDetail{" +
                "name='" + name + '\'' +
                ", capital='" + capital + '\'' +
                ", population=" + population +
                ", area=" + area +
                ", region='" + region + '\'' +
                ", subregion='" + subregion + '\'' +
                '}';
    }
}