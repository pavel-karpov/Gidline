package ru.gidline.app.screen.main.categories
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import okio.utf8Size
import org.w3c.dom.Text
import ru.gidline.app.R

class DetailPurchaseExFragment : Fragment() {

    companion object {
        fun newInstance( data:String?,price:String?,action:String?): DetailPurchaseExFragment {
            val bundle = Bundle()
            bundle.putString("textData",data)
            bundle.putString("textPrice",price)
            bundle.putString("textAction",action)
            val nds =  price?.toFloat()
            nds?.times(0.2)?.let { bundle.putDouble("nds", it) }
            val fragment =
                DetailPurchaseExFragment()
            fragment.arguments=bundle
            return fragment
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view:View = inflater.inflate(R.layout.fragment_detail_purchase_executed,container,false)
        val textData:TextView = view.findViewById(R.id.cost_status_name_ex)
        val textPrice:TextView = view.findViewById(R.id.order_cost_name_ex)
        val textNds:TextView = view.findViewById(R.id.nds_order_name_ex)
        val btnTextService:TextView = view.findViewById(R.id.btn_newslatter_ex)
        val numberEx:TextView = view.findViewById(R.id.text_number_zakaz_ex)
        val dataCostEx:TextView = view.findViewById(R.id.data_cost_name_ex)
        textData.setText(arguments?.get("textData").toString().dropLast(12))
        textPrice.setText(arguments?.get("textPrice").toString())
        textPrice.append(" "+getString(R.string.rubl))
        if (arguments?.get("nds").toString().length>7){ textNds.setText(arguments?.get("nds").toString().dropLast(13))}
        else { textNds.setText(arguments?.get("nds").toString())}
        textNds.append(" "+getString(R.string.rubl))
        btnTextService.setText(arguments?.get("textAction").toString())
        if (arguments?.get("textAction").toString().equals("НАСТРОИТЬ ОТПРАВКУ РЕЗЮМЕ")) {
            numberEx.setText(getString(R.string.number_order_1))
            dataCostEx.setText(getString(R.string.december_31))
            btnTextService.setText(getString(R.string.message))
        }
        else if (arguments?.get("textAction").toString().equals("ОТПРАВИТЬ РЕЗЮМЕ НА ПРОВЕРКУ")){
            numberEx.setText(getString(R.string.number_order_2))
            btnTextService.setText(getString(R.string.check_resume))
        }
        else if (arguments?.get("textAction").toString().equals("ЗАКАЗАТЬ ГОТОВОЕ РЕЗЮМЕ")){
            numberEx.setText(getString(R.string.number_order_3))
            dataCostEx.setText(getString(R.string.fabruary_19))
            btnTextService.setText(getString(R.string.order_resume))
        }
        return view
    }

}

