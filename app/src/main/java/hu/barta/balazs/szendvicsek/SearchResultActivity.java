package hu.barta.balazs.szendvicsek;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class SearchResultActivity extends AppCompatActivity {
    private Button btn_vissza;
    private TextView text_lista;
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
    }
    public void init(){
        btn_vissza = findViewById(R.id.btn_vissza);
        text_lista = findViewById(R.id.text_lista);
    }
}