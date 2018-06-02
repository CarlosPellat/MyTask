package com.campe.mytask.activities;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.campe.mytask.R;
import com.campe.mytask.models.User;
import com.campe.mytask.utils.DbOperations;

/**
 * Created by campe on 21/04/18.
 */

public class CadastroUsuarioActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastro_usuario);
    }

    public void cadastrarusuario(View view) {
        EditText newUsername = (EditText) findViewById(R.id.newusername);
        String username = newUsername.getText().toString();

        EditText newName = (EditText) findViewById(R.id.newname);
        String nameuser = newName.getText().toString();

        EditText newPassword = (EditText) findViewById(R.id.newpassword);
        String password = newPassword.getText().toString();

        DbOperations db = new DbOperations(this);
        db.saveUser(new User(username, nameuser, password), new DbOperations.DBOperationsCallBack() {
            @Override
            public void userSaverd(Boolean success) {
                CadastroUsuarioActivity.this.runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        Toast.makeText(CadastroUsuarioActivity.this, "USUARIO SALVO!", Toast.LENGTH_SHORT).show();
                    }
                });
            }

            @Override
            public void userExists(Boolean exists) {

            }
        });
    }
}
