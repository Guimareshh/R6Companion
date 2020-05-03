package com.guimaraes.lucien.home

class HomeInteractorImpl(
    homeRepository: HomeRepository,
    private val dismissCallback: () -> Unit
) : HomeInteractor {

}

interface HomeInteractor : HomeInputs {
}



interface HomeInputs