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

public class EditCharacterActivity extends AppCompatActivity
        implements AdapterView.OnItemSelectedListener{
    public static final String EXTRA_REPLY = "com.example.android.wordlistsql.REPLY";
    private Character player;
    private DndViewModel dndViewModel;

    private EditText newCharName;
    private EditText newCharRace;
    private EditText newCharSpeed;
    private EditText newCharAlignment;
    private EditText newCharBackground;
    private EditText newCharLvl;
    private EditText newCharXp;
    private EditText newCharHp;
    private EditText newCharAc;
    private String newCharClass;
    private EditText newCharStr;
    private EditText newCharDex;
    private EditText newCharCon;
    private EditText newCharInt;
    private EditText newCharWis;
    private EditText newCharCha;
    private CheckBox cbAcrobatics;
    private CheckBox cbAnimalHandling;
    private CheckBox cbArcana;
    private CheckBox cbAthletics;
    private CheckBox cbDeception;
    private CheckBox cbHistory;
    private CheckBox cbInsight;
    private CheckBox cbIntimidation;
    private CheckBox cbInvestigation;
    private CheckBox cbMedicine;
    private CheckBox cbNature;
    private CheckBox cbPerception;
    private CheckBox cbPerformance;
    private CheckBox cbPersuasion;
    private CheckBox cbReligion;
    private CheckBox cbSleightOfHand;
    private CheckBox cbStealth;
    private CheckBox cbSurvival;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_character);

        Intent intent = getIntent();
        player = (Character) intent.getParcelableExtra("player");

        Spinner spinner = findViewById(R.id.addCharClass);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(
                this, R.array.classes,android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);
        spinner.setOnItemSelectedListener(this);

        newCharName = findViewById(R.id.addCharName);
        newCharName.setText(player.getCName());
        newCharRace = findViewById(R.id.addCharRace);
        newCharRace.setText(player.getCRace());
        newCharSpeed = findViewById(R.id.addCharSpeed);
        newCharSpeed.setText(String.valueOf(player.getCSpeed()));
        newCharAlignment = findViewById(R.id.addCharAligment);
        newCharAlignment.setText(player.getCAlignment());
        newCharBackground = findViewById(R.id.addCharBackground);
        newCharBackground.setText(player.getCBackground());
        newCharLvl = findViewById(R.id.addCharLevel);
        newCharLvl.setText(String.valueOf(player.getCLevel()));
        newCharXp = findViewById(R.id.addCharXp);
        newCharXp.setText(String.valueOf(player.getCXp()));
        newCharHp = findViewById(R.id.addCharHp);
        newCharHp.setText(String.valueOf(player.getCHp()));
        newCharAc = findViewById(R.id.addCharAc);
        newCharAc.setText(String.valueOf(player.getCAc()));
        newCharStr = findViewById(R.id.addCharStrength);
        newCharStr.setText(String.valueOf(player.getCStrength()));
        newCharDex = findViewById(R.id.addCharDexterity);
        newCharDex.setText(String.valueOf(player.getCDexterity()));
        newCharCon = findViewById(R.id.addCharConstitution);
        newCharCon.setText(String.valueOf(player.getCConstitution()));
        newCharInt = findViewById(R.id.addCharIntelligence);
        newCharInt.setText(String.valueOf(player.getCIntelligence()));
        newCharWis = findViewById(R.id.addCharWisdom);
        newCharWis.setText(String.valueOf(player.getCWisdom()));
        newCharCha = findViewById(R.id.addCharCharisma);
        newCharCha.setText(String.valueOf(player.getCCharisma()));

        cbAcrobatics = findViewById(R.id.cbAcrobatics);
        if (player.getCAcrobatics() == 1){
            cbAcrobatics.setChecked(true);
        }
        cbAnimalHandling = findViewById(R.id.cbAnimalHandling);
        if (player.getCAnimalHandling() == 1){
            cbAnimalHandling.setChecked(true);
        }
        cbArcana = findViewById(R.id.cbArcana);
        if (player.getCArcana() == 1){
            cbArcana.setChecked(true);
        }
        cbAthletics = findViewById(R.id.cbAthletics);
        if (player.getCAthletics() == 1){
            cbAthletics.setChecked(true);
        }
        cbDeception = findViewById(R.id.cbDeception);
        if (player.getCDeception() == 1){
            cbDeception.setChecked(true);
        }
        cbHistory = findViewById(R.id.cbHistory);
        if (player.getCHistory() == 1){
            cbHistory.setChecked(true);
        }
        cbInsight = findViewById(R.id.cbInsight);
        if (player.getCInsight() == 1){
            cbInsight.setChecked(true);
        }
        cbIntimidation = findViewById(R.id.cbIntimidation);
        if (player.getCIntimidation() == 1){
            cbIntimidation.setChecked(true);
        }
        cbInvestigation = findViewById(R.id.cbInvestigation);
        if (player.getCInvestigation() == 1){
            cbInvestigation.setChecked(true);
        }
        cbMedicine = findViewById(R.id.cbMedicine);
        if (player.getCMedicine() == 1){
            cbMedicine.setChecked(true);
        }
        cbNature = findViewById(R.id.cbNature);
        if (player.getCNature() == 1){
            cbNature.setChecked(true);
        }
        cbPerception = findViewById(R.id.cbPerception);
        if (player.getCPerception() == 1){
            cbPerception.setChecked(true);
        }
        cbPerformance = findViewById(R.id.cbPerformance);
        if (player.getCPerformance() == 1){
            cbPerformance.setChecked(true);
        }
        cbPersuasion = findViewById(R.id.cbPersuasion);
        if (player.getCPersuasion() == 1){
            cbPersuasion.setChecked(true);
        }
        cbReligion = findViewById(R.id.cbReligion);
        if (player.getCReligion() == 1){
            cbReligion.setChecked(true);
        }
        cbSleightOfHand = findViewById(R.id.cbSlightOfHand);
        if (player.getCSleightOfHand() == 1){
            cbSleightOfHand.setChecked(true);
        }
        cbStealth = findViewById(R.id.cbStealth);
        if (player.getCStealth() == 1){
            cbStealth.setChecked(true);
        }
        cbSurvival = findViewById(R.id.cbSurvival);
        if (player.getCSurvival() == 1){
            cbSurvival.setChecked(true);
        }

        final Button button = findViewById(R.id.button_save);
        button.setOnClickListener(view -> {
            Intent replyIntent = new Intent();
            if (player == null) {
                setResult(RESULT_CANCELED, replyIntent);
            } else {
                player.setCName(newCharName.getText().toString());
                player.setCClass(newCharClass);
                player.setCRace(newCharRace.getText().toString());
                player.setCRace(newCharAlignment.getText().toString());
                player.setCBackground(newCharBackground.getText().toString());
                player.setCLevel(Integer.parseInt(newCharLvl.getText().toString()));
                player.setCSavingThrowOne(ClassInfo.valueOf(player.getCClass()).getClassStOne());
                player.setCSavingThrowTwo(ClassInfo.valueOf(player.getCClass()).getClassStTwo());
                player.setCHitDice(ClassInfo.valueOf(player.getCClass()).getHitDice());
                if(player.getCLevel() == 1){
                    player.setCHp(ClassInfo.valueOf(player.getCClass()).getHitPoints());
                }
                player.setCXp(Integer.parseInt(newCharXp.getText().toString()));
                player.setCProficiency(checkLvlProf(player.getCLevel()));
                player.setCHp(Integer.parseInt(newCharHp.getText().toString()));
                player.setCAc(Integer.parseInt(newCharAc.getText().toString()));
                player.setCSpeed(Integer.parseInt(newCharSpeed.getText().toString()));
                player.setCStrength(Integer.parseInt(newCharStr.getText().toString()));
                player.setCDexterity(Integer.parseInt(newCharDex.getText().toString()));
                player.setCConstitution(Integer.parseInt(newCharCon.getText().toString()));
                player.setCIntelligence(Integer.parseInt(newCharInt.getText().toString()));
                player.setCWisdom(Integer.parseInt(newCharWis.getText().toString()));
                player.setCCharisma(Integer.parseInt(newCharCha.getText().toString()));
                if(cbAcrobatics.isChecked()){
                    player.setCAcrobatics(1);
                } else {
                    player.setCAcrobatics(0);
                }
                if(cbAnimalHandling.isChecked()){
                    player.setCAnimalHandling(1);
                } else {
                    player.setCAnimalHandling(0);
                }
                if(cbArcana.isChecked()){
                    player.setCArcana(1);
                } else {
                    player.setCArcana(0);
                }
                if(cbAthletics.isChecked()){
                    player.setCAthletics(1);
                } else {
                    player.setCAthletics(0);
                }
                if(cbDeception.isChecked()){
                    player.setCDeception(1);
                } else {
                    player.setCDeception(0);
                }
                if(cbHistory.isChecked()){
                    player.setCHistory(1);
                } else {
                    player.setCHistory(0);
                }
                if(cbInsight.isChecked()){
                    player.setCInsight(1);
                } else {
                    player.setCInsight(0);
                }
                if(cbIntimidation.isChecked()){
                    player.setCIntimidation(1);
                } else {
                    player.setCIntimidation(0);
                }
                if(cbInvestigation.isChecked()){
                    player.setCInvestigation(1);
                } else {
                    player.setCInvestigation(0);
                }
                if(cbMedicine.isChecked()){
                    player.setCMedicine(1);
                } else {
                    player.setCMedicine(0);
                }
                if(cbNature.isChecked()){
                    player.setCNature(1);
                } else {
                    player.setCNature(0);
                }
                if(cbPerception.isChecked()){
                    player.setCPerception(1);
                } else {
                    player.setCPerception(0);
                }
                if(cbPerformance.isChecked()){
                    player.setCPerformance(1);
                } else {
                    player.setCPerformance(0);
                }
                if(cbPersuasion.isChecked()){
                    player.setCPersuasion(1);
                } else {
                    player.setCPersuasion(0);
                }
                if(cbReligion.isChecked()){
                    player.setCReligion(1);
                } else {
                    player.setCReligion(0);
                }
                if(cbSleightOfHand.isChecked()){
                    player.setCSleightOfHand(1);
                } else {
                    player.setCSleightOfHand(0);
                }
                if(cbStealth.isChecked()){
                    player.setCStealth(1);
                } else {
                    player.setCStealth(0);
                }
                if(cbSurvival.isChecked()){
                    player.setCSurvival(1);
                } else {
                    player.setCSurvival(0);
                }
                int passiveWisdom = 10 + checkModifier(player.getCPw());
                if(cbPerception.isChecked()){
                    passiveWisdom += checkLvlProf(Integer.parseInt(newCharLvl.getText().toString()));
                }
                player.setCPw(passiveWisdom);
                replyIntent.putExtra("character", player);
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
