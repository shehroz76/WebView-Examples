package testing.demo.app.ui.splash

import android.os.Bundle
import android.os.Handler
import android.os.Looper
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.navigation.fragment.NavHostFragment
import testing.demo.app.R
import testing.demo.app.databinding.FragmentSplashBinding

class SplashFragment : Fragment() {

    private lateinit var mViewDataBinding: FragmentSplashBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {
        mViewDataBinding = DataBindingUtil.inflate<FragmentSplashBinding>(
            inflater,
            R.layout.fragment_splash,
            container,
            false
        ).apply {
            lifecycleOwner = viewLifecycleOwner
//            this.vm = viewModel
        }
        initViews()
        return mViewDataBinding.root
    }

    private fun initViews() {
        openNextScreen()
    }

    private fun openNextScreen() {
        Handler(Looper.getMainLooper()).postDelayed({
            openHome()
        }, 3000)
    }

    private fun openHome() {
        NavHostFragment.findNavController(this@SplashFragment)
            .navigate(R.id.action_splashFragment_to_homeFragment)
    }

}