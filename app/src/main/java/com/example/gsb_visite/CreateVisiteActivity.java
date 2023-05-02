package com.example.gsb_visite;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;

import com.example.gsb_visite.databinding.ActivityCreateVisiteBinding;

import java.io.Serializable;

public class CreateVisiteActivity extends AppCompatActivity implements Serializable {
    private ActivityCreateVisiteBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityCreateVisiteBinding.inflate(getLayoutInflater());
        View view = binding.getRoot();
        setContentView(view);

        binding.btnValider.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Visite uneVisite = new Visite();
            }
        });
    }
}