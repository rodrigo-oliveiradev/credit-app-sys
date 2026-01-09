package oliveiradev.dio_me_credit_app_sys.dto

import oliveiradev.dio_me_credit_app_sys.entity.Customer
import java.math.BigDecimal

/**
 * DTO para visualização de dados do cliente
 * Contém apenas os dados que devem ser expostos ao usuário (sem informações sensíveis como senha)
 * @property firstName Primeiro nome do cliente
 * @property lastName Sobrenome do cliente
 * @property cpf CPF do cliente
 * @property income Renda do cliente
 * @property email Email do cliente
 * @property zipCode CEP do endereço
 * @property street Rua do endereço
 */
data class CustomerView(
    val firstName: String,
    val lastName: String,
    val cpf: String,
    val income: BigDecimal,
    val email: String,
    val zipCode: String,
    val street: String
) {
    /**
     * Construtor secundário que converte uma entidade Customer em CustomerView
     * @param customer Entidade Customer a ser convertida
     */
    constructor(customer: Customer): this (
        firstName = customer.firstName,
        lastName = customer.lastName,
        cpf = customer.cpf,
        income = customer.income,
        email = customer.email,
        zipCode = customer.address.zipCode,
        street = customer.address.street
    )
}