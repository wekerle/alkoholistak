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
}
