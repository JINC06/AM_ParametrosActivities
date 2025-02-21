package mx.itson.app2;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class PrimerActivity extends AppCompatActivity {

    private EditText etPrimerParametro;
    private Button btnSiguiente;
    private TextView tvParametroRegreso;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_primer);

        etPrimerParametro = findViewById(R.id.etPrimerParametro);
        btnSiguiente = findViewById(R.id.btnSiguiente);
        tvParametroRegreso = findViewById(R.id.tvParametroRegreso);

        btnSiguiente.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String correo = etPrimerParametro.getText().toString();

                Intent intent = new Intent(PrimerActivity.this, SegundoActivity.class);
                intent.putExtra("PRIMER_PARAMETRO", correo);

                //startActivity(intent);
                startActivityForResult(intent, 777);
            }
        });

        /*EdgeToEdge.enable(this);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });*/
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if(requestCode == 777 && resultCode == RESULT_OK) {
            String parametroRegreso = data.getStringExtra("PARAMETRO_REGRESO");
            tvParametroRegreso.setText( parametroRegreso );
        }
    }
}