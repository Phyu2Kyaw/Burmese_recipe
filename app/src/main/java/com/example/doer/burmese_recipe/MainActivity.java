package com.example.doer.burmese_recipe;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class MainActivity extends AppCompatActivity {
    private FirebaseDatabase myFirebaseDatabase;
    private DatabaseReference myDatabaseReference;
    EditText txtName;
    EditText txtIngredients;
    EditText txtProcess;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        myFirebaseDatabase =FirebaseDatabase.getInstance();
        myDatabaseReference= myFirebaseDatabase.getReference().child("burmese-recipe");
        txtName =(EditText) findViewById(R.id.txtName);
        txtIngredients=(EditText) findViewById(R.id.txtIngredients);
        txtProcess =(EditText) findViewById(R.id.txtProcess);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch(item.getItemId()){
            case R.id.my_menu:
                saveRecipe();
                Toast.makeText(this,"Saved", Toast.LENGTH_LONG).show();
                clean();
                return true;
                default:return super.onOptionsItemSelected(item);
        }
    }

    private void clean() {
        txtName.setText("");
        txtIngredients.setText("");
        txtProcess.setText("");
        txtName.requestFocus();

    }

    private void saveRecipe() {
        String name=txtName.getText().toString();
        String ingredients=txtIngredients.getText().toString();
        String process=txtProcess.getText().toString();
        BurmeseRecipe recipe=new BurmeseRecipe(name,ingredients,process,"");
        myDatabaseReference.push().setValue(recipe);

    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater=getMenuInflater();
        inflater.inflate(R.menu.my_menu, menu);
        return true;
    }
}
