# Dog Api

## 1. Descrição do código
Este projeto é um sistema cliente-servidor para amantes de cães. O servidor Spring Boot consome a DogAPI e fornece funcionalidades de gerenciamento de favoritos. O aplicativo Android permite navegar por raças, ver fotos e salvar imagens preferidas.

## 2. Descrição do Servidor REST e Rotas
O servidor atua como um proxy para a DogAPI pública (https://dog.ceo/dog-api/).
- GET /api/breeds: Lista todas as raças disponíveis.
- GET /api/breeds/{breed}/images: Fotos de uma raça específica.
- POST /api/favorites: Adiciona uma imagem aos favoritos (Cadastro local no servidor).
- GET /api/favorites: Lista os favoritos cadastrados.
- DELETE /api/favorites: Remove uma imagem dos favoritos.

## 3. Como Rodar no Android Studio
Siga estes passos para executar a aplicação corretamente:

### A. Preparar o Servidor
1. Abra a pasta `ServidorREST` em sua IDE (IntelliJ ou VS Code).
2. Execute o comando `mvn spring-boot:run` ou inicie a classe `DogApiApplication.java`.
3. O servidor deve estar rodando em `http://localhost:8080`.

### B. Configurar o Cliente Android
1. Abra o **Android Studio**.
2. Vá em `File > Open` e selecione a pasta `ClienteAndroid`.
3. Certifique-se de que o emulador está usando a URL `http://10.0.2.2:8080` no `RetroFitClient.kt`.
4. No arquivo `AndroidManifest.xml`, verifique se as permissões de INTERNET e `android:usesCleartextTraffic="true"` estão configuradas.
5. Clique em **Run 'app'** para instalar no emulador.

## 4. Estrutura do Projeto
- **api/**: Configurações de rede e Retrofit.
- **models/**: Estrutura de dados das respostas da API.
- **views/**: Telas da aplicação (MainActivity, GalleryActivity, FavoritesActivity).
