package oliveiradev.dio_me_credit_app_sys.repository

import oliveiradev.dio_me_credit_app_sys.entity.Customer
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

/**
 * Repositório para operações de banco de dados relacionadas à entidade Customer
 * Estende JpaRepository, herdando operações CRUD básicas
 */
@Repository
interface CustomerRepository: JpaRepository <Customer, Long>