package idat.com.appfarmacia;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.regex.Pattern;

public class RegistrarActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registrar);

        EditText txt_correo = findViewById(R.id.txt_correo);
        EditText txt_fc_nacimiento = findViewById(R.id.txt_fc_nacimiento);
        EditText txt_contrasenia = findViewById(R.id.txt_contrasenia);

        Button bt_aceptar = findViewById(R.id.bt_aceptar);

        bt_aceptar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String correo = "";
                String fc_nacimiento = "";
                String contrasenia = "";

                correo = txt_correo.getText().toString();
                fc_nacimiento = txt_fc_nacimiento.getText().toString();
                contrasenia = txt_contrasenia.getText().toString();

                System.out.println(validarEmail(correo));

                System.out.println(validarFecha(fc_nacimiento));

                //System.out.println(correo +" "+ fc_nacimiento +" "+ contrasenia);
            }
        });
    }

    private boolean validarEmail(String correo) {
        Pattern pattern = Patterns.EMAIL_ADDRESS;
        boolean valor = pattern.matcher(correo).matches();

        if(!valor){
            Toast.makeText(this, "No se tiene un forma del correo", Toast.LENGTH_SHORT).show();
        }

        return valor;
    }

    private boolean validarFecha(String fecha) {
        try {
            String[] fc_nacimiento = fecha.split("[-/]+", 3);

            if(!fecha.equals("")){
                for (int i = 0; i < fc_nacimiento.length; i++) {
                    Integer.parseInt(fc_nacimiento[i]);
                }

                if(!(fc_nacimiento[0].length() == 4)){
                    Toast.makeText(this, "Longitud de año incorrecto", Toast.LENGTH_SHORT).show();
                    return false;
                }

                if(!(fc_nacimiento[1].length() >= 1 && fc_nacimiento[1].length() <= 2)
                        || !(fc_nacimiento[2].length() >= 1 && fc_nacimiento[2].length() <= 2)){
                    Toast.makeText(this, "Longitud de mes o dia incorrecto", Toast.LENGTH_SHORT).show();
                    return false;
                }

                return true;
            } else {
                Toast.makeText(this, "La fecha de nacimiento esta vacia", Toast.LENGTH_SHORT).show();
                return false;
            }
        } catch (NumberFormatException e){
            Toast.makeText(this, "La fecha de nacimiento contiene letras", Toast.LENGTH_SHORT).show();
            return false;
        }
    }

}