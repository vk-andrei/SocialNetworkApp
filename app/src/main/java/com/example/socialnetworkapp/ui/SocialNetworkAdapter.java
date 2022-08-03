package com.example.socialnetworkapp.ui;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.socialnetworkapp.R;

public class SocialNetworkAdapter extends RecyclerView.Adapter<SocialNetworkAdapter.ViewHolder> {

    private String[] dataSource;
    private OnItemMyClickListener onItemMyClickListener; // слушатель будет устанавливаться извне

    // Сеттер слушателя нажатий
    public void setOnItemMyClickListener(OnItemMyClickListener onItemMyClickListener) {
        this.onItemMyClickListener = onItemMyClickListener;
    }

    // В конструкторе адаптера передаём источник данных. По нему будем строить список. Пока для
    // простоты это будет массив строк, но также можно передавать список со сложной структурой,
    // считываемый из базы данных.
    public SocialNetworkAdapter(String[] dataSource) {
        this.dataSource = dataSource;
    }

    // Создать новый элемент пользовательского интерфейса
    // Запускается менеджером
    @NonNull
    @Override
    public SocialNetworkAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        // Создаём новый элемент пользовательского интерфейса
        // Через Inflater
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.item, parent, false);
        // Здесь можно установить всякие параметры
        return new ViewHolder(v);
    }

    // Заменить данные в пользовательском интерфейсе
    // Вызывается менеджером
    @Override
    public void onBindViewHolder(@NonNull SocialNetworkAdapter.ViewHolder holder, int position) {
        // Получить элемент из источника данных (БД, интернет...)
        // Вынести на экран, используя ViewHolder
        holder.getTextView().setText(dataSource[position]);

    }

    // Вернуть размер данных, вызывается менеджером
    @Override
    public int getItemCount() {
        return dataSource.length;
    }

    // Этот класс хранит связь между данными и элементами View
    // Сложные данные могут потребовать несколько View на один пункт списка
    // Класс ViewHolder хранит в себе пользовательские элементы, которые передаются в конструктор,
    // чтобы позже их заполнить данными. Поскольку это RecyclerView, то есть он умеет
    // переиспользовать ViewHolder, беря уже неиспользуемые, то заполнение данными элементов
    // ViewHolder отделяют от создания ViewHolder. Создаём поле textView, реализуем геттер.
    // Присваиваем это поле в конструкторе.
    public class ViewHolder extends RecyclerView.ViewHolder {

        private TextView textView;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            textView = (TextView) itemView;

            // Обработчик нажатий на этом ViewHolder
            textView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    int position = getAdapterPosition();
                    if (onItemMyClickListener != null) {
                        onItemMyClickListener.onMyItemClick(v, position);
                    }
                }
            });
        }

        public TextView getTextView() {
            return textView;
        }
    }
}
