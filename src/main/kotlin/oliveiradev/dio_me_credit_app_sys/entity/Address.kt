package oliveiradev.dio_me_credit_app_sys.entity

import jakarta.persistence.Column
import jakarta.persistence.Embeddable

/**
 * Classe que representa um endereço no sistema.
 * É marcada como @Embeddable, permitindo que seja embutida em outras entidades
 * (como Customer) sem a necessidade de uma tabela separada no banco de dados.
 *
 * @property zipCode CEP do endereço (obrigatório)
 * @property street Nome da rua do endereço (obrigatório)
 */
@Embeddable
data class Address (
    @Column (nullable = false) var zipCode: String = "",
    @Column (nullable = false) var street: String = ""
)