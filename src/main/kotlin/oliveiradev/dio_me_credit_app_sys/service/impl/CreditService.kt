package oliveiradev.dio_me_credit_app_sys.service.impl

import oliveiradev.dio_me_credit_app_sys.entity.Credit
import oliveiradev.dio_me_credit_app_sys.repository.CreditRepository
import oliveiradev.dio_me_credit_app_sys.service.ICreditService
import org.springframework.stereotype.Service
import java.util.UUID

@Service
class CreditService(
    private val creditRepository: CreditRepository,
    private val customerService: CustomerService): ICreditService {
    override fun save(credit: Credit): Credit {
        credit.apply { customer = customerService.finById(credit.customer?.id!!)
        }
        return this.creditRepository.save(credit)
    }

    override fun finAllByCustomer(customerId: Long): List<Credit> = this.creditRepository.findAllByCustomerId(customerId)

    override fun findByCreditCode(customerId: Long, creditCode: UUID): Credit {
        val credit: Credit = (this.creditRepository.findByCreditCode(creditCode) ?: throw RuntimeException("Creditcode $creditCode, not found!"))

        return if (credit.customer?.id == customerId) credit else throw RuntimeException("Contact admin.")
    }
}