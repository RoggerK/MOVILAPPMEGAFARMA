package idat.com.appfarmacia;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.ArrayList;
import java.util.List;

import idat.com.appfarmacia.model.Producto;

public class PrincipalSinActivity extends AppCompatActivity {

    private RecyclerView recyclerViewProductoCon;
    private CustomAdapterSinLogeo adaptadorProductoSin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_principal_sin);

        recyclerViewProductoCon = findViewById(R.id.recyclerSinLogear);
        recyclerViewProductoCon.setLayoutManager(new LinearLayoutManager(this));

        adaptadorProductoSin = new CustomAdapterSinLogeo(this, obtenerPaises());
        recyclerViewProductoCon.setAdapter(adaptadorProductoSin);
    }

    public List<Producto> obtenerPaises(){
        List<Producto> productos = new ArrayList<>();

        productos.add(new Producto("https://dcuk1cxrnzjkh.cloudfront.net/imagesproducto/421011X.jpg","Enterogermina Suspensión Oral","SANOFI","12.00"));
        productos.add(new Producto("https://dcuk1cxrnzjkh.cloudfront.net/imagesproducto/025891X.jpg","Panadol Antigripal NF Tableta","GLAXO SMITHKLINE OTC","2.06"));
        productos.add(new Producto("https://dcuk1cxrnzjkh.cloudfront.net/imagesproducto/108220X.jpg","Panadol 100mg/ml Solución oral gotas","GLAXO SMITHKLINE OTC","5.00"));
        productos.add(new Producto("https://dcuk1cxrnzjkh.cloudfront.net/imagesproducto/108024X.jpg","Panadol 160mg/5ml Jarabe","GLAXO SMITHKLINE OTC","10.00"));

        return productos;
    }
}