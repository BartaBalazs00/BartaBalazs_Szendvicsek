package hu.barta.balazs.szendvicsek;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private Button btn_kereses, btn_ujFelvetele;
    private EditText edit_ar, edit_nev;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();
        btn_kereses.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String arString = edit_ar.getText().toString();
                if(arString.isEmpty()){
                    Toast.makeText(getApplicationContext(), "Az ár mező kitöltése kötelező", Toast.LENGTH_SHORT).show();
                }else {
                    try {
                        int ar = Integer.parseInt(arString);
                        String nev = edit_nev.getText().toString();
                        Intent kereses = new Intent(MainActivity.this, SearchResultActivity.class);
                        kereses.putExtra("ar", ar);
                        kereses.putExtra("nev", nev);
                        startActivity(kereses);
                        finish();
                    } catch (NumberFormatException e) {
                        Toast.makeText(getApplicationContext(), "Az árnak számank kell lennie!", Toast.LENGTH_SHORT).show();
                    }
                }


            }
        });
        btn_ujFelvetele.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent UjFelvetele = new Intent(MainActivity.this, InsertActivity.class);
                startActivity(UjFelvetele);
                finish();
            }
        });
    }
    public void init(){
        btn_kereses = findViewById(R.id.btn_kereses);
        btn_ujFelvetele = findViewById(R.id.btn_ujFelvetele);
        edit_ar = findViewById(R.id.edit_ar);
        edit_nev = findViewById(R.id.edit_nev);
    }
}