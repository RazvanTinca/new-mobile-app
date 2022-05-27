package store.razvan.prepself.presentation.loading

import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.BlurredEdgeTreatment
import androidx.compose.ui.draw.blur
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import store.razvan.prepself.R
import store.razvan.prepself.ui.theme.PrepselfTheme

@Composable
fun LoadingScreen(viewModel: LoadingViewModel = viewModel(), onNavigate: () -> Unit) {
    val context = LocalContext.current

    LaunchedEffect(key1 = context) {
        viewModel.authenticationEvent.collect {
            if (it is LoadingViewModel.AuthenticationEvent.isLoggedIn) {
                onNavigate()
            }
        }
    }

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.Black),
        contentAlignment = Alignment.Center
    ) {
        Image(
            painter = painterResource(id = R.drawable.loading_bg),
            contentDescription = "loading background",
            contentScale = ContentScale.Crop,
            modifier = Modifier
                .fillMaxSize()
                .blur(7.dp, edgeTreatment = BlurredEdgeTreatment.Unbounded)
        )
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            Image(
                painter = painterResource(id = R.drawable.logo), contentDescription = "logo",
                modifier = Modifier
                    .fillMaxWidth(0.45f),
                alignment = Alignment.Center,
            )
        }
    }
}


@ExperimentalAnimationApi
@Preview(showBackground = true)
@Composable
fun LoadingScreenPreview() {
    PrepselfTheme {
        LoadingScreen(onNavigate = {})
    }
}

