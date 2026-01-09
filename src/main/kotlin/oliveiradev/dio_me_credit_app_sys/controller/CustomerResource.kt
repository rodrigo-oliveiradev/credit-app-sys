package oliveiradev.dio_me_credit_app_sys.dto

import jakarta.validation.constraints.Email
import jakarta.validation.constraints.NotEmpty
import jakarta.validation.constraints.NotNull
import oliveiradev.dio_me_credit_app_sys.entity.Address
import oliveiradev.dio_me_credit_app_sys.entity.Customer
import org.hibernate.validator.constraints.br.CPF
import java.math.BigDecimal

/**
 * DTO para criação de um novo cliente
 * Contém todos os campos necessários para registrar um cliente no sistema
 * @property firstName Primeiro nome do cliente (obrigatório)
 * @property lastName Sobrenome do cliente (obrigatório)
 * @property cpf CPF do cliente (obrigatório, deve ser válido)
 * @property income Renda do cliente (obrigatório)
 * @property email Email do cliente (obrigatório, deve ser válido)
 * @property password Senha do cliente (obrigatório)
 * @property zipCode CEP do endereço (obrigatório)
 * @property street Rua do endereço (obrigatório)
 */
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
    /**
     * Converte o DTO em uma entidade Customer para persistência
     * @return Entidade Customer configurada com os dados do DTO
     */
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