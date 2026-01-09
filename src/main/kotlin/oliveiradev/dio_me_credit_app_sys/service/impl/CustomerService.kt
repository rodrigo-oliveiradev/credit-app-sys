package oliveiradev.dio_me_credit_app_sys.service.impl

import oliveiradev.dio_me_credit_app_sys.entity.Customer
import oliveiradev.dio_me_credit_app_sys.exception.BussinessExcpetion
import oliveiradev.dio_me_credit_app_sys.repository.CustomerRepository
import oliveiradev.dio_me_credit_app_sys.service.ICustomerService
import org.springframework.stereotype.Service

/**
 * Implementação do serviço de cliente
 * Contém a lógica de negócio para operações com clientes
 * @property customerRepository Repositório para operações de banco de dados de clientes
 */
@Service
class CustomerService(
    private val customerRepository: CustomerRepository): ICustomerService {

    /**
     * Salva um cliente no banco de dados
     * @param customer Entidade Customer a ser persistida
     * @return Cliente salvo com ID gerado
     */
    override fun save(customer: Customer): Customer = this.customerRepository.save(customer)

    /**
     * Busca um cliente pelo ID
     * @param id ID do cliente a ser buscado
     * @return Cliente encontrado
     * @throws BussinessExcpetion Se o cliente não for encontrado
     */
    override fun finById(id: Long): Customer = this.customerRepository.findById(id).orElseThrow() {
        throw BussinessExcpetion("Id $id, not found!")
    }

    /**
     * Remove um cliente do banco de dados pelo ID
     * Primeiro busca o cliente para garantir que existe, depois remove
     * @param id ID do cliente a ser removido
     */
    override fun delete(id: Long) {
        val customer: Customer = this.finById(id)
        this.customerRepository.delete(customer)
    }
}