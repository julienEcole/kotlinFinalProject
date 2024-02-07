package com.example.kotlinfinalproject.viewModel.user

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.kotlinfinalproject.user_model.UserData
import com.example.kotlinfinalproject.repositories.UsersRepository

import io.reactivex.rxjava3.disposables.CompositeDisposable
import io.reactivex.rxjava3.kotlin.addTo
import io.reactivex.rxjava3.schedulers.Schedulers

class UserViewModel(private val usersRepo: UsersRepository) : ViewModel() {
    private val disposeBag = CompositeDisposable()
    val userListLiveData = MutableLiveData<List<UserData>>()

    init {
        getOneRandomUser()
    }

    private fun getOneRandomUser() {
        usersRepo.getRandomUser()
            .subscribeOn(Schedulers.io())
            .subscribe({ users ->
                userListLiveData.postValue(users)
            }, { error ->
                // Handle error
            })
            .addTo(disposeBag)
    }

    override fun onCleared() {
        super.onCleared()
        disposeBag.clear()
    }
}

