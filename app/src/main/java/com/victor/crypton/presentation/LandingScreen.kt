package com.victor.crypton.presentation

import android.content.res.Configuration
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
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
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.victor.crypton.R
import com.victor.crypton.presentation.util.Screens
import com.victor.crypton.ui.theme.BlackTransparent35
import com.victor.crypton.ui.theme.CryptonTheme
import com.victor.crypton.ui.theme.LightGray
import com.victor.crypton.ui.theme.PrimaryDefault
import com.victor.crypton.ui.theme.PurpleDark
import com.victor.crypton.ui.theme.PurpleDarkGray
import com.victor.crypton.ui.theme.SecondaryMedium
import com.victor.crypton.ui.theme.WhiteTransparent20

@Composable
fun LandingScreen(
    navController: NavController
) {
    val largeRadialGradient: Brush = object : ShaderBrush() {
        override fun createShader(size: Size): Shader {
            val biggerDimension = maxOf(size.height, size.width)
            return RadialGradientShader(
                colors = listOf(LightGray, PurpleDark, PurpleDarkGray, Color.Black),
                center = Offset.Zero,
                radius = biggerDimension * 1.1f,
                colorStops = listOf(0f, 0.5f, 0.85f, 1f),
            )
        }
    }
    LandingContent(
        modifier = Modifier.background(largeRadialGradient),
        onButtonClick = { navController.navigate(Screens.REGISTRATION.route) }
    )
}

@Composable
private fun LandingContent(
    modifier: Modifier = Modifier,
    onButtonClick: () -> Unit = {}
) {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .then(modifier)
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
                .padding(start = 24.dp, top = 100.dp)
        ) {
            val headerText = buildAnnotatedString {
                pushStyle(SpanStyle(color = PrimaryDefault, fontWeight = FontWeight.Medium))
                append("Smart ")

                pushStyle(SpanStyle(color = Color.White, fontWeight = FontWeight.Light))
                append("Trading, ")

                pushStyle(SpanStyle(color = PrimaryDefault, fontWeight = FontWeight.Medium))
                append("Safe ")

                pushStyle(SpanStyle(color = Color.White, fontWeight = FontWeight.Light))
                append("Wallet")
            }

            val buttonGradient = Brush.horizontalGradient(listOf(LightGray, SecondaryMedium))
            Text(
                text = headerText,
                modifier = Modifier
                    .width(300.dp)
                    .padding(top = 50.dp),
                color = Color.White,
                style = MaterialTheme.typography.titleLarge
            )

            Spacer(modifier = Modifier.height(32.dp))

            TransparentButton(
                modifier = Modifier.background(buttonGradient),
                text = stringResource(id = R.string.button_get_started),
                onClick = onButtonClick
            )
        }
    }
}

@Composable
fun TransparentButton(
    modifier: Modifier = Modifier,
    text: String,
    onClick: () -> Unit = {}
) {
    Box(
        modifier = Modifier
            .height(70.dp)
            .clip(CircleShape)
            .clickable { onClick() }
            .then(modifier)
            .background(BlackTransparent35)
            .background(WhiteTransparent20)
            .clip(CircleShape)
            .padding(horizontal = 30.dp),
        contentAlignment = Alignment.Center
    ) {
        Row {
            Text(
                text = text,
                style = MaterialTheme.typography.bodyMedium,
                color = Color.White
            )
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