package charlie.com.e.portofolio;

import android.content.Intent;
import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class NoteDetails extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_note_details);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);//memunculkan tombol back di pojok atas

        Intent data = getIntent();

        ImageView itemImg = findViewById(R.id.itemImg);
        TextView itemName = findViewById(R.id.itemName);
        TextView stock = findViewById(R.id.stock);
        TextView expDate = findViewById(R.id.expDate);
        TextView title = findViewById(R.id.noteDetailsTitle);

        itemName.setText(data.getStringExtra("itemName"));
        stock.setText(data.getStringExtra("stock"));
        expDate.setText(data.getStringExtra("expDate"));
        title.setText(data.getStringExtra("titles"));





        FloatingActionButton fab = findViewById(R.id.addItemFloat);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
    }

    @Override//memunculkan tombol back di pojok atas
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if (item.getItemId() == android.R.id.home){
            onBackPressed();
        }
        return super.onOptionsItemSelected(item);
    }
}
