package oliveiradev.dio_me_credit_app_sys.dto

import jakarta.validation.constraints.Email
import jakarta.validation.constraints.NotEmpty
import jakarta.validation.constraints.NotNull
import oliveiradev.dio_me_credit_app_sys.entity.Address
import oliveiradev.dio_me_credit_app_sys.entity.Customer
import org.hibernate.validator.constraints.br.CPF
import java.math.BigDecimal

data class CustomeDto(
    @field:NotEmpty(message = "This field cannot be blank") val firstName: String,
    @field:NotEmpty(message = "This field cannot be blank") val lastName: String,
    @field:NotEmpty(message = "Invalid input") @CPF(message = "CPF Invalid") val cpf: String,
    @field:NotNull(message = "This field cannot be blank") val income: BigDecimal,
    @field:Email(message = "This field cannot be blank") val email: String,
    @field:NotEmpty(message = "This field cannot be blank") val password: String,
    @field:NotEmpty(message = "Invalid input") val zipCode: String,
    @field:NotEmpty(message = "This field cannot be blank") val street: String
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