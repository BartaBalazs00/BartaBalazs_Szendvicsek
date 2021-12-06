package hu.barta.balazs.szendvicsek;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class InsertActivity extends AppCompatActivity {
    private EditText edit_nev, edit_leiras, edit_ido, edit_ar;
    private Button btn_felvetel, btn_vissza;
    private DBHelper adatbazis;
    private String nev;
    private String leiras;
    private String idoString;
    private String arString;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_insert);
        init();
        btn_vissza.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent Vissza = new Intent(InsertActivity.this, MainActivity.class);
                startActivity(Vissza);
                finish();
            }
        });

        edit_nev.addTextChangedListener(textWatcher);
        edit_leiras.addTextChangedListener(textWatcher);
        edit_ido.addTextChangedListener(textWatcher);
        edit_ar.addTextChangedListener(textWatcher);



        btn_felvetel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(nev.isEmpty() || leiras.isEmpty() || idoString.isEmpty() || arString.isEmpty()){
                    Toast.makeText(getApplicationContext(), "Minden mező kitöltése kötelező", Toast.LENGTH_SHORT).show();
                } else {
                    try {
                        int ido = Integer.parseInt(idoString);
                        int ar = Integer.parseInt(arString);
                        if (ido <1 || ar<1) {
                            Toast.makeText(getApplicationContext(), "Az időnek és az árnak nagyobbnak kell lennie mint nulla", Toast.LENGTH_SHORT).show();
                        } else {
                            if(adatbazis.felvetel(nev, leiras, ido, ar)){
                                Toast.makeText(getApplicationContext(), "Sikeres felvétel", Toast.LENGTH_SHORT).show();
                            } else {
                                Toast.makeText(getApplicationContext(), "Sikertelen felvétel", Toast.LENGTH_SHORT).show();

                            }
                        }
                    } catch (NumberFormatException e) {
                        Toast.makeText(getApplicationContext(), "Az időnek és az árnak számank kell lennie!", Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });
    }
    public void init(){
        edit_nev = findViewById(R.id.edit_nev);
        edit_leiras = findViewById(R.id.edit_leiras);
        edit_ido = findViewById(R.id.edit_ido);
        edit_ar = findViewById(R.id.edit_ar);
        btn_vissza = findViewById(R.id.btn_vissza);
        btn_felvetel = findViewById(R.id.btn_felvetel);
        adatbazis = new DBHelper(this);

    }

    private TextWatcher textWatcher = new TextWatcher() {
        @Override
        public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

        }

        @Override
        public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
            nev = edit_nev.getText().toString().trim();
            leiras = edit_leiras.getText().toString().trim();
            idoString = edit_ido.getText().toString().trim();
            arString = edit_ar.getText().toString().trim();
            btn_felvetel.setEnabled(!nev.isEmpty() && !leiras.isEmpty() && !idoString.isEmpty() && !arString.isEmpty());
        }

        @Override
        public void afterTextChanged(Editable editable) {

        }
    };
}