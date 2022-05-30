package com.example.jcode;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity2 extends AppCompatActivity {
 Button bouton;
 TextView text;
 EditText edit;
    Spinner spinner_Parent;
    Button button_resultat;

    ArrayList<String> arrayList_Parent;
    ArrayAdapter<String> arrayAdapter_Parent;

    String caractere="";

    private int counter_for = 0;
    private int counter_for_i = 0;
    int j ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        text = (TextView) findViewById(R.id.textView_code);
        edit = (EditText) findViewById(R.id.edit);
        bouton = (Button) findViewById(R.id.button_code);

        spinner_Parent = findViewById(R.id.spinner);

        arrayList_Parent = new ArrayList<>();
        arrayList_Parent.add("Windows");
        arrayList_Parent.add("Linux");
        arrayAdapter_Parent = new ArrayAdapter<>(this, R.layout.textview_red, arrayList_Parent);
        spinner_Parent.setAdapter(arrayAdapter_Parent);
        spinner_Parent.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                if (i == 0){
                    text.setText("windows");
                    edit.setText("?");
                    edit.setBackgroundColor(0xFF00FF00);
                    counter_for = i;
                }
                else if (i == 1){
                    text.setText("Linux");
                    edit.setText("");
                    counter_for = i;
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });
        bouton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (counter_for == 0){
                     caractere = " ☺☻♥♦♣♠•◘○◙♂♀♪♫☼►◄↕‼¶§▬↨↑↓→←∟↔▲▼ !\"#$%&'()*+,-./0123456789:;<=>?@ABCDEFGHIJKLMNOPQRSTUVWXYZ[\\]^_`abcdefghijklmnopqrstuvwxyz{|}~Δ€‚ƒ„…†‡ˆ‰Š‹ŒŽ‘’“”•–—˜™š›œžŸ¡¢£¤¥¦§¨©ª«¬\u00AD®¯°±²³´µ¶·¸¹º»¼½¾¿ÀÁÂÃÄÅÆÇÈÉÊËÌÍÎÏÐÑÒÓÔÕÖ×ØÙÚÛÜÝÞßàáâãäåæçèéêëìíîïðñòóôõö÷øùúûüýþÿÇüéâäàåçêëèïîìÄÅÉæÆôöòûùÿÖÜ¢£¥₧ƒáíóúñÑªº¿⌐¬½¼¡«»░▒▓│┤╡╢╖╕╣║╗╝╜╛┐└┴┬├─┼╞╟╚╔╩╦╠═╬╧╨╤╥╙╘╒╓╫╪┘┌█▄▌▐▀αßΓπΣσµτΦΘΩδ∞φε∩≡±≥≤⌠⌡÷≈°∙·√ⁿ²■ ";

                }
                else if (counter_for == 1){
                    caractere = "²²²²²²²²²²²²²²²²²!\"#$%&'()\t0123456789@ABCDEFGHIJPQRSTUVWXY`abcdefghipqrstuvwxy" ;
                }
                char element;
                if (counter_for == 0){
                    j = caractere.length()-1;
                }
                if (counter_for == 1){
                    j = 77;
                }
                if(edit.getText().charAt(0) == '&' && counter_for ==0 ){
                    text.setText("alt + 38");
                }
                else if (edit.getText().charAt(0) == '<'&& counter_for == 0){
                    text.setText("alt + 60");
                }
                else{

                    for(int i = j; i > 0  ; i--){
                        element = caractere.charAt(i);
                        if (edit.getText().charAt(0) == element ) {
                            element = caractere.charAt(caractere.length()-1);
                            if (counter_for == 1){
                                i+=2;
                            }
                            text.setText("alt +"+ i + element);

                        }
                    }
                }
            }
        });

    }
}