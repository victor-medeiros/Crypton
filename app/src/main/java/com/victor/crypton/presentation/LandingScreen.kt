package com.victor.crypton.presentation

import android.content.res.Configuration
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowForward
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RadialGradientShader
import androidx.compose.ui.graphics.Shader
import androidx.compose.ui.graphics.ShaderBrush
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.victor.crypton.R
import com.victor.crypton.presentation.util.Screens
import com.victor.crypton.ui.theme.CryptonTheme
import com.victor.crypton.ui.theme.Gray100
import com.victor.crypton.ui.theme.Gray400
import com.victor.crypton.ui.theme.Gray900
import com.victor.crypton.ui.theme.LimeGreen
import com.victor.crypton.ui.theme.Purple200
import com.victor.crypton.ui.theme.Purple700
import com.victor.crypton.ui.theme.Purple900

@Composable
fun LandingScreen(
    navController: NavController
) {
    val largeRadialGradient: Brush = object : ShaderBrush() {
        override fun createShader(size: Size): Shader {
            val biggerDimension = maxOf(size.height, size.width)
            return RadialGradientShader(
                colors = listOf(Gray400, Purple700, Purple900, Gray900),
                center = Offset.Zero,
                radius = biggerDimension * 1.1f,
                colorStops = listOf(0f, 0.5f, 0.85f, 1f),

                )
        }
    }
    Box(
        Modifier
            .fillMaxSize()
            .background(largeRadialGradient)
    ) {
        Image(
            painter = painterResource(id = R.drawable.landing_shapes),
            contentDescription = "",
            modifier = Modifier
                .align(Alignment.BottomEnd)
                .fillMaxWidth(0.65f)
        )
        Column(
            Modifier
                .padding(24.dp)
        ) {
            val headerText = buildAnnotatedString {
                pushStyle(SpanStyle(color = LimeGreen, fontWeight = FontWeight.Medium))
                append("Smart ")

                pushStyle(SpanStyle(color = Color.White, fontWeight = FontWeight.Light))
                append("Trading, ")

                pushStyle(SpanStyle(color = LimeGreen, fontWeight = FontWeight.Medium))
                append("Safe ")

                pushStyle(SpanStyle(color = Color.White, fontWeight = FontWeight.Light))
                append("Wallet")
            }
            Text(
                text = headerText,
//                fontSize = 62.sp,
                modifier = Modifier
                    .width(300.dp)
                    .padding(top = 50.dp),
                color = Gray100,
                style = MaterialTheme.typography.headlineLarge
            )

            Spacer(modifier = Modifier.height(32.dp))
            Box(
                modifier = Modifier
                    .height(90.dp)
                    .clip(CircleShape)
                    .clickable { navController.navigate(Screens.REGISTRATION.route) }
                    .border(
                        width = 2.dp,
                        brush = Brush.verticalGradient(listOf(LimeGreen, Purple200)),
                        shape = CircleShape
                    )
                    .padding(4.dp)
                    .clip(CircleShape)
                    .background(Brush.verticalGradient(listOf(Purple700, Purple900)))
                    .padding(16.dp),
                contentAlignment = Alignment.Center
            ) {
                Row {
                    Text(
                        text = "Get started",
                        style = MaterialTheme.typography.bodyLarge,
                        color = Gray100
                    )
                    Spacer(modifier = Modifier.width(16.dp))
                    Icon(
                        imageVector = Icons.Filled.ArrowForward,
                        contentDescription = "Start",
                        tint = Gray100,
                    )
                }
            }
        }
    }
}

@Preview(
    showSystemUi = true,
    uiMode = Configuration.UI_MODE_NIGHT_MASK
)
@Composable
fun LandingPreview() {
    val navController = rememberNavController()
    CryptonTheme {
        LandingScreen(navController)
    }
}