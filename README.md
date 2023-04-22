[![Open in Codespaces](https://classroom.github.com/assets/launch-codespace-f4981d0f882b2a3f0472912d15f9806d57e124e0fc890972558857b51b24a6f9.svg)](https://classroom.github.com/open-in-codespaces?assignment_repo_id=10074921)
# Varejo Molejo - Projeto de Gestão de Estoque
O projeto "Varejo Molejo", apresentado à disciplina de Laboratório de Programação Modular, tem como objetivo elaborar, conforme os requisitos propostos nos enunciados, uma aplicação de controle de estoque destinada a um cliente fictício, cujo negócio é uma mercearia. O desenvolvimento do projeto teve como base o TDD (Test-driven Development), no qual se implementou as classes de negócio — Produto e Estoque —, bem como suas respectivas classes de teste.

---

## Nota base do grupo: 10

A nota final, que é individual, se dará pela nota acima, multiplicada por um peso entre 0 e 1 relativo ao acompanhamento semanal do projeto. Lembre-se: não é só a entrega do produto finalizado que importa, é todo o processo de sua construção e as entregas parciais para o “cliente”.

## Comentários

### Diagrama + aderência das classes ao diagrama: 1,8/2 pontos 
    - "adicionarProduto", que causou diversos outros problemas.
	
### Requisitos corretamente implementados: 3/6 pontos 
	- produto (preço, estoque)
        - print em classe
        - sets sem validação
	- estoque (valor, abaixo do estoque)
        - no teste e no main, "adicionarProduto" recebe 2 parâmetros. Na classe, só tem um parâmetro: sistema não executa, nem o teste.
	- sistema (vender, comprar, consultas)
        - parece que cria produtos com quantidade 0 e depois não informa o que está acontecendo.
        - mensagem "Houve um erro ao realizar a venda" quando não tem estoque para venda: pouco intuitiva.

    - observações sem descontar nota:
        - pode-se usar "constantes" (static final) para os valores literais (margem, imposto etc)
        - se está usando HashMap, use o "get" para procurar. Não faz sentido um "for"
        - sistema sem opção no menu para encerrar.

### Documentação de código: 2,2/3 pontos 
    - documentação presente, porém pouco útil em vários casos do estoque: adicionarProduto, por exemplo
 		
### Testes (quantidade e qualidade): 3/4 pontos 
	- produto: 2/2 pontos
	- estoque: 1/2 pontos (não rodou se eu não consertar o parâmetro de adicionarProduto)

---

## Alunos integrantes da equipe
* André Rodrigues de Freitas Faria 
* Carlos Emanuel Silva e Melo Oliveira 
* Gustavo Andrade Alves 
* Letícia Teixeira Lott Carvalho 
* Yan Rodrigues Nalon 

## Professores responsáveis
* João Caram Santos de Oliveira

