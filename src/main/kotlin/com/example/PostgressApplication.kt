package com.example

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class PostgressApplication

fun main(args: Array<String>) {
	runApplication<PostgressApplication>(*args)
}
