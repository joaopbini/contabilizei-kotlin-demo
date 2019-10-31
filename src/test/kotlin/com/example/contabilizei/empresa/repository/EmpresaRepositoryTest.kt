package com.example.contabilizei.empresa.repository

import com.example.contabilizei.template.createEmpresa
import io.zonky.test.db.AutoConfigureEmbeddedDatabase
import org.junit.Assert
import org.junit.Test
import org.junit.runner.RunWith
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.test.context.ActiveProfiles
import org.springframework.test.context.junit4.SpringRunner

@RunWith(SpringRunner::class)
@SpringBootTest
@AutoConfigureEmbeddedDatabase(beanName = "dataSource")
@ActiveProfiles(profiles = ["local"])
class EmpresaRepositoryTest {

    @Autowired
    private lateinit var empresaRepository: EmpresaRepository

    @Test
    fun saveEmpresaTest() {

        val empresaEsperada = createEmpresa()

        val empresa = empresaRepository.save(empresaEsperada)

        Assert.assertEquals(empresaEsperada, empresa)

    }

}