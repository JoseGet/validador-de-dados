package com.validador.credit.application.system.service.impl

import com.validador.credit.application.system.entity.Customer
import com.validador.credit.application.system.exception.BusinessException
import com.validador.credit.application.system.repository.CustomerRepository
import com.validador.credit.application.system.service.ICustomerService
import org.springframework.stereotype.Service

@Service
class CustomerService(
    private val clienteRepository: CustomerRepository
): ICustomerService {

    override fun save(customer: Customer): Customer =
        this.clienteRepository.save(customer)

    override fun findById(id: Long): Customer = this.clienteRepository.findById(id).orElseThrow {
        throw BusinessException("ID $id not found")
    }

    override fun delete(id: Long) {
        val customer: Customer = this.findById(id)
        this.clienteRepository.delete(customer)
    }
}