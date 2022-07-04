package idat.com.appfarmacia;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;

public class MainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button btRegis = findViewById(R.id.btn_Registrar);
        Button btIniciar = findViewById(R.id.btnIniciar);
        btIniciar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ValidarUsuario();
            }
        });
        btRegis.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
               Registrar();
            }
        });

    }

    private void Registrar(){
        Intent intent = new Intent (this, RegistrarActivity.class);
        startActivity(intent);
    }

    private void ValidarUsuario() {

        EditText etUsuario = findViewById(R.id.lblUsu);
        EditText etClave = findViewById(R.id.lblContra);

        String textUsuario = etUsuario.getText().toString();
        String textClave = etClave.getText().toString();

        if(textUsuario.isEmpty()) {
            Toast.makeText(this, "El campor usuario esta vacio",
                    Toast.LENGTH_SHORT).show();
        } else if(textClave.isEmpty()) {
            Toast.makeText(this, "El campo contraseña esta vacio",
                    Toast.LENGTH_SHORT).show();
        } else {
            if(textUsuario.equals("caycho") && textClave.equals("123456")){
                Intent intent = new Intent(this,  PrincipalActivity.class);
                intent.putExtra("usuario",textUsuario);

                startActivity(intent);
            } else if(textUsuario.equals("rogger") && textClave.equals("789456")){
                Intent intent = new Intent(this,  PrincipalActivity.class);
                intent.putExtra("usuario",textUsuario);

                startActivity(intent);
            } else {
                Toast.makeText(this, "El usuario no esta registrado",
                        Toast.LENGTH_SHORT).show();
            }
        }

    }

}
