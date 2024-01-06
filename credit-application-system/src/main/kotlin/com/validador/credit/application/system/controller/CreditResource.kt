package com.validador.credit.application.system.controller

import com.validador.credit.application.system.dto.CreditDto
import com.validador.credit.application.system.dto.CreditView
import com.validador.credit.application.system.dto.CreditViewList
import com.validador.credit.application.system.entity.Credit
import com.validador.credit.application.system.service.impl.CreditService
import jakarta.validation.Valid
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import java.util.UUID
import java.util.stream.Collectors

@RestController
@RequestMapping("/api/credits")
class CreditResource(
    private val creditService: CreditService
) {

    @PostMapping
    fun SaveCredit(@RequestBody @Valid creditDto: CreditDto): ResponseEntity<String>
    {
        val credit: Credit = this.creditService.save(creditDto.toEntity())
        return ResponseEntity.status(HttpStatus.CREATED)
            .body("Credit ${credit.creditCode} - Customer ${credit.customer?.firstName} saved!")
    }

    @GetMapping
    fun findAllByCustomerId(@RequestParam(value = "customerId") customerId: Long):
            ResponseEntity<List<CreditViewList>>{
        val creditViewList: List<CreditViewList> = this.creditService.findAllByCustomer(customerId).stream()
            .map{ credit: Credit -> CreditViewList(credit)}
            .collect(Collectors.toList())
        return ResponseEntity.status(HttpStatus.OK).body(creditViewList)
    }

    @GetMapping("/{creditCode}")
    fun findByCreditCode(
        @RequestParam(value = "customerId") customerId: Long,
        @PathVariable creditCode: UUID
    ):  ResponseEntity<CreditView> {
        val credit: Credit = this.creditService.findByCreditCode(customerId, creditCode)
        return ResponseEntity.status(HttpStatus.OK).body(CreditView(credit))
    }


}