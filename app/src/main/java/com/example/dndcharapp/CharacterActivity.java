package com.example.dndcharapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.dndcharapp.model.Character;

import java.util.Locale;

public class CharacterActivity extends AppCompatActivity {
    public static final int EDIT_CHARACTER_ACTIVITY_REQUEST_CODE = 1;
    private Character player;
    private DndViewModel dndViewModel;

    //basic info
    private TextView tvName;
    private TextView tvClass;
    private TextView tvRace;
    private TextView tvAlignment;
    private TextView tvBackground;
    private TextView tvSpeed;
    private TextView tvProficiency;
    private TextView tvHitDice;
    private TextView tvLevel;
    private TextView tvXp;
    private TextView tvHp;
    private TextView tvAc;
    //abilities
    private TextView tvStrScore;
    private TextView tvStrModifier;
    private TextView tvStrST;
    private TextView tvDexScore;
    private TextView tvDexModifier;
    private TextView tvDexST;
    private TextView tvConScore;
    private TextView tvConModifier;
    private TextView tvConST;
    private TextView tvIntScore;
    private TextView tvIntModifier;
    private TextView tvIntST;
    private TextView tvWisScore;
    private TextView tvWisModifier;
    private TextView tvWisST;
    private TextView tvChaScore;
    private TextView tvChaModifier;
    private TextView tvChaST;
    //skills
    private TextView tvCharAcrobaticsScore;
    private ImageView ivCharAcrobaticsProficiency;
    private TextView tvCharAnimalHandlingScore;
    private ImageView ivCharAnimalHandlingProficiency;
    private TextView tvCharArcanaScore;
    private ImageView ivCharArcanaProficiency;
    private TextView tvCharAthleticsScore;
    private ImageView ivCharAthleticsProficiency;
    private TextView tvCharDeceptionScore;
    private ImageView ivCharDeceptionProficiency;
    private TextView tvCharHistoryScore;
    private ImageView ivCharHistoryProficiency;
    private TextView tvCharInsightScore;
    private ImageView ivCharInsightProficiency;
    private TextView tvCharIntimidationScore;
    private ImageView ivCharIntimidationProficiency;
    private TextView tvCharInvestigationScore;
    private ImageView ivCharInvestigationProficiency;
    private TextView tvCharMedicineScore;
    private ImageView ivCharMedicineProficiency;
    private TextView tvCharNatureScore;
    private ImageView ivCharNatureProficiency;
    private TextView tvCharPerceptionScore;
    private ImageView ivCharPerceptionProficiency;
    private TextView tvCharPerformanceScore;
    private ImageView ivCharPerformanceProficiency;
    private TextView tvCharPersuasionScore;
    private ImageView ivCharPersuasionProficiency;
    private TextView tvCharReligionScore;
    private ImageView ivCharReligionProficiency;
    private TextView tvCharSleightOfHandScore;
    private ImageView ivCharSleightOfHandProficiency;
    private TextView tvCharStealthScore;
    private ImageView ivCharStealthProficiency;
    private TextView tvCharSurvivalScore;
    private ImageView ivCharSurvivalProficiency;
    private TextView tvPw;
    private Button btChangeSome;
    private Button btEditAll;
    private Button btNavNotes;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_character);

        //basic info
        tvName = (TextView)findViewById(R.id.tvCharName);
        tvClass = (TextView)findViewById(R.id.tvCharClass);
        tvRace = (TextView)findViewById(R.id.tvCharRace);
        tvAlignment = (TextView)findViewById(R.id.tvCharAlig);
        tvBackground = (TextView)findViewById(R.id.tvCharBackground);
        tvSpeed = (TextView)findViewById(R.id.tvCharSpeedScore);
        tvProficiency = (TextView)findViewById(R.id.tvCharProficiencyScore);
        tvHitDice = (TextView)findViewById(R.id.tvCharHitDiceScore);
        tvLevel = (TextView)findViewById(R.id.tvCharLvlScore);
        tvXp = (TextView)findViewById(R.id.tvCharXpScore);
        tvHp = (TextView)findViewById(R.id.tvCharHpScore);
        tvAc = (TextView)findViewById(R.id.tvCharAcScore);
        //abilities
        tvStrScore = (TextView)findViewById(R.id.tvCharStrengthScore);
        tvStrModifier = (TextView)findViewById(R.id.tvCharStrengthModifier);
        tvStrST = (TextView)findViewById(R.id.tvCharStrengthST);
        tvDexScore = (TextView)findViewById(R.id.tvCharDexterityScore);
        tvDexModifier = (TextView)findViewById(R.id.tvCharDexterityModifier);
        tvDexST = (TextView)findViewById(R.id.tvCharDexterityST);
        tvConScore = (TextView)findViewById(R.id.tvCharConstitutionScore);
        tvConModifier = (TextView)findViewById(R.id.tvCharConstitutionModifier);
        tvConST = (TextView)findViewById(R.id.tvCharConstitutionST);
        tvIntScore = (TextView)findViewById(R.id.tvCharIntelligenceScore);
        tvIntModifier = (TextView)findViewById(R.id.tvCharIntelligenceModifier);
        tvIntST = (TextView)findViewById(R.id.tvCharIntelligenceST);
        tvWisScore = (TextView)findViewById(R.id.tvCharWisdomScore);
        tvWisModifier = (TextView)findViewById(R.id.tvCharWisdomModifier);
        tvWisST = (TextView)findViewById(R.id.tvCharWisdomST);
        tvChaScore = (TextView)findViewById(R.id.tvCharCharismaScore);
        tvChaModifier = (TextView)findViewById(R.id.tvCharCharismaModifier);
        tvChaST = (TextView)findViewById(R.id.tvCharCharismaST);
        //skills
        tvCharAcrobaticsScore = (TextView)findViewById(R.id.tvCharAcrobaticsScore);
        ivCharAcrobaticsProficiency = (ImageView)findViewById(R.id.ivCharAcrobaticsProficiency);
        tvCharAnimalHandlingScore = (TextView)findViewById(R.id.tvCharAnimalHandlingScore);
        ivCharAnimalHandlingProficiency = (ImageView)findViewById(R.id.ivCharAnimalHandlingProficiency);
        tvCharArcanaScore = (TextView)findViewById(R.id.tvCharArcanaScore);
        ivCharArcanaProficiency = (ImageView)findViewById(R.id.ivCharArcanaProficiency);
        tvCharAthleticsScore = (TextView)findViewById(R.id.tvCharAthleticsScore);
        ivCharAthleticsProficiency = (ImageView)findViewById(R.id.ivCharAthleticsProficiency);
        tvCharDeceptionScore = (TextView)findViewById(R.id.tvCharDeceptionScore);
        ivCharDeceptionProficiency = (ImageView)findViewById(R.id.ivCharDeceptionProficiency);
        tvCharHistoryScore = (TextView)findViewById(R.id.tvCharHistoryScore);
        ivCharHistoryProficiency = (ImageView)findViewById(R.id.ivCharHistoryProficiency);
        tvCharInsightScore = (TextView)findViewById(R.id.tvCharInsightScore);
        ivCharInsightProficiency = (ImageView)findViewById(R.id.ivCharInsightProficiency);
        tvCharIntimidationScore = (TextView)findViewById(R.id.tvCharIntimidationScore);
        ivCharIntimidationProficiency = (ImageView)findViewById(R.id.ivCharIntimidationProficiency);
        tvCharInvestigationScore = (TextView)findViewById(R.id.tvCharInvestigationScore);
        ivCharInvestigationProficiency = (ImageView)findViewById(R.id.ivCharInvestigationProficiency);
        tvCharMedicineScore = (TextView)findViewById(R.id.tvCharMedicineScore);
        ivCharMedicineProficiency = (ImageView)findViewById(R.id.ivCharMedicineProficiency);
        tvCharNatureScore = (TextView)findViewById(R.id.tvCharNatureScore);
        ivCharNatureProficiency = (ImageView)findViewById(R.id.ivCharNatureProficiency);
        tvCharPerceptionScore = (TextView)findViewById(R.id.tvCharPerceptionScore);
        ivCharPerceptionProficiency = (ImageView)findViewById(R.id.ivCharPerceptionProficiency);
        tvCharPerformanceScore = (TextView)findViewById(R.id.tvCharPerformanceScore);
        ivCharPerformanceProficiency = (ImageView)findViewById(R.id.ivCharPerformanceProficiency);
        tvCharPersuasionScore = (TextView)findViewById(R.id.tvCharPersuasionScore);
        ivCharPersuasionProficiency = (ImageView)findViewById(R.id.ivCharPersuasionProficiency);
        tvCharReligionScore = (TextView)findViewById(R.id.tvCharReligionScore);
        ivCharReligionProficiency = (ImageView)findViewById(R.id.ivCharReligionProficiency);
        tvCharSleightOfHandScore = (TextView)findViewById(R.id.tvCharSleightOfHandScore);
        ivCharSleightOfHandProficiency = (ImageView)findViewById(R.id.ivCharSleightOfHandProficiency);
        tvCharStealthScore = (TextView)findViewById(R.id.tvCharStealthScore);
        ivCharStealthProficiency = (ImageView)findViewById(R.id.ivCharStealthProficiency);
        tvCharSurvivalScore = (TextView)findViewById(R.id.tvCharSurvivalScore);
        ivCharSurvivalProficiency = (ImageView)findViewById(R.id.ivCharSurvivalProficiency);
        tvPw = (TextView)findViewById(R.id.tvPwScore);

        btChangeSome = (Button)findViewById(R.id.btChangeSome);
        btEditAll = (Button)findViewById(R.id.btEditCharacter);

        Intent intent = getIntent();
        player = (Character) intent.getParcelableExtra("choice");
        updateCharFields();
        dndViewModel = new ViewModelProvider(this).get(DndViewModel.class);

        dndViewModel.getCharacter(player.getCId()).observe(this, new Observer<Character>() {
            @Override
            public void onChanged(Character character) {
                if(character == null){
                    Toast.makeText(CharacterActivity.this, "Empty character",
                            Toast.LENGTH_SHORT).show();
                }
                updateCharFields();
            }
        });
        btEditAll.setOnClickListener( v -> {
            Intent myIntent = new Intent(CharacterActivity.this, EditCharacterActivity.class);
            myIntent.putExtra("player", player);
            startActivityForResult(myIntent, EDIT_CHARACTER_ACTIVITY_REQUEST_CODE);
        });

        btNavNotes = (Button) findViewById(R.id.btNavNotes);
        btNavNotes.setOnClickListener(v -> {
            Intent noteIntent = new Intent(CharacterActivity.this, NotesActivity.class);
            noteIntent.putExtra("player", player);
            startActivity(noteIntent);
        });
    }

    public void buttonClick(View v) {
        player.setCLevel(Integer.parseInt(tvLevel.getText().toString()));
        player.setCXp(Integer.parseInt(tvXp.getText().toString()));
        player.setCHp(Integer.parseInt(tvHp.getText().toString()));
        player.setCAc(Integer.parseInt(tvAc.getText().toString()));
        player.setCProficiency(checkLvlProf(Integer.parseInt(tvLevel.getText().toString())));
        dndViewModel.updateCharacter(player);
        Toast.makeText(CharacterActivity.this, "Updated",
                Toast.LENGTH_SHORT).show();
    }

    public void updateCharFields(){
        if(player != null){
            //basic info
            tvName.setText(player.getCName());
            tvClass.setText(player.getCClass());
            tvRace.setText(player.getCRace());
            tvAlignment.setText(player.getCAlignment());
            tvBackground.setText(player.getCBackground());
            tvSpeed.setText(String.format(Locale.getDefault(),"%d",player.getCSpeed()));
            tvProficiency.setText(String.format(Locale.getDefault(),"%d",player.getCProficiency()));
            tvHitDice.setText(player.getCHitDice());
            tvLevel.setText(String.format(Locale.getDefault(),"%d",player.getCLevel()));
            tvXp.setText(String.format(Locale.getDefault(),"%d",player.getCXp()));
            tvHp.setText(String.format(Locale.getDefault(),"%d",player.getCHp()));
            tvAc.setText(String.format(Locale.getDefault(),"%d",player.getCAc()));
            //abilities
            String savingThrow1 = ClassInfo.valueOf(player.getCClass()).getClassStOne();
            String savingThrow2 = ClassInfo.valueOf(player.getCClass()).getClassStTwo();
            int lvlProf = checkLvlProf(player.getCLevel());
            int pStr = player.getCStrength();
            int pStrMod = checkModifier(pStr);
            int pDex = player.getCDexterity();
            int pDexMod = checkModifier(pDex);
            int pCon = player.getCConstitution();
            int pConMod = checkModifier(pCon);
            int pInt = player.getCIntelligence();
            int pIntMod = checkModifier(pInt);
            int pWis = player.getCWisdom();
            int pWisMod = checkModifier(pWis);
            int pCha = player.getCCharisma();
            int pChaMod = checkModifier(pCha);

            tvStrScore.setText(String.format(Locale.getDefault(),"%d",pStr));
            tvStrModifier.setText(String.format(Locale.getDefault(),"%d",pStrMod));
            if (savingThrow1.equals("Strength") || savingThrow2.equals("Strength")){
                tvStrST.setText(String.format(Locale.getDefault(),"%d",pStrMod + lvlProf));
            } else {
                tvStrST.setText(String.format(Locale.getDefault(),"%d",pStrMod));
            }

            tvDexScore.setText(String.format(Locale.getDefault(),"%d",pDex));
            tvDexModifier.setText(String.format(Locale.getDefault(),"%d",pDexMod));
            if (savingThrow1.equals("Dexterity") || savingThrow2.equals("Dexterity")){
                tvDexST.setText(String.format(Locale.getDefault(),"%d",pDexMod + lvlProf));
            } else {
                tvDexST.setText(String.format(Locale.getDefault(),"%d",pDexMod));
            }

            tvConScore.setText(String.format(Locale.getDefault(),"%d",pCon));
            tvConModifier.setText(String.format(Locale.getDefault(),"%d",pConMod));
            if (savingThrow1.equals("Constitution") || savingThrow2.equals("Constitution")){
                tvConST.setText(String.format(Locale.getDefault(),"%d",pConMod + lvlProf));
            } else {
                tvConST.setText(String.format(Locale.getDefault(),"%d",pConMod));
            }

            tvIntScore.setText(String.format(Locale.getDefault(),"%d",pInt));
            tvIntModifier.setText(String.format(Locale.getDefault(),"%d",pIntMod));
            if (savingThrow1.equals("Intelligence") || savingThrow2.equals("Intelligence")){
                tvIntST.setText(String.format(Locale.getDefault(),"%d",pIntMod + lvlProf));
            } else {
                tvIntST.setText(String.format(Locale.getDefault(),"%d",pIntMod));
            }

            tvWisScore.setText(String.format(Locale.getDefault(),"%d",pWis));
            tvWisModifier.setText(String.format(Locale.getDefault(),"%d",pWisMod));
            if (savingThrow1.equals("Wisdom") || savingThrow2.equals("Wisdom")){
                tvWisST.setText(String.format(Locale.getDefault(),"%d",pWisMod + lvlProf));
            } else {
                tvWisST.setText(String.format(Locale.getDefault(),"%d",pWisMod));
            }

            tvChaScore.setText(String.format(Locale.getDefault(),"%d",pCha));
            tvChaModifier.setText(String.format(Locale.getDefault(),"%d",pChaMod));
            if (savingThrow1.equals("Charisma") || savingThrow2.equals("Charisma")){
                tvChaST.setText(String.format(Locale.getDefault(),"%d",pChaMod + lvlProf));
            } else {
                tvChaST.setText(String.format(Locale.getDefault(),"%d",pChaMod));
            }

            //skills
            if (player.getCAcrobatics() == 1){
                tvCharAcrobaticsScore.setText(String.format(Locale.getDefault(),"%d",pDexMod + lvlProf));
                ivCharAcrobaticsProficiency.setBackgroundResource(R.drawable.ic_baseline_check_box_24);
            } else {
                tvCharAcrobaticsScore.setText(String.format(Locale.getDefault(),"%d",pDexMod));
                ivCharAcrobaticsProficiency.setBackgroundResource(R.drawable.ic_baseline_check_box_outline_blank_24);
            }
            if (player.getCAnimalHandling() == 1){
                tvCharAnimalHandlingScore.setText(String.format(Locale.getDefault(),"%d",pWisMod + lvlProf));
                ivCharAnimalHandlingProficiency.setBackgroundResource(R.drawable.ic_baseline_check_box_24);
            } else {
                tvCharAnimalHandlingScore.setText(String.format(Locale.getDefault(),"%d",pWisMod));
                ivCharAnimalHandlingProficiency.setBackgroundResource(R.drawable.ic_baseline_check_box_outline_blank_24);
            }
            if (player.getCArcana() == 1){
                tvCharArcanaScore.setText(String.format(Locale.getDefault(),"%d",pIntMod + lvlProf));
                ivCharArcanaProficiency.setBackgroundResource(R.drawable.ic_baseline_check_box_24);
            } else {
                tvCharArcanaScore.setText(String.format(Locale.getDefault(),"%d",pDexMod));
                ivCharArcanaProficiency.setBackgroundResource(R.drawable.ic_baseline_check_box_outline_blank_24);
            }
            if (player.getCAthletics() == 1){
                tvCharAthleticsScore.setText(String.format(Locale.getDefault(),"%d",pStrMod + lvlProf));
                ivCharAthleticsProficiency.setBackgroundResource(R.drawable.ic_baseline_check_box_24);
            } else {
                tvCharAthleticsScore.setText(String.format(Locale.getDefault(),"%d",pStrMod));
                ivCharAthleticsProficiency.setBackgroundResource(R.drawable.ic_baseline_check_box_outline_blank_24);
            }
            if (player.getCDeception() == 1){
                tvCharDeceptionScore.setText(String.format(Locale.getDefault(),"%d",pChaMod + lvlProf));
                ivCharDeceptionProficiency.setBackgroundResource(R.drawable.ic_baseline_check_box_24);
            } else {
                tvCharDeceptionScore.setText(String.format(Locale.getDefault(),"%d",pChaMod));
                ivCharDeceptionProficiency.setBackgroundResource(R.drawable.ic_baseline_check_box_outline_blank_24);
            }
            if (player.getCHistory() == 1){
                tvCharHistoryScore.setText(String.format(Locale.getDefault(),"%d",pIntMod + lvlProf));
                ivCharHistoryProficiency.setBackgroundResource(R.drawable.ic_baseline_check_box_24);
            } else {
                tvCharHistoryScore.setText(String.format(Locale.getDefault(),"%d",pIntMod));
                ivCharHistoryProficiency.setBackgroundResource(R.drawable.ic_baseline_check_box_outline_blank_24);
            }
            if (player.getCInsight() == 1){
                tvCharInsightScore.setText(String.format(Locale.getDefault(),"%d",pWisMod + lvlProf));
                ivCharInsightProficiency.setBackgroundResource(R.drawable.ic_baseline_check_box_24);
            } else {
                tvCharInsightScore.setText(String.format(Locale.getDefault(),"%d",pWisMod));
                ivCharInsightProficiency.setBackgroundResource(R.drawable.ic_baseline_check_box_outline_blank_24);
            }
            if (player.getCIntimidation() == 1){
                tvCharIntimidationScore.setText(String.format(Locale.getDefault(),"%d",pChaMod + lvlProf));
                ivCharIntimidationProficiency.setBackgroundResource(R.drawable.ic_baseline_check_box_24);
            } else {
                tvCharIntimidationScore.setText(String.format(Locale.getDefault(),"%d",pChaMod));
                ivCharIntimidationProficiency.setBackgroundResource(R.drawable.ic_baseline_check_box_outline_blank_24);
            }
            if (player.getCInvestigation() == 1){
                tvCharInvestigationScore.setText(String.format(Locale.getDefault(),"%d",pIntMod + lvlProf));
                ivCharInvestigationProficiency.setBackgroundResource(R.drawable.ic_baseline_check_box_24);
            } else {
                tvCharInvestigationScore.setText(String.format(Locale.getDefault(),"%d",pIntMod));
                ivCharInvestigationProficiency.setBackgroundResource(R.drawable.ic_baseline_check_box_outline_blank_24);
            }
            if (player.getCMedicine() == 1){
                tvCharMedicineScore.setText(String.format(Locale.getDefault(),"%d",pWisMod + lvlProf));
                ivCharMedicineProficiency.setBackgroundResource(R.drawable.ic_baseline_check_box_24);
            } else {
                tvCharMedicineScore.setText(String.format(Locale.getDefault(),"%d",pWisMod));
                ivCharMedicineProficiency.setBackgroundResource(R.drawable.ic_baseline_check_box_outline_blank_24);
            }
            if (player.getCNature() == 1){
                tvCharNatureScore.setText(String.format(Locale.getDefault(),"%d",pIntMod + lvlProf));
                ivCharNatureProficiency.setBackgroundResource(R.drawable.ic_baseline_check_box_24);
            } else {
                tvCharNatureScore.setText(String.format(Locale.getDefault(),"%d",pIntMod));
                ivCharNatureProficiency.setBackgroundResource(R.drawable.ic_baseline_check_box_outline_blank_24);
            }
            if (player.getCPerception() == 1){
                tvCharPerceptionScore.setText(String.format(Locale.getDefault(),"%d",pWisMod + lvlProf));
                ivCharPerceptionProficiency.setBackgroundResource(R.drawable.ic_baseline_check_box_24);
            } else {
                tvCharPerceptionScore.setText(String.format(Locale.getDefault(),"%d",pWisMod));
                ivCharPerceptionProficiency.setBackgroundResource(R.drawable.ic_baseline_check_box_outline_blank_24);
            }
            if (player.getCPerformance() == 1){
                tvCharPerformanceScore.setText(String.format(Locale.getDefault(),"%d",pChaMod + lvlProf));
                ivCharPerformanceProficiency.setBackgroundResource(R.drawable.ic_baseline_check_box_24);
            } else {
                tvCharPerformanceScore.setText(String.format(Locale.getDefault(),"%d",pChaMod));
                ivCharPerformanceProficiency.setBackgroundResource(R.drawable.ic_baseline_check_box_outline_blank_24);
            }
            if (player.getCPersuasion() == 1){
                tvCharPersuasionScore.setText(String.format(Locale.getDefault(),"%d",pChaMod + lvlProf));
                ivCharPersuasionProficiency.setBackgroundResource(R.drawable.ic_baseline_check_box_24);
            } else {
                tvCharPersuasionScore.setText(String.format(Locale.getDefault(),"%d",pChaMod));
                ivCharPersuasionProficiency.setBackgroundResource(R.drawable.ic_baseline_check_box_outline_blank_24);
            }
            if (player.getCReligion() == 1){
                tvCharReligionScore.setText(String.format(Locale.getDefault(),"%d",pIntMod + lvlProf));
                ivCharReligionProficiency.setBackgroundResource(R.drawable.ic_baseline_check_box_24);
            } else {
                tvCharReligionScore.setText(String.format(Locale.getDefault(),"%d",pIntMod));
                ivCharReligionProficiency.setBackgroundResource(R.drawable.ic_baseline_check_box_outline_blank_24);
            }
            if (player.getCSleightOfHand() == 1){
                tvCharSleightOfHandScore.setText(String.format(Locale.getDefault(),"%d",pDexMod + lvlProf));
                ivCharSleightOfHandProficiency.setBackgroundResource(R.drawable.ic_baseline_check_box_24);
            } else {
                tvCharSleightOfHandScore.setText(String.format(Locale.getDefault(),"%d",pDexMod));
                ivCharSleightOfHandProficiency.setBackgroundResource(R.drawable.ic_baseline_check_box_outline_blank_24);
            }
            if (player.getCStealth() == 1){
                tvCharStealthScore.setText(String.format(Locale.getDefault(),"%d",pDexMod + lvlProf));
                ivCharStealthProficiency.setBackgroundResource(R.drawable.ic_baseline_check_box_24);
            } else {
                tvCharStealthScore.setText(String.format(Locale.getDefault(),"%d",pDexMod));
                ivCharStealthProficiency.setBackgroundResource(R.drawable.ic_baseline_check_box_outline_blank_24);
            }
            if (player.getCSurvival() == 1){
                tvCharSurvivalScore.setText(String.format(Locale.getDefault(),"%d",pWisMod + lvlProf));
                ivCharSurvivalProficiency.setBackgroundResource(R.drawable.ic_baseline_check_box_24);
            } else {
                tvCharSurvivalScore.setText(String.format(Locale.getDefault(),"%d", pWisMod));
                ivCharSurvivalProficiency.setBackgroundResource(R.drawable.ic_baseline_check_box_outline_blank_24);
            }
            tvPw.setText(String.format(Locale.getDefault(),"%d", player.getCPw()));
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

    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == EDIT_CHARACTER_ACTIVITY_REQUEST_CODE && resultCode == RESULT_OK) {
            Bundle extraa = data.getExtras();
            player = (Character) extraa.getParcelable("character");
            dndViewModel.updateCharacter(player);
        } else {
            Toast.makeText(getApplicationContext(), R.string.character_not_edited,
                    Toast.LENGTH_LONG).show();
        }
    }
}