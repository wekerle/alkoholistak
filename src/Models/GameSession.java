package Models;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Ronaldo
 */
public class GameSession 
{
    private GameObject[][] objects=null;
    public GameSession(LevelModel level)
    {
        char[][] matrix=level.getMatrix();
        int height=matrix.length;
        int width=matrix[0].length;
        objects=new GameObject[height][width];
                
        int i=0,j=0;
        for(i=0;i<height;i++)
        {
            for(j=0;j<width;j++)
            {
                //# -fal
                //a -alkololista
                //b -nem alkoholista
                //c -vas lada
                //d -fa lada
                //e -bomba
                //f -tuskek
                
                GameObject gameObject=null;
                gameObject.setX(i);
                gameObject.setY(j);
                
                switch(matrix[i][j])
                {
                    case '#':
                        gameObject=new Fal();
                        break;
                    case 'a':
                        gameObject=new Alkoholista();
                        break;
                    case 'b':
                        gameObject=new NemAlkoholista();
                        break;
                    case 'c':
                        gameObject=new VasLada();
                        break;
                    case 'd':
                        gameObject=new FaLada();
                        break;
                    case 'e':
                        gameObject=new Bomba();
                        break;
                    case 'f':
                        gameObject=new Tuske();
                        break;
                }
                objects[i][j]=gameObject;
            }
        }
    }
    
    public int getWidth()
    {
        return objects[0].length;
    }
    
    public int getHeight()
    {
       return objects.length;
    }
    
    public GameObject getGameObjectAt(int x,int y)
    {
        return objects[x][y];
    }

}
