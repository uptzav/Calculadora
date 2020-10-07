package com.example.calculadora;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    private Calculadora mCalculadora;

    private EditText mPrimerOperador;

    private EditText mSegundoOperador;

    private EditText mResult;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mCalculadora = new Calculadora();
        mPrimerOperador= (EditText)findViewById(R.id.edt_primeroperador);
        mSegundoOperador= (EditText)findViewById(R.id.edt_segundooperador);
        mResult = (EditText)findViewById(R.id.edt_resultado);

        ((Button)findViewById(R.id.btnsuma)).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                calcular(Calculadora.Operador.SUM);
            }
        });

        ((Button)findViewById(R.id.btnresta)).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                calcular(Calculadora.Operador.RES);
            }
        });

        ((Button)findViewById(R.id.btnmultiplica)).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                calcular(Calculadora.Operador.MUL);
            }
        });
        ((Button)findViewById(R.id.btndivide)).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                calcular((Calculadora.Operador.DIV));
            }
        });
    }

    private void calcular(Calculadora.Operador operador){
        double operadorUno;
        double operadorDos;
        operadorUno = obtenerOperador(mPrimerOperador);
        operadorDos = obtenerOperador(mSegundoOperador);

        String resultado;

        switch (operador){
            case SUM:
                resultado = String.valueOf(mCalculadora.suma(operadorUno,operadorDos));
                break;
            case  RES:
                resultado = String.valueOf(mCalculadora.resta(operadorUno,operadorDos));
                break;
            case MUL:
                resultado = String.valueOf(mCalculadora.multiplicacion(operadorUno,operadorDos));
               break;
            case DIV:
                resultado = String.valueOf(mCalculadora.division(operadorUno,operadorDos));
                break;
            default:
                resultado ="Nan";
                break;
        }
        mResult.setText(resultado);
    }

    private static  Double obtenerOperador(EditText operadorText){
        String operando = operadorText.getText().toString();
        return Double.valueOf(operando);
    }
}