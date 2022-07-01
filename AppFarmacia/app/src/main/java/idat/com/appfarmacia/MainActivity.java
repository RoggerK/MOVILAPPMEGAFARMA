package idat.com.appfarmacia;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.AutoCompleteTextView;

import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;

public class MainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);



    }

}



   /*

       TextInputLayout textInputLayout;
    AutoCompleteTextView autoCompleteTextView;

@Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        textInputLayout = findViewById(R.id.correo_completo);
        autoCompleteTextView = findViewById(R.id.autoCompleteTextView);

        String[] correos = new String[] {
                "@hotmail.com",
                "@outlook.com",
                "@gmail.com",
                "@idat.edu.pe",
                "otros"
        };

        // otros datos
        Context context;
        ArrayAdapter<String> adapter = new ArrayAdapter<>(
                context MainActivity.this,
                R.layout.lista_correo,
                correos
        );

        // auto compeltar listo
        autoCompleteTextView.setAdapter(adapter);


    }*/