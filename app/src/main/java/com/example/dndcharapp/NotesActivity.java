package com.example.dndcharapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.viewpager.widget.ViewPager;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.example.dndcharapp.model.Character;
import com.example.dndcharapp.model.Item;
import com.example.dndcharapp.model.Note;
import com.example.dndcharapp.model.Spell;

public class NotesActivity extends AppCompatActivity {
    private SectionStatePagerAdapter mSectionsStatePagerAdapter;
    private ViewPager mViewPager;
    private Character player;
    private DndViewModel dndViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_notes);

        Intent intent = getIntent();
        player = (Character) intent.getParcelableExtra("player");

        dndViewModel = new ViewModelProvider(this).get(DndViewModel.class);
        mSectionsStatePagerAdapter = new SectionStatePagerAdapter(getSupportFragmentManager());
        mViewPager = (ViewPager) findViewById(R.id.fragment_container);
        setupViewPager(mViewPager);
    }

    private void setupViewPager(ViewPager viewPager){
        SectionStatePagerAdapter adapter = new SectionStatePagerAdapter(getSupportFragmentManager());
        adapter.addFragment(new FragmentAllNotes(), "FragmentAllNotes");    //0
        adapter.addFragment(new FragmentAddNote(), "FragmentAddNote");      //1
        adapter.addFragment(new FragmentEditNote(), "FragmentEditNote");    //2
        adapter.addFragment(new FragmentAllItems(), "FragmentAllItems");    //3
        adapter.addFragment(new FragmentAddItem(), "FragmentAddItem");      //4
        adapter.addFragment(new FragmentEditItem(), "FragmentEditItem");    //5
        adapter.addFragment(new FragmentAllSpells(), "FragmentAllSpells");    //6
        adapter.addFragment(new FragmentAddSpell(), "FragmentAddSpell");      //7
        adapter.addFragment(new FragmentEditSpell(), "FragmentEditSpell");    //8
        viewPager.setAdapter(adapter);
    }

    public void setViewPager(int fragmentNumber){
        mViewPager.setCurrentItem(fragmentNumber);
    }

    public Character getPlayer(){
        return player;
    }

}