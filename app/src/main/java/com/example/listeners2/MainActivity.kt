package com.example.listeners2

/*
Crear una aplicacion en android que cumpla:
1- Tenga un botón "Comenzar", cuando se pulsa deben aparecer un editText en el que el usuario debe introducir su nombre. Una vez pulsado, el texto del botón de cambiar a: "Finalizar".
Si el usuario pulsa el botón otra vez, entonces el editText desaparece.

2- Si el usuario no ha escrito nada, el editText debe mostrar: "Introduce tu nombre". Cuando el usuario pulsa en el editText, el texto se borra y permite la introducción de texto.
Si el usuario no ha escrito nada y quita el focus, entonces "Introduce tu nombre" se vuelve a mostrar.

3- Si el nombre del usuario contiene el texto Wayne, entonces debe aparecer una imagen de con el logo de batman.
Si el texto contiene la palabra joker entonces los colores de la app deben cambiar, background, color de la letras, etc.
 */


import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.view.View
import android.app.Activity;
import android.view.View.OnClickListener;
import android.view.inputmethod.InputMethodManager;
import android.widget.*

class MainActivity : AppCompatActivity() {
    private lateinit var ll : LinearLayout
    private lateinit var b1 : Button
    private lateinit var et1 : EditText
    private lateinit var img : ImageView

    private val textWatcher = object : TextWatcher {
        override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
        }

        override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
        }

        override fun afterTextChanged(p0: Editable?) {
            if(et1.text.toString() == "Wayne"){
                img.visibility = View.VISIBLE
            } else {
                if (et1.text.toString() == "Joker"){
                ll.setBackgroundColor(572364)

                }
            }


        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        b1 =  findViewById(R.id.b1)
        et1 = findViewById(R.id.et1)
        img = findViewById(R.id.img)
        setAllListener()
    }

    private fun setAllListener(){

        b1.setOnClickListener {
            et1.visibility = View.VISIBLE
            et1.setOnClickListener{
                et1.setOnFocusChangeListener{v, hasFocus ->
                    if (hasFocus)
                        et1.setText("")
                    else {
                        et1.setText("Introduzca el nombre")
                    }
                }
            }

            b1.text = "Finalizar"

            b1.setOnClickListener {
                et1.visibility = View.INVISIBLE
            }
        }


        et1.addTextChangedListener(textWatcher)



    }


}