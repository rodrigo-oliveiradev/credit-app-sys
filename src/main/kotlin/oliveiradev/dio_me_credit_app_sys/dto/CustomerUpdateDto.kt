package oliveiradev.dio_me_credit_app_sys.dto

import oliveiradev.dio_me_credit_app_sys.entity.Customer
import java.math.BigDecimal

/**
 * DTO para atualização parcial de um cliente existente
 * Contém apenas campos que podem ser atualizados (campos imutáveis como CPF e email não estão incluídos)
 * @property firstName Novo primeiro nome do cliente
 * @property lastName Novo sobrenome do cliente
 * @property income Nova renda do cliente
 * @property zipCode Novo CEP do endereço
 * @property street Nova rua do endereço
 */
data class CustomerUpdateDto(
    val firstName: String,
    val lastName: String,
    val income: BigDecimal,
    val zipCode: String,
    val street: String
) {
    /**
     * Aplica as atualizações do DTO a uma entidade Customer existente
     * @param customer Entidade Customer a ser atualizada
     * @return Entidade Customer com os dados atualizados
     */
    fun toEntity(customer: Customer) : Customer {
        customer.firstName = this.firstName
        customer.lastName = this.lastName
        customer.income = this.income
        customer.address.street = this.street
        customer.address.zipCode = this.zipCode

        return customer
    }
}