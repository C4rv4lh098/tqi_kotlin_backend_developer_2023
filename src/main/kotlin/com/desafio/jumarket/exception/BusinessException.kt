package com.desafio.jumarket.exception

data class BusinessException(override val message: String?): RuntimeException(message)
