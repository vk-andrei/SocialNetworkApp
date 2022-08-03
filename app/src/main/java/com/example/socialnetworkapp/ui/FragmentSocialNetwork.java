package com.example.socialnetworkapp.ui;

import android.annotation.SuppressLint;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.example.socialnetworkapp.R;


public class FragmentSocialNetwork extends Fragment {

    public static FragmentSocialNetwork newInstance() {
        //Bundle args = new Bundle();
        FragmentSocialNetwork fragment = new FragmentSocialNetwork();
        //fragment.setArguments(args);
        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_social_network, container, false);
        RecyclerView recyclerView = v.findViewById(R.id.recycler_view_lines);
        String[] data = getResources().getStringArray(R.array.titles_array);
        initRecyclerView(recyclerView, data);
        return v;
    }

    private void initRecyclerView(RecyclerView recyclerView, String[] data) {
        // Для начала надо найти элемент RecyclerView. Поскольку у нас все элементыспискаодинаковые по
        // размеру, стоит установить параметр recyclerView.setHasFixedSize(true);. Это ускорит
        // обработку.
        // Эта установка служит для повышения производительности системы
        recyclerView.setHasFixedSize(true);

        // Далее создаём менеджер, пусть это будет линейный менеджер.
        LinearLayoutManager layoutManager = new LinearLayoutManager(getContext());
        recyclerView.setLayoutManager(layoutManager);

        // Затем создаём адаптер и передаём ему данные в виде массива.
        SocialNetworkAdapter adapter = new SocialNetworkAdapter(data);
        recyclerView.setAdapter(adapter);

        // Установим слушателя
        adapter.setOnItemMyClickListener(new OnItemMyClickListener() {
            @SuppressLint("DefaultLocale")
            @Override
            public void onMyItemClick(View view, int position) {
                Toast.makeText(getContext(), String.format("%s - %d", ((TextView) view).getText(),
                        position), Toast.LENGTH_SHORT).show();
            }
        });
    }
}