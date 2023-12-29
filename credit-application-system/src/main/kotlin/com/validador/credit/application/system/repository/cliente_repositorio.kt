package com.validador.credit.application.system.repository

import com.validador.credit.application.system.entity.Customer
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface cliente_repositorio: JpaRepository<Customer,Long>