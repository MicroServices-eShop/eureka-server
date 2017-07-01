package kjkrol.eshop.discovery

import org.springframework.boot.SpringApplication
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer

fun main(args: Array<String>) {
    SpringApplication.run(EurekaServerApp::class.java, *args)
}

@SpringBootApplication
@EnableEurekaServer
open class EurekaServerApp