package ru.gidline.app.screen.main.view

import android.annotation.SuppressLint
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
import kotlinx.android.synthetic.main.fragment_order_right.*
import kotlinx.android.synthetic.main.fragment_order_right.view.*
import ru.gidline.app.R
import ru.gidline.app.screen.main.SubscribeActivity

class OrderFragmentLeftFull : Fragment(){
    lateinit var editTextDate: EditText
    lateinit var editTime: EditText
    var checkTelephone: CheckBox? = null
    var checkTelegram: CheckBox? = null
    var checkWatsapp: CheckBox? = null
    var checkViber: CheckBox? = null
    var checkComit: CheckBox? = null
    companion object {
        fun newInstance(cost: String?): OrderFragmentLeftFull {
            val bundle = Bundle()
            bundle.putString("cost", cost)
            val fragment = OrderFragmentLeftFull()
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
        view = inflater.inflate(R.layout.fragment_order_left_full, container, false)
        val editPhone: EditText = view.findViewById(R.id.edit_text_phone)
        editTime = view.findViewById(R.id.edit_text_time)
        val listChoice: TextView = view.findViewById(R.id.list_choice)
        val spinner: Spinner = view.findViewById(R.id.spinner)
        val textCommit: TextView = view.findViewById(R.id.text_view_commit)
        val imageBtnCommit: ImageButton = view.findViewById(R.id.image_button_commit)
        val spinnerGraphic: TextView = view.findViewById(R.id.spinner_graphic)
        editTextDate = view.findViewById(R.id.edit_text_date)
        editTextDate.isEnabled = false
        editTime.isEnabled = false
        val imageCalendar: ImageView = view.findViewById(R.id.image_calendar)
        val imageTime: ImageView = view.findViewById(R.id.image_time)
        val imageToolbar: ImageButton = view.toolbar.findViewById(R.id.image_toolbar_arrow)
        val textToolbar: TextView = view.toolbar.findViewById(R.id.text_toolbar_subscribe)
        val textSalary: TextView = view.findViewById(R.id.text_salary)
        val seekSalary: SeekBar = view.findViewById(R.id.seek_salary)
        val spinnerRegion: Spinner = view.findViewById(R.id.spinner_region)
        val editCity: Spinner = view.findViewById(R.id.edit_text_city)
        val editName: EditText = view.findViewById(R.id.edit_text_name)
        checkTelephone = view.findViewById(R.id.check_telephone)
        checkTelegram = view.findViewById(R.id.check_telegram)
        checkWatsapp = view.findViewById(R.id.check_watsapp)
        checkViber = view.findViewById(R.id.check_viber)
        checkComit = view.findViewById(R.id.check_comit)
        checkTelephone()
        var dialog: CalendarFragment
        var dialogTime: TimeFragment
        var scheduleFragment: ScheduleFragment
        var fragmentWhant: WantWorkFragment
        seekSalary.setProgress(0)
        textSalary.setText(getString(R.string.not_important))
        textToolbar.setText("ФОРМА ЗАКАЗА")
        var arraySpinner = listOf("", "Россия", "Таджикистан", "Узбекистан", "Кургызстан", "Другое")
        var adapter: ArrayAdapter<String>? =
            context?.let { ArrayAdapter(it, R.layout.spinner_item2, arraySpinner) }
        spinner.adapter = adapter
        arraySpinner =
            listOf("Разнорабочий", "Администратор", "Комплектовщик", "Оператор", "Продавец")
        adapter = context?.let { ArrayAdapter(it, R.layout.simple_list, arraySpinner) }
        arraySpinner = listOf("", "Москва и Московская область")
        adapter = context?.let { ArrayAdapter(it, R.layout.spinner_item, arraySpinner) }
        spinnerRegion.adapter = adapter
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
                if (it.isChecked.equals(false) || checBoxes().equals(false) || editName.text.length.equals(
                        0
                    ) || spinner.selectedItem.toString().length.equals(0)
                    || editPhone.text.length < 17 || editTextDate.text.length < 4 || editTime.text.length < 4 || spinnerRegion.selectedItem.toString().length < 1 || listChoice.text.length < 1
                ) {

                } else {
                    activity?.finish()
                    startActivity(Intent(activity, SubscribeActivity::class.java))
                }
            }
        }
        seekSalary.setOnSeekBarChangeListener(object : SeekBar.OnSeekBarChangeListener {
            override fun onProgressChanged(seekBar: SeekBar?, progress: Int, fromUser: Boolean) {
                if (progress >= 0 && progress < 15) {
                    textSalary.setText(getText(R.string.not_important))
                } else if (progress >= 15 && progress < 25) {
                    textSalary.setText("20000 РУБ.")
                } else if (progress >= 25 && progress < 30) {
                    textSalary.setText("25000 РУБ.")
                } else if (progress >= 30 && progress < 35) {
                    textSalary.setText("30000 РУБ.")
                } else if (progress >= 35 && progress < 40) {
                    textSalary.setText("35000 РУБ.")
                } else if (progress >= 40 && progress < 45) {
                    textSalary.setText("40000 РУБ.")
                } else if (progress >= 45 && progress < 50) {
                    textSalary.setText("45000 РУБ.")
                } else if (progress >= 50 && progress < 55) {
                    textSalary.setText("50000 РУБ.")
                } else if (progress >= 55 && progress < 60) {
                    textSalary.setText("55000 РУБ.")
                } else if (progress >= 60 && progress < 65) {
                    textSalary.setText("60000 РУБ.")
                } else if (progress >= 65 && progress < 70) {
                    textSalary.setText("65000 РУБ.")
                } else if (progress >= 70 && progress < 75) {
                    textSalary.setText("70000 РУБ.")
                } else if (progress >= 75 && progress < 80) {
                    textSalary.setText("75000 РУБ.")
                } else if (progress >= 80 && progress < 85) {
                    textSalary.setText("80000 РУБ.")
                } else if (progress >= 85 && progress < 90) {
                    textSalary.setText("85000 РУБ.")
                } else if (progress >= 90 && progress < 95) {
                    textSalary.setText("90000 РУБ.")
                } else if (progress >= 95 && progress < 100) {
                    textSalary.setText("95000 РУБ.")
                } else if (progress == 100) {
                    textSalary.setText("100000 РУБ.")
                }
            }

            override fun onStartTrackingTouch(seekBar: SeekBar?) {}
            override fun onStopTrackingTouch(seekBar: SeekBar?) {
            }
        })
        imageCalendar.setOnClickListener(object : View.OnClickListener {
            override fun onClick(v: View?) {
                dialog = CalendarFragment()
                dialog.setTargetFragment(this@OrderFragmentLeftFull, 1)
                fragmentManager?.let { dialog.show(it, "s") }
            }
        })
        imageTime.setOnClickListener(object : View.OnClickListener {
            override fun onClick(v: View?) {
                dialogTime = TimeFragment()
                dialogTime.setTargetFragment(this@OrderFragmentLeftFull, 2)
                fragmentManager?.let {
                    dialogTime.show(it, "a")
                }
            }

        })

