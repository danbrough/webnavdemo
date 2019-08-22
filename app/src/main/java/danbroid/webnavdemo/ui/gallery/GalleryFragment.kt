package danbroid.webnavdemo.ui.gallery

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.navigation.fragment.findNavController
import danbroid.webnavdemo.R
import danbroid.webnavdemo.ui.tree.TreeFragmentDirections
import kotlinx.android.synthetic.main.fragment_gallery.*

class GalleryFragment : Fragment() {

  private lateinit var galleryViewModel: GalleryViewModel

  override fun onCreateView(
    inflater: LayoutInflater,
    container: ViewGroup?,
    savedInstanceState: Bundle?
  ): View? {
    galleryViewModel =
      ViewModelProviders.of(this).get(GalleryViewModel::class.java)
    val root = inflater.inflate(R.layout.fragment_gallery, container, false)
    val textView: TextView = root.findViewById(R.id.text_gallery)
    galleryViewModel.text.observe(this, Observer {
      textView.text = it
    })
    return root
  }

  override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
    button_tree.setOnClickListener {
      findNavController().navigate(TreeFragmentDirections.actionGlobalNavTree("From the Gallery"))
    }
  }
}