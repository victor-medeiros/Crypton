package com.victor.crypton.presentation

import android.icu.text.DecimalFormat
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import coil.compose.AsyncImage
import com.victor.crypton.R
import com.victor.crypton.domain.model.CryptoCoin
import com.victor.crypton.domain.util.Resource
import com.victor.crypton.ui.theme.CryptonTheme
import com.victor.crypton.ui.theme.DarkGray
import java.math.BigDecimal

@Composable
fun HomeScreen(navController: NavController, homeViewModel: HomeViewModel) {
    val cryptoCoin by homeViewModel.cryptoCoins.collectAsState()

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(MaterialTheme.colorScheme.background)
            .padding(top = 16.dp, start = 16.dp)
    ) {
        HomeHeader(userName = "Victor")
        Spacer(modifier = Modifier.height(32.dp))
        HomeScreenContent(cryptoCoins = cryptoCoin)
    }
}

@Composable
private fun HomeScreenContent(cryptoCoins: Resource<List<CryptoCoin>>) {
    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        when (cryptoCoins) {
            is Resource.Success -> {
                Text(
                    text = stringResource(id = R.string.home_market),
                    style = MaterialTheme.typography.titleMedium,
                    color = MaterialTheme.colorScheme.onBackground,
                    modifier = Modifier.fillMaxWidth()
                )
                LazyColumn(contentPadding = PaddingValues(bottom = 16.dp)) {
                    items(items = cryptoCoins.value, key = { it.id }) {
                        Spacer(modifier = Modifier.height(16.dp))
                        CryptoCoinCard(cryptoCoin = it)
                    }
                }
            }

            is Resource.Failure -> {
                Text(
                    text = cryptoCoins.errorMessage,
                    style = MaterialTheme.typography.bodyLarge
                )
            }

            else -> CircularProgressIndicator(
                modifier = Modifier
                    .size(64.dp)
                    .fillMaxSize(),
                color = MaterialTheme.colorScheme.surface,
                trackColor = MaterialTheme.colorScheme.onBackground
            )
        }
    }
}

@Composable
private fun HomeHeader(
    modifier: Modifier = Modifier,
    userName: String
) {
    Row(
        Modifier
            .fillMaxWidth()
            .then(modifier)
    ) {
        Column {
            Text(
                text = stringResource(id = R.string.home_greeting, userName),
                style = MaterialTheme.typography.titleMedium,
                color = MaterialTheme.colorScheme.onBackground,
            )
            Spacer(modifier = Modifier.height(8.dp))
            Text(
                text = stringResource(id = R.string.home_welcome),
                style = MaterialTheme.typography.bodyLarge,
                color = MaterialTheme.colorScheme.onBackground
            )
        }
    }
}

@Composable
private fun CryptoCoinCard(cryptoCoin: CryptoCoin) {
    Row(
        Modifier
            .fillMaxWidth()
            .clip(RoundedCornerShape(24.dp))
            .border(2.dp, DarkGray, shape = RoundedCornerShape(24.dp))
            .padding(16.dp),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Row(verticalAlignment = Alignment.CenterVertically) {
            AsyncImage(
                model = cryptoCoin.logo,
                contentDescription = cryptoCoin.name,
                modifier = Modifier.size(40.dp),
                placeholder = painterResource(id = R.drawable.crypto_icon_default),
                error = painterResource(id = R.drawable.crypto_icon_default)
            )
            Spacer(modifier = Modifier.width(16.dp))

            Column {
                Text(
                    text = cryptoCoin.name,
                    style = MaterialTheme.typography.bodyMedium,
                    color = MaterialTheme.colorScheme.onBackground
                )
                Spacer(modifier = Modifier.height(8.dp))
                Text(
                    text = cryptoCoin.symbol,
                    style = MaterialTheme.typography.bodySmall,
                    color = MaterialTheme.colorScheme.onBackground,
                    modifier = Modifier
                        .clip(CircleShape)
                        .background(DarkGray)
                        .padding(horizontal = 10.dp, vertical = 5.dp)
                )
            }
        }

        val formatter = DecimalFormat(stringResource(id = R.string.decimal_format))
        Text(
            text = formatter.format(cryptoCoin.currency),
            style = MaterialTheme.typography.bodyMedium,
            color = MaterialTheme.colorScheme.onBackground
        )
    }
}

@Preview(showSystemUi = true)
@Composable
fun HomeScreenPreview() {
    CryptonTheme {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .background(MaterialTheme.colorScheme.background)
                .padding(top = 16.dp, start = 16.dp)
        ) {
            HomeHeader(userName = "Victor")
            Spacer(modifier = Modifier.height(32.dp))
            HomeScreenContent(cryptoCoins = Resource.Success(cryptoCoins))
        }
    }
}

val cryptoCoins = listOf(
    CryptoCoin(
        id = 1,
        name = "Bitcoin",
        symbol = "BTC",
        currency = BigDecimal("66237.89316505895"),
        logo = "https://s2.coinmarketcap.com/static/img/coins/64x64/1.png"
    ),
    CryptoCoin(
        id = 2,
        name = "Bitcoin",
        symbol = "BTC",
        currency = BigDecimal("66237.89316505895"),
        logo = "https://s2.coinmarketcap.com/static/img/coins/64x64/1.png"
    ),
    CryptoCoin(
        id = 3,
        name = "Bitcoin",
        symbol = "BTC",
        currency = BigDecimal("66237.89316505895"),
        logo = "https://s2.coinmarketcap.com/static/img/coins/64x64/1.png"
    ),
    CryptoCoin(
        id = 4,
        name = "Bitcoin",
        symbol = "BTC",
        currency = BigDecimal("66237.89316505895"),
        logo = "https://s2.coinmarketcap.com/static/img/coins/64x64/1.png"
    ),
    CryptoCoin(
        id = 5,
        name = "Bitcoin",
        symbol = "BTC",
        currency = BigDecimal("66237.89316505895"),
        logo = "https://s2.coinmarketcap.com/static/img/coins/64x64/1.png"
    ),
    CryptoCoin(
        id = 6,
        name = "Bitcoin",
        symbol = "BTC",
        currency = BigDecimal("66237.89316505895"),
        logo = "https://s2.coinmarketcap.com/static/img/coins/64x64/1.png"
    )
)