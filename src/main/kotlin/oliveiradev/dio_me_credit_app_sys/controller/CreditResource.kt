package oliveiradev.dio_me_credit_app_sys.controller

import jakarta.validation.Valid
import oliveiradev.dio_me_credit_app_sys.dto.CreditDto
import oliveiradev.dio_me_credit_app_sys.dto.CreditView
import oliveiradev.dio_me_credit_app_sys.dto.CreditViewList
import oliveiradev.dio_me_credit_app_sys.entity.Credit
import oliveiradev.dio_me_credit_app_sys.service.impl.CreditService
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController
import java.util.UUID
import java.util.stream.Collectors

@RestController
@RequestMapping("/api/credits")
class CreditResource (
    private  val creditService: CreditService
){
    /**
     * Salva um novo crédito para um cliente
     * @param creditDto Dados do crédito a ser criado
     * @return ResponseEntity com mensagem de confirmação e status CREATED
     */
    @PostMapping
    fun saveCredit(@RequestBody @Valid creditDto: CreditDto): ResponseEntity<String> {
        val credit: Credit = this.creditService.save(creditDto.toEntity())

        return ResponseEntity.status(HttpStatus.CREATED)
            .body("Credit ${credit.creditCode} - Customer ${credit.customer?.firstName} ${credit.customer?.lastName}, saved!")
    }

    /**
     * Busca todos os créditos de um cliente específico
     * @param customerId ID do cliente para filtrar os créditos
     * @return Lista de créditos do cliente no formato CreditViewList
     */
    @GetMapping
    fun findAllCustomerId(@RequestParam(value = "customerId") customerId: Long) : ResponseEntity<List<CreditViewList>> {
        val creditViewList: List<CreditViewList> = this.creditService.finAllByCustomer(customerId).stream()
            .map { credit: Credit -> CreditViewList(credit) }
            .collect(Collectors.toList())
        return ResponseEntity.status(HttpStatus.OK).body(creditViewList)
    }

    /**
     * Busca um crédito específico pelo código do crédito, validando se pertence ao cliente
     * @param customerId ID do cliente para validação de propriedade
     * @param creditCode Código único do crédito a ser buscado
     * @return Detalhes completos do crédito no formato CreditView
     */
    @GetMapping("/{creditCode}")
    fun findByCreditCode (@RequestParam(value = "customerId") customerId: Long,
                          @PathVariable creditCode: UUID) : ResponseEntity<CreditView> {
        val credit: Credit = this.creditService.findByCreditCode(customerId, creditCode)

        return ResponseEntity.status(HttpStatus.OK).body(CreditView(credit))
    }
}