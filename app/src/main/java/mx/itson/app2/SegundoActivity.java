package mx.itson.app2;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class SegundoActivity extends AppCompatActivity {

    TextView tvValorParametro;
    EditText etParametroRegreso;
    Button btnRegresar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_segundo);

        ///Obtener el parametro enviado de la otra actividad
        String correoParametro = getIntent().getStringExtra("PRIMER_PARAMETRO");

        tvValorParametro = findViewById(R.id.tvValorParametro);
        etParametroRegreso = findViewById(R.id.etParametroRegreso);
        btnRegresar = findViewById(R.id.btnRegresar);

        tvValorParametro.setText(correoParametro);

        btnRegresar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ///Enviar un parametro de regreso
                String parametroRegreso = etParametroRegreso.getText().toString();
                Intent intent = new Intent();
                intent.putExtra("PARAMETRO_REGRESO", parametroRegreso);
                //Indicar el resultado del llamado de esta actividad
                setResult(RESULT_OK, intent);
                finish();
            }
        });

        /*EdgeToEdge.enable(this);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });*/
    }
}