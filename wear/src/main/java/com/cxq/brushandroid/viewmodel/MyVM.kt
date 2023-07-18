package com.cxq.brushandroid.viewmodel

import androidx.lifecycle.ViewModel
import com.cxq.brushandroid.entity.Section

class MyVM: ViewModel() {
    private var _section: Section = Section.OLB
    var section: Section
        get() = _section
        set(value) {
            _section = value
        }
}