# Mini-rede

**Mini-rede** é um projeto de rede social focado em algoritmos de recomendação, onde os usuários podem interagir, postar e receber conteúdos personalizados com base em seus gostos. A proposta é criar uma aplicação que simula o funcionamento de uma rede social simples, mas com uma ênfase especial no algoritmo de recomendação, inspirada em modelos usados por plataformas como o TikTok.

## Sobre o Projeto

O **Mini-rede** tem como objetivo estudar e implementar um sistema de recomendação baseado em dados de interação dos usuários. Além disso, o projeto vai além da parte algorítmica, pois também conta com uma interface onde os usuários poderão criar postagens, interagir com outros e ver conteúdos recomendados de acordo com suas preferências.

Esse é um projeto de longo prazo, com foco em aprendizagem prática e aprimoramento das habilidades no desenvolvimento de algoritmos de recomendação, APIs e interfaces dinâmicas.

## Funcionalidades

- **Postagens**: Usuários podem criar postagens e interagir com o conteúdo de outros.
- **Recomendações Personalizadas**: Algoritmo de recomendação baseado nas interações dos usuários.
- **Interação Social**: Curtidas, comentários e seguimentos de outros usuários.
- **Sistema de Recomendação em Tempo Real**: Usando Redis para armazenar as recomendações em cache, proporcionando uma experiência mais rápida e eficiente.

## Stack Utilizada

- **Backend:**
  - **Java + Spring Boot**: API principal, responsável por gerenciar as operações de backend.
  - **Python + FastAPI**: Algoritmo de recomendação e workers para processar e gerar as recomendações.
  - **MySQL ou PostgreSQL**: Banco de dados para armazenar informações dos usuários, postagens e interações.
  - **Redis**: Armazenamento de recomendações em cache para otimizar a performance.

- **Frontend:**
  - **React**: Framework para construção da interface do usuário.
  - **Tailwind CSS**: Framework CSS para facilitar a estilização e criação de layouts responsivos.

## Como Rodar o Projeto

### Pré-requisitos

- [Java 17+](https://adoptopenjdk.net/) para o backend em Spring Boot.
- [Python 3.9+](https://www.python.org/downloads/) para o backend em FastAPI.
- [MySQL](https://dev.mysql.com/downloads/) ou [PostgreSQL](https://www.postgresql.org/download/) para o banco de dados.
- [Redis](https://redis.io/download) para o cache das recomendações.
- [Node.js](https://nodejs.org/) para o frontend.
