Algoritmo "Cadastro SIS Bora Bora Viagens"
// Disciplina   : Atividade Prática do Módulo 2
// Descrição   : Simulação de Cadastro para uma Agência de Viagens
// Autor(a)    : Marcos André Nonaka
// Data atual  : 03/07/2022
Var
   // Seção de Declarações das variáveis

   opcao: inteiro
   dadosCliente: vetor [1..4] de caractere
   dadosDestino: vetor [1..5] de caractere
   i: inteiro

Inicio
   // Seção de Comandos, procedimento, funções, operadores, etc...

   procedimento menu

   inicio

      escreval("Escolha uma opção:")
      escreval("")
      escreval("1 - Cadastro de cliente")
      escreval("2 - Consulta de cliente")
      escreval("3 - Cadastro de destino")
      escreval("4 - Consulta de destino")
      escreval("ENTER - Sair")
      escreval("")
      escreval("-----------------------------------------------------------")
      leia(opcao)
      escreval("")

      escolha opcao
         caso 1
            lerDadosCliente
         caso 2
            exibeDadosCliente
         caso 3
            lerDadosDestino
         caso 4
            exibeDadosDestino
      fimescolha

   fimprocedimento

   procedimento lerDadosCliente

   inicio

      para i de 1 ate 4 faca
      
         escolha i
            caso 1
               escreval("Informe o nome do cliente:")
               leia(dadosCliente[i])
            caso 2
               escreval("Informe o CPF do cliente:")
               leia(dadosCliente[i])
            caso 3
               escreval("Informe o telefone do cliente:")
               leia(dadosCliente[i])
            caso 4
               escreval("Informe o endereço do cliente:")
               leia(dadosCliente[i])
         fimescolha
         
      fimpara
      
      escreval("")
      escreval("Cadastro de cliente realizado com sucesso!")
      escreval("")
      escreval("-----------------------------------------------------------")
      menu

   fimprocedimento
   
   procedimento exibeDadosCliente
   
   inicio
   
      se dadosCliente[1] = "" entao
         escreval("Cadastre um cliente antes de realizar uma consulta.")
         escreval("")
         menu
      senao
         escreval("Dados do cliente:")
         escreval("")

         para i de 1 ate 4 faca

            escolha i
               caso 1
                  escreva("Nome: ")
               caso 2
                  escreva("CPF: ")
               caso 3
                  escreva("Telefone: ")
               caso 4
                  escreva("Endereço: ")
            fimescolha

            escreval(dadosCliente[i])
         
         fimpara

         escreval("")
         escreval("-----------------------------------------------------------")
         menu
      
      fimse
      
   fimprocedimento

   procedimento lerDadosDestino

   inicio
   
      se dadosCliente[1] = "" entao
         escreval("Cadastre um cliente antes de cadastrar um destino.")
         escreval("")
         menu
      senao

         para i de 1 ate 5 faca

            escolha i
               caso 1
                  escreval("Informe o destino da viagem do cliente ", dadosCliente[i], ":")
                  leia(dadosDestino[i])
               caso 2
                  escreval("Informe a data de ida:")
                  leia(dadosDestino[i])
               caso 3
                  escreval("Informe a data de volta:")
                  leia(dadosDestino[i])
               caso 4
                  escreval("Informe o nome da companhia aérea:")
                  leia(dadosDestino[i])
               caso 5
                  escreval("Informe o nome do hotel:")
                  leia(dadosDestino[i])
            fimescolha

         fimpara

         escreval("")
         escreval("Cadastro de destino realizado com sucesso!")
         escreval("")
         escreval("-----------------------------------------------------------")
         menu
         
      fimse

   fimprocedimento

   procedimento exibeDadosDestino

   inicio

      se dadosDestino[1] = "" entao
         escreval("Cadastre um destino antes de realizar uma consulta.")
         escreval("")
         menu
      senao
         escreval("Dados da viagem para o destino ", dadosDestino[1], ":")
         escreval("")

         para i de 2 ate 5 faca

            escolha i
               caso 2
                  escreva("Data de ida: ")
               caso 3
                  escreva("Data de volta: ")
               caso 4
                  escreva("Companhia aérea: ")
               caso 5
                  escreva("Hotel: ")
            fimescolha

            escreval(dadosDestino[i])

         fimpara

         escreval("")
         escreval("-----------------------------------------------------------")
         menu

      fimse

   fimprocedimento

   escreval("********** Bem-vindo(a) ao SIS Bora Bora Viagens **********")
   escreval("")
   menu

Fimalgoritmo