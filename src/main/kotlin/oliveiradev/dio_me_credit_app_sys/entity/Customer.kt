package oliveiradev.dio_me_credit_app_sys.entity

import jakarta.persistence.*
import java.math.BigDecimal

@Entity
//@Table(name = "Customers")
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
