package com.example.dndcharapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import com.example.dndcharapp.model.Character;

public class NewCharacterActivity extends AppCompatActivity
        implements AdapterView.OnItemSelectedListener{

    public static final String EXTRA_REPLY = "com.example.android.wordlistsql.REPLY";

    private EditText newCharName;
    private EditText newCharRace;
    private EditText newCharSpeed;
    private EditText newCharAlignment;
    private EditText newCharBackground;
    private EditText newCharLvl;
    private EditText newCharXp;
    private String newCharClass = "Artificer";
    private EditText newCharStr;
    private EditText newCharDex;
    private EditText newCharCon;
    private EditText newCharInt;
    private EditText newCharWis;
    private EditText newCharCha;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_character);

        Spinner spinner = findViewById(R.id.addCharClass);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(
                this, R.array.classes,android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);
        spinner.setOnItemSelectedListener(this);

        newCharName = findViewById(R.id.addCharName);
        newCharRace = findViewById(R.id.addCharRace);
        newCharSpeed = findViewById(R.id.addCharSpeed);
        newCharAlignment = findViewById(R.id.addCharAligment);
        newCharBackground = findViewById(R.id.addCharBackground);
        newCharLvl = findViewById(R.id.addCharLevel);
        newCharXp = findViewById(R.id.addCharXp);
        newCharStr = findViewById(R.id.addCharStrength);
        newCharDex = findViewById(R.id.addCharDexterity);
        newCharCon = findViewById(R.id.addCharConstitution);
        newCharInt = findViewById(R.id.addCharIntelligence);
        newCharWis = findViewById(R.id.addCharWisdom);
        newCharCha = findViewById(R.id.addCharCharisma);

        final Button button = findViewById(R.id.button_save);
        button.setOnClickListener(view -> {
            Intent replyIntent = new Intent();
            if (TextUtils.isEmpty(newCharName.getText()) ||
                    TextUtils.isEmpty(newCharRace.getText()) ||
                    TextUtils.isEmpty(newCharSpeed.getText()) ||
                    TextUtils.isEmpty(newCharAlignment.getText()) ||
                    TextUtils.isEmpty(newCharBackground.getText()) ||
                    TextUtils.isEmpty(newCharLvl.getText()) ||
                    TextUtils.isEmpty(newCharXp.getText()) ||
                    TextUtils.isEmpty(newCharStr.getText()) ||
                    TextUtils.isEmpty(newCharDex.getText()) ||
                    TextUtils.isEmpty(newCharCon.getText()) ||
                    TextUtils.isEmpty(newCharInt.getText()) ||
                    TextUtils.isEmpty(newCharWis.getText()) ||
                    TextUtils.isEmpty(newCharCha.getText())) {
                setResult(RESULT_CANCELED, replyIntent);
            } else {
                int acrobatics = 0;
                if (((CheckBox)findViewById(R.id.cbAcrobatics)).isChecked()){
                    acrobatics = 1;
                }
                int animalhandling = 0;
                if (((CheckBox)findViewById(R.id.cbAnimalHandling)).isChecked()){
                    animalhandling = 1;
                }
                int arcana = 0;
                if (((CheckBox)findViewById(R.id.cbArcana)).isChecked()){
                    arcana = 1;
                }
                int athletics = 0;
                if (((CheckBox)findViewById(R.id.cbAthletics)).isChecked()){
                    athletics = 1;
                }
                int deception = 0;
                if (((CheckBox)findViewById(R.id.cbDeception)).isChecked()){
                    deception = 1;
                }
                int history = 0;
                if (((CheckBox)findViewById(R.id.cbHistory)).isChecked()){
                    history = 1;
                }
                int insight = 0;
                if (((CheckBox)findViewById(R.id.cbInsight)).isChecked()){
                    insight = 1;
                }
                int intimidation = 0;
                if (((CheckBox)findViewById(R.id.cbIntimidation)).isChecked()){
                    insight = 1;
                }
                int investigation = 0;
                if (((CheckBox)findViewById(R.id.cbInvestigation)).isChecked()){
                    investigation = 1;
                }
                int medicine = 0;
                if (((CheckBox)findViewById(R.id.cbMedicine)).isChecked()){
                    medicine = 1;
                }
                int nature = 0;
                if (((CheckBox)findViewById(R.id.cbNature)).isChecked()){
                    nature = 1;
                }
                int perception = 0;
                if (((CheckBox)findViewById(R.id.cbPerception)).isChecked()){
                    perception = 1;
                }
                int performance = 0;
                if (((CheckBox)findViewById(R.id.cbPerformance)).isChecked()){
                    performance = 1;
                }
                int persuasion = 0;
                if (((CheckBox)findViewById(R.id.cbPersuasion)).isChecked()){
                    persuasion = 1;
                }
                int religion = 0;
                if (((CheckBox)findViewById(R.id.cbReligion)).isChecked()){
                    religion = 1;
                }
                int sleightofhand = 0;
                if (((CheckBox)findViewById(R.id.cbSlightOfHand)).isChecked()){
                    sleightofhand = 1;
                }
                int stealth = 0;
                if (((CheckBox)findViewById(R.id.cbStealth)).isChecked()){
                    stealth = 1;
                }
                int survival = 0;
                if (((CheckBox)findViewById(R.id.cbSurvival)).isChecked()){
                    survival = 1;
                }
                int hitPoints = ClassInfo.valueOf(newCharClass).getHitPoints() +
                        checkModifier(Integer.parseInt(newCharCon.getText().toString()));
                int armorClass = 10 + checkModifier(Integer.parseInt(newCharDex.getText().toString()));
                int passiveWisdom = 10 + checkModifier(Integer.parseInt(newCharWis.getText().toString()));
                if(((CheckBox)findViewById(R.id.cbPerception)).isChecked()){
                    passiveWisdom += checkLvlProf(Integer.parseInt(newCharLvl.getText().toString()));
                }
                replyIntent.putExtra("character", new Character(
                        newCharName.getText().toString(),
                        newCharClass,
                        newCharRace.getText().toString(),
                        newCharAlignment.getText().toString(),
                        newCharBackground.getText().toString(),
                        Integer.parseInt(newCharLvl.getText().toString()),
                        Integer.parseInt(newCharXp.getText().toString()),
                        checkLvlProf(Integer.parseInt(newCharLvl.getText().toString())),
                        ClassInfo.valueOf(newCharClass).getClassStOne(),
                        ClassInfo.valueOf(newCharClass).getClassStTwo(),
                        ClassInfo.valueOf(newCharClass).getHitDice(),
                        hitPoints,
                        armorClass,
                        Integer.parseInt(newCharSpeed.getText().toString()),
                        Integer.parseInt(newCharStr.getText().toString()),
                        Integer.parseInt(newCharDex.getText().toString()),
                        Integer.parseInt(newCharCon.getText().toString()),
                        Integer.parseInt(newCharInt.getText().toString()),
                        Integer.parseInt(newCharWis.getText().toString()),
                        Integer.parseInt(newCharCha.getText().toString()),
                        acrobatics,
                        animalhandling,
                        arcana,
                        athletics,
                        deception,
                        history,
                        insight,
                        intimidation,
                        investigation,
                        medicine,
                        nature,
                        perception,
                        performance,
                        persuasion,
                        religion,
                        sleightofhand,
                        stealth,
                        survival,
                        passiveWisdom));
                setResult(RESULT_OK, replyIntent);
            }
            finish();
        });
    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        newCharClass = parent.getItemAtPosition(position).toString();
        Toast.makeText(parent.getContext(), newCharClass, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }

    public int checkLvlProf(int level){
        switch (level){
            case 1:
            case 2:
            case 3:
            case 4:
                return 2;
            case 5:
            case 6:
            case 7:
            case 8:
                return 3;
            case 9:
            case 10:
            case 11:
            case 12:
                return 4;
            case 13:
            case 14:
            case 15:
            case 16:
                return 5;
            case 17:
            case 18:
            case 19:
            case 20:
                return 6;
            default:
                return 0;
        }
    }

    public int checkModifier(int score){
        switch (score){
            case 1:
                return -5;
            case 2:
            case 3:
                return -4;
            case 4:
            case 5:
                return -3;
            case 6:
            case 7:
                return -2;
            case 8:
            case 9:
                return -1;
            case 10:
            case 11:
                return 0;
            case 12:
            case 13:
                return 1;
            case 14:
            case 15:
                return 2;
            case 16:
            case 17:
                return 3;
            case 18:
            case 19:
                return 4;
            case 20:
            case 21:
                return 5;
            case 22:
            case 23:
                return 6;
            case 24:
            case 25:
                return 7;
            case 26:
            case 27:
                return 8;
            case 28:
            case 29:
                return 9;
            case 30:
                return 10;
            default:
                return 0;
        }
    }
}
