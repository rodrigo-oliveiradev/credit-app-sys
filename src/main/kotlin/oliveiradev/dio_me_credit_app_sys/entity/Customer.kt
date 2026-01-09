package oliveiradev.dio_me_credit_app_sys.entity

import jakarta.persistence.*
import java.math.BigDecimal

/**
 * Entidade que representa um cliente no sistema
 * Mapeada para a tabela "customers" no banco de dados
 * @property id Identificador único gerado automaticamente
 * @property firstName Primeiro nome do cliente
 * @property lastName Sobrenome do cliente
 * @property cpf CPF único do cliente
 * @property email Email único do cliente
 * @property income Renda do cliente
 * @property password Senha do cliente (deve ser hasheada na prática)
 * @property address Endereço do cliente (objeto embutido)
 * @property credits Lista de créditos associados a este cliente (relação One-to-Many)
 */
@Entity
@Table(name = "customers")
data class Customer(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long? = null,

    @Column(nullable = false)
    var firstName: String = "",

    @Column(nullable = false)
    var lastName: String = "",

    @Column(nullable = false, unique = true)
    var cpf: String = "",

    @Column(nullable = false, unique = true)
    var email: String = "",

    @Column(nullable = false)
    var income: BigDecimal = BigDecimal.ZERO,

    @Column(nullable = false)
    var password: String = "",

    @Column(nullable = false)
    @Embedded var address: Address = Address(),

    @Column(nullable = false)
    @OneToMany(
        cascade = [CascadeType.REMOVE, CascadeType.PERSIST],
        fetch = FetchType.LAZY,
        mappedBy = "customer",
    )
    var credits: List<Credit> = mutableListOf()
)