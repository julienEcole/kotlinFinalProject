import com.example.kotlinfinalproject.model.User

data class FakeUserDto(
    val code: Int,
    val data: User,
    val status: String,
    val total: Int
)