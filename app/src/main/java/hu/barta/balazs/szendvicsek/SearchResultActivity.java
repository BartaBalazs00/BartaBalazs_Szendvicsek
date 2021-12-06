package hu.barta.balazs.szendvicsek;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class SearchResultActivity extends AppCompatActivity {
    private Button btn_vissza;
    private TextView text_lista;
    private DBHelper adatbazis;
    private int ar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search_result);
        init();
        btn_vissza.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent Vissza = new Intent(SearchResultActivity.this, MainActivity.class);
                startActivity(Vissza);
                finish();
            }
        });



        Cursor adatok = adatbazis.listaz( ar );
        if(adatok.getCount() == 0){
            Toast.makeText(getApplicationContext(), "Nincs az adatbázisban bejegyzés", Toast.LENGTH_SHORT).show();
        } else {
            StringBuilder szoveg = new StringBuilder();
            while (adatok.moveToNext()){
                szoveg.append("ID: ").append(adatok.getInt(0)).append(System.lineSeparator());
                szoveg.append("Név: ").append(adatok.getString(1)).append(System.lineSeparator());
                szoveg.append("Leírás: ").append(adatok.getString(2)).append(System.lineSeparator());
                szoveg.append("Elkészítési Idő: ").append(adatok.getInt(3)).append(System.lineSeparator());
                szoveg.append("Ár: ").append(adatok.getInt(4)).append(System.lineSeparator());
                szoveg.append(System.lineSeparator());
                szoveg.append(System.lineSeparator());
            }
        text_lista.setText(szoveg.toString());
        }

    }
    public void init(){
        btn_vissza = findViewById(R.id.btn_vissza);
        text_lista = findViewById(R.id.text_lista);
        adatbazis = new DBHelper(this);
        Intent kereses = getIntent();
        ar = kereses.getIntExtra("ar", 0);
    }
}