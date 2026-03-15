📦 E-commerce Legado - Integrações e Logística (Módulo 3)

Bem-vindo(a) ao repositório oficial do Módulo 3 da disciplina de Padrões de Projetos de Software com Java.

📜 O Contexto (A Sua Missão)

O E-commerce está crescendo e, graças às suas refatorações no Módulo 2, o sistema agora suporta milhares de acessos sem esgotar o banco de dados. No entanto, o seu excelente trabalho chamou a atenção da diretoria, e você foi promovido(a) para a equipe de Integrações e Logística.

Ao analisar o código atual da área de logística, você encontrou um cenário caótico. O sistema sofre para se comunicar com APIs externas, finalizar uma compra exige o conhecimento de dezenas de regras complexas e empacotar pedidos gerou uma árvore de objetos impossível de ser calculada corretamente.

🚨 Os Sintomas (O que você vai consertar):

APIs Incompatíveis (O choque de contratos): A empresa comprou acesso a uma nova transportadora (FreteFacilAPI), que é muito mais barata. O problema é que ela tem métodos em inglês e não respeita a nossa interface padrão (ServicoFrete).

Checkout Caótico (Alto Acoplamento): Para finalizar uma compra, a classe Main precisa instanciar e chamar manualmente o Estoque, Pagamento, Logistica e Email. Se o desenvolvedor esquecer uma linha, o pedido sai sem ser cobrado!

Caixas Misteriosas (Árvores Complexas): Na hora de despachar, uma Caixa pode conter Produtos soltos ou outras Caixas menores dentro dela. O código atual tenta calcular o preço varrendo tudo com verificações instanceof que não funcionam direito e quebram facilmente.

A sua missão é "remendar" essas falhas e organizar a arquitetura aplicando os Padrões de Projeto Estruturais (GoF).

🛠️ Pré-requisitos e Setup

O nosso ambiente oficial de desenvolvimento continua sendo o IntelliJ IDEA.

Java JDK 21 instalado.

IntelliJ IDEA (Community ou Ultimate) instalado.

Git configurado na sua máquina.

Como iniciar:

Abra o IntelliJ IDEA.

Na tela de boas-vindas, clique em Get from VCS.

Cole a URL deste repositório:

[https://github.com/prof-salu/ECommerceLegado_II.git](https://github.com/prof-salu/ECommerceLegado_II.git)


Clique em Clone e em seguida Trust Project.

No painel de projeto à esquerda, expanda a pasta azul src e abra o arquivo Main.java.

Clique na seta verde (Play) ao lado do método main para rodar o sistema e ver a bagunça estrutural acontecendo no console.

🎯 Laboratórios de Refatoração

Siga a sua Apostila de Laboratório para aplicar as correções abaixo:

1. Salvando a Entrega (Padrão Adapter)

Objetivo: Fazer o nosso sistema antigo "conversar" com a nova API de fretes sem alterar o código existente do cliente (Main).

Ação: Criar a classe FreteFacilAdapter que implementa a nossa interface ServicoFrete e traduz as chamadas para a API nova por debaixo dos panos.

2. O Botão Mágico (Padrão Facade)

Objetivo: Esconder a complexidade assustadora do processo de finalização de compra.

Ação: Criar uma classe CheckoutFacade que centraliza as chamadas de Estoque, Pagamento, Logística e Email em um único e simples método finalizarCompra().

3. A Caixa Misteriosa (Padrão Composite)

Objetivo: Calcular o preço total de caixas dentro de caixas de forma elegante, abolindo o uso de instanceof e de laços complexos.

Ação: Fazer com que tanto a Caixa quanto o Produto implementem a mesma interface (ComponenteLogistica), permitindo que a árvore de objetos se resolva sozinha através de chamadas recursivas.
