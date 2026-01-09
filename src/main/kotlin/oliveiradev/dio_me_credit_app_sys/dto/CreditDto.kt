package oliveiradev.dio_me_credit_app_sys.dto

import jakarta.validation.constraints.Future
import jakarta.validation.constraints.NotNull
import oliveiradev.dio_me_credit_app_sys.entity.Credit
import oliveiradev.dio_me_credit_app_sys.entity.Customer
import java.math.BigDecimal
import java.time.LocalDate

/**
 * DTO (Data Transfer Object) para receber dados de criação de crédito
 * @property creditValue Valor do crédito (obrigatório)
 * @property dayFirstOfInstallment Data da primeira parcela (deve ser futura)
 * @property numberOfInstallments Número de parcelas
 * @property customerId ID do cliente associado ao crédito (obrigatório)
 */
class CreditDto (
    @field:NotNull(message = "This field cannot be blank") val creditValue: BigDecimal,
    @field:Future val dayFirstOfInstallment: LocalDate,
    val numberOfInstallments: Int,
    @field:NotNull(message = "This field cannot be blank") val customerId: Long
){
    /**
     * Converte o DTO em uma entidade Credit para persistência
     * @return Entidade Credit configurada com os dados do DTO
     */
    fun toEntity(): Credit = Credit(
        creditValue = this.creditValue,
        dayFirstInstallment = this.dayFirstOfInstallment,
        numberOfInstallments = this.numberOfInstallments,
        customer = Customer(id = this.customerId)
    )
}