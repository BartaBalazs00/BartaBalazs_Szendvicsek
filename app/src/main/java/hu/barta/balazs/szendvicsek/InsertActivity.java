package hu.barta.balazs.szendvicsek;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class InsertActivity extends AppCompatActivity {
    private EditText edit_nev, edit_leiras, edit_ido, edit_ar;
    private Button btn_felvetel, btn_vissza;
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
    }
    public void init(){
        edit_nev = findViewById(R.id.edit_nev);
        edit_leiras = findViewById(R.id.edit_leiras);
        edit_ido = findViewById(R.id.edit_ido);
        edit_ar = findViewById(R.id.edit_ar);
        btn_vissza = findViewById(R.id.btn_vissza);
        btn_felvetel = findViewById(R.id.btn_felvetel);
    }
}