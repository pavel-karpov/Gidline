package ru.gidline.app.screen.main.view

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*
import androidx.appcompat.widget.Toolbar
import androidx.fragment.app.Fragment
import com.redmadrobot.inputmask.MaskedTextChangedListener
import kotlinx.android.synthetic.main.fragment_order_right.view.*
import ru.gidline.app.R
import ru.gidline.app.screen.main.SubscribeActivity

class OrderFragmentCenter : Fragment() {
    var checkTelephone:CheckBox? = null
    var checkTelegram:CheckBox? = null
    var checkWatsapp:CheckBox? = null
    var checkViber:CheckBox? = null
    var checkComit:CheckBox?=null
    companion object {
        fun newInstance(cost: String?): OrderFragmentCenter {
            val bundle = Bundle()
            bundle.putString("cost", cost)
            val fragment = OrderFragmentCenter()
            fragment.arguments = bundle
            return fragment
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        var view: View? = null
        val cost: String
        val context: Context? = getContext()
        view = inflater.inflate(R.layout.fragment_order_center, container, false)
        val editName:EditText = view.findViewById(R.id.edit_text_name_center)
        val editPhone: EditText = view.findViewById(R.id.edit_text_phone_center)
        val spinner: Spinner = view.findViewById(R.id.spinner_center)
        val textCommit: TextView = view.findViewById(R.id.text_view_commit_center)
        val imageBtnCommit: ImageButton = view.findViewById(R.id.image_button_commit_center)
        val toolbar:Toolbar = view.findViewById(R.id.toolbar)
        val textToolbar:TextView = view.toolbar.findViewById(R.id.text_toolbar_subscribe)
        val imageToolbar:ImageButton = toolbar.findViewById(R.id.image_toolbar_arrow)
        checkTelephone = view.findViewById(R.id.check_telephone_center)
        checkTelegram = view.findViewById(R.id.check_telegram_center)
        checkWatsapp = view.findViewById(R.id.check_watsapp_center)
        checkViber = view.findViewById(R.id.check_viber_center)
        checkComit = view.findViewById(R.id.check_comit_center)
        checkTelephone()
        textToolbar.setText("ФОРМА ЗАКАЗА")
        var arraySpinner = listOf("", "Россия", "Таджикистан", "Узбекистан", "Кургызстан", "Другое")
        var adapter: ArrayAdapter<String>? =
            context?.let { ArrayAdapter(it, R.layout.spinner_item2, arraySpinner) }
        spinner.adapter = adapter
        cost = arguments?.get("cost").toString()
        val phoneFormat = "+7([000]) [000]-[00]-[00]"
        val affineFormats = listOf(
            "+992 [000]-[00]-[00]",
            "+998 [000]-[00]-[00]",
            "+996 [000]-[00]-[00]"
        )
        MaskedTextChangedListener.installOn(editPhone, phoneFormat, affineFormats)
        imageToolbar.setOnClickListener {
            activity?.finish()
        }
        cost?.let {
            textCommit.setText(it)
        }
        imageBtnCommit.setOnClickListener {
            checkComit?.let {
                if (it.isChecked.equals(false)||checBoxes().equals(false)||editName.text.length.equals(0)||spinner.selectedItem.toString().length.equals(0)||editPhone.text.length<17){

                }
                else {
                    activity?.finish()
                    startActivity(Intent(activity, SubscribeActivity::class.java))
                }
            }
        }
        imageToolbar.setOnClickListener {
            activity?.finish()
        }

        return view

    }
    fun checBoxes():Boolean{
        if ((checkTelephone!!.isChecked)||(checkTelegram!!.isChecked)||(checkWatsapp!!.isChecked)||(checkViber!!.isChecked)) return true
        else return false
    }
    fun checkTelephone():Unit{
        if (checkTelephone?.isChecked==false) checkTelephone?.isChecked=true
    }
}