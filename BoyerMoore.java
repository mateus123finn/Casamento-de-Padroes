import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class BoyerMoore {
    File file;

    public BoyerMoore(File file) {
        this.file = file;
    }


    //Função que de acordo com o padrão informado, cria uma tabela HASH para o Caractere Ruim e um vetor para o Sufixo Bom.
    //Depois compara com o texto carregado pelo arquivo e utiliza o maior movimento para os saltos.
    public void achaPadrao(String padrao) throws FileNotFoundException{
        HashCR cr = new HashCR(padrao);
        VetorSB sb = new VetorSB(padrao);

        Scanner sc = new Scanner(this.file);
        String texto = "";
        while(sc.hasNext()){
            texto += sc.nextLine();
        }

        int qntComparacoes = 0;

        int posTexto = padrao.length() - 1;

        boolean acabouTexto = false;
        while(!acabouTexto){
            for (int i = padrao.length() - 1; i >= 0; i--) {
                if(posTexto >= texto.length()){
                    acabouTexto = true;
                    break;
                }
                qntComparacoes ++;
                if(texto.charAt(posTexto) != padrao.charAt(i)){
                    int jcr = cr.getElemento(texto.toUpperCase().charAt(posTexto));
                    int jsb = sb.getElemento(i);

                    if((i - jcr) > jsb && posTexto+((padrao.length()) - i) + (i - jcr) < texto.length()){
                        posTexto += ((padrao.length()) - i) + (i - jcr);
                    } else {
                        posTexto += ((padrao.length()) - i) + (jsb);
                    }
                    i = padrao.length();
                }

                posTexto -= 1;
                
            }
            if(!acabouTexto){
                //System.out.println("Encontrei");
                posTexto += padrao.length() + 1;
            }
        }

        System.out.println("Algorítimo Boyer Moore");
        System.out.println(qntComparacoes+" Comparações");
        System.out.println("");

    }
}
