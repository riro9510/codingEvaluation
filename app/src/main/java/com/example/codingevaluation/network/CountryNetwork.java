package com.example.codingevaluation.network;

import com.example.codingevaluation.domain.models.CountryDetail;
import org.json.JSONArray;
import org.json.JSONObject;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.concurrent.Executors;

public class CountryNetwork {

    public interface Callback {
        void onSuccess(CountryDetail country);
        void onError(String errorMessage);
    }

    public void fetchCountryDetail(String countryName, Callback callback) {
        Executors.newSingleThreadExecutor().execute(() -> {
            HttpURLConnection conn = null;
            BufferedReader reader = null;
            try {
                String encodedName = countryName.replace(" ", "%20");
                URL url = new URL("https://restcountries.com/v3.1/name/" + encodedName);
                conn = (HttpURLConnection) url.openConnection();
                conn.setRequestMethod("GET");
                conn.setConnectTimeout(10000);
                conn.setReadTimeout(10000);

                int responseCode = conn.getResponseCode();
                if (responseCode != HttpURLConnection.HTTP_OK) {
                    callback.onError("HTTP " + responseCode);
                    return;
                }

                reader = new BufferedReader(new InputStreamReader(conn.getInputStream()));
                StringBuilder response = new StringBuilder();
                String line;
                while ((line = reader.readLine()) != null) {
                    response.append(line);
                }

                CountryDetail country = parseCountryResponse(response.toString());
                callback.onSuccess(country);

            } catch (Exception e) {
                callback.onError("Network error: " + e.getMessage());
            } finally {
                if (reader != null) {
                    try { reader.close(); } catch (Exception ignored) {}
                }
                if (conn != null) {
                    conn.disconnect();
                }
            }
        });
    }

    private CountryDetail parseCountryResponse(String jsonResponse) throws Exception {
        JSONArray array = new JSONArray(jsonResponse);
        JSONObject obj = array.getJSONObject(0);

        String name = obj.getJSONObject("name").getString("common");
        String capital = obj.getJSONArray("capital").getString(0);
        long population = obj.getLong("population");
        double area = obj.getDouble("area");
        String region = obj.getString("region");
        String subregion = obj.getString("subregion");
        String flagUrl = obj.getJSONObject("flags").getString("png");

        return new CountryDetail(name, capital, population, area, region, subregion, flagUrl);
    }
}