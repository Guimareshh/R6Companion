package com.guimaraes.lucien.home

import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flowOf

class HomeViewModel(
) : HomeOutputs {

    override val users: Flow<List<Repo>> = flowOf(listOf(Repo("MyNewRepo"), Repo("MyNewRepo 2")))

    override val title: Flow<String> = flowOf("This is my favorite app of the Citadel")
}

interface HomeOutputs {
    val users: Flow<List<Repo>>
    val title: Flow<String>
}