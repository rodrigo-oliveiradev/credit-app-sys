package oliveiradev.dio_me_credit_app_sys.dto

import oliveiradev.dio_me_credit_app_sys.entity.Credit
import oliveiradev.dio_me_credit_app_sys.entity.Customer
import java.math.BigDecimal
import java.time.LocalDate

class CreditDto (
    val creditValue: BigDecimal,
    val dayFirstOfInstallment: LocalDate,
    val numberOfInstallments: Int,
    val customerId: Long
){
    fun toEntity(): Credit = Credit(
        creditValue = this.creditValue,
        dayFirstInstallment = this.dayFirstOfInstallment,
        numberOfInstallments = this.numberOfInstallments,
        customer = Customer(id = this.customerId)
    )
}