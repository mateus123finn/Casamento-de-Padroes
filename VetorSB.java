
public class VetorSB {
    int[] vetor;
    public int[] getVetor() {
        return vetor;
    }
    public void setVetor(int[] vetor) {
        this.vetor = vetor;
    }
    public VetorSB(String padrao) {
        this.vetor = new int[padrao.length()];
        this.initializeVetor(padrao);
    }

    public int getElemento(int pos){
        return vetor[pos];
    }

    // Função que criar o vetor de saltos para o Sufixo bom, de acordo com o padrão.
    private void initializeVetor(String padrao){
        vetor[padrao.length() - 1] = 1;
        String aux = "";
        for(int i = padrao.length() - 2; i >= 0; i--){
            aux = padrao.charAt(i+1) + aux;
            int index = padrao.length();
            do{
                index = padrao.lastIndexOf(aux,index - 1);
                if (index == -1 || index == 0){
                    break;
                }
                if(padrao.charAt(index - 1) != padrao.charAt(i)){
                    vetor[i] = i - (index - 1);
                    break;
                }
            } while(index != -1);

            if(vetor[i] != 0){
                continue;
            }
            
            for (int j = 0; j < aux.length(); j++) {
                if(padrao.startsWith(aux.substring(j))){
                    vetor[i] = padrao.length() - (aux.length() - j);
                    break;
                }
            }

            if(vetor[i] != 0){
                continue;
            }

            vetor[i] = padrao.length();
            
        }

    }
    


}
