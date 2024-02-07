package com.example.kotlinfinalproject.view.Profil

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.example.kotlinfinalproject.databinding.FragmentProfilBinding
import com.example.kotlinfinalproject.repositories.UsersRepository
import com.example.kotlinfinalproject.viewModel.user.UserViewModel

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
        userViewModel = ViewModelProvider(this, UserViewModelFactory(UsersRepository())).get(UserViewModel::class.java)

        // Observe LiveData
        userViewModel.randomUserLiveData.observe(viewLifecycleOwner) { user ->
            setUserInformation(user)
        }

        // Trigger ViewModel to fetch random user
        userViewModel.fetchRandomUser()
    }

    private fun setUserInformation(user: UserData) {
        binding.apply {
            userNameTv.text = user.name
            userLastnameTv.text = user.lastName
            userEmailTv.text = user.mail
            userPhoneTv.text = user.phoneNumber
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}