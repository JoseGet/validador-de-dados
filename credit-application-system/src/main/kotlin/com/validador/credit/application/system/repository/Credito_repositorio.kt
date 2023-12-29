package com.validador.credit.application.system.repository

import com.validador.credit.application.system.entity.Credit
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface Credito_repositorio : JpaRepository<Credit,Long>