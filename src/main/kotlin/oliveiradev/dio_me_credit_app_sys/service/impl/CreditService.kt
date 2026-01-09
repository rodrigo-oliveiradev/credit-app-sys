package oliveiradev.dio_me_credit_app_sys.service.impl

import oliveiradev.dio_me_credit_app_sys.entity.Credit
import oliveiradev.dio_me_credit_app_sys.exception.BussinessExcpetion
import oliveiradev.dio_me_credit_app_sys.repository.CreditRepository
import oliveiradev.dio_me_credit_app_sys.service.ICreditService
import org.springframework.stereotype.Service
import java.util.UUID

/**
 * Implementação do serviço de crédito
 * @property creditRepository Repositório para operações de banco de dados de créditos
 * @property customerService Serviço para operações com clientes
 */
@Service
class CreditService(
    private val creditRepository: CreditRepository,
    private val customerService: CustomerService): ICreditService {

    /**
     * Salva um novo crédito associando-o ao cliente correspondente
     * @param credit Entidade Credit a ser persistida
     * @return Crédito salvo com o cliente associado
     */
    override fun save(credit: Credit): Credit {
        credit.apply { customer = customerService.finById(credit.customer?.id!!)
        }
        return this.creditRepository.save(credit)
    }

    /**
     * Busca todos os créditos de um cliente específico
     * @param customerId ID do cliente para filtrar os créditos
     * @return Lista de créditos do cliente especificado
     */
    override fun finAllByCustomer(customerId: Long): List<Credit> = this.creditRepository.findAllByCustomerId(customerId)

    /**
     * Busca um crédito pelo código, validando se pertence ao cliente especificado
     * @param customerId ID do cliente para validação de propriedade
     * @param creditCode Código único do crédito a ser buscado
     * @return Crédito encontrado após validação
     * @throws BussinessExcpetion Se o crédito não for encontrado ou não pertencer ao cliente
     */
    override fun findByCreditCode(customerId: Long, creditCode: UUID): Credit {
        val credit: Credit = (this.creditRepository.findByCreditCode(creditCode) ?: throw BussinessExcpetion("Creditcode $creditCode, not found!"))

        return if (credit.customer?.id == customerId) credit else throw BussinessExcpetion("Contact admin.")
    }
}