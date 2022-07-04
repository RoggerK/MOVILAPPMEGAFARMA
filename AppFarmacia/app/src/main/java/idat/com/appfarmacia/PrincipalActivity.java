package idat.com.appfarmacia;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class PrincipalActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_principal);


        Bundle parametros = this.getIntent().getExtras();
        if(parametros != null) {
            String usuario = parametros.getString("usuario");

            TextView tvUsuario = findViewById(R.id.tv_usuario);
            tvUsuario.setText(usuario);
        }
    }


}