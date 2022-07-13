package idat.com.appfarmacia;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class PrincipalActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_principal);

        Button btnSalir = findViewById(R.id.btnSalir);

        Bundle parametros = this.getIntent().getExtras();
        if(parametros != null) {
            String usuario = parametros.getString("usuario");

            TextView tvUsuario = findViewById(R.id.tv_usuario);
            tvUsuario.setText(usuario);
        }

        btnSalir.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                cerrarSesion();
            }
        });

    }

    private void cerrarSesion(){
        Intent intent = new Intent (this, MainActivity.class);
        Toast.makeText(this, "Se cerro Sesion",
                Toast.LENGTH_SHORT).show();

        startActivity(intent);
    }
}