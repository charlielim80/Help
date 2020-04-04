package charlie.com.e.portofolio;

import android.content.Intent;
import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class NoteDetails extends AppCompatActivity {
    Intent data;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_note_details);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);//memunculkan tombol back di pojok atas

         data = getIntent();

        ImageView itemImg = findViewById(R.id.itemImg);
        TextView itemName = findViewById(R.id.editItemName);
        TextView stock = findViewById(R.id.editStock);
        TextView expDate = findViewById(R.id.editExpDate);
        TextView title = findViewById(R.id.noteDetailsTitle);

        itemName.setText(data.getStringExtra("itemName"));
        stock.setText(data.getStringExtra("stock"));
        expDate.setText(data.getStringExtra("expDate"));
        title.setText(data.getStringExtra("titles"));

        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i =  new Intent(view.getContext(),EditItem.class);
                i.putExtra("itemName",data.getStringExtra("itemName"));
                i.putExtra("stock",data.getStringExtra("stock"));
                i.putExtra("expDate",data.getStringExtra("expDate"));
                i.putExtra("itemId",data.getStringExtra("itemId"));
                startActivity(i);

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
