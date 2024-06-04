package com.victor.crypton.ui.theme

import androidx.compose.material3.Typography
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.googlefonts.Font
import androidx.compose.ui.text.googlefonts.GoogleFont
import androidx.compose.ui.unit.sp
import com.victor.crypton.R

// Set of Material typography styles to start with

val provider = GoogleFont.Provider(
    providerAuthority = "com.google.android.gms.fonts",
    providerPackage = "com.google.android.gms",
    certificates = R.array.com_google_android_gms_fonts_certs
)

val Poppins = GoogleFont(name = "Poppins")

val PoppinsFamily = FontFamily(
    Font(googleFont = Poppins, fontProvider = provider, weight = FontWeight.Light),
    Font(googleFont = Poppins, fontProvider = provider, weight = FontWeight.Normal),
    Font(googleFont = Poppins, fontProvider = provider, weight = FontWeight.Medium),
    Font(googleFont = Poppins, fontProvider = provider, weight = FontWeight.Bold),
)
val Typography = Typography(
    bodyLarge = TextStyle(
        fontFamily = PoppinsFamily,
        fontWeight = FontWeight.Normal,
        fontSize = 24.sp,
        lineHeight = 30.sp,
        letterSpacing = 0.9.sp
    ),
    bodyMedium = TextStyle(
        fontFamily = PoppinsFamily,
        fontWeight = FontWeight.Normal,
        fontSize = 18.sp,
        lineHeight = 24.sp,
        letterSpacing = 0.7.sp
    ),
    bodySmall = TextStyle(
        fontFamily = PoppinsFamily,
        fontWeight = FontWeight.Light,
        fontSize = 14.sp,
        lineHeight = 24.sp,
        letterSpacing = 0.5.sp
    ),
    titleLarge = TextStyle(
        fontFamily = PoppinsFamily,
        fontWeight = FontWeight.Bold,
        fontSize = 64.sp,
        lineHeight = 70.sp,
        letterSpacing = 0.9.sp

    ),
    titleMedium = TextStyle(
        fontFamily = PoppinsFamily,
        fontWeight = FontWeight.Medium,
        fontSize = 36.sp,
        lineHeight = 42.sp,
        letterSpacing = 0.7.sp
    ),
    titleSmall = TextStyle(
        fontFamily = PoppinsFamily,
        fontWeight = FontWeight.Medium,
        fontSize = 18.sp,
        lineHeight = 24.sp,
        letterSpacing = 0.5.sp
    ),
)