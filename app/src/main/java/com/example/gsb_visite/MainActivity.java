package com.example.gsb_visite;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.example.gsb_visite.databinding.ActivityMainBinding;

import java.io.Serializable;
import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity implements Serializable {

    private ActivityMainBinding binding;
    private Token token;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        View view = binding.getRoot();
        setContentView(view);

        binding.buttonConnexion.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Visiteur unVisiteur = new Visiteur( binding.editTextUsername.getText().toString(), binding.editTextPassword.getText().toString());

                GsbVisite services =
                        RetrofitClientInstance.getRetrofitInstance().create(GsbVisite.
                                class);
                Call<Token> call = services.getToken(unVisiteur);
                call.enqueue(new Callback<Token>() {
                    @Override
                    public void onResponse(Call<Token> call, Response<Token>
                            response) {

                        token = response.body();
                        Intent intentVisiteurActivity = new Intent(getApplicationContext(), VisiteurActivity.class);
                        intentVisiteurActivity.putExtra("username",  binding.editTextUsername.getText().toString());
                        intentVisiteurActivity.putExtra("token", token.getToken());
                        startActivity(intentVisiteurActivity);


                    }

                    @Override
                    public void onFailure(Call<Token> call, Throwable t) {
                        Toast.makeText(MainActivity.this, "Une erreur est survenue !",
                                Toast.LENGTH_SHORT).show();
                    }
                });


                }
            });


    }
}