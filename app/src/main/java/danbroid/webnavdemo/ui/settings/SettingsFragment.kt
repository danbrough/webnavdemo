package danbroid.webnavdemo.ui.settings

import android.os.Bundle
import androidx.preference.PreferenceFragmentCompat
import danbroid.webnavdemo.R

class SettingsFragment : PreferenceFragmentCompat() {

  override fun onCreatePreferences(savedInstanceState: Bundle?, rootKey: String?) {
    setPreferencesFromResource(R.xml.root_preferences, rootKey)
  }


}

private val log = org.slf4j.LoggerFactory.getLogger(SettingsFragment::class.java)
