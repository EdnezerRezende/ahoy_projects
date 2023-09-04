# Ahoy-Desafio
## projeto para avaliação de entendimento de negócio e desenvolvimento de software
### Requisitos
    Criar uma interface Web para upload de um ou mais arquivos com extensão .xml.
     Para o desenvolvimento da interface, deve ser utilizado o tema Indigo do Angular
    Material.
     Durante o envio do(s) arquivo(s) mostrar um loader para informar ao usuário que
    estão sendo processados, e ao final esse loader deve desaparecer (utilizar
    componentes do Angular Material).
     Os arquivos contêm uma lista de agentes com código e data em formato ISO, e uma
    lista com quatro regiões (SE, S, NE, N) com sete valores numéricos de geração, compra
    e preço médio.
     Todos os arquivos seguem o mesmo formato, como nos exemplos em anexo:
    o exemplo_01.xml
    o exemplo_02.xml
    o exemplo_03.xml
     Não é necessário validar os dados dos arquivos, considere que eles estarão sempre
    corretos e no formato especificado acima.
     Os arquivos devem ser lidos e enviados um a um, sequencialmente.
     Os arquivos podem conter quantidades grandes de dados, por exemplo, 1.000 agentes
    (agentes/agente[0..999])
     Os dados de preço médio (/agentes/agente[]/submercado[]/precoMedio) são
    confidenciais, portanto devem ser removidos ou substituídos por valores em branco
    antes de serem enviados.
     Ao receber cada arquivo, o back-end deve apenas imprimir na saída padrão
    (System.out) os códigos de agentes (/agentes/agente[]/codigo) recebidos.
     Utlizar
     Salvar os itens no Banco de dados.
     Recuperar um dado consolidado por região.

## Instruções
    Cada projeto tem o Readme para execução do mesmo.
    O projeto foi desenvolvido em Java 17, com Spring Boot, Maven, Docker, Mysql, Lombok, Swagger, JPA, Hibernate, Junit, Mockito, Hamcrest, Angular 16, Angular Material.
