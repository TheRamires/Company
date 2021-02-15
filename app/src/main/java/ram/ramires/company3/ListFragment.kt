package ram.ramires.company3

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import org.koin.android.viewmodel.ext.android.viewModel
import ram.ramires.company3.adapters.RecyclerViewAdapter
import ram.ramires.company3.databinding.FragmentListBinding
import ram.ramires.company3.data.Company
import ram.ramires.company3.utilities.LOG


class ListFragment : Fragment() {
    val myViewModel: MyViewModel by viewModel()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        myViewModel.requestList()

        val binding = FragmentListBinding.inflate(inflater, container, false)
        context ?: return binding.root

        val adapter = RecyclerViewAdapter()
        binding.list.adapter = adapter
        subscribeUi(adapter)
        // Inflate the layout for this fragment
        return binding.root
    }

    private fun subscribeUi(adapter: RecyclerViewAdapter) {
        myViewModel.list.observe(viewLifecycleOwner) { list ->
            Log.d(LOG, "RecyclerViewList is  " + list.size)
            adapter.submitList(list)
        }
    }
}