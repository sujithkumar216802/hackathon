package com.example.hackathon;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class viewmodel extends ViewModel {


    Integer[][] grid = new Integer[8][10];


    // 0 - empty
    //1-red spinx(down)
    //2-red spinx(right)

    //3-Rpyramid(top-right)
    //4-Rpyramid(right-down)
    //5-Rpyramidv(down-left)
    //6-Rpyramid(left-up)

    //7-Ranubis(top)
    //8-Ranubis(right)
    //9-Ranubis(down)
    //10-Ranubis(left)


    //13-Rscarab(down-left)    
    //14-Rscarab(left-top)

    //15-Rparoah(left)
    //16-Rparoah(right)
    //17-Rparoah(down)
    //18-Rparoah(up)


    //21-red spinx(up)
    //22-red spinx(left)

    //23-Rpyramid(top-right)
    //24-Rpyramid(right-down)
    //25-Rpyramidv(down-left)
    //26-Rpyramid(left-up)

    //27-Ranubis(top)
    //28-Ranubis(right)
    //29-Ranubis(down)
    //30-Ranubis(left)


    //33-Rscarab(down-left)
    //34-Rscarab(left-top)

    //35-Rparoah(left)
    //36-Rparoah(right)
    //37-Rparoah(down)
    //38-Rparoah(up)


    Integer touchx, touchy, turn;
    MutableLiveData<Boolean> selected = new MutableLiveData<>();


    public Integer getTouchx() {
        return touchx;
    }

    public void setTouchx(Integer touchx) {
        this.touchx = touchx;
    }

    public Integer getTouchy() {
        return touchy;
    }

    public void setTouchy(Integer touchy) {
        this.touchy = touchy;
    }

    public Integer getTurn() {
        return turn;
    }

    public void setTurn(Integer turn) {
        this.turn = turn;
    }

    public MutableLiveData<Boolean> getSelected() {
        if (selected.getValue() == null)
            selected.setValue(false);
        return selected;
    }

    public void setSelected(MutableLiveData<Boolean> selected) {
        this.selected = selected;
    }

    void init() {

        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 10; j++)
                grid[i][j] = 0;
        }

        grid[0][0] = 1;
        grid[3][0] = 3;
        grid[4][0] = 4;
        grid[1][2] = 5;
        grid[0][4] = 9;
        grid[0][6] = 9;
        grid[0][5] = 17;
        grid[0][7] = 4;
        grid[3][4] = 12;
        grid[3][5] = 13;
        grid[3][7] = 4;
        grid[4][7] = 3;
        grid[5][6] = 4;


        grid[7][9] = 21;
        grid[7][2] = 26;
        grid[7][3] = 27;
        grid[7][4] = 38;
        grid[7][5] = 27;
        grid[5][7] = 23;
        grid[3][9] = 26;
        grid[4][9] = 25;
        grid[2][3] = 26;
        grid[3][2] = 25;
        grid[4][2] = 26;
        grid[4][4] = 32;
        grid[4][5] = 33;


    }


    public Integer[][] getGrid() {
        return grid;
    }

    public void setGrid(Integer[][] grid) {
        this.grid = grid;
    }


}
