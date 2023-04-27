package testing.demo.app.base

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.FragmentManager
import androidx.lifecycle.ViewModel

open class BaseViewModel: ViewModel() {
    var VMTAG = this.javaClass.canonicalName

    var ctx: Context?= null

    val fm by lazy {
        (ctx as AppCompatActivity).supportFragmentManager
    }

    var childFM: FragmentManager? = null


    fun setContext(context: Context?){
        this.ctx = context
    }

    open fun onBackPressed() {
        if (ctx != null) {
//            Tools.hideKeyboard((ctx as AppCompatActivity))
        }
        fm?.popBackStack()
    }

    open fun hideKeyboard(){
        if (ctx != null) {
//            Tools.hideKeyboard((ctx as AppCompatActivity))
        }
    }

    open fun getArrayListFromArray(resource: Int): ArrayList<String> {
        var arraylist = ArrayList<String>()
        (ctx as AppCompatActivity).resources.getStringArray(resource).forEach {
         arraylist.add(it)
        }
        return arraylist
    }

    override fun onCleared() {
        super.onCleared()
    }
}