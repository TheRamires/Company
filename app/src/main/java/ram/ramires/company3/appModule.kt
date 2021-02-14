package ram.ramires.company3

import org.koin.android.ext.koin.androidContext
import org.koin.android.viewmodel.dsl.viewModel
import org.koin.dsl.module
import ram.ramires.company3.adapters.GeoJCoder
import ram.ramires.company3.api.CompanyService
import ram.ramires.company3.data.*


val appModule = module {
    single { CompanyService.create()}
    single<Repository> { CompanyRepositoriy(get(), geoJCoder= GeoJCoder(androidContext()))}
    // MyViewModel ViewModel
    viewModel { MyViewModel(get()) }
}

