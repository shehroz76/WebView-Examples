package testing.demo.app.utils

import android.webkit.WebView
import android.webkit.WebViewClient

class MyBrowser : WebViewClient() {
    override fun shouldOverrideUrlLoading(view: WebView, url: String): Boolean {
        view.loadUrl(url)
        return true
    }
}
