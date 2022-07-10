package idat.com.appfarmacia;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
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

        EditText txt_nombre = findViewById(R.id.txt_Nombre);
        EditText txt_apellido = findViewById(R.id.txt_Apellido);
        EditText txt_correo = findViewById(R.id.txt_Correo);
        EditText txt_fc_nacimiento = findViewById(R.id.txt_Fecha);
        EditText txt_contrasenia = findViewById(R.id.txt_Contrasenia);

        EditText txt_dni = findViewById(R.id.txt_Dni);
        EditText txt_nucel = findViewById(R.id.txt_Celular);

        Button bt_aceptar = findViewById(R.id.bt_Aceptar);
        Button bt_cancelar = findViewById(R.id.bt_Cancelar);

        bt_aceptar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String nombre = txt_nombre.getText().toString().trim();
                String apellido = txt_apellido.getText().toString().trim();
                String dni = txt_dni.getText().toString();
                String numcel = txt_nucel.getText().toString();
                String correo = txt_correo.getText().toString();
                String fc_nacimiento = txt_fc_nacimiento.getText().toString();
                String contrasenia = txt_contrasenia.getText().toString();

                boolean rsregistro = respuesta(nombre,apellido,numcel,dni,
                                                correo, fc_nacimiento, contrasenia);

                if (rsregistro){
                    mess_registrado();
                }

            }
        });

        bt_cancelar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                cancelar();
            }
        });
    }

    private void mess_registrado(){
        Intent intent = new Intent (this, MainActivity.class);

        Toast.makeText(this, "Registro completado",
                Toast.LENGTH_SHORT).show();

        startActivity(intent);
    }

    private void cancelar(){
        Intent intent = new Intent (this, MainActivity.class);

        startActivity(intent);
    }

    private boolean respuesta(String nombre, String apellido, String numcel, String dni,
                              String correo, String fc_nacimiento, String contrasenia){
        if (validarNombre(nombre)){
            if (validarApellido(apellido)){
                if (validarNumCel(numcel)){
                    if (validarDNI(dni)){
                        if (validarCorreo(correo)){
                            if (validarFecha(fc_nacimiento)){
                                if(validarContrasenia(contrasenia)){
                                    return true;
                                }
                            }
                        }
                    }
                }
            }
        }

        return false;
    }

    private boolean validarNombre(String nombre) {
        Pattern nombreRegex = Pattern.compile(
                "^" +
                        "(?=.*[a-z])" +         //al menos una letra minusucla
                        "(?=.*[A-Z])" +         //al menos una letra mayuscula
                        ".{3,}" +               //al menos 3 caracteres
                        "$"
        );

        if (nombre.isEmpty()) {
            Toast.makeText(this, "El campo de nombre esta vacio",
                    Toast.LENGTH_SHORT).show();
            return false;
        }else if (!nombreRegex.matcher(nombre).matches()){
            Toast.makeText(this, "El campo nombre debe tener al menos una minuscula y una mayuscula",
                    Toast.LENGTH_SHORT).show();
            return false;
        }

        return true;
    }

    private boolean validarApellido(String apellido) {

        Pattern apellidoRegex = Pattern.compile(
                "^" +
                        "(?=.*[a-z])" +         //al menos una letra minusucla
                        "(?=.*[A-Z])" +         //al menos una letra mayuscula
                        ".{3,}" +               //al menos 3 caracteres
                        "$"
        );

        if (apellido.isEmpty()) {
            Toast.makeText(this, "El campo de apellido esta vacio",
                    Toast.LENGTH_SHORT).show();
            return false;
        }else if (!apellidoRegex.matcher(apellido).matches()){
            Toast.makeText(this, "El campo apellido debe tener al menos una minuscula y una mayuscula",
                    Toast.LENGTH_SHORT).show();
            return false;
        }

        return true;
    }

    private boolean validarNumCel(String numcel){

        Pattern pati = Patterns.PHONE;
        boolean valorCel = pati.matcher(numcel).matches();

        if(numcel.isEmpty()){
            Toast.makeText(this, "El campo de número de celular esta vacia",
                    Toast.LENGTH_SHORT).show();
            return false;
        } else if(numcel.length() > 9) {
            Toast.makeText(this, "El campo de celular no debe superar los 9 dígitos",
                    Toast.LENGTH_SHORT).show();
            return false;
        } else if(!valorCel){
            Toast.makeText(this, "El campo de celular no puede tener letras",
                    Toast.LENGTH_SHORT).show();
            return false;
        } else if(numcel.length() < 9 ){
            Toast.makeText(this, "El campo de celular debe tener 9 dígitos",
                    Toast.LENGTH_SHORT).show();
            return false;
        }

        return true;
    }

    private boolean validarDNI(String dnni) {
        Pattern pati = Patterns.PHONE;
        boolean valorDni = pati.matcher(dnni).matches();

        if (dnni.isEmpty()) {
            Toast.makeText(this, "El campo de DNI esta vacia",
                    Toast.LENGTH_SHORT).show();
            return false;
        } else if (dnni.length() >= 9) {
            Toast.makeText(this, "El DNI solo acepta 8 caracteres",
                    Toast.LENGTH_SHORT).show();
            return false;
        } else if(!valorDni){
            Toast.makeText(this, "El DNI no puede tener letras",
                    Toast.LENGTH_SHORT).show();
            return false;
        } else if (dnni.length() < 8){
            Toast.makeText(this, "El DNI debe tener 8 dígitos como mínimo",
                    Toast.LENGTH_SHORT).show();
            return false;
        }

        return true;
    }

    /**
     * validarCorreo(String correo):
     *
     * Se instancia un patron, para ver el valor
     * de correo si este tiene al menos un '@' y '.'
     *
     * . Caso contrario botaria un mensaje de error de
     * formato de correo.
     *
     * @author Curisinche Guia Kennedy
     * @param correo, de tipo String
     * @return boolean
     * */

    private boolean validarCorreo(String correo) {
        Pattern pattern = Patterns.EMAIL_ADDRESS;
        boolean valor = pattern.matcher(correo).matches();

        if (correo.isEmpty()){
            Toast.makeText(this, "El campo de correo esta vacia",
                    Toast.LENGTH_SHORT).show();
            return false;
        }

        if(!valor){
            Toast.makeText(this, "El campo correo no tiene un formato de correo",
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
     * incorrecto se controla en conversion de numeros.
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
            Toast.makeText(this, "La fecha de nacimiento contiene letras o el formato de fecha es incorrecto",
                            Toast.LENGTH_SHORT).show();
            return false;
        } catch (ArrayIndexOutOfBoundsException e){
            Toast.makeText(this, "La fecha debe esta compuesta por año-mes-dia",
                    Toast.LENGTH_SHORT).show();
            return false;
        }
    }
    /**
     * validarContrasenia(String contrasenia):
     *
     * Validamos una contraseña con expresiones regulares
     * con al menos un numero, letra minuscula, letra mayuscula,
     * al menos alguno de estos caracteres especiales '@#$%^&+='
     * . Se evalua si esta vacio el compa contraseña y por otro
     * lado este verifica que si se cumplan las expresiones regulares
     *
     * @author Curisinche Guia Kennedy
     * @param contrasenia, de tipo String
     * @return boolean
     * */
    private boolean validarContrasenia(String contrasenia){
        Pattern passwordRegex = Pattern.compile(
                "^" +
                        "(?=.*[0-9])" +         //al menos un numero
                        "(?=.*[a-z])" +         //al menos una letra minusucla
                        "(?=.*[A-Z])" +         //al menos una letra mayuscula
                        "(?=.*[@#$%^&+=])" +    //algunos de ellos debe estar
                        "(?=\\S+$)" +           //nada de espacios
                        ".{4,}" +               //al menos 4 caracteres
                        "$"
        );

        if (contrasenia.isEmpty()) {
            Toast.makeText(this, "El campo de contraseña esta vacia",
                    Toast.LENGTH_SHORT).show();
            return false;
        } else if (contrasenia.length() > 8) {
            Toast.makeText(this, "La contranseña no puede superar los 8 caracteres",
                    Toast.LENGTH_SHORT).show();
            return false;
        }else if (!passwordRegex.matcher(contrasenia).matches()){
            Toast.makeText(this, "El campo de contraseña no cumple con " +
                            " los valores que deberia tener como a-z, A-z, 0-9 y @#$%^&+=",
                    Toast.LENGTH_SHORT).show();
            return false;
        }

        return true;
    }

}