package ru.gidline.app.screen.main.view

import android.content.Intent
import android.os.Bundle
import android.widget.*
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.core.graphics.toColorInt
import ru.gidline.app.R
import ru.gidline.app.screen.main.SubscribeActivity
import kotlin.math.cos

class OrderActivity : AppCompatActivity() {

    private lateinit var toolbar: Toolbar
    private lateinit var textCommit:TextView
    private lateinit var textOf:TextView
    private lateinit var imageToolbar: ImageButton
    private lateinit var imageBtnCommit:ImageButton
    private lateinit var listChoice:ListView
    private lateinit var spinner:Spinner
    private lateinit var spinnerGraphic:Spinner
    private lateinit var arrayChoice:List<String>
    private lateinit var arraySpinner:List<String>
    private lateinit var adapter:ArrayAdapter<String>
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_order)
        val cost = intent?.getStringExtra("cost")
        listChoice = findViewById(R.id.list_choice)
        toolbar = findViewById(R.id.toolbar)
        spinner = findViewById(R.id.spinner)
        textOf = findViewById(R.id.text_oferta)
        textCommit = findViewById(R.id.text_view_commit)
        imageBtnCommit = findViewById(R.id.image_button_commit)
        spinnerGraphic = findViewById(R.id.spinner_graphic)
        imageToolbar = toolbar.findViewById(R.id.image_toolbar_arrow)
        arrayChoice = listOf("Разнорабочий","Администратор","Комплектовщик","Оператор","Продавец")
        arraySpinner = listOf("Таджикистан","Узбекистан","Киргизия")
        adapter = ArrayAdapter(this,R.layout.simple_list,arrayChoice)
        listChoice.adapter=adapter
        adapter = ArrayAdapter(this,R.layout.spinner_item,arraySpinner)
        spinner.adapter=adapter
        arraySpinner = listOf("ПОСТОЯННАЯ РАБОТА, ПОЛНЫЙ РАБОЧИЙ ДЕНЬ")
        adapter = ArrayAdapter(this,R.layout.spinner_item1,arraySpinner)
        spinnerGraphic.adapter=adapter

        cost?.let {
            textCommit.setText(it)
        }
        imageToolbar.setOnClickListener {
            finish()
        }
        imageBtnCommit.setOnClickListener {
            startActivity(Intent(this,SubscribeActivity::class.java))
        }


    }
}
