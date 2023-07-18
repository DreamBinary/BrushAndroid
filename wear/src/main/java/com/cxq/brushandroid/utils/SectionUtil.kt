package com.cxq.brushandroid.utils

import com.cxq.brushandroid.R
import com.cxq.brushandroid.entity.Section

object SectionUtil {
    fun getName(section: Section?): String = when (section) {

        Section.OLB -> "外左下片区"
        Section.OLT -> "外左上片区"
        Section.ILB -> "内左下片区"
        Section.ILT -> "内左上片区"
        Section.ORB -> "外右下片区"
        Section.ORT -> "外右上片区"
        Section.IRB -> "内右下片区"
        Section.IRT -> "内右上片区"
        null -> "完成"
    }

    fun getId(section: Section): Int = when (section) {
        Section.OLB -> R.drawable.sec_olb
        Section.OLT -> R.drawable.sec_olb
        Section.ILB -> R.drawable.sec_olb
        Section.ILT -> R.drawable.sec_olb
        Section.ORB -> R.drawable.sec_olb
        Section.ORT -> R.drawable.sec_olb
        Section.IRB -> R.drawable.sec_olb
        Section.IRT -> R.drawable.sec_olb
    }

    // 左右手
    fun getNext(section: Section): Section? = when (section) {
        Section.OLB -> Section.OLT
        Section.OLT -> Section.ILB
        Section.ILB -> Section.ILT
        Section.ILT -> Section.ORB
        Section.ORB -> Section.ORT
        Section.ORT -> Section.IRB
        Section.IRB -> Section.IRT
        Section.IRT -> null
    }
}