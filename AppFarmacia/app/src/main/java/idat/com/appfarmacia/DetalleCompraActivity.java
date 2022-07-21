package idat.com.appfarmacia;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import java.util.ArrayList;
import java.util.List;

import idat.com.appfarmacia.model.ProductoPyP;

public class DetalleCompraActivity extends AppCompatActivity {

    private RecyclerView recyclerViewProductoPyP;
    private CustomAdapterProductoPP adaptadorProductoPyP;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detalle_compra);

        recyclerViewProductoPyP = findViewById(R.id.recyclerDetails);
        recyclerViewProductoPyP.setLayoutManager(new LinearLayoutManager(this));

        adaptadorProductoPyP = new CustomAdapterProductoPP(obtenerProductos());
        recyclerViewProductoPyP.setAdapter(adaptadorProductoPyP);


        Button btnSiguiente = findViewById(R.id.btnSiguiente);
        btnSiguiente.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Siguiente();
            }
        });
    }

    private void Siguiente(){
        Intent intent = new Intent (this, SolicitudActivity.class);
        startActivity(intent);
    }

    public List<ProductoPyP> obtenerProductos(){
        List<ProductoPyP> productoPyPList = new ArrayList<>();
        productoPyPList.add(new ProductoPyP("Paracetamol 1000 gr caja","50.50","10.10"));
        productoPyPList.add(new ProductoPyP("Azitromicina 1000 gr caja","50.50","10.10"));
        productoPyPList.add(new ProductoPyP("Penicilina 1000 gr caja","50.50","10.10"));
        productoPyPList.add(new ProductoPyP("Panadol 1000 gr caja","50.50","10.10"));
        productoPyPList.add(new ProductoPyP("Anterogerminlina 1000 gr caja","50.50","10.10"));
        productoPyPList.add(new ProductoPyP("Cartuchera 1000 gr caja","50.50","10.10"));
        productoPyPList.add(new ProductoPyP("Plumon 1000 gr caja","50.50","10.10"));

        return productoPyPList;
    }
}