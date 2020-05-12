package ru.gidline.app.screen.main

import android.content.Context
import android.content.Intent
import android.content.res.Resources
import android.graphics.Color
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageButton
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import ru.gidline.app.R
import ru.gidline.app.local.model.Purchases

class SubscribeActivity : AppCompatActivity() {
    private lateinit var mRecyclerPurchases:RecyclerView
    private lateinit var mLayoutManager:RecyclerView.LayoutManager
    private lateinit var mAdapter:RecyclerAdapter
    private lateinit var imageBack:ImageButton
    private lateinit var toolbar:Toolbar
    private lateinit var imageBtnLeft:ImageButton
    private lateinit var imageBtnCenter:ImageButton
    private lateinit var imageBtnRight:ImageButton
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_subscribe)
        toolbar = findViewById(R.id.toolbar)
        imageBtnLeft = findViewById(R.id.image_btn_left)
        imageBtnCenter = findViewById(R.id.image_btn_center)
        imageBtnRight = findViewById(R.id.image_btn_rigth)
        mRecyclerPurchases = findViewById(R.id.recycler_purchases)
        imageBack = toolbar.findViewById(R.id.image_toolbar_arrow)
        mLayoutManager = LinearLayoutManager(this)
        mRecyclerPurchases.layoutManager = mLayoutManager
        val items = listOf<Purchases>(Purchases(R.drawable.mailing_96,"НАСТРОИТЬ ОТПРАВКУ РЕЗЮМЕ","Действует до 14.04.2020",R.drawable.background_inwork,"259","оплачено"),
            Purchases(R.drawable.resume_check_96,"ОТПРАВИТЬ РЕЗЮМЕ НА ПРОВЕРКУ","В работе до 16.01.2020",R.drawable.background_inwork,"499","оплачено"),
            Purchases(R.drawable.create_resume_96,"ЗАКАЗАТЬ ГОТОВОЕ РЕЗЮМЕ","Исполнено  21.02.2020",R.drawable.chec_96,"1499","оплачено"),
            Purchases(R.drawable.mailing_96,"НАСТРОИТЬ ОТПРАВКУ РЕЗЮМЕ","Исполнено 14.01.2020",R.drawable.chec_96,"259","оплачено")
        )
        mAdapter = RecyclerAdapter(items,this)
        mRecyclerPurchases.adapter=mAdapter
        imageBack.setOnClickListener(View.OnClickListener {finish()})
        imageBtnLeft.setOnClickListener(View.OnClickListener {
            intent = Intent(this,DetailPurchaseActivity::class.java)
            intent.putExtra("imageLeft","left")
            startActivity(intent)
        })
        imageBtnCenter.setOnClickListener(View.OnClickListener {
            intent = Intent(this,DetailPurchaseActivity::class.java)
            intent.putExtra("imageLeft","center")
            startActivity(intent)
        })
        imageBtnRight.setOnClickListener(View.OnClickListener {
            intent = Intent(this,DetailPurchaseActivity::class.java)
            intent.putExtra("imageLeft","right")
            startActivity(intent)
        })
    }
}



private class RecyclerAdapter(var items: List<Purchases>,var context:Context): RecyclerView.Adapter<RecyclerAdapter.RecyclerHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerHolder
        = RecyclerHolder(LayoutInflater.from(parent.context).inflate(R.layout.item_purchases,parent,false))



    override fun getItemCount(): Int {
        return items.size
    }

    override fun onBindViewHolder(holder: RecyclerHolder, position: Int) {
        holder.bind(items[position])
       holder.constraint_item.setOnClickListener {
           val intent = Intent(context,DetailPurchaseActivity::class.java)
           intent.putExtra("textData",items[position].textData)
           intent.putExtra("textPrice",items[position].textPrice)
           intent.putExtra("textAction",items[position].textAction)
           context.startActivity(intent) }

    }

  inner class RecyclerHolder(v:View): RecyclerView.ViewHolder(v) {
       val constraint_item = v.findViewById<ConstraintLayout>(R.id.item_constraint_id)
      private val imageId = v.findViewById<ImageView>(R.id.image_id)
      private val textAction = v.findViewById<TextView>(R.id.text_action)
      private val textData = v.findViewById<TextView>(R.id.text_data)
      private val imageAction = v.findViewById<ImageView>(R.id.image_action)
      private val textPrice = v.findViewById<TextView>(R.id.text_price)
      private val textPurchase = v.findViewById<TextView>(R.id.text_purchase)
       fun bind(item: Purchases){
            imageId.setImageResource(item.imageId)
            textAction.text = item.textAction
            textData.text = item.textData
           if (item.textData.get(0).toString().equals("И")){
               textData.setTextColor(Color.parseColor("#4D872687"))
           }
            item.imageAction?.let {
                imageAction.setImageResource(it)
            }
            textPrice.text = item.textPrice
            textPurchase.text = item.textPurchase
            textPrice.append(" "+context.getString(R.string.rubl))
       }

    }

}


