package com.cxq.brushandroid.viewmodel

import androidx.lifecycle.ViewModel
import com.cxq.brushandroid.entity.Section

class MyVM: ViewModel() {
    init {
        reset()
    }

    private lateinit var _section: Section
    var section: Section
        get() = _section
        set(value) {
            _section = value
        }

    fun reset() {
        _section = Section.OLB
    }
}