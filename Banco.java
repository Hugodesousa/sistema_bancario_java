/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.Banco;
import java.util.Scanner;
/**
 *
 * @author hugo.sousa
 */
public class Banco {
    
    public static class Usuario {
        private final Integer idUsuario;
        private String nome;
        private String sobrenome;
        private String cpf;
        private final Conta contaUsuario;

        public Usuario() {
            this.idUsuario = 100;
            this.contaUsuario = new Conta(this.idUsuario);       
            this.nome = null;
            this.sobrenome = null;
            this.cpf = null;
        }
        
        public double consultarSaldo() {
            return contaUsuario.consultarSaldo();
        }
        
        public void realizarDeposito(double valor) {
            this.contaUsuario.realizarDeposito(valor);
            System.out.println("Deposito realizado");
        }
        
        public void realizarSaque(double valor) {
            this.contaUsuario.realizarSaque(valor);
        }
       
        public Integer pegarIdUsuario() {
            return this.idUsuario;
        }
        
        public String pegarNome() {
            return this.nome;
        }
        
        public String pegarSobrenome() {
            return this.sobrenome;
        }
        
        public String pegarNomeCompleto() {
            return nome + " " + sobrenome;
        }
        
        public String pegarCPF() {
            return this.cpf;
        }
        
        public void alterarNome(String novoNome) {
            this.nome = novoNome;
        }
        
        public void alterarSobrenome(String novoSobrenome) {
            this.sobrenome = novoSobrenome;
        }
        
        public void alterarCPF(String novoCPF) {
            this.cpf = novoCPF;
        }
    }
    
    public static class Conta {
        private final Integer idConta;
        private final Integer idUsuario;
        private double saldo; 
        
        public Conta(Integer usuario) {
            this.idConta = 100;
            this.idUsuario = usuario;
            this.saldo = 0;
        }
        
        public double consultarSaldo() {
            return this.saldo;
        }
        
        public void realizarDeposito(double valor) {
            this.saldo = this.saldo + valor;
            System.out.println("Depósito de R$" + valor + " realizado com sucesso.");
        }
        
        public void realizarSaque(double valor) {     
            if (this.saldo < 0) {
                System.out.println("Você não tem saldo.");
            } else if (valor > this.saldo) {
                System.out.println("Saldo menor que valor de saque.");
            } else {
                this.saldo = this.saldo - valor;
                System.out.println("Saque de R$" + valor + " realizado com sucesso.");
            }
        }
        
        public Integer pegarIdConta(){
            return this.idConta;
        }
        
        public Integer pegarIdUsuario(){
            return this.idUsuario;
        }
    }
    
    public static void main(String[] args) {
        try (Scanner sc = new Scanner(System.in)) {
            Usuario usuario = new Usuario();
            
            System.out.println("Bem-vindo ao Banco Simples!");
            System.out.print("Digite seu nome: ");
            usuario.alterarNome(sc.nextLine());
            
            System.out.print("Digite seu sobrenome: ");
            usuario.alterarSobrenome(sc.nextLine());
            
            System.out.print("Digite seu CPF: ");
            usuario.alterarCPF(sc.nextLine());
            
            int opcao;
            do {
                System.out.println("\n--- Menu ---");
                System.out.println("1 - Consultar Saldo");
                System.out.println("2 - Realizar Depósito");
                System.out.println("3 - Realizar Saque");
                System.out.println("4 - Mostrar Dados do Usuário");
                System.out.println("0 - Encerrar");
                System.out.print("Escolha uma opção: ");
                opcao = sc.nextInt();
                
                switch (opcao) {
                    case 1 -> System.out.println("Saldo atual: R$" + usuario.consultarSaldo());
                    case 2 -> {
                        System.out.print("Digite o valor para depósito: ");
                        double deposito = sc.nextDouble();
                        usuario.realizarDeposito(deposito);
                    }
                    case 3 -> {
                        System.out.print("Digite o valor para saque: ");
                        double saque = sc.nextDouble();
                        usuario.realizarSaque(saque);
                    }
                    case 4 -> {
                        System.out.println("Nome: " + usuario.pegarNomeCompleto());
                        System.out.println("CPF: " + usuario.pegarCPF());
                    }
                    case 0 -> System.out.println("Obrigado por utilizar o Banco Simples. Até logo!");
                    default -> System.out.println("Opção inválida!");
                }
            } while (opcao != 0);
        }
    }
}
