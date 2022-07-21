package idat.com.appfarmacia;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

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

        TextView tv_totalPrecio = findViewById(R.id.txtPrecioTotal);
        Button btnSiguiente = findViewById(R.id.btnSiguiente);

        recyclerViewProductoPyP = findViewById(R.id.recyclerDetails);
        recyclerViewProductoPyP.setLayoutManager(new LinearLayoutManager(this));

        List<ProductoPyP> productoPyPList = obtenerProductos();
        Double suma = 0.00;

        for (ProductoPyP p : productoPyPList) {
            suma += p.getImporte();
        }

        adaptadorProductoPyP = new CustomAdapterProductoPP(productoPyPList);
        recyclerViewProductoPyP.setAdapter(adaptadorProductoPyP);

        tv_totalPrecio.setText(suma + "");

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
        productoPyPList.add(new ProductoPyP("Paracetamol 1000 gr caja", 5, 10.00, 50.00));
        productoPyPList.add(new ProductoPyP("Azitromicina 1000 gr caja", 2, 50.00, 100.00));
        productoPyPList.add(new ProductoPyP("Penicilina 1000 gr caja", 4, 35.00, 140.00));
        productoPyPList.add(new ProductoPyP("Panadol 10 gr caja", 5, 1.00, 5.00));
        productoPyPList.add(new ProductoPyP("Anterogerminlina 100 gr caja", 2, 15.00, 30.00));

        return productoPyPList;
    }
}