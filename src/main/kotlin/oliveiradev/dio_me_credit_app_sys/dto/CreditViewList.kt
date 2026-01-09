package oliveiradev.dio_me_credit_app_sys.dto

import oliveiradev.dio_me_credit_app_sys.entity.Credit
import java.math.BigDecimal
import java.util.UUID

/**
 * DTO para listagem resumida de créditos
 * @property creditCode Código único do crédito
 * @property creditValue Valor do crédito
 * @property numberOfInstallments Número de parcelas
 */
data class CreditViewList(
    val creditCode: UUID,
    val creditValue: BigDecimal,
    val numberOfInstallments: Int
) {
    /**
     * Construtor secundário que converte uma entidade Credit em CreditViewList
     * @param credit Entidade Credit a ser convertida
     */
    constructor(credit: Credit) : this (
        creditCode = credit.creditCode,
        creditValue = credit.creditValue,
        numberOfInstallments = credit.numberOfInstallments
    )
}