package ram.ramires.company3

import android.content.Intent.getIntent
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import org.koin.android.viewmodel.ext.android.viewModel
import ram.ramires.company3.databinding.FragmentDetailBinding
import ram.ramires.company3.utilities.BUNDLE_ARGUMENT

class DetailFragment : Fragment() {
    val myViewModel: MyViewModel by viewModel()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding= FragmentDetailBinding.inflate(inflater, container, false)
        binding.lifecycleOwner=this
        binding.detail=myViewModel

        return binding.root
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val id: String? = arguments?.getString(BUNDLE_ARGUMENT)
        Log.d("myLog","Company id is "+id)

        id?.let { myViewModel.requestDeatail(id) }
    }
}