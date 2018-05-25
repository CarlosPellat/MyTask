package com.campe.mytask.activities;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.CheckBox;
import android.widget.TextView;

import com.campe.mytask.R;
import com.campe.mytask.models.Tarefa;
import com.campe.mytask.models.Task;
import com.campe.mytask.models.User;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by campe on 21/04/18.
 */

public class TarefasAdapter extends ArrayAdapter<Tarefa> {
    ArrayList<Tarefa> tarefas;
    public TarefasAdapter(@NonNull Context context, int resource, @NonNull Tarefa[] objects) {
        super(context, resource);
        tarefas = new ArrayList<>(Arrays.asList(objects));
    }

    @Nullable
    @Override
    public Tarefa getItem(int position) {
        return tarefas.get(position);
    }

    @Override
    public int getCount() {
        return tarefas.size();
    }

    @Override
    public void add(@Nullable Tarefa object) {
        tarefas.add(object);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        LayoutInflater inflater = (LayoutInflater) this.getContext()
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View itemTarefa = inflater.inflate(R.layout.item_tarefa,
                parent,
                false);

        Tarefa tarefa = getItem(position);
        TextView titulo = (TextView) itemTarefa.findViewById(R.id.titulo);
        titulo.setText(tarefa.getDescription());
        CheckBox status = (CheckBox) itemTarefa.findViewById(R.id.status);
        status.setChecked(tarefa.getDone());

        return itemTarefa;
    }


}