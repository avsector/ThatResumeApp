package com.samsaz.thatresumeapp.aboutme

import androidx.lifecycle.MutableLiveData
import com.samsaz.shared.util.BaseViewModel
import com.samsaz.shared.util.CoroutineDispatchers
import com.samsaz.thatresumeapp.base.ui.ViewLoadingState
import com.samsaz.thatresumeapp.base.ui.ViewStateProvider
import com.samsaz.thatresumeapp.data.DataStateListener
import com.samsaz.thatresumeapp.model.AboutMe
import kotlinx.coroutines.launch
import javax.inject.Inject

class AboutMeViewModel @Inject constructor(
    dispatchers: CoroutineDispatchers,
    private val repository: AboutMeRepository
) : BaseViewModel(dispatchers), ViewStateProvider<AboutMe>, DataStateListener<AboutMe> {

    override val liveData: MutableLiveData<AboutMe> = MutableLiveData()
    override val loadingLiveData: MutableLiveData<ViewLoadingState> = MutableLiveData()

    init {
        refresh()
    }

    override fun refresh() {
        launch {
            repository.loadData(this@AboutMeViewModel)
        }
    }

    override fun onDataChange(data: AboutMe) {
        liveData.value = data
    }

    override fun onStateChange(state: ViewLoadingState) {
        loadingLiveData.value = state
    }
}