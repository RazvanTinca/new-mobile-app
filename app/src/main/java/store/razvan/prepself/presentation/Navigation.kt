package store.razvan.prepself.presentation

import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.runtime.Composable
import com.google.accompanist.navigation.animation.AnimatedNavHost
import com.google.accompanist.navigation.animation.composable
import com.google.accompanist.navigation.animation.rememberAnimatedNavController
import store.razvan.prepself.presentation.discovery.DiscoveryScreen
import store.razvan.prepself.presentation.loading.LoadingScreen
import store.razvan.prepself.presentation.utils.Routes

@ExperimentalAnimationApi
@Composable
fun Navigation() {
    val navController = rememberAnimatedNavController()
    AnimatedNavHost(navController = navController, startDestination = Routes.loadingScreenRoute) {
        composable(route = Routes.discoveryScreenRoute) {
            DiscoveryScreen()
        }

        composable(route = Routes.loadingScreenRoute) {
            LoadingScreen(onNavigate = {
                navController.navigate(Routes.discoveryScreenRoute) {
                    launchSingleTop = true
                }
            })
        }
    }
}
