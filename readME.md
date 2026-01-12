# DOG API

## 1. Descrição

Sistema distribuído composto por um servidor REST (Spring Boot) e um cliente Mobile (Android Kotlin). O sistema permite a exploração de raças de cães, visualização de galerias e gestão de uma lista de favoritos.

## 2. Servidor e Rotas

O servidor consome a DogAPI pública e expõe as seguintes rotas:

- GET /api/breeds: Lista todas as raças (JSON/XML).
- GET /api/breeds/{breed}/images: Fotos da raça informada.
- POST /api/favorites: Cadastro de imagem favorita no servidor.
- GET /api/favorites: Recuperação da lista de favoritos.
- DELETE /api/favorites: Remoção de uma imagem da lista.

## 3. Implementação Mobile

- Tela 1: Listagem de todas as raças.
- Tela 2: Galeria de fotos da raça selecionada com opção de favoritar.
- Tela 3: Gerenciamento dos favoritos cadastrados localmente/remotamente.
