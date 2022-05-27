package store.razvan.prepself

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.animation.ExperimentalAnimationApi
import store.razvan.prepself.presentation.Navigation
import store.razvan.prepself.ui.theme.PrepselfTheme

@ExperimentalAnimationApi
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            PrepselfTheme {
                Navigation()
            }
        }
    }
}
