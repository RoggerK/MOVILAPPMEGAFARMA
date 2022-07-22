package idat.com.appfarmacia;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.Toast;


public class DetailsFragment extends Fragment {

    private View view;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view = inflater.inflate(R.layout.fragment_details, container, false);
        abrirPrincipalLog();
        cerrarSesion();
        return view;
    }

    private void abrirPrincipalLog(){
        ImageView btnRegresar_Principal = view.findViewById(R.id.btn_Regresar_Principal);

        btnRegresar_Principal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent (AppWale.context, PrincipalActivity.class);
                startActivity(intent);
            }
        });

    }

    private void cerrarSesion(){
        ImageView btnSalir = view.findViewById(R.id.btn_CerrarSesion);

        btnSalir.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent (AppWale.context, PrincipalSinActivity.class);
                Toast.makeText(AppWale.context, "Se cerro Sesion",
                        Toast.LENGTH_SHORT).show();
                startActivity(intent);
            }
        });

    }
}