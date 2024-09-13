# Aplicação Java Spring Boot com Archaius, Eureka e Load Balancer

## Descrição
Este projeto é uma aplicação Spring Boot que integra **Netflix Archaius** para gerenciamento dinâmico de configurações, **Netflix Eureka** como serviço de descoberta, e um **Load Balancer** para distribuir o tráfego entre instâncias do serviço.

## Pré-requisitos

- Java 8 ou superior
- Maven 3.6.0 ou superior
- Docker (opcional, para rodar o Eureka Server em container)
- Eureka Server (pode ser rodado em um container ou como aplicação separada)

## Tecnologias Utilizadas

- **Spring Boot**
- **Netflix Archaius**
- **Netflix Eureka**
- **Spring Cloud LoadBalancer**
- **Maven**

## Como funciona o Eureka?
Eureka é utilizado para descoberta de serviços. Certifique-se de que o Eureka Server esteja rodando antes de iniciar a aplicação.
