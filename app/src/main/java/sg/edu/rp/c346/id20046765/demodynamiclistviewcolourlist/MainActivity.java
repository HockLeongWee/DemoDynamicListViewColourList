package sg.edu.rp.c346.id20046765.demodynamiclistviewcolourlist;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    EditText etElement;
    EditText etIndexElement;
    Button btnAdd;
    Button btnRemove;
    Button btnUpdate;
    ListView lvColour;
    ArrayAdapter aaColour ;

    String colourInput = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etElement = findViewById(R.id.editTextColor);
        btnAdd = findViewById(R.id.buttonAddItem);
        btnRemove = findViewById(R.id.buttonRemove);
        btnUpdate = findViewById(R.id.buttonUpdate);
        lvColour = findViewById(R.id.listViewColour);
        etIndexElement = findViewById(R.id.editTextIndex);

        ArrayList<String> alColours ; // Array List

        alColours  = new ArrayList<String>(); // Array
        alColours.add("Red");
        alColours.add("Orange");

        aaColour  = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, alColours);
        lvColour.setAdapter(aaColour);

        btnAdd.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                colourInput = etElement.getText().toString();
                int position = Integer.parseInt(etIndexElement.getText().toString());
                alColours.add((position - 1), colourInput);
                aaColour.notifyDataSetChanged();
            }
        });

        lvColour.setOnItemClickListener(new AdapterView.OnItemClickListener(){
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id){
                String colorChosen = lvColour.getItemAtPosition(position).toString();
                Toast.makeText(MainActivity.this, colorChosen, Toast.LENGTH_SHORT).show();
            }
        });

        btnRemove.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                int pos = Integer.parseInt(etIndexElement.getText().toString());
                alColours.remove(pos - 1);
                aaColour.notifyDataSetChanged();
            }
        });

        btnUpdate.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                int pos = Integer.parseInt(etIndexElement.getText().toString());
                String updateColours = etElement.getText().toString();
                alColours.set((pos - 1), updateColours);
                aaColour.notifyDataSetChanged();
            }
        });


    }
}