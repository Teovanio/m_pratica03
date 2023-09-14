/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package cadastrobd;

import java.sql.SQLException;
import java.util.ArrayList;

import cadastrobd.model.PessoaFisica;
import cadastrobd.model.PessoaFisicaDAO;
import cadastrobd.model.PessoaJuridica;
import cadastrobd.model.PessoaJuridicaDAO;
import cadastrobd.model.util.SequenceManager;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Usuario
 */
public class CadastroBD {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        BufferedReader reader = new BufferedReader(
                new InputStreamReader(System.in));
        PessoaFisicaDAO PFisicaDao = new PessoaFisicaDAO();
        PessoaJuridicaDAO PJuridicaDao = new PessoaJuridicaDAO();
        SequenceManager sequenceCode = new SequenceManager();
        int nextValue;

        String opcao = "";

        while (!"0".equals(opcao)) {
            try {
                System.out.println("1 - Incluir");
                System.out.println("2 - Alterar");
                System.out.println("3 - Excluir");
                System.out.println("4 - Exibir pelo ID");
                System.out.println("5 - Exibir Todos");
                System.out.println("0 - Finalizar Execução");
                
                System.out.println("---------------------------------------------");
                
                // Reading data using readLine
                opcao = reader.readLine();
                
                // Printing the read line
                System.out.println(opcao);
                
                String pessoa;
                
                switch (opcao) {
                    
                    case "1" -> {
                        System.out.println("F - Pessoa Fisica | J - Pessoa Juridica");
                        pessoa = reader.readLine();
                        nextValue = sequenceCode.getValue("CodigoPessoa");
                        switch (pessoa) {
                            case "F" -> {
                                PessoaFisica p = new PessoaFisica();
                                System.out.println(" Digite o CPF da pessoa: ");
                                p.setCpf(reader.readLine());
                                p.setId(nextValue);
                                System.out.println(" Digite o nome da pessoa: ");
                                p.setNome(reader.readLine());
                                System.out.println(" Digite o endereço da pessoa: ");
                                p.setLogradouro(reader.readLine());
                                System.out.println(" Digite a cidade: ");
                                p.setCidade(reader.readLine());
                                System.out.println(" Digite o estado: ");
                                p.setEstado(reader.readLine());
                                System.out.println(" Digite o telefone: ");
                                p.setTelefone(reader.readLine());
                                System.out.println(" Digite o e-mail: ");
                                p.setEmail(reader.readLine());
                                PFisicaDao.incluir(p);
                                System.out.println("Pessoa Inserida com sucesso: ");
                                p.exibir();
                            }
                            case "J" -> {
                                PessoaJuridica j = new PessoaJuridica();
                                System.out.println(" Digite o CNPJ da pessoa: ");
                                j.setCnpj(reader.readLine());
                                j.setId(nextValue);
                                System.out.println(" Digite o nome da pessoa: ");
                                j.setNome(reader.readLine());
                                System.out.println(" Digite o endereço da pessoa: ");
                                j.setLogradouro(reader.readLine());
                                System.out.println(" Digite a cidade: ");
                                j.setCidade(reader.readLine());
                                System.out.println(" Digite o estado: ");
                                j.setEstado(reader.readLine());
                                System.out.println(" Digite o telefone: ");
                                j.setTelefone(reader.readLine());
                                System.out.println(" Digite o e-mail: ");
                                j.setEmail(reader.readLine());
                                PJuridicaDao.incluir(j);
                                System.out.println("Pessoa Inserida com sucesso: ");
                                j.exibir();
                            }
                        }
                    }
                    
                    case "2" -> {
                        System.out.println("F - Pessoa Fisica | J - Pessoa Juridica");
                        pessoa = reader.readLine();
                        switch (pessoa) {
                            case "F" -> {
                                System.out.println(" Digite o Id que deseja alterar: ");
                                int id = Integer.parseInt(reader.readLine());
                                PessoaFisica pf = PFisicaDao.getPessoa(id);
                                
                                System.out.println("O CPF Antigo da Pessoa é: " + pf.getCpf() + 
                                " Digite um novo CPF da pessoa ou deixe em branco para não alterar: ");
                                String cpf = reader.readLine();
                                if(!cpf.isBlank() && !cpf.isEmpty()){
                                    pf.setCpf(cpf);
                                }
                                
                                System.out.println("O Nome Antigo da Pessoa é: " + pf.getNome() + 
                                " Digite o novo Nome da pessoa ou deixe em branco para não alterar: ");
                                String nome = reader.readLine();
                                if(!nome.isBlank() && !nome.isEmpty()){
                                    pf.setNome(nome);
                                }
                                
                                System.out.println("O Logradouro Antigo da Pessoa é: " + pf.getLogradouro() + 
                                " Digite o novo Logradouro da pessoa ou deixe em branco para não alterar: ");
                                String logradouro = reader.readLine();
                                if(!logradouro.isBlank() && !logradouro.isEmpty()){
                                    pf.setLogradouro(logradouro);
                                }
                                
                                System.out.println("A Cidade Antigo da Pessoa é: " + pf.getCidade() + 
                                " Digite a nova Cidade da pessoa ou deixe em branco para não alterar: ");
                                String cidade = reader.readLine();
                                if(!cidade.isBlank() && !cidade.isEmpty()){
                                    pf.setCidade(cidade);
                                }
                                
                                System.out.println("O Estado Antigo da Pessoa é: " + pf.getEstado() + 
                                " Digite o novo Estado da pessoa ou deixe em branco para não alterar: ");
                                String estado = reader.readLine();
                                if(!estado.isBlank() && !estado.isEmpty()){
                                    pf.setEstado(estado);
                                }
                                
                                System.out.println("O Telefone Antigo da Pessoa é: " + pf.getTelefone() + 
                                " Digite o novo Telefone da pessoa ou deixe em branco para não alterar: ");
                                String telefone = reader.readLine();
                                if(!telefone.isBlank() && !telefone.isEmpty()){
                                    pf.setTelefone(telefone);
                                }
                                
                                System.out.println("O Email Antigo da Pessoa é: " + pf.getEmail() + 
                                " Digite um novo Email da pessoa ou deixe em branco para não alterar: ");
                                String email = reader.readLine();
                                if(!email.isBlank() && !email.isEmpty()){
                                    pf.setEmail(email);
                                }
                                
                                PFisicaDao.alterar(pf);
                                
                            }
                            case "J" -> {
                                System.out.println(" Digite o Id que deseja alterar: ");
                                int id = Integer.parseInt(reader.readLine());
                                PessoaJuridica pj = PJuridicaDao.getPessoa(id);
                                
                                System.out.println("O CNPJ Antigo da Pessoa é: " + pj.getCnpj()+ 
                                " Digite um novo CNPJ da pessoa ou deixe em branco para não alterar: ");
                                String cnpj = reader.readLine();
                                if(!cnpj.isBlank() && !cnpj.isEmpty()){
                                    pj.setCnpj(cnpj);
                                }
                                
                                System.out.println("O Nome Antigo da Pessoa é: " + pj.getNome() + 
                                " Digite o novo Nome da pessoa ou deixe em branco para não alterar: ");
                                String nome = reader.readLine();
                                if(!nome.isBlank() && !nome.isEmpty()){
                                    pj.setNome(nome);
                                }
                                
                                System.out.println("O Logradouro Antigo da Pessoa é: " + pj.getLogradouro() + 
                                " Digite o novo Logradouro da pessoa ou deixe em branco para não alterar: ");
                                String logradouro = reader.readLine();
                                if(!logradouro.isBlank() && !logradouro.isEmpty()){
                                    pj.setLogradouro(logradouro);
                                }
                                
                                System.out.println("A Cidade Antigo da Pessoa é: " + pj.getCidade() + 
                                " Digite a nova Cidade da pessoa ou deixe em branco para não alterar: ");
                                String cidade = reader.readLine();
                                if(!cidade.isBlank() && !cidade.isEmpty()){
                                    pj.setCidade(cidade);
                                }
                                
                                System.out.println("O Estado Antigo da Pessoa é: " + pj.getEstado() + 
                                " Digite o novo Estado da pessoa ou deixe em branco para não alterar: ");
                                String estado = reader.readLine();
                                if(!estado.isBlank() && !estado.isEmpty()){
                                    pj.setEstado(estado);
                                }
                                
                                System.out.println("O Telefone Antigo da Pessoa é: " + pj.getTelefone() + 
                                " Digite o novo Telefone da pessoa ou deixe em branco para não alterar: ");
                                String telefone = reader.readLine();
                                if(!telefone.isBlank() && !telefone.isEmpty()){
                                    pj.setTelefone(telefone);
                                }
                                
                                System.out.println("O Email Antigo da Pessoa é: " + pj.getEmail() + 
                                " Digite um novo Email da pessoa ou deixe em branco para não alterar: ");
                                String email = reader.readLine();
                                if(!email.isBlank() && !email.isEmpty()){
                                    pj.setEmail(email);
                                }
                                
                                PJuridicaDao.alterar(pj);
                            }
                        }
                    }
                    
                    case "3" -> {
                        System.out.println("F - Pessoa Fisica | J - Pessoa Juridica");
                        pessoa = reader.readLine();
                        switch (pessoa) {
                            case "F" -> {
                                System.out.println(" Digite o Id da pessoa");
                                int id = Integer.parseInt(reader.readLine());
                                PFisicaDao.excluir(id);
                                
                            }
                            case "J" -> {
                                System.out.println(" Digite o Id da pessoa");
                                int id = Integer.parseInt(reader.readLine());
                                PJuridicaDao.excluir(id);
                            }
                        }
                    }
                    
                    case "4" -> {
                        System.out.println("F - Pessoa Fisica | J - Pessoa Juridica");
                        pessoa = reader.readLine();
                        switch (pessoa) {
                            case "F" -> {
                                System.out.println(" Digite o Id da pessoa");
                                int id = Integer.parseInt(reader.readLine());
                                PessoaFisica pf = PFisicaDao.getPessoa(id);
                                pf.exibir();
                                
                            }
                            case "J" -> {
                                System.out.println(" Digite o Id da pessoa");
                                int id = Integer.parseInt(reader.readLine());
                                PessoaJuridica pj = PJuridicaDao.getPessoa(id);
                                pj.exibir();
                            }
                        }
                    }
                    
                    case "5" -> {
                        System.out.println("F - Pessoa Fisica | J - Pessoa Juridica");
                        pessoa = reader.readLine();
                        switch (pessoa) {
                            case "F" -> {
                                ArrayList<PessoaFisica> list = PFisicaDao.getPessoas();
                                for (int i = 0; i < list.size(); i++) {
                                    list.get(i).exibir();
                                }
                            }
                            case "J" -> {
                                ArrayList<PessoaJuridica> list = PJuridicaDao.getPessoas();
                                for(int i = 0; i < list.size(); i++){
                                    list.get(i).exibir();
                                }
                            }
                        }
                    }
                    
                    case "0" -> {
                        System.out.println("Fechando o sistema");
                    }
                    
                    default -> {
                    }
                    
                }
            } catch (IOException ex) {
                Logger.getLogger(CadastroBD.class.getName()).log(Level.SEVERE, null, ex);
                System.out.println("Não foi possível ler o que foi digitado!");
            } catch (SQLException expt) {
                Logger.getLogger(CadastroBD.class.getName()).log(Level.SEVERE, null, expt);
                System.out.println("Não foi possível Manipular o Banco de Dados!");
            }
        }
    }

}
