package com.example.kotlinfinalproject.view.Profil

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.kotlinfinalproject.user_model.userDto
import com.example.kotlinfinalproject.R
import com.example.kotlinfinalproject.user_model.FakeUserDto

class ProfilAdapter(
    val users: List<userDto>
): RecyclerView.Adapter<ProfilAdapter.UserConversationCellViewHolder>() {

    /**
     *  This function is called to create all of the visible cells
     *  It is called when a new cell is appearing while another is disappearing
     */
    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): UserConversationCellViewHolder {
        val conversationCellView = LayoutInflater
            .from(parent.context)
            .inflate(R.layout.fragment_profil, parent, false)
        return UserConversationCellViewHolder(conversationCellView)
    }

    /**
     * This function is called before all others to get the size of the complete list
     */
    override fun getItemCount(): Int {
        return users.count()
    }

    /**
     * This function is called to bind the generated view holder with a dto at a certain position in the list
     */
    override fun onBindViewHolder(holder: UserConversationCellViewHolder, position: Int) {
        val currentUser = this.users[position]
        holder.bind(currentUser)
    }

    /**
     * This class represents the visible cell that will be bind with a DTO (Data Transfer Object)
     */
    inner class UserConversationCellViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {
        //var userProfilePictureIv: ImageView
        private var userNameTV: TextView
        private var userLastnameTV : TextView

        init {
            this.userNameTV = itemView.findViewById(R.id.user_name_tv)
            this.userLastnameTV = itemView.findViewById(R.id.user_lastname_tv)
        }

        fun bind(userData: userDto) {
            userNameTV.text = userData.infos.name
            userLastnameTV.text = "Smith"
        }
    }
}