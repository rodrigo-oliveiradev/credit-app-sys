package oliveiradev.dio_me_credit_app_sys.repository

import oliveiradev.dio_me_credit_app_sys.entity.Credit
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface CreditRepository: JpaRepository<Credit, Long>