package com.cxq.mobile.ui.theme

import androidx.compose.material3.Typography
import androidx.compose.ui.text.font.FontWeight


// Set of Material typography styles to start with

private val typ = Typography()

val Typography = Typography(
    displayMedium = typ.displayMedium.copy(color = MyColor.fontBlack, fontWeight = FontWeight.SemiBold),
    displaySmall = typ.displaySmall.copy(color = MyColor.fontBlack, fontWeight = FontWeight.SemiBold),
    headlineLarge = typ.headlineLarge.copy(color = MyColor.fontBlack, fontWeight = FontWeight.SemiBold),
    headlineMedium = typ.headlineMedium.copy(color = MyColor.fontBlack, fontWeight = FontWeight.SemiBold),
    headlineSmall = typ.headlineSmall.copy(color = MyColor.fontBlack, fontWeight = FontWeight.SemiBold),
    titleLarge = typ.titleLarge.copy(color = MyColor.fontBlack, fontWeight = FontWeight.SemiBold),
    titleMedium = typ.titleMedium.copy(color = MyColor.fontBlack, fontWeight = FontWeight.SemiBold),
    titleSmall = typ.titleSmall.copy(color = MyColor.fontBlack, fontWeight = FontWeight.SemiBold),
    bodyLarge = typ.bodyLarge.copy(color = MyColor.fontBlack, fontWeight = FontWeight.SemiBold),
    bodyMedium = typ.bodyMedium.copy(color = MyColor.fontBlack, fontWeight = FontWeight.SemiBold),
    bodySmall = typ.bodySmall.copy(color = MyColor.fontBlack, fontWeight = FontWeight.SemiBold),
    labelLarge = typ.labelLarge.copy(color = MyColor.fontBlack, fontWeight = FontWeight.SemiBold),
    labelMedium = typ.labelMedium.copy(color = MyColor.fontBlack, fontWeight = FontWeight.SemiBold),
    labelSmall = typ.labelSmall.copy(color = MyColor.fontBlack, fontWeight = FontWeight.SemiBold),
)