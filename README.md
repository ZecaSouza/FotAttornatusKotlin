# ForAttornatusKotlin
Este repositório é referente ao teste proposto pela Attornatus e foi desenvolvido utilizando a linguagem Kotlin. Como a JVM é a base do Java, e não a sintaxe em si, optei por usar a sintaxe do Kotlin devido a minha familiaridade com esta linguagem.

Kotlin é uma linguagem de programação moderna e mais expressiva do que Java. Ela foi projetada para ser mais segura, concisa e fácil de ler e escrever. Possui interoperabilidade com Java, suporta programação funcional, possibilidade de segurança contra valores nulos, sintaxe mais concisa e limpa, suporte nativo para coroutines e é amplamente adotada pela comunidade, além de ser apoiada pelo Google como uma das linguagens oficiais para o desenvolvimento de aplicativos para a plataforma.

Este link apresenta um projeto mais completo, fazendo uso de bibliotecas como Liquibase (que proporciona uma melhor visibilidade e manutenção do código de banco de dados) e SpringWebFlux (para desenvolvimento de aplicações web assíncronas e baseadas em fluxos, melhorando a escalibilidade e suporte nativo para programação reativa). Utilizamos o banco de dados H2, conforme solicitado no teste.

É importante prestar atenção à linha 3 do arquivo application.yml (url: jdbc:h2:file:/home/zecasouza/test), pois é necessário corrigir o nome do usuário para o correspondente. Recomenda-se o uso de sistemas Linux.

Como extras, poderíamos ter implementado o SWAGGER para melhorar a visualização e documentação da API, bem como "Dockerizar" a aplicação, mas estas tarefas demandariam tempo e acredito que a entrega do teste é uma prioridade neste momento.
