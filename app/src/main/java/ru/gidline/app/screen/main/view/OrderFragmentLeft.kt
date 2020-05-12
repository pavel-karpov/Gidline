package ru.gidline.app.screen.main.view

import android.app.Activity
import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*
import androidx.fragment.app.Fragment
import com.redmadrobot.inputmask.MaskedTextChangedListener
import kotlinx.android.synthetic.main.fragment_order_left.*
import kotlinx.android.synthetic.main.fragment_order_right.view.*
import kotlinx.android.synthetic.main.fragment_order_right.view.check_telephone
import ru.gidline.app.R
import ru.gidline.app.screen.main.SubscribeActivity

class OrderFragmentLeft : Fragment() {
    var checkTelephone:CheckBox? = null
    var checkTelegram:CheckBox? = null
    var checkWatsapp:CheckBox? = null
    var checkViber:CheckBox? = null
    var checkComit:CheckBox?=null
    lateinit var editTime: EditText
    lateinit var editTextDate:EditText
    companion object {
        fun newInstance(cost: String?): OrderFragmentLeft {
            val bundle = Bundle()
            bundle.putString("cost", cost)
            val fragment = OrderFragmentLeft()
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
        view = inflater.inflate(R.layout.fragment_order_left, container, false)
        val editPhone: EditText = view.findViewById(R.id.edit_text_phone)
        val spinner: Spinner = view.findViewById(R.id.spinner)
        val textCommit: TextView = view.findViewById(R.id.text_view_commit)
        val imageBtnCommit: ImageButton = view.findViewById(R.id.image_button_commit)
        val imageToolbar: ImageButton = view.toolbar.findViewById(R.id.image_toolbar_arrow)
        val imageCalendar: ImageView = view.findViewById(R.id.image_calendar)
        val imageTime: ImageView = view.findViewById(R.id.image_time)
        val textToolbar:TextView = view.toolbar.findViewById(R.id.text_toolbar_subscribe)
        val editName:EditText = view.findViewById(R.id.edit_text_name)
        checkTelephone = view.findViewById(R.id.check_telephone)
        checkTelegram = view.findViewById(R.id.check_telegram)
        checkWatsapp = view.findViewById(R.id.check_watsapp)
        checkViber = view.findViewById(R.id.check_viber)
        editTime = view.findViewById(R.id.edit_text_time)
        editTextDate = view.findViewById(R.id.edit_text_date)
        checkComit = view.findViewById(R.id.check_comit)
        checkTelephone()
        var dialog: CalendarFragment
        var dialogTime: TimeFragment
        textToolbar.setText("ФОРМА ЗАКАЗА")
        var arraySpinner = listOf("", "Россия", "Таджикистан", "Узбекистан", "Кургызстан", "Другое")
        var adapter: ArrayAdapter<String>? =
            context?.let { ArrayAdapter(it, R.layout.spinner_item, arraySpinner) }
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
               if (it.isChecked.equals(false)||checBoxes().equals(false)||editName.text.length.equals(0)||spinner.selectedItem.toString().length.equals(0)
                   ||editPhone.text.length<17||editTextDate.text.length<4||editTime.text.length<4){

               }
                else {
                   activity?.finish()
                   startActivity(Intent(activity, SubscribeActivity::class.java))
               }
            }

        }
        imageCalendar.setOnClickListener(object : View.OnClickListener {
            override fun onClick(v: View?) {
                dialog = CalendarFragment()
                dialog.setTargetFragment(this@OrderFragmentLeft, 1)
                fragmentManager?.let { dialog.show(it, "s") }
            }
        })
        imageTime.setOnClickListener(object : View.OnClickListener {
            override fun onClick(v: View?) {
                dialogTime = TimeFragment()
                dialogTime.setTargetFragment(this@OrderFragmentLeft, 2)
                fragmentManager?.let {
                    dialogTime.show(it, "a")
                }
            }

        })
        return view
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (resultCode.equals(Activity.RESULT_OK) && requestCode.equals(1)) {
            val day = data!!.extras!!.get("day")
            val month = data!!.extras!!.get("month")
            val year = data!!.extras!!.get("year")
            editTextDate!!.setText(day.toString() + "." + month + "." + year)

        } else if (resultCode.equals(Activity.RESULT_OK) && requestCode == 2) {
            data?.getSerializableExtra("time")?.let {
                editTime.setText(data?.getSerializableExtra("time").toString().drop(1).dropLast(1))
            }
        }
    }
    fun checBoxes():Boolean{
        if ((checkTelephone!!.isChecked)||(checkTelegram!!.isChecked)||(checkWatsapp!!.isChecked)||(checkViber!!.isChecked)) return true
        else return false
    }
    fun checkTelephone():Unit{
        if (checkTelephone?.isChecked==false) checkTelephone?.isChecked=true
    }
}