package testing.demo.app.utils

import android.app.Activity
import android.content.Context
import android.content.Intent
import android.net.Uri
import android.util.DisplayMetrics
import android.util.TypedValue
import android.view.View
import android.widget.TextView
import androidx.browser.customtabs.CustomTabsIntent
import com.google.android.material.snackbar.Snackbar
import kotlin.math.roundToInt


class MethodsUtils {

    companion object {

        fun showMessage(cx: Activity, message: String) {
            val snack =
                Snackbar.make(cx.findViewById(android.R.id.content), message, Snackbar.LENGTH_LONG)
                    .apply {
                        view.findViewById<TextView>(com.google.android.material.R.id.snackbar_text).maxLines =
                            10
                        setAction("OK") {
                            dismiss()
                        }
                    }
            snack.show()
        }

        fun showSnackBar(cx: Context, message: String, view: View) {
            val snackBar =
                Snackbar.make(view, message, Snackbar.LENGTH_SHORT)
            snackBar.setAction("OK") {
                snackBar.dismiss()
            }
            snackBar.show()
        }

        fun getValueInDp(context: Context, value: Float): Int {
            return TypedValue.applyDimension(
                TypedValue.COMPLEX_UNIT_DIP,
                value,
                context.resources.displayMetrics
            )
                .roundToInt()
//            return ((context.resources.getDimension(resourceId) / context.resources
//                .displayMetrics.density).roundToInt())
        }

        fun Int.toPx(context: Context) =
            this * context.resources.displayMetrics.densityDpi / DisplayMetrics.DENSITY_DEFAULT

        fun openCustomTab(activity: Activity, customTabsIntent: CustomTabsIntent, url: String) {

            var webpage = Uri.parse(url)

            if (!url.startsWith("http://") && !url.startsWith("https://")) {
                webpage = Uri.parse("http://$url")
            }
            val packageName = "com.android.chrome"
            if (packageName != null) {

                // we are checking if the package name is not null
                // if package name is not null then we are calling
                // that custom chrome tab with intent by passing its
                // package name.
                customTabsIntent.intent.setPackage(packageName)

                // in that custom tab intent we are passing
                // our url which we have to browse.
                customTabsIntent.launchUrl(activity, webpage!!)
            } else {
                // if the custom tabs fails to load then we are simply
                // redirecting our user to users device default browser.
                activity.startActivity(Intent(Intent.ACTION_VIEW, webpage))
            }
        }

    }

}