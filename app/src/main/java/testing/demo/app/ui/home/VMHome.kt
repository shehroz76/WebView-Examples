package testing.demo.app.ui.home

import android.app.usage.UsageEvents
import androidx.lifecycle.MutableLiveData
import testing.demo.app.base.BaseViewModel
import testing.demo.app.utils.Event

class VMHome : BaseViewModel() {

    val urlSelectedValue = MutableLiveData("")
    val androidWebViewNavigateEvent = MutableLiveData<Event>()
    val customWebViewNavigateEvent = MutableLiveData<Event>()
    val chromeWebViewNavigateEvent = MutableLiveData<Event>()

    fun onUrlChanged(p0: CharSequence, start: Int, before: Int, count: Int) {
        urlSelectedValue.value = p0.toString()
    }

    fun navigateToWebView() {
        if (validateUrl()) {
            androidWebViewNavigateEvent.postValue(Event())
        }
    }

    fun navigateToCustomWebView() {
        if (validateUrl()) {
            customWebViewNavigateEvent.postValue(Event())
        }
    }

    fun navigateToChromeWebView() {
        if (validateUrl()) {
            chromeWebViewNavigateEvent.postValue(Event())
        }
    }

    private fun validateUrl(): Boolean {
        return urlSelectedValue.value?.isNotEmpty()!!
    }


}