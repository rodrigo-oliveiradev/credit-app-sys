package oliveiradev.dio_me_credit_app_sys.dto

import oliveiradev.dio_me_credit_app_sys.entity.Address
import oliveiradev.dio_me_credit_app_sys.entity.Customer
import java.math.BigDecimal

data class CustomeDto(
    val firstName: String,
    val lastName: String,
    val cpf: String,
    val income: BigDecimal,
    val email: String,
    val password: String,
    val zipCode: String,
    val street: String
) {
    fun toEntity(): Customer = Customer(
        firstName = this.firstName,
        lastName = this.lastName,
        cpf = this.cpf,
        income = this.income,
        email = this.email,
        password = this.password,
        address = Address(
            zipCode = this.zipCode,
            street = this.street
        )
    )
}