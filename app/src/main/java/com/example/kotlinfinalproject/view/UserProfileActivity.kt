package com.example.kotlinfinalproject.view

import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.bumptech.glide.Glide
import com.example.kotlinfinalproject.R
import com.example.kotlinfinalproject.di.injectDependencies
import com.example.kotlinfinalproject.viewModel.UserViewModel
import com.example.kotlinfinalproject.model.User
import org.koin.android.ext.android.inject

class UserProfileActivity : AppCompatActivity() {

    private val userViewModel: UserViewModel by inject()
    private lateinit var userPictureIv: ImageView
    private lateinit var userNameTv: TextView
    private lateinit var userLastnameTv: TextView
    private lateinit var userEmailTv: TextView
    private lateinit var userPhoneTv: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.fragment_profil)

        this.bindViews()
        this.observeUserData()
    }

    private fun bindViews() {
        this.userPictureIv = findViewById(R.id.user_picture_iv)
        this.userNameTv = findViewById(R.id.user_name_tv)
        this.userLastnameTv = findViewById(R.id.user_lastname_tv)
        this.userEmailTv = findViewById(R.id.user_email_tv)
        this.userPhoneTv = findViewById(R.id.user_phone_tv)
    }

    private fun observeUserData() {
        userViewModel.userLiveData.observe(this@UserProfileActivity) { user ->
            setUserInformation(user)
        }
    }

    private fun setUserInformation(user: User) {    //utiliser Glide pour import le drawable représentant l'image utilisateur
        this.userLastnameTv.text = user.userLastName
        this.userNameTv.text = user.userName
        this.userEmailTv.text = user.userMail
        this.userPhoneTv.text = user.phoneNumber
        Glide.with(this)
            .load(R.drawable.recipe_card_example_image) // Replace "your_image" with the name of your drawable resource
            .into(this.userPictureIv)
    }
}