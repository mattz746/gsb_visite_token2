package com.example.gsb_visite;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.example.gsb_visite.databinding.ActivityVisiteurBinding;

import java.io.Serializable;
import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class VisiteurActivity extends AppCompatActivity {
    private ActivityVisiteurBinding binding;
    private String username, token;
    private Visiteurs visiteurs;
    private Visiteur visiteur;

    private ArrayList<Praticien> dataPraticiens;
    private RecyclerViewAdapter myAdapterPraticien;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_visiteur);
        binding = ActivityVisiteurBinding.inflate(getLayoutInflater());
        View view = binding.getRoot();
        setContentView(view);

        Intent myIntent = getIntent();
        username = (String)myIntent.getSerializableExtra("username");
        token = (String)myIntent.getSerializableExtra("token");
        GsbVisite service =
                RetrofitClientInstance.getRetrofitInstance().create(GsbVisite.
                        class);
        Call<Visiteurs> call = service.getVisiteurs();
        call.enqueue(new Callback<Visiteurs>() {
            @Override
            public void onResponse(Call<Visiteurs> call, Response<Visiteurs>
                    response) {
                visiteurs = response.body();
                for (Visiteur unVisiteur : visiteurs.getVisiteurs()) {
                    if (unVisiteur.getUsername().equals(username)) {
                        visiteur = unVisiteur;
                    }
                }
                binding.textViewVisiteurNom.setText(visiteur.getNom());
                binding.textViewVisiteurPrenom.setText(visiteur.getPrenom());
                binding.txtMatricule.setText(visiteur.getMatricule());

                for (String unPraticienStr : visiteur.getPraticiensStr()) {
                    int chaine = unPraticienStr.lastIndexOf("/") + 1;
                    String id = unPraticienStr.substring(chaine);

                    Call<Praticien> praticienCall = service.getPraticiens("Bearer " + token, id);
                    praticienCall.enqueue(new Callback<Praticien>() {
                        @Override
                        public void onResponse(Call<Praticien> call, Response<Praticien> response) {
                            Praticien unPraticien = response.body();
                            dataPraticiens.add(unPraticien);
                            myAdapterPraticien = new RecyclerViewAdapter(dataPraticiens);
                            binding.recyclerViewPraticiens.setAdapter(myAdapterPraticien);

                        }

                        @Override
                        public void onFailure(Call<Praticien> call, Throwable t) {

                        }
                    });
                }

                binding.recyclerViewPraticiens.setHasFixedSize(true);
                LinearLayoutManager layoutManager = new LinearLayoutManager(getApplicationContext(), LinearLayoutManager.VERTICAL, false);
                binding.recyclerViewPraticiens.setLayoutManager(layoutManager);
                binding.recyclerViewPraticiens.setFocusable(false);
                binding.recyclerViewPraticiens.addOnItemTouchListener(new RecyclerTouchListener(getApplicationContext(), binding.recyclerViewPraticiens, new RecyclerViewClickListener() {
                    @Override
                    public void onClick(View view, int position) {
                        Intent myIntent = new Intent(getApplicationContext(), PraticienActivity.class);
                        myIntent.putExtra("praticien", dataPraticiens.get(position));
                        myIntent.putExtra("token", token);
                        myIntent.putExtra("username", username);
                        startActivity(myIntent);
                    }
                }));


            }

            @Override
            public void onFailure(Call<Visiteurs> call, Throwable t) {
                Toast.makeText(VisiteurActivity.this, "Une erreur est survenue !",
                        Toast.LENGTH_SHORT).show();
            }
        });

    }
}