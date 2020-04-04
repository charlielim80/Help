package charlie.com.e.portofolio;

import android.os.Bundle;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FirebaseFirestore;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;

import java.util.HashMap;
import java.util.Map;

public class AddItem extends AppCompatActivity {
    FirebaseFirestore fstore;
    EditText addItemName, addStock, addExpDate;
    ProgressBar progressBar;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_item);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        fstore = FirebaseFirestore.getInstance();
        addItemName = findViewById(R.id.addItemName);
        addStock = findViewById(R.id.addStock);
        addExpDate = findViewById(R.id.addExpDate);
        progressBar = findViewById(R.id.progressBar);

        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Toast.makeText(AddItem.this, "Item Saved", Toast.LENGTH_SHORT).show();
                String aItemName= addItemName.getText().toString();
                String aStock = addStock.getText().toString();
                String aExpDate = addExpDate.getText().toString();

                if (aItemName.isEmpty() || aStock.isEmpty() || aExpDate.isEmpty()){
                    Toast.makeText(AddItem.this, "Can Not Save Item Data With Empty Field", Toast.LENGTH_SHORT).show();
                    return;
                }

                progressBar.setVisibility(View.VISIBLE);

                //Save Item
                DocumentReference docref = fstore.collection("Items").document();
                Map<String,Object> item = new HashMap<>();
                item.put("itemname",aItemName);
                item.put("stock",aStock);
                item.put("expdate",aExpDate);
                docref.set(item).addOnSuccessListener(new OnSuccessListener<Void>() {
                    @Override
                    public void onSuccess(Void aVoid) {
                        Toast.makeText(AddItem.this, "Item Added", Toast.LENGTH_SHORT).show();
                        onBackPressed();
                    }
                }).addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e) {
                        Toast.makeText(AddItem.this, "Error, Please Try Again", Toast.LENGTH_SHORT).show();
                        progressBar.setVisibility(View.INVISIBLE);
                    }
                });
                //End Save Item
            }
        });
    }
    //Menu Close

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.close_menu,menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if (item.getItemId() == R.id.close){// <- Yang Berarti Close Manu Di Click
            Toast.makeText(this, "Item Not Saved", Toast.LENGTH_SHORT).show();
            onBackPressed();
        }
        return super.onOptionsItemSelected(item);
    }

    //Akhir Menu Close
}
