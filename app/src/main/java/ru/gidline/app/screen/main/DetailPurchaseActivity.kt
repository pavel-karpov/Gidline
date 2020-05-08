package ru.gidline.app.screen.main

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.ImageButton
import android.widget.TextView
import androidx.appcompat.widget.Toolbar
import androidx.fragment.app.Fragment
import ru.gidline.app.R
import ru.gidline.app.screen.main.categories.DetailPurchaseExFragment
import ru.gidline.app.screen.main.categories.DetailPurchaseFragment
import ru.gidline.app.screen.main.view.LeftFragment

class DetailPurchaseActivity : AppCompatActivity() {
    private lateinit var toolbar: Toolbar
    private lateinit var btnBack:ImageButton
    private lateinit var str:String

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail_purchase)
        toolbar = findViewById(R.id.toolbar)
        val textToolbar:TextView = toolbar.findViewById(R.id.text_toolbar_subscribe)
        val textData:String? = intent.getStringExtra("textData")
        val textPrice:String? = intent.getStringExtra("textPrice")
        val textAction:String?=intent.getStringExtra("textAction")
        val left:String?=intent.getStringExtra("imageLeft")
        var fragContainer: Fragment?
        left?.let {
            if (it.equals("left")) {
                fragContainer = supportFragmentManager.findFragmentById(R.id.detail_container)
                if (fragContainer == null) {
                    supportFragmentManager.beginTransaction().add(
                        R.id.detail_container, LeftFragment.newInstance(
                            "НУЖНА ПОМОЩЬ С РЕЗЮМЕ?",
                            "Проведём удаленное интервью на родном языке и подготовим вам готовое резюме.",
                            "Готовое резюме за 48 часов",
                            "Помощь в составлении резюме",
                            "Резюме на русском языке",
                            "+259 "+getString(R.string.rubl),
                            "Добавить автоматическую рассылку резюме по базе вакансий Gidline на 14 дней",
                            "1499 "+getString(R.string.rubl)
                        )
                    ).commit()
                }
                textToolbar.setText("ЗАКАЗАТЬ РЕЗЮМЕ")

            }
            else if (it.equals("center")){
                fragContainer = supportFragmentManager.findFragmentById(R.id.detail_container)
                if (fragContainer == null) {
                    supportFragmentManager.beginTransaction().add(
                        R.id.detail_container, LeftFragment.newInstance(
                            "НЕ УВЕРЕНЫ В ПРАВИЛЬНОСТИ ЗАПОЛНЕНИЯ ФОРМЫ РЕЗЮМЕ?",
                            "Проверим правильность заполнения формы, грамматику и офрографию.",
                            "Грамотное резюме за 24 часа",
                            "Помощь в составлении резюме",
                            "Резюме на русском языке",
                            "+259 "+getString(R.string.rubl),
                            "Добавить автоматическую рассылку резюме по базе вакансий Gidline на 14 дней",
                            "499 "+getString(R.string.rubl)
                        )
                    ).commit()
                }
                textToolbar.setText("ПРОВЕРИТЬ РЕЗЮМЕ")
            }
            else if (it.equals("right")){
                fragContainer = supportFragmentManager.findFragmentById(R.id.detail_container)
                if (fragContainer == null) {
                    supportFragmentManager.beginTransaction().add(
                        R.id.detail_container, LeftFragment.newInstance(
                            "ХОТИТЕ ЧТОБЫ РАБОТА НАШЛА ВАС САМА?",
                            "Настроим автоматическую рассылку вашего резюме по базе вакансий Gidline.",
                            "14 дней сервис работает на Вас",
                            "Вы всегда будете первым",
                            "Экономия времени на поиск",
                            "+499 "+getString(R.string.rubl),
                            "Добавить проверку Вашего резюме",
                            "259 "+getString(R.string.rubl)
                        )
                    ).commit()
                }
                textToolbar.setText("НАСТРОИТЬ РАССЫЛКУ")
            }
        }
        textData?.let {
            str = it.toString()
            if (str[0].toString().equals("Д")||str[0].toString().equals("В")) {
                fragContainer =  supportFragmentManager.findFragmentById(R.id.detail_container)
                if (fragContainer==null){
                  // DetailPurchaseFragment.newInstance(textData,textPrice)
                    supportFragmentManager.beginTransaction().add(R.id.detail_container,
                        DetailPurchaseFragment.newInstance(textData,textPrice,textAction)).commit()
                }
            }
            else if (str[0].toString().equals("И")){
                fragContainer =  supportFragmentManager.findFragmentById(R.id.detail_container)
                if (fragContainer==null){
                    // DetailPurchaseFragment.newInstance(textData,textPrice)
                    supportFragmentManager.beginTransaction().add(R.id.detail_container,
                        DetailPurchaseExFragment.newInstance(textData,textPrice,textAction)).commit()
                }
            }
        }
        btnBack = findViewById(R.id.image_toolbar_arrow)
        btnBack.setOnClickListener(View.OnClickListener {
            finish()
        })
        }
    }

