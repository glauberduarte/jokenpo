#Jokenpo

Jokenpo � uma brincadeira japonesa, onde dois jogadores escolhem um dentre tr�s poss�veis itens: Pedra, Papel ou Tesoura.

O objetivo � fazer um juiz de Jokenpo que dada a jogada dos dois jogadores informa o resultado da partida.

##As regras s�o as seguintes:

	- Pedra empata com Pedra e ganha de Tesoura
	- Tesoura empata com Tesoura e ganha de Papel
	- Papel empata com Papel e ganha de Pedra

[Referencia dojopuzzles][id/name] 

[id/name]: http://dojopuzzles.com/problemas/exibe/jokenpo/


##Solu��o:

Apartir da leitura do teclado utilizando um *BufferedReader*, compara-se a lista de preced�ncia utilizando o '*java.util.Comparetor*', com excess�o do 'Papel' e da 'Pedra', que tive que utilizar uma compara��o direta, pois esta utiliza uma avalia��o ciclica;

###Features
 - � poss�vel sair qualquer momento do jogo digitando 'sair' ou 'exit'
 - Caso o usu�rio digite a jogada de forma equivocada o jogo solicitar� nova digita��o



###Baixar o jogo

Escolha uma pasta do seu agrado, por exemplo:

`$ cd /c/projetos/glauber`

execute:

`$ git clone https://github.com/glauberduarte/jokenpo.git`


###Execute o jogo

`$  java -jar build/libs/jokenpo-all-1.0.0-RELEASE.jar`


###Gerando uma nova vers�o

Caso deseje gerar uma nova vers�o, navegue at� a pasta onde foi feito o download da aplica��o, por exemplo:

`$ cd /c/projetos/glauber/jokenpo`


Execute o clean build, para limpar o projeto e realizar o download das dependencias:

`$ ./gradlew clean build --refresh-dependencies`


Execute para gerar a nova vers�o

`$ ./gradlew fatjar`

A vers�o gerada ficar� em:

`$ cd /c/projetos/glauber/jokenpo/build/libs`

