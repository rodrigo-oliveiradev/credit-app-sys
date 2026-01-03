package oliveiradev.dio_me_credit_app_sys.service

import oliveiradev.dio_me_credit_app_sys.entity.Credit
import java.util.UUID

interface ICreditService {
    fun save(credit: Credit): Credit
    fun finAllByCustomer(customerId: Long): List<Credit>
    fun findByCreditCode(customerId: Long, creditCode: UUID): Credit
}