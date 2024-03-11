# Teste Log.One

Projeto realizado como teste técnico para a vaga de desenvolvedor Java na empresa Log.One. O projeto também está disponível no seguinte [link](http://teste-logone.us-east-1.elasticbeanstalk.com/).

Vìdeo explicatório sobre o projeto disponível [aqui](https://youtu.be/bvi-Rxjjrnw?si=3-25ciE2Yu2Qe70q).

## Introdução ao projeto

Para integrar o JSF com o Spring Boot, optei por utilizar a biblioteca JoinFaces, simplificando consideravelmente a configuração. Graças a ela, não precisei lidar diretamente com arquivos como web.xml e faces-config.xml. Além disso, para manter o código limpo e prevenir possíveis bugs, adotei o plugin SonarLint no IntelliJ.

Em relação à estruturação do projeto, optei por uma abordagem diferente, organizando as classes e interfaces em "domains" em vez de dividir em camadas tradicionais como repository, service e entities. Essa escolha foi feita com intuito de evitar a exposição desnecessária de classes e interfaces como públicas. Por exemplo, defini a camada de entities e repository com o modificador de acesso default, visando encapsular e desacoplar o código de forma mais eficiente.

## Tecnologias Utilizadas

- Spring Boot
- JSF
- HyperSQL

## Funcionalidades da aplicação

- **Cadastro de solicitantes:** Permite cadastrar novos solicitantes.

  ![image](https://github.com/lucasruviaro/teste-logone/assets/103154696/d27c5cdf-1790-4e5b-9075-d52194aa75f5)
 
- **Cadastro de vagas:** Permite cadastrar novas vagas dentro de um período específico.

  ![image](https://github.com/lucasruviaro/teste-logone/assets/103154696/42da3bff-c441-4bf4-8575-b71a391ecf3a)

- **Cadastro de agendamentos:** Permite cadastrar agendamentos com data específica.

  ![image](https://github.com/lucasruviaro/teste-logone/assets/103154696/397c76f5-e27d-4ce4-b90e-34668ff17a94)

- **Consulta de agendamentos:** Permite realizar consultas agendamentos realizados dentro de um período específico.

  ![image](https://github.com/lucasruviaro/teste-logone/assets/103154696/ad0e9294-c47a-49ab-b58a-2b4fba786293)
  

## Deploy da aplicação

Como comentado nas entrevistas, como tenho experiência com ambientes cloud como AWS, pensei que seria interessante realizar o deploy dessa aplicação. Por isso, usei os serviços CodePipeline, CodeBuild e Elastic Beanstalk para realizá-lo.

![image](https://github.com/lucasruviaro/teste-logone/assets/103154696/2519c109-94b5-402b-9873-bc43b42b739c)

## Iniciando a aplicação localmente

### Clone o repositório do GitHub
git clone https://github.com/lucasruviaro/teste-logone.git

### Navegue até o diretório do projeto clonado
cd teste-logone

### Execute o projeto Spring Boot com Maven
mvn spring-boot:run

localhost:9292 (no documento do teste estava 9494, mas a aplicação estava configurada como 9292).


