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

    /**
     * validarEmail(String correo):
     *
     * Se instancia un patron, para ver el valor
     * de correo si este tiene al menos un @ y .
     *
     * Caso contrario botaria un mensaje de no
     * formate de correo
     *
     * @param correo, de tipo String
     * @return boolean
     * */

    private boolean validarEmail(String correo) {
        Pattern pattern = Patterns.EMAIL_ADDRESS;
        boolean valor = pattern.matcher(correo).matches();

        if(!valor){
            Toast.makeText(this, "No se tiene un forma del correo",
                            Toast.LENGTH_SHORT).show();
        }

        return valor;
    }

    /**
     * validarFecha(String fecha):
     *
     * Valida que sean numeros; sus longitudes
     * de año igual a 4, mes y dia igual a 1 o 2.
     * Por ultimo la excepcion de formato de fecha
     * incorrecto se controla en conversion de numeros
     *
     * @author Curisinche Guia Kennedy
     * @param fecha, foramto fecha aaaa/mm/dd o aaaa-mm-dd,
     *               si la persona ingresa aaaa-mm/dd o
     *               aaaa/mm-dd, sera valido, pero con
     *               advertencia en sql que convertira en tipo
     *               fecha aaaa-mm-dd
     * @return boolean
     * */
    private boolean validarFecha(String fecha) {
        try {
            String[] fc_nacimiento = fecha.split("[-/]+", 3);

            if(!fecha.equals("")){
                for (int i = 0; i < fc_nacimiento.length; i++) {
                    Integer.parseInt(fc_nacimiento[i]);
                }

                if(!(fc_nacimiento[0].length() == 4)){
                    Toast.makeText(this, "Longitud de año incorrecto",
                                    Toast.LENGTH_SHORT).show();
                    return false;
                }

                if(!(fc_nacimiento[1].length() >= 1 && fc_nacimiento[1].length() <= 2)
                        || !(fc_nacimiento[2].length() >= 1 && fc_nacimiento[2].length() <= 2)){
                    Toast.makeText(this, "Longitud de mes o dia incorrecto",
                                    Toast.LENGTH_SHORT).show();
                    return false;
                }

                return true;
            } else {
                Toast.makeText(this, "La fecha de nacimiento esta vacia",
                                Toast.LENGTH_SHORT).show();
                return false;
            }
        } catch (NumberFormatException e){
            e.printStackTrace();
            Toast.makeText(this, "La fecha de nacimiento contiene letras o el formato de fecha es incorrecto",
                            Toast.LENGTH_SHORT).show();
            return false;
        }
    }

}