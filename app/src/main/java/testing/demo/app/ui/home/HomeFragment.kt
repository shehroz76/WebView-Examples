package testing.demo.app.ui.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.browser.customtabs.CustomTabsIntent
import androidx.core.content.ContextCompat
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.NavHostFragment
import testing.demo.app.R
import testing.demo.app.databinding.FragmentHomeBinding
import testing.demo.app.utils.MethodsUtils.Companion.openCustomTab


class HomeFragment : Fragment() {

    private lateinit var mViewDataBinding: FragmentHomeBinding

    private val viewModel by lazy {
        ViewModelProvider(this).get(VMHome::class.java)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {
        mViewDataBinding = DataBindingUtil.inflate<FragmentHomeBinding>(
            inflater,
            R.layout.fragment_home,
            container,
            false
        ).apply {
            lifecycleOwner = viewLifecycleOwner
            this.vm = viewModel
        }
        initViews()
        return mViewDataBinding.root
    }

    private fun initViews() {
        viewModel.androidWebViewNavigateEvent.observe(viewLifecycleOwner) {
            if (it.handle()) openAndroidWebView()
        }
        viewModel.customWebViewNavigateEvent.observe(viewLifecycleOwner) {
            if (it.handle()) openCustomWebView()
        }
        viewModel.chromeWebViewNavigateEvent.observe(viewLifecycleOwner) {
            if (it.handle()) openChromeWebView()
        }
    }

    private fun openChromeWebView() {
        val customIntent = CustomTabsIntent.Builder()

        customIntent.setToolbarColor(ContextCompat.getColor(requireContext(),
            R.color.purple_200))

        openCustomTab(requireActivity(),
            customIntent.build(),
            viewModel.urlSelectedValue.value.toString())
    }


    private fun openCustomWebView() {
        val bundle = Bundle()
        bundle.putString("myUrl", viewModel.urlSelectedValue.value.toString())
        NavHostFragment.findNavController(this@HomeFragment)
            .navigate(R.id.action_homeFragment_to_customWebViewFragment,bundle)
    }

    private fun openAndroidWebView() {
        val bundle = Bundle()
        bundle.putString("myUrl", viewModel.urlSelectedValue.value.toString())
        NavHostFragment.findNavController(this@HomeFragment)
            .navigate(R.id.action_homeFragment_to_webViewFragment,bundle)
    }

}