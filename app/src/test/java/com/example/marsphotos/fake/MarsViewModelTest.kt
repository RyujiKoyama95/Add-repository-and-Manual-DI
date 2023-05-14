package com.example.marsphotos.fake

import com.example.marsphotos.fake.rules.TestDispatcherRule
import com.example.marsphotos.ui.screens.MarsUiState
import com.example.marsphotos.ui.screens.MarsViewModel
import kotlinx.coroutines.test.runTest
import org.junit.Assert.assertEquals
import org.junit.Rule
import org.junit.Test

class MarsViewModelTest {
    // @get:RuleでtestDispatcherをテストに適用する
    @get:Rule
    val testDispatcher = TestDispatcherRule()

    @Test
    fun marsViewModel_getMarsPhotos_verifyMarsUiStateSuccess() {
        runTest {
            val list = FakeNetworkMarsPhotosRepository().getMarsPhotos()
            val expectState =
                MarsUiState.Success("Success. ${list.size} Mars photos retrieved")

            val dummyRepository = FakeNetworkMarsPhotosRepository()
            val viewModel = MarsViewModel(dummyRepository)
            val resultState = viewModel.marsUiState

            assertEquals(expectState, resultState)
        }
    }
}