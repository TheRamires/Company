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
import ram.ramires.company3.data.Company
import ram.ramires.company3.databinding.FragmentDetailBinding
import ram.ramires.company3.utilities.BUNDLE_ARGUMENT
import ram.ramires.company3.utilities.LOG


class DetailFragment : Fragment() {
    val myViewModel: MyViewModel by viewModel()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        var id = arguments?.getString(BUNDLE_ARGUMENT).toString()
        Log.d(LOG, "Company id is " + id)
        id?.let { myViewModel.requestDeatail(id) }

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

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
}

