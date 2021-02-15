package ram.ramires.company3.adapters

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.navigation.Navigation
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import ram.ramires.company3.R
import ram.ramires.company3.data.Company
import ram.ramires.company3.databinding.ItemViewBinding
import ram.ramires.company3.utilities.BUNDLE_ARGUMENT
import ram.ramires.company3.utilities.LOG

class RecyclerViewAdapter : ListAdapter<Company, RecyclerView.ViewHolder>(CompanyDiffCallback()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return CompanyViewHolder(
            ItemViewBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        val company = getItem(position)
        (holder as CompanyViewHolder).bind(company)
        holder.itemView.setOnClickListener {
            Log.d(LOG, "Recycler Id is " + company.getId())

            var bundle= Bundle()
            bundle.putString(BUNDLE_ARGUMENT, company.getId())
            Navigation.findNavController(it).navigate(R.id.action_listFragment_to_detailFragment,bundle)

        }
    }

    class CompanyViewHolder(
        private val binding: ItemViewBinding
    ) : RecyclerView.ViewHolder(binding.root) {

        fun bind(item: Company) {
            binding.apply {
                bind = item
                executePendingBindings()
            }
        }
    }
}

private class CompanyDiffCallback : DiffUtil.ItemCallback<Company>() {

    override fun areItemsTheSame(oldItem: Company, newItem: Company): Boolean {
        return oldItem.getId().equals(newItem.getId())
    }

    override fun areContentsTheSame(oldItem: Company, newItem: Company): Boolean {
        return oldItem.equals(newItem)
    }
}
