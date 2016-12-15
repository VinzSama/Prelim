package com.training.android.prelimexam;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class TodoFragment extends Fragment {
    private ListView lv = null;
    private ArrayAdapter<Task> mAdapter;
    ArrayList<Task> tasks = null;

    public TodoFragment() {

    }


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_todo, container, false);
        Bundle bundle = this.getArguments();

        if (bundle != null)
            Toast.makeText(getContext(), "asdasd", Toast.LENGTH_SHORT).show();
        if (tasks != null) {
            tasks = (ArrayList<Task>) bundle.getSerializable("arraylist");
            mAdapter = new Adapter(getContext(), R.layout.list_task, tasks);
            lv.setAdapter(mAdapter);

        }
        else {
            Toast.makeText(getContext(), "List is empty", Toast.LENGTH_SHORT).show();
        }

        return view;
    }


    @Override
    public void onAttach(Context context) {
        super.onAttach(context);

    }

    @Override
    public void onDetach() {
        super.onDetach();

    }


}
