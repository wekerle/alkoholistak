package Models;

import Helpers.Enums;
import java.util.ArrayList;

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
    private ArrayList<NextStepSimulateModel> nextSteps =new ArrayList<NextStepSimulateModel>();
    private int levelNumber;
    private boolean lose=false;
    
    private Enums.PozicioAMatrixBan getPoztionInMatrix(int i,int j)
    {
        if(i==0)
        {
            if(j==0)
            {
                return Enums.PozicioAMatrixBan.FelsoBallSarok;
            }else if(j==objects[0].length)
            {
                return Enums.PozicioAMatrixBan.AlsoJobbSarok;
            }else
            {
                return Enums.PozicioAMatrixBan.FelsoOldal;
            }
        }else if(i==objects.length)
        {
            if(j==0)
            {
                return Enums.PozicioAMatrixBan.AlsoBallSarok;
            }else if(j==objects[0].length)
            {
                return Enums.PozicioAMatrixBan.FelsoJobbSarok;
            }else
            {
                return Enums.PozicioAMatrixBan.AlsoOldal;
            }
        }else if(j==0)
        {
            if(i==0)
            {
                return Enums.PozicioAMatrixBan.FelsoBallSarok;
            }else if(i==objects.length)
            {
                return Enums.PozicioAMatrixBan.AlsoBallSarok;
            }else
            {
                return Enums.PozicioAMatrixBan.BallOldal;
            }
        }else if(j==objects[0].length)
        {
            if(i==0)
            {
                return Enums.PozicioAMatrixBan.FelsoJobbSarok;
            }else if(i==objects.length)
            {
                return Enums.PozicioAMatrixBan.AlsoJobbSarok;
            }else
            {
                return Enums.PozicioAMatrixBan.JobbOldal;
            }
        }
        
        return Enums.PozicioAMatrixBan.Kozepen;
    }
    
    public void deleteObject(int i, int j)
    {
        objects[i][j]=new Levego();
    }
    
    public int getLevelNumber() 
    {
        return levelNumber;
    }
    
    public GameSession(LevelModel level)
    {
        this.levelNumber=level.getLevelNumber();
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
                    case ' ':
                        gameObject=new Levego();
                        break;
                }
                objects[i][j]=gameObject;
                gameObject.currentI=i;
                gameObject.currentJ=j;
                gameObject.setGameSession(this);
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
    
    private void simulateNextStep(int i,int j,int numberStepsI,int numberStepsJ)
    {
        if(numberStepsI==0 && numberStepsJ==0)
        {
            return;
        }

        GameObject temp=objects[i][j];
        objects[i][j]=objects[i+numberStepsI][j+numberStepsJ];
        objects[i+numberStepsI][j+numberStepsJ]=temp;
    }
    
    public void addNextStepSimulateModel(NextStepSimulateModel nextStep)
    {
        nextSteps.add(nextStep);
    }
    
    public void clearNextStepSimulateModel()
    {
        nextSteps.clear();
    }
    
    public void simulateNextStep()
    {
        for(NextStepSimulateModel nextStep : nextSteps)
        {
            simulateNextStep(nextStep.getI(),nextStep.getJ(),nextStep.getNumberOfStepsI(),nextStep.getNumberOfStepsJ());
        }
    }
    
    public boolean hasObjectWichCanFall(Enums.GravitacioIranya gravitacioIrany)
    {
        boolean result=false;
        for(int i=0;i<objects.length;i++)
        {
            for(int j=0;j<objects[0].length;j++)
            {
                if(objects[i][j].canFall() && objects[i][j].getNeighbor(gravitacioIrany, i, j) instanceof Levego)
                {
                    result=true;
                    break;
                }
            }
        }
            
        return result;
    }
    
    public boolean win()
    {
        boolean result=true;
        for(int i=0;i<objects.length;i++)
        {
            for(int j=0;j<objects[0].length;j++)
            {
                if(objects[i][j] instanceof NemAlkoholista)
                {
                    result=false;
                    break;
                }
            }
        }
            
        return result;
    }
    
    public ArrayList<GameObject> getMainNeighbors(int i, int j)
    {
        ArrayList<GameObject> neighbors=new ArrayList<GameObject>();
        
        Enums.PozicioAMatrixBan pozicio=getPoztionInMatrix(i, j);
        switch(pozicio)
        {
            case FelsoBallSarok:
                neighbors.add(objects[i][j+1]);
                neighbors.add(objects[i+1][j]);
                break;
            case FelsoJobbSarok:
                neighbors.add(objects[i][j-1]);
                neighbors.add(objects[i+1][j]);
                break;
            case AlsoBallSarok:
                neighbors.add(objects[i-1][j]);
                neighbors.add(objects[i][j+1]);
                break;
            case AlsoJobbSarok:
                neighbors.add(objects[i-1][j]);
                neighbors.add(objects[i][j-1]);
                break;
            case BallOldal:
                neighbors.add(objects[i-1][j]);
                neighbors.add(objects[i][j+1]);
                neighbors.add(objects[i+1][j]);
                break;
            case JobbOldal:
                neighbors.add(objects[i-1][j]);
                neighbors.add(objects[i][j-1]);
                neighbors.add(objects[i+1][j]);
                break;
            case AlsoOldal:
                neighbors.add(objects[i-1][j]);
                neighbors.add(objects[i][j+1]);
                neighbors.add(objects[i][j-1]);
                break;
            case FelsoOldal:
                neighbors.add(objects[i+1][j]);
                neighbors.add(objects[i][j+1]);
                neighbors.add(objects[i][j-1]);
                break;
            case Kozepen:
                neighbors.add(objects[i-1][j]);
                neighbors.add(objects[i+1][j]);
                neighbors.add(objects[i][j+1]);
                neighbors.add(objects[i][j-1]);
                break;              
        }
        
        return neighbors;
    }
    
    public ArrayList<GameObject> getAllNeighbors(int i, int j)
    {
        ArrayList<GameObject> neighbors=new ArrayList<GameObject>();
        
        Enums.PozicioAMatrixBan pozicio=getPoztionInMatrix(i, j);
        switch(pozicio)
        {
            case FelsoBallSarok:
                neighbors.add(objects[i][j+1]);
                neighbors.add(objects[i+1][j]);
                neighbors.add(objects[i+1][j+1]);
                break;
            case FelsoJobbSarok:
                neighbors.add(objects[i][j-1]);
                neighbors.add(objects[i+1][j]);
                neighbors.add(objects[i+1][j-1]);
                break;
            case AlsoBallSarok:
                neighbors.add(objects[i-1][j]);
                neighbors.add(objects[i][j+1]);
                neighbors.add(objects[i-1][j+1]);
                break;
            case AlsoJobbSarok:
                neighbors.add(objects[i-1][j]);
                neighbors.add(objects[i][j-1]);
                neighbors.add(objects[i-1][j-1]);
                break;
            case BallOldal:
                neighbors.add(objects[i-1][j]);
                neighbors.add(objects[i][j+1]);
                neighbors.add(objects[i+1][j]);
                neighbors.add(objects[i-1][j+1]);
                neighbors.add(objects[i+1][j+1]);
                break;
            case JobbOldal:
                neighbors.add(objects[i-1][j]);
                neighbors.add(objects[i][j-1]);
                neighbors.add(objects[i+1][j]);
                neighbors.add(objects[i-1][j-1]);
                neighbors.add(objects[i+1][j-1]);
                break;
            case AlsoOldal:
                neighbors.add(objects[i-1][j]);
                neighbors.add(objects[i][j+1]);
                neighbors.add(objects[i][j-1]);
                neighbors.add(objects[i-1][j-1]);
                neighbors.add(objects[i-1][j+1]);
                break;
            case FelsoOldal:
                neighbors.add(objects[i+1][j]);
                neighbors.add(objects[i][j+1]);
                neighbors.add(objects[i][j-1]);
                neighbors.add(objects[i+1][j-1]);
                neighbors.add(objects[i+1][j+1]);
                break;
            case Kozepen:
                neighbors.add(objects[i-1][j]);
                neighbors.add(objects[i+1][j]);
                neighbors.add(objects[i][j+1]);
                neighbors.add(objects[i][j-1]);
                neighbors.add(objects[i+1][j-1]);
                neighbors.add(objects[i+1][j+1]);
                neighbors.add(objects[i-1][j-1]);
                neighbors.add(objects[i-1][j+1]);
                break;              
        }
        
        return neighbors;
    }
}
