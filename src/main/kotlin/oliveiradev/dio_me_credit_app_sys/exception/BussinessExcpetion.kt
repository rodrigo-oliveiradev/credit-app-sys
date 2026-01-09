package oliveiradev.dio_me_credit_app_sys.exception

/**
 * Exceção personalizada para representar erros de negócio no sistema.
 * Estende RuntimeException, sendo portanto uma exceção não verificada.
 *
 * @property message Mensagem descritiva sobre o erro ocorrido
 *
 * Nota: Há um typo no nome da classe (BussinessExcpetion vs BusinessException).
 * Em um cenário real, considerar corrigir para manter a consistência e legibilidade.
 */
data class BussinessExcpetion (override val message: String?) : RuntimeException(message){
}