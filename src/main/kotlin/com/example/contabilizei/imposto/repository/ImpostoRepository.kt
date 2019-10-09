package com.example.contabilizei.imposto.repository

import com.example.contabilizei.imposto.model.Imposto
import org.springframework.data.repository.CrudRepository

interface ImpostoRepository : CrudRepository<Imposto, Long>