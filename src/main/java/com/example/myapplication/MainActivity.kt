package com.example.myapplication

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

import android.widget.CheckBox
import android.widget.TextView
import android.widget.EditText
import android.widget.Button
import android.widget.Toast // Importa a classe Toast
import kotlin.math.sqrt


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }


        val kelvin = findViewById<Button>(R.id.kelvinBtn)
        val fahrenheit = findViewById<Button>(R.id.FahrenheitBtn)

        val resultInputFinal = findViewById<EditText>(R.id.input)
        val resultInputFinalStrg = resultInputFinal.toString()

        if (resultInputFinalStrg.isEmpty()) {

            showToast("Insira um valor no primeiro campo")


        } else {
            fahrenheit.setOnClickListener { FahrenheitEvent() }

            kelvin.setOnClickListener { kelvinEvent() }
        }


//      BOTAO SQRT
        val sqrtButton = findViewById<Button>(R.id.btnSqrt)

        sqrtButton.setOnClickListener {

            val sqrtResultBox = findViewById<TextView>(R.id.sqrtResult)
            val sqrtInputUser = findViewById<EditText>(R.id.sqrtInput)

            val valorString = sqrtInputUser.text.toString()
            val valor = valorString.toDouble()


            val resposta = doSqrt(valor)

            sqrtResultBox.text = "$resposta"      //FUNCAO



            showToast("item clicado")


        }

//     BOTAO AREA DE UM CIRCULO

        val areaButton = findViewById<Button>(R.id.btnArea)

        areaButton.setOnClickListener {

            val userAnsw = findViewById<EditText>(R.id.inputArea)

            val userAnswString = userAnsw.text.toString()
            val userAnswDouble = userAnswString.toDouble()

            val finalResult = findViewById<TextView>(R.id.areaResult)


            finalResult.text = "${calcularArea(userAnswDouble)}"

        }



        val btnPot = findViewById<Button>(R.id.btnPotencia)

        btnPot.setOnClickListener{

            val inputBase = findViewById<EditText>(R.id.baseInput)
            val inputExp = findViewById<EditText>(R.id.expoenteInput)

            val resultPot = findViewById<TextView>(R.id.potenciaResult)

            val inputBaseString = inputBase.text.toString()
            val inputBaseNum = inputBaseString.toInt()

            val inputExpString = inputExp.text.toString()
            val inputExpNum = inputExpString.toInt()

            val resultados = calculaPotencia(inputBaseNum, inputExpNum)

            resultPot.text = "$resultados"

            showToast("item clicado")

        }

    }


    private fun showToast(message: String) {

        Toast.makeText(this, message, Toast.LENGTH_SHORT).show()

    }


    fun FahrenheitEvent () {

        val resultBox = findViewById<TextView>(R.id.resultBox)
        val userInput = findViewById<EditText>(R.id.input)

        val userInputString = userInput.text.toString()

        val userInputInteger = userInputString.toInt()
        val result = (userInputInteger * 1.8) + 32

        resultBox.text = "$result"


        showToast("Clicado")

    }


    fun kelvinEvent () {

        val resultadoBox = findViewById<TextView>(R.id.resultBox)
        val userInputKelvin = findViewById<EditText>(R.id.input)

        val userInputString = userInputKelvin.text.toString()
        val userInputInteger = userInputString.toInt()

        val resultado = (userInputInteger + 273)

        resultadoBox.text = "$resultado"

        showToast("Clicado")
    }


    fun doSqrt (valor: Double): Double {

        return sqrt(valor)

    }


    fun calcularArea (raio: Double): Double {


        val raio2 = sqrt(raio)
        val result = 3.14 * raio2

        return result

    }


    fun calculaPotencia (base : Int, expoente : Int): Int {

        var resultado = 1

        for (i in 1..expoente) {
            resultado *= base

        }

        return resultado

    }

}