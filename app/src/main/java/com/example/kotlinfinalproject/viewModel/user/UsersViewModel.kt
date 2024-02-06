package com.example.kotlinfinalproject.viewModel.user

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.kotlinfinalproject.user_model.userDto
import com.example.kotlinfinalproject.user_model.UserData
import com.example.kotlinfinalproject.repositories.UsersRepository

import io.reactivex.rxjava3.core.Observable
import io.reactivex.rxjava3.disposables.CompositeDisposable
import io.reactivex.rxjava3.kotlin.Observables
import io.reactivex.rxjava3.kotlin.addTo
import io.reactivex.rxjava3.kotlin.subscribeBy
import io.reactivex.rxjava3.schedulers.Schedulers
import io.reactivex.rxjava3.subjects.BehaviorSubject
import io.reactivex.rxjava3.subjects.PublishSubject
import kotlin.random.Random

class UsersViewModel(
    private val usersRepo: UsersRepository,
): ViewModel() {

    private val disposeBag = CompositeDisposable()


    // Observables used by the view model to get the users infos only
    private val usersData: BehaviorSubject<List<UserData>> = BehaviorSubject.createDefault(listOf())

    // Observable exposed to the view to get the final data
    val completeUsersList: MutableLiveData<List<userDto>> = MutableLiveData()

    var currentUserId: String = "-1"

    init {
        //
        //this.getUsersInfosAndConversation(1, 2)
        this.getFixedSizeOfRandomUsers(1)
    }
    //Je sais pas a quoi ca sert
    private fun getFixedSizeOfRandomUsers(count: Int) {
        this.usersRepo.getRandomListOfUsers(count).subscribe({ users ->
            //usersLiveData.postValue(users)
            this.usersData.onNext(users)
        }, { error ->
            Log.d("Error in function getFixedSizeOfRandomUsers while fetching data from Fake API",
                error.message ?: "Default message error"
            )
        }).addTo(disposeBag)
    }

/*
    fun getUsersInfos(usersToFetch: Int) {
        this.getConversations(usersToFetch) {
            Log.d("Conversations loaded", "Loaded $usersToFetch random conversations")
        }
        this.getFixedSizeOfRandomUsers(usersToFetch)
        Observables
            .combineLatest(this.usersData, this.usersConversations)
            .observeOn(Schedulers.io())
            .subscribeBy {(users, conversations) ->
                val completeUsersMappedData = users.zip(conversations) { userInfos, conversation ->
                    userDto(userInfos, conversation)
                }
                this.completeUsersList.postValue(completeUsersMappedData)
            }.let {
                this.disposeBag.add(it)
            }
    }

 */

}