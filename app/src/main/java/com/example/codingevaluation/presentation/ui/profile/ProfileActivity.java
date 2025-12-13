package com.example.codingevaluation.presentation.ui.profile;

import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.example.codingevaluation.R;

public class ProfileActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);

        // Views
        ImageView ivProfile = findViewById(R.id.iv_profile_photo);
        TextView tvName = findViewById(R.id.tv_name);
        TextView tvTitle = findViewById(R.id.tv_title);
        TextView tvContact = findViewById(R.id.tv_contact);
        TextView tvBio = findViewById(R.id.tv_bio);


        tvName.setText(R.string.profile_name);
        tvTitle.setText(R.string.profile_title);
        tvContact.setText(R.string.profile_contact);


        String fullBio = getString(R.string.profile_summary) + "\n\n" +
                getString(R.string.profile_experience_title) + "\n" +
                getString(R.string.profile_job_title) + "\n" +
                getString(R.string.profile_company) + "\n" +
                getString(R.string.profile_job_period) + "\n" +
                getString(R.string.profile_job_details) + "\n\n" +
                getString(R.string.profile_education_title) + "\n" +
                getString(R.string.profile_degree) + "\n" +
                getString(R.string.profile_university) + "\n" +
                getString(R.string.profile_education_period) + "\n" +
                getString(R.string.profile_education_details);

        tvBio.setText(fullBio);

        Glide.with(this)
                .load(getString(R.string.profile_picture))
                .apply(RequestOptions.circleCropTransform())
                .placeholder(R.drawable.ic_launcher_foreground)
                .error(R.drawable.ic_launcher_background)
                .into(ivProfile);
    }
}