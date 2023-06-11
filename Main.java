import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Main{
    public static void main(String[] args){

        if(args.length < 1 || args.length > 1){
            System.out.println("Uso Incorreto !!!");
            System.out.println("TP4 <Nome do Arquivo>");
            return;
        }

        System.out.println("Casamento de Padrões VER 1.0 - @ Mateus Leal");
        Scanner sc = new Scanner(System.in);
        File file = new File(args[0]);

        BoyerMoore bm = new BoyerMoore(file);
        KMP kmp = new KMP(file);
        String padrao = "";
        while(!padrao.equals("-1")){
            System.out.println("Digite o Padrão a ser buscado ou -1 para Sair");
            padrao = sc.nextLine();
            if(!padrao.equals("-1")){
                try{
                kmp.findPadrao(padrao);
                bm.achaPadrao(padrao);
                } catch(Exception e){
                    System.out.println("Arquivo não Encontrado");
                    return;
                }
            }
        }
    }
}