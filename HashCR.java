import java.util.HashMap;
import java.util.Map;


public class HashCR {
    Map<Character, Integer> tabela;

    public HashCR(String padrao) {
        this.tabela = new HashMap<Character, Integer>();
        this.initializeHash(padrao);
    }

    // Função que inicializa a tabela HASH com o padrão, começando pelo penultimo caractere.
    private void initializeHash(String padrao){
        for(int i = padrao.length() - 2; i >= 0; i--){
            if(tabela.get(padrao.charAt(i)) == null){
                tabela.put(padrao.charAt(i), i);
            }
        }
    }

    //Função que retorna a posição do caractere "letra", se não existe retorna -1.
    public int getElemento(char letra){
        return tabela.getOrDefault(letra, -1);
    }

}
