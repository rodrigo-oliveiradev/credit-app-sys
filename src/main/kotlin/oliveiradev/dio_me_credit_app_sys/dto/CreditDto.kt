package oliveiradev.dio_me_credit_app_sys.dto

import jakarta.validation.constraints.Future
import jakarta.validation.constraints.NotNull
import oliveiradev.dio_me_credit_app_sys.entity.Credit
import oliveiradev.dio_me_credit_app_sys.entity.Customer
import java.math.BigDecimal
import java.time.LocalDate

class CreditDto (
    @field:NotNull(message = "This field cannot be blank") val creditValue: BigDecimal,
    @field:Future val dayFirstOfInstallment: LocalDate,
    val numberOfInstallments: Int,
    @field:NotNull(message = "This field cannot be blank") val customerId: Long
){
    fun toEntity(): Credit = Credit(
        creditValue = this.creditValue,
        dayFirstInstallment = this.dayFirstOfInstallment,
        numberOfInstallments = this.numberOfInstallments,
        customer = Customer(id = this.customerId)
    )
}