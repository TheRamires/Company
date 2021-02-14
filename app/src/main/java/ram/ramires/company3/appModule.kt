package ram.ramires.company3

import org.koin.android.viewmodel.dsl.viewModel
import org.koin.dsl.module
import ram.ramires.company3.api.CompanyService
import ram.ramires.company3.data.*


val appModule = module {

    single { CompanyService.create()}
    single { AppDatabase.getInstance(get()).getDao() }
    single<Repository> { CompanyRepositoriy(get(), get()) }
    // MyViewModel ViewModel
    viewModel { MyViewModel(get()) }
}