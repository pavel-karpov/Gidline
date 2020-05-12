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
import kotlinx.android.synthetic.main.img_frag.*
import kotlinx.android.synthetic.main.merge_expansion_set.view.*
import org.jetbrains.anko.backgroundDrawable
import ru.gidline.app.R
import ru.gidline.app.local.model.Vacancy
import ru.gidline.app.screen.search.vacancies.vacancy.ExpansionLayout
import ru.gidline.app.screen.search.vacancies.vacancy.ExpansionLayoutSet

class LeftFragment :Fragment(){
    val list:List<String> = arrayListOf("Резюме может выделить вас среди других и определиться будущему работодателю, насколько вы справитесь с предлагаемой работой.",
        "В указанное время и дату наш специалист свяжется с вами. Предоставит консультацию и задаст вопросы необходимые для создания вашего резюме. Через 48 часов готовое резюме вы сможете увидеть в личном кабинете Gidline.",
        "Мы снимаем языковые барьеры, общаясь с вами на родном языке.","Наши специалисты проведут диагностику вашего резюме. Исправят орфографические, грамматические и пунктуационные ошибки допущенные при заполнении формы резюме.",
    "Вы получите рекомендации по улучшению вашего резюме на основании которых сможете внести изменения своего резюме.",
    "Ежедневно в течение 14 дней мы рассылаем ваше резюме за вас по новым вакансиям Gidline",
    "Пока другие самостоятельно просматривают вакансии - мы уже отправили ваше резюме работодателю",
    "Вы можете заниматься своими делами. Отклики на вакансии вы можете увидеть в личном кабинете Gidline в любое удобное время для вас.")
    var flag:String = ""
    var checkService:String=""
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
        val img1 = view.findViewById<ExpansionLayoutSet>(R.id.img1)
        val img2 = view.findViewById<ExpansionLayoutSet>(R.id.img2)
        val img3 = view.findViewById<ExpansionLayoutSet>(R.id.img3)
        val priceAddServ = view.findViewById<CheckBox>(R.id.check_price)
        val textAddServ = view.findViewById<TextView>(R.id.text_add_serv111)
        val textPriceServ = view.findViewById<TextView>(R.id.text_price_serv)
        val imageBtnOrder = view.findViewById<ImageButton>(R.id.imageButton2)
        val checkPrice = view.findViewById<CheckBox>(R.id.check_price)
        textQuestion.setText(arguments?.get("question").toString())
        textService.setText(arguments?.get("textService").toString())
        priceAddServ.setText(arguments?.get("priceAddServ").toString())
        textAddServ.setText(arguments?.get("textAddServ").toString())
        textPriceServ.setText(arguments?.get("priceServ").toString())
        if(textPriceServ.text.toString().get(0).equals('1')){
            img1.tv_name_ex.setText(getString(R.string.resume))
            img2.tv_text_ex.setText(getText(R.string.resume_helpws))
            img3.tv_text_ex.setText(getText(R.string.language))
            img1.updateText(list)
            img2.updateText(list)
            img3.updateText(list)
            flag="left"
        }
        else if (textPriceServ.text.toString().get(0).equals('4')){
            img1.tv_name_ex.setText(getString(R.string.resume_right))
            img2.tv_text_ex.setText(getText(R.string.resume_help))
            img3.tv_text_ex.setText(getText(R.string.language))
            img1.updateText(list)
            img2.updateText(list)
            img3.updateText(list)
            flag="center"
        }
        else if(textPriceServ.text.toString().get(0).equals('2')){
            img1.tv_name_ex.setText(getString(R.string.days))
            img2.tv_name_ex.setText(getString(R.string.first_always1))
            img3.tv_name_ex.setText(getText(R.string.economy))
            img1.updateText(list)
            img2.updateText(list)
            img3.updateText(list)
            flag="right"

        }
        checkPrice.setOnClickListener {
            if (checkPrice.isChecked) {
                if (textPriceServ.text.toString().get(0).equals('1')){
                     textPriceServ.setText("1758 "+getString(R.string.rubl))
                }
                else if (textPriceServ.text.toString().get(0).equals('4')||textPriceServ.text.toString().get(0).equals('2'))
                    { textPriceServ.setText("758 "+getString(R.string.rubl))}

            }
            else textPriceServ.setText(arguments?.get("priceServ").toString())

        }
        imageBtnOrder.setOnClickListener {
            if (checkPrice.isChecked)checkService="yes" else checkService="no"
            val intent = Intent(activity,OrderActivity::class.java)
            intent.putExtra("cost",textPriceServ.text.toString())
            intent.putExtra("flag",flag)
            intent.putExtra("service",checkService)
            startActivity(intent)
        }
        return view
    }
}