package com.example.kotlinfinalproject.view.Profil

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.kotlinfinalproject.R
import com.example.kotlinfinalproject.user_model.UserData

class ProfilAdapter : RecyclerView.Adapter<ProfilAdapter.UserViewHolder>() {

    private lateinit var userActuel : UserData

    inner class UserViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val userNameTV: TextView = itemView.findViewById(R.id.user_name_tv)
        val userLastnameTV: TextView = itemView.findViewById(R.id.user_lastname_tv)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UserViewHolder {
        val itemView = LayoutInflater.from(parent.context)
            .inflate(R.layout.fragment_profil, parent, false)
        return UserViewHolder(itemView)
    }

    override fun getItemCount(): Int {
        return 1
    }

    override fun onBindViewHolder(holder: UserViewHolder, position: Int) {
        //val currentUser = userList[position]
        holder.userNameTV.text = userActuel.name
        holder.userLastnameTV.text = userActuel.lastName
    }

    /*override fun getItemCount(): Int {
        return userList.size
    }*/

    fun setActualUser(user: UserData) {
        this.userActuel = user
        notifyItemChanged(R.id.user_name_tv)    //evenement disant que le first name a changer
        notifyItemChanged(R.id.user_lastname_tv)//evenement disant que le last name a changer
    }
}
