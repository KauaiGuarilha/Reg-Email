package br.com.cadastroEmail;

import corejava.*;
import java.io.*;
import java.util.ArrayList;

public class Principal {
    
    public static void main(String[] args) {
        
        final int tam = Console1.readInt("Informe a quantidade de cadastros que deseja efetuar: ");
        ArrayList<Email> lista = new ArrayList(tam);
        String nome;
        String email;
        Email umEmail = null;
        
        try{
            ObjectInputStream in = new ObjectInputStream(new FileInputStream("C:\\Email\\dados.txt"));
            lista = (ArrayList<Email>) in.readObject();
            umEmail.setContador(((Integer) in.readObject()).intValue());
            in.close();
        }catch(FileNotFoundException e){
            lista = new ArrayList(tam);
        
        }catch(IOException e){
            e.printStackTrace();
            System.exit(tam);
        
        }catch(ClassNotFoundException e){
            e.printStackTrace();
            System.exit(tam);
        }
        
        boolean continua = true;
        
        System.out.println("_______________________________");
        System.out.println("_______Cadastro de Email_______");
        System.out.println("_______________________________");
        
        while(continua){
            
            System.out.println('\n' + "1. Cadastrar");
            System.out.println('\n' + "2. Remover");
            System.out.println('\n' + "3. Listar");
            System.out.println('\n' + "4. Sair");
           
            int opcao = Console1.readInt('\n' + "Informe a opção desejada : ");
            
            switch(opcao){
                
                case 1: {
                    nome = Console1.readLine('\n' + "Informe o nome: ");
                    email = Console1.readLine('\n' + "Informe o Email: ");
                    umEmail = new Email(nome, email);
                    lista.add(umEmail);
                    break;
                }
                
                case 2: {
                    int resposta = Console1.readInt('\n' + "Informe o número que Deseja remover: ");
                    
                    boolean achou = false;
                    int i;
                        for(i = 0; i < lista.size(); i++){
                            umEmail = lista.get(i);
                            if(resposta == umEmail.getNumero()){
                                achou = true;
                                break;
                            }
                        } 
                        
                        if(achou){
                            lista.remove(i);
                            System.out.println('\n' + "Removido com sucesso!");
                        } else{
                            System.out.println('\n' + "Não há cadastros para remover!");
                        }
                        
                    break;
                }
                
                case 3:{
                    if(lista.isEmpty()){
                        System.out.println('\n' + "Não há cadastros");
                    }else{
                        for(int i = 0; i < lista.size(); i++){
                            umEmail = lista.get(i);
                            umEmail.imprime();
                        }
                        
                    }
                   break; 
                }
                
                case 4:{
                    String resposta = Console1.readLine('\n' + "Deseja Salvar as Alterações ? (s/n)");
                    
                    if(resposta.equals("s")){
                        try{
                            ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream("C:\\Email\\dados.txt"));
                            out.writeObject(lista);
                            out.writeObject(new Integer(umEmail.getContador()));
                            out.close();
                        } catch(FileNotFoundException e){
                            e.printStackTrace();
                            System.exit(tam);
                        } catch(IOException e){
                            e.printStackTrace();
                            System.exit(tam);
                        }
                    } else{
                        System.out.println('\n' + "Os Dados não foram Salvos!");
                    }
                    continua = false;
                    break;
                }
                
                default:
                    System.out.println('\n' + "Opção Inválida!");
                    break;
            }
        }
    }
}
