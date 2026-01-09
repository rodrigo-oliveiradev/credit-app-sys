package oliveiradev.dio_me_credit_app_sys.dto

import oliveiradev.dio_me_credit_app_sys.entity.Credit
import oliveiradev.dio_me_credit_app_sys.enums.Status
import java.math.BigDecimal
import java.util.UUID

/**
 * DTO para visualização detalhada de um crédito
 * @property creditCode Código único do crédito
 * @property creditValue Valor do crédito
 * @property numberOfInstallments Número de parcelas
 * @property status Status atual do crédito
 * @property emailCustomer Email do cliente associado
 * @property incomeCustomer Renda do cliente associado
 */
data class CreditView (
    val creditCode: UUID,
    val creditValue: BigDecimal,
    val numberOfInstallments: Int,
    val status: Status,
    val emailCustomer: String?,
    val incomeCustomer: BigDecimal?
) {
    /**
     * Construtor secundário que converte uma entidade Credit em CreditView
     * @param credit Entidade Credit a ser convertida
     */
    constructor(credit: Credit):this (
        creditCode = credit.creditCode,
        creditValue = credit.creditValue,
        numberOfInstallments = credit.numberOfInstallments,
        status = credit.status,
        emailCustomer = credit.customer?.email,
        incomeCustomer = credit.customer?.income
    )
}