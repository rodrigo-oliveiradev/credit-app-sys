package oliveiradev.dio_me_credit_app_sys.entity

import jakarta.persistence.*

@Entity
@Table(name = "Customers")
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
    var password: String = "",

    @Column(nullable = false)
    var address: String = "",

    @OneToMany(
        mappedBy = "customer",
        cascade = [CascadeType.REMOVE, CascadeType.PERSIST],
        fetch = FetchType.LAZY
    )
    var credits: List<Credit> = mutableListOf()
)
