# JavaVanilla-Microservices 🚀

![Docker](https://img.shields.io/badge/Docker-Container-blue)
![Java](https://img.shields.io/badge/Java-Pure-red)
![Microservices](https://img.shields.io/badge/Microservices-HTTPServer-orange)

**JavaVanilla-Microservices** é um projeto de demonstração de **microserviços em Java puro**, sem frameworks ou bibliotecas externas. Ele utiliza apenas o **HTTP Server nativo do Java** e **Docker**, permitindo que você entenda a comunicação entre microserviços e a orquestração de containers com Docker Compose.

O projeto inclui três serviços:
- **Users Service**: retorna uma lista de usuários.  
- **Products Service**: retorna uma lista de produtos.  
- **Gateway**: integra os serviços e funciona como proxy.

---

## 📂 Estrutura do Projeto
docker-compass

src
├─ gateway/
│ ├─ Gateway.java
│ └─ Dockerfile
├─ auth/
│ ├─ UsersService.java
│ └─ Dockerfile
├─ store/
│ ├─ ProductsService.java
│ └─ Dockerfile
└─ docker-compose.yml

---


---

## ⚙️ Pré-requisitos
- [Java JDK 20](https://adoptium.net/)
- [Docker](https://www.docker.com/)
- [Docker Compose](https://docs.docker.com/compose/)

---

## 🚀 Como Rodar

1. Clone o repositório:
```bash
git clone https://github.com/viniciusfonseca19/JavaVanilla-Microservices-dio.git
cd JavaVanilla-Microservices

2. Construa e suba os containers:

docker-compose up --build

3. Teste os endpoints:

Gateway (integra os serviços)
Users: http://localhost:8081/users
Products: http://localhost:8082/products
Serviços individuais
Users Service: http://localhost:8080/users
Products Service: http://localhost:8082/products
