package oliveiradev.dio_me_credit_app_sys.exception

import org.springframework.dao.DataAccessException
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.validation.FieldError
import org.springframework.validation.ObjectError
import org.springframework.web.bind.MethodArgumentNotValidException
import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.web.bind.annotation.RestControllerAdvice
import java.time.LocalDateTime

/**
 * Classe que centraliza o tratamento de exceções em toda a aplicação.
 * Anotada com @RestControllerAdvice, intercepta exceções lançadas nos controllers
 * e retorna respostas padronizadas em formato JSON.
 */
@RestControllerAdvice
class RestExceptionHandler {
    /**
     * Trata exceções de validação de argumentos (Bean Validation).
     * Ocorre quando os dados de entrada não atendem às anotações de validação.
     *
     * @param ex Exceção MethodArgumentNotValidException lançada pelo Spring
     * @return ResponseEntity com detalhes dos erros de validação e status BAD_REQUEST
     */
    @ExceptionHandler(MethodArgumentNotValidException::class)
    fun handlerValidException(ex: MethodArgumentNotValidException) : ResponseEntity<ExceptDetails> {
        val erros : MutableMap<String, String?> = HashMap()
        ex.bindingResult.allErrors.stream().forEach {
                erro: ObjectError ->
            val fieldName: String = (erro as FieldError).field
            val messageError: String? = erro.defaultMessage
            erros[fieldName] = messageError
        }
        return ResponseEntity(
            ExceptDetails(
                title = "Bad Request! Consult the documentation",
                timestamp = LocalDateTime.now(),
                status = HttpStatus.BAD_REQUEST.value(),
                exception = ex.javaClass.toString(),
                details = erros
            ), HttpStatus.BAD_REQUEST
        )
    }

    /**
     * Trata exceções de acesso a dados (ex: violação de constraints no banco).
     *
     * @param ex Exceção DataAccessException lançada pelo Spring Data
     * @return ResponseEntity com detalhes do erro e status CONFLICT
     */
    @ExceptionHandler(DataAccessException::class)
    fun handlerValidException(ex: DataAccessException) : ResponseEntity<ExceptDetails> {
        return ResponseEntity.status(HttpStatus.CONFLICT).body(
            ExceptDetails(
                title = "Conflict! Consult the documentation",
                timestamp = LocalDateTime.now(),
                status = HttpStatus.BAD_REQUEST.value(),
                exception = ex.javaClass.toString(),
                details = mutableMapOf(ex.cause.toString() to ex.message)
            )
        )
    }

    /**
     * Trata exceções de negócio personalizadas (BussinessExcpetion).
     *
     * @param ex Exceção BussinessExcpetion lançada pela aplicação
     * @return ResponseEntity com detalhes do erro e status BAD_REQUEST
     */
    @ExceptionHandler(BussinessExcpetion::class)
    fun handlerValidException(ex: BussinessExcpetion) : ResponseEntity<ExceptDetails> {
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(
            ExceptDetails(
                title = "Bad request! Consult the documentation",
                timestamp = LocalDateTime.now(),
                status = HttpStatus.BAD_REQUEST.value(),
                exception = ex.javaClass.toString(),
                details = mutableMapOf(ex.cause.toString() to ex.message)
            )
        )
    }
}