package com.campe.mytask.activities;

import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import com.campe.mytask.R;
import com.campe.mytask.daos.TaskDao;
import com.campe.mytask.models.Task;
import com.campe.mytask.models.User;
import com.campe.mytask.utils.AppDatabase;
import com.campe.mytask.utils.DbOperations;

import java.util.List;

/**
 * Created by campe on 21/04/18.
 */

public class ListaTarefasActivity extends AppCompatActivity {

    ListView tarefasListView;
    TarefasAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista_tarefas);
        tarefasListView = (ListView) findViewById(R.id.lista_tarefas);

        DbOperations op = new DbOperations(this.getApplicationContext());
        op.getAllTasks(new DbOperations.DBOperationsTaskCallBack() {
            @Override
            public void taskSaved(Boolean success) {}

            @Override
            public void getAllTasks(final List<Task> listaTarefas) {
                ListaTarefasActivity.this.runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        adapter = new TarefasAdapter(ListaTarefasActivity.this, 1, listaTarefas);
                        tarefasListView.setAdapter(adapter);
                    }
                });
            }
        });



    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_tarefas, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if(item.getItemId() == R.id.adicionar_tarefa) {
            criarDialogoTarefa();
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    public void criarDialogoTarefa() {
        AlertDialog.Builder alert = new AlertDialog.Builder(this);
        alert.setMessage("Coloque a descrição da tarefa");
        alert.setTitle("Criar tarefa");
        alert.setCancelable(true);

        final EditText edittext = new EditText(getApplicationContext());
        alert.setView(edittext);

        alert.setPositiveButton("Salvar", new DialogInterface.OnClickListener(){
            public void onClick(DialogInterface dialog, int whichButton) {
                String taskTitle = edittext.getText().toString();
                DbOperations db = new DbOperations(getApplicationContext());
                final Task task = new Task(taskTitle);
                db.saveTask(new Task(taskTitle), new DbOperations.DBOperationsTaskCallBack() {
                    @Override
                    public void taskSaved(Boolean success) {
                        ListaTarefasActivity.this.runOnUiThread(new Runnable() {
                            @Override
                            public void run() {
                                adapter.add(task);
                            }
                        });
                    }

                    @Override
                    public void getAllTasks(List<Task> listaTarefas) {}
                });

            }
        });

        alert.setNegativeButton("Cancelar", null);

        alert.show();
    }

}