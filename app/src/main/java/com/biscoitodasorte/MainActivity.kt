package com.biscoitodasorte

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.biscoitodasorte.data.Phrases
import com.br.biscoitodasorte.R
import com.biscoitodasorte.ui.components.BannerAdd
import com.biscoitodasorte.ui.components.PhraseContainer
import com.br.biscoitodasorte.ui.theme.BiscoitoDaSorteTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)

        setContent {
            BiscoitoDaSorteTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    App()
                }
            }
        }
    }
}

@Composable
fun App() {
    val modifier: Modifier = Modifier
    val phrases = Phrases()
    val localContext = LocalContext.current

    val fortuneCookieIsBroken = remember {
        mutableStateOf(true);
    }

    val fortuneCookieImageClose = remember {
        mutableStateOf(R.drawable.biscoito_fechado)
    }

    val fortuneCookieImageOpen = remember {
        mutableStateOf(R.drawable.biscoito_aberto)
    }

    val selectedPhrase = remember {
        mutableStateOf(phrases.getRandomPhrase())
    }

    val handleChangePhrase:()->Unit = {
        selectedPhrase.value = phrases.getRandomPhrase()
    }

    val brokeFortuneCookie: ()->Unit = {
        if (!fortuneCookieIsBroken.value)
            fortuneCookieIsBroken.value = true;

        handleChangePhrase();
    }

    val resetFortuneCookie: ()->Unit = {
        if (fortuneCookieIsBroken.value)
            fortuneCookieIsBroken.value = false;

    }

    Column(modifier = modifier
        .fillMaxSize()
        .padding(horizontal = 20.dp), horizontalAlignment = Alignment.CenterHorizontally, verticalArrangement = Arrangement.Center) {

        Image(painter = painterResource(id = if (fortuneCookieIsBroken.value) fortuneCookieImageOpen.value else fortuneCookieImageClose.value),
            contentDescription = "fortune cookie",
            modifier = modifier
                .height(160.dp)
                .width(160.dp))

        if (fortuneCookieIsBroken.value){
            Spacer(modifier = modifier.height(20.dp))
            PhraseContainer(modifier = modifier, selectedPhrase = selectedPhrase.value)
        }

        Spacer(modifier = modifier.height(100.dp))
        Button(onClick = brokeFortuneCookie ) {
            Text(text = "Quebrar Biscoito")
        }
        Spacer(modifier = modifier.height(20.dp))

        if (fortuneCookieIsBroken.value)
            Button(onClick = resetFortuneCookie, colors = ButtonDefaults.buttonColors(Color(0xFFE9726A))) {
                Text(text = "Fechar Biscoito")
            }

        Spacer(modifier = modifier.height(20.dp))
        BannerAdd(modifier = modifier)
    }
}



