package danbroid.webnavdemo.ui.web

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.webkit.WebView
import android.webkit.WebViewClient
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import danbroid.webnavdemo.NavUrlArgs
import danbroid.webnavdemo.R

class WebBrowserFragment : Fragment(), URLNavigator.PopBackStackCallback {

  lateinit var webView: WebView

  val args: WebBrowserFragmentArgs by navArgs()

  val urlNavigator
    get() = findNavController().navigatorProvider.getNavigator(URLNavigator::class.java)

  override fun popBackStack() = if (webView.canGoBack()) {
    webView.goBack()
    true
  } else false

  override fun onCreateView(
    inflater: LayoutInflater,
    container: ViewGroup?,
    savedInstanceState: Bundle?
  ) = WebView(context).also {
    webView = it
  }

  override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
    log.info("onViewCreated()")

    webView.webViewClient = object : WebViewClient() {

      override fun shouldOverrideUrlLoading(view: WebView?, url: String): Boolean {
        log.trace("shouldOverrideUrlLoading() $url")

        findNavController().navigate(R.id.nav_url, NavUrlArgs(url).toBundle())

        return false
      }

      override fun onPageFinished(view: WebView, url: String) {
        if (!isResumed) return

        log.trace("onPageFinished() $url")

        activity?.also {
          (it as AppCompatActivity).supportActionBar?.title = webView.title
        }

      }
    }

    urlNavigator.backStackCallback = this

    if (savedInstanceState == null)
      webView.loadUrl(args.url)
    else
      webView.restoreState(savedInstanceState)
  }

  override fun onSaveInstanceState(outState: Bundle) {
    super.onSaveInstanceState(outState)
    webView.saveState(outState)
  }

  override fun onDetach() {
    super.onDetach()
    urlNavigator.backStackCallback = null
  }
}

private val log = org.slf4j.LoggerFactory.getLogger(WebBrowserFragment::class.java)