        spinnerRegion?.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onNothingSelected(parent: AdapterView<*>?) {
            }

            override fun onItemSelected(
                parent: AdapterView<*>?,
                view: View?,
                position: Int,
                id: Long
            ) {
                if (position == 1) {
                    editCity.isEnabled = true
                    arraySpinner = listOf("Москва")
                    adapter = activity?.let { ArrayAdapter(it,R.layout.spinner_item,arraySpinner) }
                    editCity.adapter = adapter
                } else{
                    arraySpinner = listOf("")
                    adapter = activity?.let { ArrayAdapter(it,R.layout.spinner_item,arraySpinner) }
                    editCity.adapter = adapter
                }
            }
        }

        spinnerGraphic.setOnClickListener(object : View.OnClickListener {
            override fun onClick(v: View?) {
                scheduleFragment = ScheduleFragment()
                scheduleFragment.setTargetFragment(this@OrderFragmentLeftFull, 3)
                fragmentManager?.let {
                    scheduleFragment.show(it, "c")
                }
            }
        })
        listChoice.setOnClickListener(View.OnClickListener {
            fragmentWhant = WantWorkFragment()
            fragmentWhant.setTargetFragment(this@OrderFragmentLeftFull, 4)
            fragmentManager?.let {
                fragmentWhant.show(it, "d")
            }
        })
        return view
    }

    @SuppressLint("SetTextI18n")
    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (resultCode.equals(Activity.RESULT_OK) && requestCode.equals(1)) {
            val day = data!!.extras!!.get("day")
            val month = data!!.extras!!.get("month")
            val year = data!!.extras!!.get("year")
            editTextDate!!.setText(day.toString() + "." + month + "." + year)

        } else if (resultCode.equals(Activity.RESULT_OK) && requestCode.equals(2)) {
            data?.getSerializableExtra("time")?.let {
                editTime.setText(data?.getSerializableExtra("time").toString().drop(1).dropLast(1))
            }
            //editTime.setText(data?.getSerializableExtra("time").toString().drop(1).dropLast(1))
        } else if (resultCode.equals(Activity.RESULT_OK) && requestCode.equals(3)) {
            spinner_graphic.setText(data?.getStringExtra("key_work"))
        } else if (resultCode.equals(Activity.RESULT_OK) && requestCode.equals(4)) {
            val text: ArrayList<String>? =
                data?.getSerializableExtra("workList") as ArrayList<String>?
            val workList: String? = data?.getStringExtra("editWorkList")
            list_choice.setText("")
            if (workList.equals("")) {
                if (text?.size!! > 0) {
                    for (item in text) {
                        list_choice.append(item)
                    }
                }
            } else {
                list_choice.setText(workList.toString().toUpperCase() + "\n")
                if (text?.size!! > 0) {
                    for (item in text) {
                        list_choice.append(item)
                    }
                }

            }
        }
    }
    fun checBoxes(): Boolean {
        if ((checkTelephone!!.isChecked) || (checkTelegram!!.isChecked) || (checkWatsapp!!.isChecked) || (checkViber!!.isChecked)) return true
        else return false
    }
    fun checkTelephone(): Unit {
        if (checkTelephone?.isChecked == false) checkTelephone?.isChecked = true
    }


}