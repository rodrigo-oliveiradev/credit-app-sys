package oliveiradev.dio_me_credit_app_sys.exception

import java.time.LocalDateTime

data class ExceptDetails (
    val title: String,
    val timestamp: LocalDateTime,
    val status: Int,
    val exception: String,
    val details: MutableMap<String, String?>
) {

}