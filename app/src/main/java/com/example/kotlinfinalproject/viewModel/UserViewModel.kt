package com.example.kotlinfinalproject.viewModel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.kotlinfinalproject.user_model.UserData
import com.example.kotlinfinalproject.repositories.UsersRepository
import io.reactivex.rxjava3.disposables.CompositeDisposable
import io.reactivex.rxjava3.kotlin.addTo
import io.reactivex.rxjava3.schedulers.Schedulers
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers

import android.util.Log
import androidx.lifecycle.LiveData
import com.example.kotlinfinalproject.db.AppDatabase
import com.example.kotlinfinalproject.db.provider.DatabaseProvider

class UserViewModel(private val usersRepo: UsersRepository) : ViewModel() {
    private val disposeBag = CompositeDisposable()
    val userLiveData: LiveData<UserData> = MutableLiveData()

    init {
        getOneRandomUser()
    }

    private fun getOneRandomUser() {
        usersRepo.getRandomUser()
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe({ user ->
                (userLiveData as MutableLiveData).value = user
            }, { error ->
                Log.e("UserViewModel", "Error fetching user: ${error.message}")
            })
            .addTo(disposeBag)
    }

    override fun onCleared() {
        super.onCleared()
        disposeBag.clear()
    }
}
