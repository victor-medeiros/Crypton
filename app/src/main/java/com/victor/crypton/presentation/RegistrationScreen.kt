package com.victor.crypton.presentation

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Close
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.focus.FocusRequester
import androidx.compose.ui.focus.focusRequester
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.victor.crypton.R
import com.victor.crypton.presentation.util.Screens
import com.victor.crypton.ui.theme.CryptonTheme
import com.victor.crypton.ui.theme.PrimaryDefault
import com.victor.crypton.ui.theme.PrimaryLight

@Composable
fun RegistrationScreen(
    navController: NavController
) {
    var userName by remember { mutableStateOf("") }
    val focusRequester = remember {
        FocusRequester()
    }
    val textStyle = MaterialTheme.typography.titleMedium.copy(
        color = MaterialTheme.colorScheme.onBackground,
        textAlign = TextAlign.Center
    )
    Column(
        Modifier
            .fillMaxSize()
            .background(MaterialTheme.colorScheme.background)
            .padding(16.dp),
    ) {
        IconButton(onClick = { navController.popBackStack() }) {
            Icon(
                imageVector = Icons.Filled.Close,
                contentDescription = "Back",
                tint = MaterialTheme.colorScheme.onBackground,
                modifier = Modifier.size(32.dp)
            )
        }

        Text(
            text = stringResource(id = R.string.registration_title),
            color = MaterialTheme.colorScheme.onBackground,
            style = MaterialTheme.typography.titleMedium
        )

        Spacer(modifier = Modifier.height(100.dp))

        BasicTextField(
            value = userName,
            onValueChange = { userName = it },
            textStyle = textStyle,
            cursorBrush = SolidColor(MaterialTheme.colorScheme.onBackground),
            modifier = Modifier
                .fillMaxWidth(0.8f)
                .background(Color.Transparent)
                .align(Alignment.CenterHorizontally)
                .focusRequester(focusRequester),
        )

        Spacer(modifier = Modifier.weight(1f))

        PrimaryButton(
            text = stringResource(id = R.string.button_confirm),
            onClick = { navController.navigate(Screens.HOME.route) }
        )
    }
    LaunchedEffect(Unit) {
        focusRequester.requestFocus()
    }
}

@Composable
fun PrimaryButton(
    modifier: Modifier = Modifier,
    text: String,
    color: Brush = Brush.verticalGradient(listOf(PrimaryDefault, PrimaryLight)),
    onClick: () -> Unit = {}
) {
    Box(
        modifier = Modifier
            .clickable { onClick() }
            .clip(CircleShape)
            .background(color)
            .fillMaxWidth()
            .height(70.dp)
            .then(modifier),
    ) {
        Text(
            text = text,
            color = MaterialTheme.colorScheme.onPrimary,
            style = MaterialTheme.typography.titleSmall,
            modifier = Modifier.align(Alignment.Center),
        )
    }
}

@Preview(showSystemUi = true)
@Composable
fun RegistrationScreenPreview() {
    val navController = rememberNavController()
    CryptonTheme {
        RegistrationScreen(navController)
    }
}