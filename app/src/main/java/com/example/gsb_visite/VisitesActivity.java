package com.example.gsb_visite;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.gsb_visite.databinding.ActivityVisitesBinding;

import java.io.Serializable;

public class VisitesActivity extends AppCompatActivity implements Serializable {
    private ActivityVisitesBinding binding;
    private String username, token;
    private Visite visite;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityVisitesBinding.inflate(getLayoutInflater());
        View view = binding.getRoot();
        setContentView(view);

        Intent myIntent = getIntent();
        visite = (Visite)myIntent.getSerializableExtra("visite");
        username = (String)myIntent.getSerializableExtra("username");
        token = (String)myIntent.getSerializableExtra("token");

        binding.textViewDateVisite.setText(visite.getDateVisite().toString());
        binding.textViewCommentaireVisite.setText(visite.getCommentaire());
    }
}