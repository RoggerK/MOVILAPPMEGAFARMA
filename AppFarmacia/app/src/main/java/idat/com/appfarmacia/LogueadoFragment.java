package idat.com.appfarmacia;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.Toast;


public class LogueadoFragment extends Fragment {

    private View view;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view = inflater.inflate(R.layout.fragment_logueado, container, false);
        verDetalle();
        cerrarSesion();
        return view;
    }

    private void verDetalle(){
        ImageView btn_PrincipalLog_VerDetalle = view.findViewById(R.id.btn_PrincipalLog_VerDetalle);

        btn_PrincipalLog_VerDetalle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent (AppWale.context, DetalleCompraActivity.class);
                startActivity(intent);
            }
        });

    }

    private void cerrarSesion(){
        ImageView btn_PrincipalLog_CerrarSesion = view.findViewById(R.id.btn_PrincipalLog_CerrarSesion);

        btn_PrincipalLog_CerrarSesion.setOnClickListener(new View.OnClickListener() {
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