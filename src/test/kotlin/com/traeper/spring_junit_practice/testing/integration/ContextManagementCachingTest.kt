package com.traeper.spring_junit_practice.testing.integration

import mu.KLogger
import mu.KotlinLogging
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Order
import org.junit.jupiter.api.Test
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.context.ApplicationContext

private val log: KLogger = KotlinLogging.logger {}

@DisplayName("test 간 context 재활용 테스트")
@SpringBootTest
class ContextManagementCachingTest {

    @Test
    @Order(-2)
    internal fun test1(context: ApplicationContext) {
        contexts.add(context)
    }

    @Test
    @Order(-1)
    internal fun test2(context: ApplicationContext) {
        contexts.add(context)
    }

    @Test
    @Order(0)
    internal fun test3() {
        contexts.forEach { log.info { it } }
        assertThat(contexts[0] == contexts[1]).isTrue
    }

    companion object {
        private val contexts = mutableListOf<ApplicationContext>()
    }
}