package idat.com.appfarmacia;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import idat.com.appfarmacia.model.Producto;

public class PrincipalActivity extends AppCompatActivity {

    private RecyclerView recyclerViewProductoSin;
    private CustomAdapterLogeo adaptadorProductoLog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_principal);

        Button btnSalir = findViewById(R.id.btnSalir);

        recyclerViewProductoSin = findViewById(R.id.recyclerLogear);
        recyclerViewProductoSin.setLayoutManager(new LinearLayoutManager(this));


        Bundle parametros = this.getIntent().getExtras();
        if(parametros != null) {
            String usuario = parametros.getString("usuario");

            TextView tvUsuario = findViewById(R.id.tv_usuario);
            tvUsuario.setText(usuario);
        }

        adaptadorProductoLog = new CustomAdapterLogeo(this, obtenerPaises());
        recyclerViewProductoSin.setAdapter(adaptadorProductoLog);

        btnSalir.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                cerrarSesion();
            }
        });

    }

    public List<Producto> obtenerPaises(){
        List<Producto> productos = new ArrayList<>();

        productos.add(new Producto("https://dcuk1cxrnzjkh.cloudfront.net/imagesproducto/421011X.jpg","Enterogermina Suspensión Oral","SANOFI","12.00"));
        productos.add(new Producto("https://dcuk1cxrnzjkh.cloudfront.net/imagesproducto/025891X.jpg","Panadol Antigripal NF Tableta","GLAXO SMITHKLINE OTC","2.06"));
        productos.add(new Producto("https://dcuk1cxrnzjkh.cloudfront.net/imagesproducto/108220X.jpg","Panadol 100mg/ml Solución oral gotas","GLAXO SMITHKLINE OTC","5.00"));
        productos.add(new Producto("https://dcuk1cxrnzjkh.cloudfront.net/imagesproducto/108024X.jpg","Panadol 160mg/5ml Jarabe","GLAXO SMITHKLINE OTC","10.00"));

        return productos;
    }

    private void cerrarSesion(){
        Intent intent = new Intent (this, MainActivity.class);
        Toast.makeText(this, "Se cerro Sesion",
                Toast.LENGTH_SHORT).show();

        startActivity(intent);
    }
}