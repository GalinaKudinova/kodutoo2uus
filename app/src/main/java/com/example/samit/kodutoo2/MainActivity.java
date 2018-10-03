package com.example.samit.kodutoo2;

import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;
import java.util.jar.Attributes;

public class MainActivity extends AppCompatActivity {





    private EditText txt_FirstName, txt_LastName;
    private Button btn_clear, btn_add;
    private ListView ListView1;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);






    }

    public void onClick(View view){
        final EditText txt_FirstName=(EditText) findViewById(R.id.txt_FirstName);
        final EditText txt_LastName=(EditText) findViewById(R.id.txt_LastName);
        btn_clear= (Button) findViewById(R.id. btn_clear);
        btn_add= (Button) findViewById(R.id.btn_add);
        ListView ListView1= (ListView)findViewById(R.id.ListView1);
        //String name= new String(txt_FirstName.getText().toString());
        //String name2= new String(txt_LastName.getText().toString());











        if (view.getId() == R.id.btn_clear){
            txt_FirstName.setText("");
            txt_LastName.setText("");
            //ListView1.clearChoices();
        }


        else if (view.getId() == R.id.btn_add){

            if (txt_FirstName.getText().length() == 0) {
                Toast.makeText(this, "", Toast.LENGTH_SHORT).show();
                return;}
            if (txt_LastName.getText().length() == 0){
                Toast.makeText(this, "", Toast.LENGTH_SHORT).show();
                return;}}

        else if (view.getId() == R.id.btn_add){

            // Teeme tuhi massiv
            final ArrayList<String> Names= new ArrayList<>();

            // Loome adapter
            final ArrayAdapter<String > adapter = new ArrayAdapter<String>(this,
                    android.R.layout.simple_list_item_1, Names);

            Names.add(Integer.parseInt(txt_FirstName.getText().toString()), txt_LastName.getText().toString()) ;


            ListView1.setAdapter(adapter);
            adapter.notifyDataSetChanged();
            txt_FirstName.setText("");
            txt_LastName.setText("");


            ListView1.setLongClickable(true);
            ListView1.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
                @Override
                public boolean onItemLongClick(AdapterView<?> parent, View view, final int position, long id) {
                    final AlertDialog alert = new AlertDialog.Builder(MainActivity.this).create();
                    alert.setTitle("DELETE");
                    alert.setCancelable(false);

                    alert.setButton(DialogInterface.BUTTON_POSITIVE, "YES", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            Names.remove(position);
                            adapter.notifyDataSetChanged();

                        }
                    });
                    alert.setButton(DialogInterface.BUTTON_NEGATIVE, "CANCEL", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            alert.cancel();
                        }
                    });
                    alert.show();
                    return false;
                }
            });


        }





    }
}


