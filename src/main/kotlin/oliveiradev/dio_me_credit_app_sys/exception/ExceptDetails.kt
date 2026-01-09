package oliveiradev.dio_me_credit_app_sys.exception

import java.time.LocalDateTime

/**
 * DTO (Data Transfer Object) que representa os detalhes de uma exceção
 * a ser retornada nas respostas de erro da API.
 *
 * @property title Título geral do erro
 * @property timestamp Data e hora em que o erro ocorreu
 * @property status Código de status HTTP associado ao erro
 * @property exception Classe da exceção que foi lançada
 * @property details Mapa contendo detalhes específicos do erro,
 *                   como campos com erro e suas respectivas mensagens
 */
data class ExceptDetails (
    val title: String,
    val timestamp: LocalDateTime,
    val status: Int,
    val exception: String,
    val details: MutableMap<String, String?>
) {

}