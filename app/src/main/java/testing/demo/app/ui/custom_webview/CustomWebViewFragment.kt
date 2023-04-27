package testing.demo.app.ui.custom_webview

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import testing.demo.app.R
import testing.demo.app.databinding.FragmentCustomWebViewBinding
import testing.demo.app.ui.webview.WebViewFragment
import testing.demo.app.utils.MyBrowser

class CustomWebViewFragment : Fragment() {

    private lateinit var mViewDataBinding: FragmentCustomWebViewBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {
        mViewDataBinding = DataBindingUtil.inflate<FragmentCustomWebViewBinding>(
            inflater,
            R.layout.fragment_custom_web_view,
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