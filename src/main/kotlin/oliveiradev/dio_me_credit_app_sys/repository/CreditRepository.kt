package oliveiradev.dio_me_credit_app_sys.repository

import oliveiradev.dio_me_credit_app_sys.entity.Credit
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Query
import org.springframework.stereotype.Repository
import java.util.UUID

/**
 * Repositório para operações de banco de dados relacionadas à entidade Credit
 */
@Repository
interface CreditRepository: JpaRepository<Credit, Long> {
    /**
     * Busca um crédito pelo seu código único
     * @param creditCode Código único do crédito
     * @return Crédito encontrado ou null se não existir
     */
    fun findByCreditCode(creditCode: UUID): Credit?

    /**
     * Busca todos os créditos associados a um cliente específico usando consulta nativa
     * @param customerId ID do cliente para filtrar os créditos
     * @return Lista de créditos do cliente especificado
     */
    @Query(value = "SELECT * FROM CREDITS WHERE CUSTOMER_ID = ?1", nativeQuery = true)
    fun findAllByCustomerId(customerId: Long): List<Credit>
}