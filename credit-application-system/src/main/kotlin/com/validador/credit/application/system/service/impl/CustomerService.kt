package com.validador.credit.application.system.service.impl

import com.validador.credit.application.system.entity.Customer
import com.validador.credit.application.system.repository.CustomerRepository
import com.validador.credit.application.system.service.ICustomerService
import org.springframework.stereotype.Service
import java.lang.RuntimeException

@Service
class CustomerService(
    private val clienteRepository: CustomerRepository
): ICustomerService {

    override fun save(customer: Customer): Customer =
        this.clienteRepository.save(customer)

    override fun findById(id: Long): Customer = this.clienteRepository.findById(id).orElseThrow {
            throw RuntimeException("ID $id not found")
        }

    override fun delete(id: Long) = this.clienteRepository.deleteById(id)
}