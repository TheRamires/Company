package ram.ramires.company3

import androidx.databinding.ObservableField
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import ram.ramires.company3.data.Company
import ram.ramires.company3.data.Repository

class MyViewModel(val repo: Repository) : ViewModel() {
    var list: MutableLiveData<List<Company>> = MutableLiveData()
    var detail: ObservableField<Company> = ObservableField()

    fun requestList() {
        // launch a coroutine in viewModelScope
        viewModelScope.launch(Dispatchers.IO) {
            repo.requestList(list)
            // slowFetch()
        }
    }
    fun requestDeatail(id: String){
        viewModelScope.launch(Dispatchers.IO){
            repo.requestDetail(id, detail)
        }
    }
}