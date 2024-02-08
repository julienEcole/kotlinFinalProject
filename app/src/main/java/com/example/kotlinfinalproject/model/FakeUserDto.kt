import com.example.kotlinfinalproject.user_model.UserData

data class FakeUserDto(
    val code: Int,
    val data: UserData,
    val status: String,
    val total: Int
)