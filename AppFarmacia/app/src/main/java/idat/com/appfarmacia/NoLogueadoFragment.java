package idat.com.appfarmacia;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

public class NoLogueadoFragment extends Fragment {

    private View view;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view = inflater.inflate(R.layout.fragment_no_logueado, container, false);
        abrirLogin();
        return view;
    }

    private void abrirLogin(){
        ImageView btn_PrincipalSin_Iniciar_Sesion = view.findViewById(R.id.btn_PrincipalSin_Iniciar_Sesion);

        btn_PrincipalSin_Iniciar_Sesion.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent (AppWale.context, MainActivity.class);
                startActivity(intent);
            }
        });

    }
}