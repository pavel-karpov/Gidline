package ru.gidline.app.screen.main.view

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import ru.gidline.app.R

class OrderActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_order)
        val orderConatiner: Fragment?
        val cost = intent?.getStringExtra("cost")
        val flag: String? = intent?.getStringExtra("flag")
        val service: String? = intent?.getStringExtra("service")
        if (flag != null) {
            if (flag.equals("center")) {
                if (service.equals("no")){
                    orderConatiner = supportFragmentManager.findFragmentById(R.id.order_container)
                       if (orderConatiner == null) {
                          supportFragmentManager.beginTransaction().add(R.id.order_container, OrderFragmentCenter.newInstance(cost)).commit()
                    }
                }
                else if (service.equals("yes")){
                    orderConatiner = supportFragmentManager.findFragmentById(R.id.order_container)
                    if (orderConatiner == null) {
                        supportFragmentManager.beginTransaction().add(R.id.order_container, OrderFragmenCenterFull.newInstance(cost)).commit()
                    }
                }

            } else if (flag.equals("left")) {
                if (service.equals("no")) {
                    orderConatiner = supportFragmentManager.findFragmentById(R.id.order_container)
                    if (orderConatiner == null) {
                        supportFragmentManager.beginTransaction()
                            .add(R.id.order_container, OrderFragmentLeft.newInstance(cost)).commit()
                    }
                }
                else if (service.equals("yes")){
                    orderConatiner = supportFragmentManager.findFragmentById(R.id.order_container)
                    if (orderConatiner == null) {
                        supportFragmentManager.beginTransaction().add(R.id.order_container, OrderFragmentLeftFull.newInstance(cost)).commit()
                    }
                }
            } else if (flag.equals("right")) {
                if (service.equals("no")) {
                    orderConatiner = supportFragmentManager.findFragmentById(R.id.order_container)
                    if (orderConatiner == null) {
                        supportFragmentManager.beginTransaction()
                            .add(R.id.order_container, OrderFragmentRight.newInstance(cost))
                            .commit()
                    }
                }
                else if (service.equals("yes")){
                    orderConatiner = supportFragmentManager.findFragmentById(R.id.order_container)
                    if (orderConatiner == null) {
                        supportFragmentManager.beginTransaction().add(R.id.order_container, FragmentOrderRightFull.newInstance(cost)).commit()
                    }
                }
            }
        }
    }
}

        /*
        listChoice = findViewById(R.id.list_choice)
        toolbar = findViewById(R.id.toolbar)
        spinner = findViewById(R.id.spinner)
        textOf = findViewById(R.id.text_oferta)
        textCommit = findViewById(R.id.text_view_commit)
        imageBtnCommit = findViewById(R.id.image_button_commit)
        spinnerGraphic = findViewById(R.id.spinner_graphic)
        imageToolbar = toolbar.findViewById(R.id.image_toolbar_arrow)
        editPhone = findViewById(R.id.edit_text_phone)
        arrayChoice = listOf("Разнорабочий","Администратор","Комплектовщик","Оператор","Продавец")
        arraySpinner = listOf("","Россия","Таджикистан","Узбекистан","Кургызстан","Другое")
        adapter = ArrayAdapter(this,R.layout.simple_list,arrayChoice)
        listChoice.adapter=adapter
        adapter = ArrayAdapter(this,R.layout.spinner_item,arraySpinner)
        spinner.adapter=adapter
        arraySpinner = listOf("ПОСТОЯННАЯ РАБОТА, ПОЛНЫЙ РАБОЧИЙ ДЕНЬ")
        adapter = ArrayAdapter(this,R.layout.item_spinner_caps,arraySpinner)
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
        val phoneFormat = "+7([000]) [000]-[00]-[00]"
        val affineFormats = listOf(
            "+992 [000]-[00]-[00]",
            "+998 [000]-[00]-[00]",
            "+996 [000]-[00]-[00]"
        )
        MaskedTextChangedListener.installOn(editPhone, phoneFormat, affineFormats)

*/

