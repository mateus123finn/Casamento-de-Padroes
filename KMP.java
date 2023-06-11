import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class KMP {
    
    File file;

    public KMP (File file){
        this.file = file;
    }

    //Função que de acordo com o padrão informado, cria um vetor de Colisões.
    //Depois compara com o texto carregado pelo arquivo e o utiliza para realizar os saltos.
    public void findPadrao(String padrao) throws FileNotFoundException{
        Scanner sc = new Scanner(this.file);
        String texto = "";
        while(sc.hasNext()){
            texto += sc.nextLine();
        }
        int[] vetorColisao = this.createPadrao(padrao);
        int qntComparacoes = 0;

        int posTexto = 0;
        int posPadrao = 0;

        while (posTexto <= texto.length()){
            if(posPadrao >= vetorColisao.length){
                System.out.println("Padrão Encontrado em: "+(posTexto - padrao.length()));
                posPadrao = 0;
                posTexto ++;
                continue;
            }

            if(texto.length() - posTexto + posPadrao < padrao.length()){
                break;
            }
            qntComparacoes ++;
            if(padrao.charAt(posPadrao) == texto.charAt(posTexto)){
                posPadrao ++;
                posTexto ++;
            } else if (posPadrao > 0){
                posPadrao = vetorColisao[posPadrao - 1];
            } else {
                posPadrao = 0;
                posTexto ++;
            }
        }
        System.out.println();
        System.out.println("Algorítimo KMP");
        System.out.println(qntComparacoes+" Comparações");
        System.out.println("");

    }

    // Função que de acordo com o padrão, retorna o vetor de colisões.
    private int[] createPadrao(String padrao){

        int[] vet = new int[padrao.length()];
        int l1 = 0;
        int l2 = 1;
        int num = 0;

        while (l2 < padrao.length()){
            if(padrao.charAt(l1) == padrao.charAt(l2)){
                num ++;
                vet[l2] = num;
                l1 ++;
                l2 ++;
            } else {
                if(l1 > 0){
                    l1 --;
                    num --;
                } else {
                    vet[l2] = num;
                    l2 ++;
                }
            }
        }

        return vet;

    }

}
