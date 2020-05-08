package ru.gidline.app.screen.main.view

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.CheckBox
import android.widget.ImageButton
import android.widget.TextView
import android.widget.Toast
import androidx.fragment.app.Fragment
import org.jetbrains.anko.backgroundDrawable
import ru.gidline.app.R

class LeftFragment :Fragment(){
    companion object{
        fun newInstance(question:String?,
                        textService:String?,
                        textImgBtn1:String,
                        textImgBtn2:String,
                        textImgBtn3: String,
                        priceAddServ:String,
                        textAddServ:String,
                        priceServ:String):LeftFragment{
            val bundle = Bundle()
            bundle.putString("question",question)
            bundle.putString("textService",textService)
            bundle.putString("textImgBtn1",textImgBtn1)
            bundle.putString("textImgBtn2",textImgBtn2)
            bundle.putString("textImgBtn3",textImgBtn3)
            bundle.putString("priceAddServ",priceAddServ)
            bundle.putString("textAddServ",textAddServ)
            bundle.putString("priceServ",priceServ)
            val fragment = LeftFragment()
            fragment.arguments=bundle
            return fragment
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view:View = inflater.inflate(R.layout.img_frag,container,false)
        val textQuestion:TextView = view.findViewById(R.id.textview_question)
        val textService = view.findViewById<TextView>(R.id.textview_serv)
        val img1 = view.findViewById<TextView>(R.id.img1)
        val img2 = view.findViewById<TextView>(R.id.img2)
        val img3 = view.findViewById<TextView>(R.id.img3)
        val priceAddServ = view.findViewById<CheckBox>(R.id.check_price)
        val textAddServ = view.findViewById<TextView>(R.id.text_add_serv111)
        val textPriceServ = view.findViewById<TextView>(R.id.text_price_serv)
        val imageBtnOrder = view.findViewById<ImageButton>(R.id.imageButton2)
        val checkPrice = view.findViewById<CheckBox>(R.id.check_price)
        val textImg1 = view.findViewById<TextView>(R.id.text_img1)
        val textImg2 = view.findViewById<TextView>(R.id.text_img2)
        val textImg3 = view.findViewById<TextView>(R.id.text_img3)
        textQuestion.setText(arguments?.get("question").toString())
        textService.setText(arguments?.get("textService").toString())
        img1.setText(arguments?.get("textImgBtn1").toString())
        img2.setText(arguments?.get("textImgBtn2").toString())
        img3.setText(arguments?.get("textImgBtn3").toString())
        priceAddServ.setText(arguments?.get("priceAddServ").toString())
        textAddServ.setText(arguments?.get("textAddServ").toString())
        textPriceServ.setText(arguments?.get("priceServ").toString())
        if(textPriceServ.text.toString().get(0).equals('4') || textPriceServ.text.toString().get(0).equals('2') ){
            textImg1.setCompoundDrawablesWithIntrinsicBounds(R.drawable.arrow_down,0,0,0)
            textImg2.setCompoundDrawablesWithIntrinsicBounds(R.drawable.arrow_down,0,0,0)
            textImg3.setCompoundDrawablesWithIntrinsicBounds(R.drawable.arrow_down,0,0,0)

        }
        checkPrice.setOnClickListener {
            if (checkPrice.isChecked) {
                when (textPriceServ.text.toString().get(0)){
                    '1'-> textPriceServ.setText("1758 "+getString(R.string.rubl))
                    '4','2'-> textPriceServ.setText("758 "+getString(R.string.rubl))
                }
            }
            else textPriceServ.setText(arguments?.get("priceServ").toString())

        }
        imageBtnOrder.setOnClickListener {
            val intent = Intent(activity,OrderActivity::class.java)
            intent.putExtra("cost",textPriceServ.text.toString())
            startActivity(intent)
        }
        return view
    }
}