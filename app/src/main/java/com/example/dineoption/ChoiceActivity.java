package com.example.dineoption;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Toast;

public class ChoiceActivity extends AppCompatActivity {

    String[] favorite = {"Italian","Japanese", "Chinese",  "American", "Cuban", "Mexican", "Dominican"};
    String[] lastEaten = {"Italian","Japanese", "Chinese", "American", "Cuban", "Mexican", "Dominican"};
    String[] allergies = {"Yes","No"};

    String choicesFirst;

    String choiceSecond;

    String choiceThird;

    AutoCompleteTextView autoCompleteTextView;
    AutoCompleteTextView autoCompleteLastEaten;
    AutoCompleteTextView autoCompleteAllergies;

    ArrayAdapter<String> adapterFavorites;
    ArrayAdapter<String> adapterLastEaten;
    ArrayAdapter<String> adapterAllergies;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_choice);
        autoCompleteTextView = findViewById(R.id.favorite_List);
        adapterFavorites = new ArrayAdapter<String>(this,R.layout.dropdown_item, favorite);
        autoCompleteTextView.setAdapter(adapterFavorites);
        autoCompleteTextView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                String favorite = adapterView.getItemAtPosition(i).toString();
                Toast.makeText(ChoiceActivity.this, "favorite" + favorite, Toast.LENGTH_SHORT).show();
                choicesFirst ="Food places near me " + adapterView.getItemAtPosition(i).toString();
            }
        });

        autoCompleteLastEaten = findViewById(R.id.last_Eaten_List);
        adapterLastEaten = new ArrayAdapter<String>(this,R.layout.dropdown_item, lastEaten);
        autoCompleteLastEaten.setAdapter(adapterLastEaten);
        autoCompleteLastEaten.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                String lastEaten = adapterView.getItemAtPosition(i).toString();
                Toast.makeText(ChoiceActivity.this, "latseaten" + lastEaten, Toast.LENGTH_SHORT).show();
                choiceSecond = " No " + adapterView.getItemAtPosition(i).toString();
            }
        });

        autoCompleteAllergies = findViewById(R.id.allergies);
        adapterAllergies = new ArrayAdapter<String>(this,R.layout.dropdown_item, allergies);
        autoCompleteAllergies.setAdapter(adapterAllergies);
        autoCompleteAllergies.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                String allergies = adapterView.getItemAtPosition(i).toString();
                Toast.makeText(ChoiceActivity.this, "Allergies" + allergies, Toast.LENGTH_SHORT).show();
                choiceThird =" Allergies " + adapterView.getItemAtPosition(i).toString();
            }
        });
    }

    public void letsPick(View view) {

        //Toast.makeText(this, "You Chose " + choicesFirst+ choiceSecond + choiceThird, Toast.LENGTH_SHORT).show();
        Intent intent = new Intent(getApplicationContext(), SearchResultsActivity.class);
        intent.putExtra("Your Choices ", choicesFirst+ choiceSecond );
        startActivity(intent);
    }
}