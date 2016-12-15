package com.training.android.prelimexam;

import android.app.Dialog;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    final ArrayList<Task> tasks = new ArrayList();
    private Toolbar toolbar;
    private TabLayout tabLayout;
    private ViewPager viewPager;
    private FloatingActionButton fabAdd;
    Task temp = null;
    private EditText mEtTitle, mEtDesc, mEtTime, mEtDate;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        fabAdd = (FloatingActionButton) findViewById(R.id.fabAdd);

        toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        viewPager = (ViewPager) findViewById(R.id.viewpager);
        setupViewPager(viewPager);
        tabLayout = (TabLayout) findViewById(R.id.tabs);
        tabLayout.setupWithViewPager(viewPager);

        fabAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final Dialog addTask = new Dialog(MainActivity.this);
                addTask.setContentView(R.layout.activity_input);
                addTask.setTitle("Add A New Task");
                addTask.show();
                mEtTitle = (EditText) addTask.findViewById(R.id.etTitle);
                mEtDesc = (EditText) addTask.findViewById(R.id.etDesc);
                mEtTime = (EditText) addTask.findViewById(R.id.etTime);
                mEtDate = (EditText) addTask.findViewById(R.id.etDate);
                Button mBtnConfirm = (Button) addTask.findViewById(R.id.btnConfirm);


                mBtnConfirm.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        addTask.dismiss();
                        temp = new Task(mEtTitle.getText().toString(), mEtDesc.getText().toString()
                                , mEtTime.getText().toString(), mEtDate.getText().toString());
                        tasks.add(temp);
                        Bundle b = new Bundle();
                        b.putSerializable("arraylist", tasks);
                        TodoFragment todoFragment = new TodoFragment();
                        todoFragment.setArguments(b);
                        getSupportFragmentManager().beginTransaction()
                                .replace(R.id.viewpager, todoFragment)
                                .commit();

                    }
                });

            }
        });
    }

    private void setupViewPager(ViewPager viewPager) {
        ViewPagerAdapter adapter = new ViewPagerAdapter(getSupportFragmentManager());
        adapter.addFragment(new TodoFragment(), "To Do");
        adapter.addFragment(new CompletedFragment(), "Completed");
        viewPager.setAdapter(adapter);
    }

    class ViewPagerAdapter extends FragmentPagerAdapter {
        private final List<Fragment> mFragmentList = new ArrayList<>();
        private final List<String> mFragmentTitleList = new ArrayList<>();

        public ViewPagerAdapter(FragmentManager manager) {
            super(manager);
        }

        @Override
        public Fragment getItem(int position) {
            return mFragmentList.get(position);
        }

        @Override
        public int getCount() {
            return mFragmentList.size();
        }

        public void addFragment(Fragment fragment, String title) {
            mFragmentList.add(fragment);
            mFragmentTitleList.add(title);
        }

        @Override
        public CharSequence getPageTitle(int position) {
            return mFragmentTitleList.get(position);
        }
    }


}
