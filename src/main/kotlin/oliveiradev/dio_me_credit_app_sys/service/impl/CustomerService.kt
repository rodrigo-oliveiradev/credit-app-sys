package oliveiradev.dio_me_credit_app_sys.service.impl

import oliveiradev.dio_me_credit_app_sys.entity.Customer
import oliveiradev.dio_me_credit_app_sys.exception.BussinessExcpetion
import oliveiradev.dio_me_credit_app_sys.repository.CustomerRepository
import oliveiradev.dio_me_credit_app_sys.service.ICustomerService
import org.springframework.stereotype.Service

@Service
class CustomerService(
    private val customerRepository: CustomerRepository): ICustomerService {
    override fun save(customer: Customer): Customer = this.customerRepository.save(customer)

    override fun finById(id: Long): Customer = this.customerRepository.findById(id).orElseThrow() {
        throw BussinessExcpetion("Id $id, not found!")
    }

    override fun delete(id: Long) {
        val customer: Customer = this.finById(id)
        this.customerRepository.delete(customer)
    }
}