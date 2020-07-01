
package cursojavaudemyfx185;

import entidades.Produto;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

public class CursoJavaUdemyFx185 {

    public static void main(String[] args) {
        Locale.setDefault(Locale.US);
        try (Scanner sc = new Scanner(System.in)) {
            //armazenando o url passada pelo usuário
            System.out.print("Informe o caminho do arquivo: ");
            String strPath = sc.nextLine();
            
            //criando a pasta de saída
            File path = new File(strPath);
            boolean criarPasta = new File(path.getParent() + "\\out").mkdir();
            System.out.println("PASTA CRIADA COM SUCESSO!");
            
            //receberá as informações
            List<Produto> listaProd = new ArrayList<>();
            
            //fazendo a leitura do arquivo e armazenando os dados no objeto
            try (BufferedReader bfLeitura = new BufferedReader(new FileReader(strPath))) {
                String linha = bfLeitura.readLine();    //pode retornar null
                
                System.out.println();
                System.out.println("Lendo o arquivo informado e iniciando gravação!");
                
                while (linha != null){
                    System.out.println(linha);
                    
                    String[] campos = linha.split(","); //quebra a linha em campos e guarda na variavel
                    
                    String nomeProd = campos[0];
                    double valorUnit = Double.parseDouble(campos[1]);
                    int quantidade = Integer.parseInt(campos[2]);
                    
                    listaProd.add(new Produto(nomeProd, valorUnit, quantidade));
                    
                    linha = bfLeitura.readLine();
                }
                
                //armazenando o caminho para p arquivo de saída
                String urlFileOut = path.getParent() + "\\out\\summary.csv";
                
                try(BufferedWriter bfEscrita = new BufferedWriter(new FileWriter(urlFileOut))) {
                    for (Produto lEscrever : listaProd) {
                        bfEscrita.write(lEscrever.getNome() + "," + String.format("%.2f", lEscrever.calcularTotal()));
                        bfEscrita.newLine();
                    }
                    
                    System.out.println();
                    System.out.println("ARQUIVO DE SAÍDA CRIADO COM SUCESSO EM: " + urlFileOut);
                    
                } catch (IOException e) {
                    System.out.println("Error: " + e.getMessage());
                }
            } catch (IOException e) {
                System.out.println("Error: " + e.getMessage());
            }            
                
        }
    
    }
}
