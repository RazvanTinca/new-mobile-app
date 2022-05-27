package store.razvan.prepself.presentation.discovery

import androidx.compose.foundation.layout.Box
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.viewmodel.compose.viewModel
import store.razvan.prepself.presentation.loading.LoadingViewModel
import store.razvan.prepself.ui.theme.PrepselfTheme

@Composable
fun DiscoveryScreen(viewModel: LoadingViewModel = viewModel()) {
    Box(){

    }
}

@Preview
@Composable
fun DiscoveryScreenPreview() {
    PrepselfTheme {
        DiscoveryScreen()
    }
}