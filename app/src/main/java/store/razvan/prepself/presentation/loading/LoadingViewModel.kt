package store.razvan.prepself.presentation.loading

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.asSharedFlow
import kotlinx.coroutines.flow.receiveAsFlow
import kotlinx.coroutines.launch

class LoadingViewModel : ViewModel() {

    private val authenticationChannelEvent = MutableSharedFlow<AuthenticationEvent>()
    val authenticationEvent = authenticationChannelEvent.asSharedFlow()


    init {
        viewModelScope.launch {
            delay(200)
            authenticationChannelEvent.emit(AuthenticationEvent.isLoggedIn)
        }
    }

    sealed class AuthenticationEvent {
        object isLoggedIn : AuthenticationEvent()
        object isNotLoggedIn : AuthenticationEvent()
    }

}