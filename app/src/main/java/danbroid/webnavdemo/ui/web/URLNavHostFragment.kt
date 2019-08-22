package danbroid.webnavdemo.ui.web

import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.plusAssign

class URLNavHostFragment : NavHostFragment() {
  override fun onCreateNavController(navController: NavController) {
    super.onCreateNavController(navController)
    navController.navigatorProvider += URLNavigator()
  }
}

//private val log = org.slf4j.LoggerFactory.getLogger(URLNavHostFragment::class.java)

