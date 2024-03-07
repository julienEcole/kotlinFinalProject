package com.example.kotlinfinalproject.viewModel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.kotlinfinalproject.model.User
import com.example.kotlinfinalproject.repositories.UsersRepository
import io.reactivex.rxjava3.disposables.CompositeDisposable
import io.reactivex.rxjava3.kotlin.addTo
import io.reactivex.rxjava3.schedulers.Schedulers

import android.util.Log
import kotlinx.coroutines.DelicateCoroutinesApi
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class UserViewModel(private val usersRepo: UsersRepository) : ViewModel() {
    private val disposeBag = CompositeDisposable()
    val userLiveData: MutableLiveData<User> = MutableLiveData()

    init {
        observeUserData()
    }

    @OptIn(DelicateCoroutinesApi::class)
    private fun observeUserData() {
        GlobalScope.launch(Dispatchers.IO) {
            usersRepo.getRandomUser()
                .subscribeOn(Schedulers.io())
                .observeOn(Schedulers.io())
                .subscribe({ user ->
                    this@UserViewModel.userLiveData.postValue(user)
                }, { error ->
                    Log.e("UserViewModel", "Error fetching user: ${error.message}")
                })
                .addTo(disposeBag)
        }
    }

    override fun onCleared() {
        super.onCleared()
        disposeBag.clear()
    }
}
