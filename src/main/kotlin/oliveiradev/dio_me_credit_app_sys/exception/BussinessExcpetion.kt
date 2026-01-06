package oliveiradev.dio_me_credit_app_sys.exception


data class BussinessExcpetion (override val message: String?) : RuntimeException(message){
}