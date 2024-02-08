package com.example.kotlinfinalproject.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.bumptech.glide.Glide
import com.example.kotlinfinalproject.R
import com.example.kotlinfinalproject.databinding.FragmentProfilBinding
import com.example.kotlinfinalproject.db.AppDatabase
import com.example.kotlinfinalproject.db.provider.DatabaseProvider
import com.example.kotlinfinalproject.viewModel.UserViewModel
import com.example.kotlinfinalproject.user_model.UserData

class ProfilFragment : Fragment() {

    private var _binding: FragmentProfilBinding? = null
    private val binding get() = _binding!!

    private lateinit var userViewModel: UserViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentProfilBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // Initialize ViewModel
        userViewModel = ViewModelProvider(this)[UserViewModel::class.java]

        // Observe LiveData for userList
        userViewModel.userLiveData.observe(viewLifecycleOwner) { user ->
            setUserInformation(user)
        }
    }

    private fun setUserInformation(user: UserData) {    //utiliser Glide pour import le drawable représentant l'image utilisateur
        binding.userLastnameTv.text = user.userLastName
        binding.userNameTv.text = user.userName
        binding.userEmailTv.text = user.userMail
        binding.userPhoneTv.text = user.phoneNumber
        Glide.with(this)
            .load(R.drawable.recipe_card_example_image) // Replace "your_image" with the name of your drawable resource
            .into(binding.userPictureIv)

    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

}