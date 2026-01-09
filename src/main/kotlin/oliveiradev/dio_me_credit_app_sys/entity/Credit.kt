package oliveiradev.dio_me_credit_app_sys.entity

import oliveiradev.dio_me_credit_app_sys.enums.Status
import jakarta.persistence.*
import java.math.BigDecimal
import java.time.LocalDate
import java.util.UUID

/**
 * Entidade que representa um crédito no sistema
 * @property creditCode Código único gerado automaticamente para o crédito
 * @property creditValue Valor monetário do crédito
 * @property dayFirstInstallment Data da primeira parcela do crédito
 * @property numberOfInstallments Quantidade total de parcelas
 * @property status Status atual do crédito (padrão: IN_PROGRESS)
 * @property customer Cliente associado a este crédito (relação Many-to-One)
 * @property id Identificador único gerado automaticamente no banco de dados
 */
@Entity
@Table (name = "credits")
data class Credit (
    @Column (nullable = false, unique = true) val creditCode : UUID = UUID.randomUUID(),
    @Column (nullable = false) val creditValue : BigDecimal = BigDecimal.ZERO,
    @Column (nullable = false) val dayFirstInstallment: LocalDate,
    @Column (nullable = false) val numberOfInstallments: Int = 0,
    @Enumerated val status: Status = Status.IN_PROGRESS,
    @ManyToOne var customer: Customer? = null,
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY) val id: Long? = null

)