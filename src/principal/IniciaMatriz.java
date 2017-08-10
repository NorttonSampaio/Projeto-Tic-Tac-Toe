package principal;
public class IniciaMatriz {

    public IniciaMatriz() {
        retornarMatriz();
    }
    
    public int[][] retornarMatriz(){
        int[][] mat = new int[3][3];
        for(int x=0;x<3;x++){
            for(int y=0;y<3;y++){
                mat[x][y]=0;
            }
        }
        return mat;
    }
    
}
