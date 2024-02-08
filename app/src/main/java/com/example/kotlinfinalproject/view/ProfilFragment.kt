package com.example.kotlinfinalproject.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.example.kotlinfinalproject.databinding.FragmentProfilBinding
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
        userViewModel = ViewModelProvider(this).get(UserViewModel::class.java)

        // Observe LiveData for userList
        userViewModel.userLiveData.observe(viewLifecycleOwner) { user ->
            setUserInformation(user)
        }
    }

    private fun setUserInformation(user: UserData) {
        binding.userLastnameTv.text = user.userLastName
        binding.userNameTv.text = user.userName
        binding.userEmailTv.text = user.userMail
        binding.userPhoneTv.text = user.phoneNumber
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

}