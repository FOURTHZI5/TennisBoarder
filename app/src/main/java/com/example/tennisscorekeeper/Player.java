package com.example.tennisscorekeeper;

public class Player {
    private String firstName;
    private String lastName;
    private int point;
    private int game;
    private int set;

    public Player(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.point = 0;
        this.game = 0;
        this.set = 0;
    }

    public boolean isWin() {
        return set == 3;
    }

    public boolean addOnePoint(Player opponent) {
        if (this.game == 6 && opponent.getGame() == 6) {
            this.point += 1;
            if(this.point >= 7 && this.point >= 2 + opponent.getPoint()) {
                winASet(opponent);
            }
            return true;
        }

        switch (this.point) {
            case 0:
            case 15:
                point += 15;
                break;
            case 30:
                point += 10;
                break;
            case 40:
                if (opponent.getPoint() > 40) {
                    return false;
                } else if (opponent.getPoint() == 40) {
                    point += 20;
                    break;
                }
            case 60:
                winAGame(opponent);
            default:
                return false;

        }

        return true;
    }

    public int getPoint() {
        return this.point;
    }

    public int getGame() {
        return this.game;
    }

    public int getSet() {
        return this.set;
    }

    public void setPointToZero() {
        this.point = 0;
    }

    public void setGameToZero() {
        this.game = 0;
    }

    private void winAGame(Player opponent) {
        this.game += 1;
        if (this.game >= 6 && 2 + opponent.getGame() <= this.game) {
            winASet(opponent);
            return;
        }

        this.setPointToZero();
        opponent.setPointToZero();

    }

    private void winASet(Player opponent) {
        this.setPointToZero();
        opponent.setPointToZero();
        this.game = 0;
        opponent.setGameToZero();
        this.set += 1;
    }

    public String getFullName(){
        return this.firstName + " " + this.lastName;
    }
}
