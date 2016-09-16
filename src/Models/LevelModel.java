/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Models;

/**
 *
 * @author tibor.wekerle
 */
public class LevelModel {
    private char[][] matrix;
    private int levelNumber;
    private int levelId;
    
    public LevelModel(char[][] matrix,int levelNumber, int levelId)
    {
        this.matrix=matrix;
        this.levelNumber=levelNumber;
        this.levelId=levelId;
    }

    public char[][] getMatrix() 
    {
        return matrix;
    }

    public int getLevelId() 
    {
        return levelId;
    }

    public int getLevelNumber() 
    {
        return levelNumber;
    }
    
}
