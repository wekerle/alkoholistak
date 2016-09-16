/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DataCollector;

import java.util.ArrayList;


//loveercase es trim a similarty setbe
//test similarity
/**
 *
 * @author Ronaldo
 */
public class DataCollector
{
    private ArrayList<char[][]> stages=new ArrayList<char[][]>();
    
    public DataCollector()
    {
        constructStages();
        //# -fal
        //a -alkololista
        //b -nem alkoholista
    }
    
    private void constructStages()
    {
        // nivelul 1
        char[][] stage1={
            {'a','a','a'},
            {'a','a','a'},
            {'a','a','a'},
            {'a','a','a'},
        };
        stages.add(stage1);
    }
    
    private ArrayList<char[][]>  getStages()
    {
        return stages;
    }
    
}
