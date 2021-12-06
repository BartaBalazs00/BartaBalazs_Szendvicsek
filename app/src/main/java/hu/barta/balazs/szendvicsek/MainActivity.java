package hu.barta.balazs.szendvicsek;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
    private Button btn_kereses, btn_ujFelvetele;
    private EditText edit_ar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();
        btn_kereses.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent kereses = new Intent(MainActivity.this, SearchResultActivity.class);
                startActivity(kereses);
                finish();
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
    }
}