package danbroid.webnavdemo.ui.web

import android.os.Bundle
import androidx.navigation.NavDestination
import androidx.navigation.NavOptions
import androidx.navigation.Navigator

@Navigator.Name("url")
class URLNavigator : Navigator<NavDestination>() {

  interface PopBackStackCallback {
    fun popBackStack(): Boolean
  }

  var backStackCallback: PopBackStackCallback? = null

  override fun navigate(
    destination: NavDestination,
    args: Bundle?,
    navOptions: NavOptions?,
    navigatorExtras: Extras?
  ) = destination

  override fun createDestination() = URLDestination(this)

  override fun popBackStack() = backStackCallback?.popBackStack() ?: false

  class URLDestination(navigator: URLNavigator) : NavDestination(navigator)

}

//private val log = org.slf4j.LoggerFactory.getLogger(URLNavigator::class.java)
