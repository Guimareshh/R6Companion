package com.guimaraes.lucien.home

import android.view.ViewGroup
import androidx.constraintlayout.widget.ConstraintLayout
import com.lucienguimaraes.arch.ArchViewHolder

class HomeViewHolder(
    rootView: ViewGroup
) : ArchViewHolder<ConstraintLayout, HomeViewModel, HomeInputs, HomeOutputs>(
    rootView,
    R.layout.layout_home
) {

    override fun bindOutputs() {

    }
}