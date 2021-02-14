package ram.ramires.company3

import android.os.Bundle
import android.util.Log
import android.view.*
import androidx.appcompat.app.ActionBar
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.navigation.Navigation
import org.koin.android.viewmodel.ext.android.viewModel
import ram.ramires.company3.databinding.FragmentDetailBinding
import ram.ramires.company3.utilities.BUNDLE_ARGUMENT


class DetailFragment : Fragment() {
    val myViewModel: MyViewModel by viewModel()
    //lateinit var myView: View
    //lateinit var id: String

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        var id = arguments?.getString(BUNDLE_ARGUMENT).toString()
        Log.d("myLog", "Company id is " + id)
        id?.let { myViewModel.requestDeatail(id) }

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        /*val binding = DataBindingUtil.inflate<FragmentDetailBinding>(
            inflater,
            R.layout.fragment_detail,
            container,
            false
        ).apply {
            lifecycleOwner = viewLifecycleOwner

            toolbar.setOnMenuItemClickListener { item ->
                when (item.itemId) {
                    R.id.action_back -> {
                        view?.let { Navigation.findNavController(it).popBackStack() }
                        true
                    }
                    else -> false
                }
            }
        }*/

       val binding= FragmentDetailBinding.inflate(inflater, container, false)
        binding.lifecycleOwner=this
        binding.detail=myViewModel
        binding.toolbar.setOnMenuItemClickListener { item ->
            when(item.itemId){
                R.id.action_back->{
                    view?.let{
                        Navigation.findNavController(it).popBackStack()
                    }
                    true
                }
                else->false
            }
        }
        setHasOptionsMenu(true)

        return binding.root
    }

    /*override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        inflater.inflate(R.menu.menu_back, menu)
        return super.onCreateOptionsMenu(menu, inflater)
    }*/

   /* override fun onOptionsItemSelected(item: MenuItem): Boolean {
        Log.d("myLog", "toolbar Item selected " + item.itemId)
        when(item){
            Navigation.findNavController(myView).popBackStack()
        }
        return super.onOptionsItemSelected(item)
    }*/
}

