package testing.demo.app.ui.custom_webview

import android.content.Context
import android.util.AttributeSet
import android.webkit.WebView
import android.view.LayoutInflater

class MyWebView : WebView {
    constructor(context: Context) : super(context) {
        initView(context)
    }

    constructor(context: Context, attrs: AttributeSet?) : super(context, attrs) {
        initView(context)
    }

    fun initView(context: Context) {
        this.settings.javaScriptEnabled = true
        this.settings.useWideViewPort = true
        this.settings.loadWithOverviewMode = true
        this.settings.domStorageEnabled = true
    }
}