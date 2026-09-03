package br.gov.sp.etec.jokenpo

import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import org.w3c.dom.Text
import kotlin.random.Random
import kotlin.random.nextInt


class MainActivity : AppCompatActivity() {

    private lateinit var txtResultado : TextView
    private lateinit var imageComputador : ImageView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        imageComputador = findViewById<ImageView>(R.id.imageComputador)
        txtResultado = findViewById<TextView>(R.id.textResultado)
        val pedra = findViewById<ImageView>(R.id.imagePedra)
        pedra.setOnClickListener {
            jogar("pedra")
        }
        val tesoura = findViewById<ImageView>(R.id.imageTesoura)
        tesoura.setOnClickListener {
            jogar("tesoura")
        }
        val papel = findViewById<ImageView>(R.id.imagePapel)
        papel.setOnClickListener {
            jogar("papel")
        }
    }
    fun jogar(jogador : String){
        val opcoes = arrayOf("papel", "tesoura", "pedra")
        val computador = opcoes[Random.nextInt(until = opcoes.size)]
        when(computador){
            "papel" -> imageComputador.setImageResource(R.drawable.papel)
            "tesoura" -> imageComputador.setImageResource(R.drawable.tesoura)
            "pedra" -> imageComputador.setImageResource(R.drawable.pedra)
        }
        when{
            (jogador == computador) -> {txtResultado.text = "Empate"}
            (jogador == "pedra" && computador == "tesoura") -> {txtResultado.text = "Você Venceu"}
            (jogador == "papel" && computador == "pedra") -> {txtResultado.text = "Você Venceu"}
            (jogador == "tesoura" && computador == "papel") -> {txtResultado.text = "Você Venceu"}
            else ->{txtResultado.text = "Você Perdeu"}
        }
    }
}