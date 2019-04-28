#Jokenpo

Jokenpo é uma brincadeira japonesa, onde dois jogadores escolhem um dentre três possíveis itens: Pedra, Papel ou Tesoura.

O objetivo é fazer um juiz de Jokenpo que dada a jogada dos dois jogadores informa o resultado da partida.

##As regras são as seguintes:

	- Pedra empata com Pedra e ganha de Tesoura
	- Tesoura empata com Tesoura e ganha de Papel
	- Papel empata com Papel e ganha de Pedra

[Referencia dojopuzzles][id/name] 

[id/name]: http://dojopuzzles.com/problemas/exibe/jokenpo/


##Solução:

Apartir da leitura do teclado utilizando um *BufferedReader*, compara-se a lista de precedência utilizando o '*java.util.Comparetor*', com excessão do 'Papel' e da 'Pedra', que tive que utilizar uma comparação direta, pois esta utiliza uma avaliação ciclica;

###Features
 - É possível sair qualquer momento do jogo digitando 'sair' ou 'exit'
 - Caso o usuário digite a jogada de forma equivocada o jogo solicitará nova digitação



###Baixar o jogo

Escolha uma pasta do seu agrado, por exemplo:

`$ cd /c/projetos/glauber`

execute:

`$ git clone https://github.com/glauberduarte/jokenpo.git`


###Execute o jogo

`$  java -jar build/libs/jokenpo-all-1.0.0-RELEASE.jar`


###Gerando uma nova versão

Caso deseje gerar uma nova versão, navegue até a pasta onde foi feito o download da aplicação, por exemplo:

`$ cd /c/projetos/glauber/jokenpo`


Execute o clean build, para limpar o projeto e realizar o download das dependencias:

`$ ./gradlew clean build --refresh-dependencies`


Execute para gerar a nova versão

`$ ./gradlew fatjar`

A versão gerada ficará em:

`$ cd /c/projetos/glauber/jokenpo/build/libs`

