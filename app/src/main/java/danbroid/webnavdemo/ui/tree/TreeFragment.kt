package danbroid.webnavdemo.ui.tree

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import danbroid.webnavdemo.R
import danbroid.webnavdemo.ui.settings.SettingsFragmentDirections
import kotlinx.android.synthetic.main.fragment_tree.*

class TreeFragment : Fragment() {

  val args: TreeFragmentArgs by navArgs()

  override fun onCreateView(
    inflater: LayoutInflater,
    container: ViewGroup?,
    savedInstanceState: Bundle?
  ) = inflater.inflate(R.layout.fragment_tree, container, false)


  override fun onViewCreated(view: View, savedInstanceState: Bundle?) {

    text_title.text = args.title

    button_a.setOnClickListener {
      findNavController().navigate(TreeFragmentDirections.actionGlobalNavTree("${args.title}/A"))
    }

    button_b.setOnClickListener {
      findNavController().navigate(TreeFragmentDirections.actionGlobalNavTree("${args.title}/B"))
    }

    button_bottom.setOnClickListener {
      findNavController().navigate(SettingsFragmentDirections.actionGlobalNavSettings())
    }

    button_web.setOnClickListener {
      findNavController().navigate(R.id.nav_web)
    }
  }
}