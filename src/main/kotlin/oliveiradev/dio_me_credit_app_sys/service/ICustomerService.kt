package oliveiradev.dio_me_credit_app_sys.service

import oliveiradev.dio_me_credit_app_sys.entity.Customer

interface ICustomerService {
    fun save(customer: Customer): Customer
    fun finById(id: Long): Customer
    fun delete(id: Long)
}