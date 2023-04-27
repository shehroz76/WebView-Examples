package testing.demo.app.ui.webview

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.webkit.WebView
import android.webkit.WebViewClient
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import testing.demo.app.R
import testing.demo.app.databinding.FragmentWebViewBinding
import testing.demo.app.utils.MyBrowser


class WebViewFragment : Fragment() {

    private lateinit var mViewDataBinding:FragmentWebViewBinding


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {
        mViewDataBinding = DataBindingUtil.inflate<FragmentWebViewBinding>(
            inflater,
            R.layout.fragment_web_view,
            container,
            false
        ).apply {
            lifecycleOwner = viewLifecycleOwner
        }
        initViews()
        return mViewDataBinding.root
    }

    private fun initViews() {
        mViewDataBinding.webView.setWebViewClient(MyBrowser())
        mViewDataBinding.webView.getSettings().setLoadsImagesAutomatically(true)
        mViewDataBinding.webView.getSettings().setJavaScriptEnabled(true)
        mViewDataBinding.webView.setScrollBarStyle(View.SCROLLBARS_INSIDE_OVERLAY)


        var url = arguments?.getString("myUrl")
        if (!url!!.startsWith("http://") && !url!!.startsWith("https://")) {
            url = "http://$url"
        }
        mViewDataBinding.webView.loadUrl(url)
    }

}