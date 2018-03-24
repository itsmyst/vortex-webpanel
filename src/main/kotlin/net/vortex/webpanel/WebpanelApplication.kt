package net.vortex.webpanel

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class WebpanelApplication

fun main(args: Array<String>) {
    runApplication<WebpanelApplication>(*args)
}
