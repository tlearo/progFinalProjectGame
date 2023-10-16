//Creating the Game Map
class gameMap{
        private char[][]map;
        private char[][]gameMap;
        static int mapSize = 5;

        //Creating and printing Map
        public gameMap(){
            map = new char[mapSize][mapSize];
            gameMap = new char[mapSize][mapSize];
            for(int i=0;i<mapSize; i++){
                for(int j=0;j<mapSize; j++){
                map[i][j]= '-';
                }
            }
            //Events at specific coordinates
            gameMap[0][0] = 'F'; //Fairy Circle
            gameMap[1][0] = 'Q'; //Quicksand
            gameMap[2][0] = 'B'; //Suzuiwa (Sword)
            gameMap[3][0] = '~'; //River
            gameMap[4][0] = 'C'; //Abandoned Cottage

            gameMap[0][1] = 'S'; //Spike Trap
            gameMap[1][1] = '-'; //Marsh
            gameMap[2][1] = 'Q'; //Quicksand
            gameMap[3][1] = '~'; //River Crossing
            gameMap[4][1] = '%'; //Petalling Forest

            gameMap[0][2] = '-'; //Woods
            gameMap[1][2] = 'X'; //Starting Location
            gameMap[2][2] = '-'; //Sandy Plain
            gameMap[3][2] = '^'; //Mountain
            gameMap[4][2] = '^'; //Mountain

            gameMap[0][3] = '$'; //Merchant's Shop
            gameMap[1][3] = '-'; //Green field
            gameMap[2][3] = '^'; //Mountain Start
            gameMap[3][3] = '-'; //Craggy rocks
            gameMap[4][3] = '@'; //Battle with the Suitor

            gameMap[0][4] = '-'; //Cliff edge
            gameMap[1][4] = '!'; //Ogre fight
            gameMap[2][4] = '^'; //South direction blocked
            gameMap[3][4] = 'E'; //Enchanted Cavern
            gameMap[4][4] = 'D'; //Dragon's Castle

        }
        public char getEventSymbol(int x, int y) {
            if (x >= 0 && x < mapSize && y >= 0 && y < mapSize) {
                return gameMap[x][y];
            }
            return '-';
        }


        //Positioning player on the Map
        public void printMap(Player Player){
            for(int i=0;i<mapSize; i++){
                for(int j=0;j<mapSize; j++){
                    if(i==Player.getXLocation()&&j==Player.getYLocation()){
                    System.out.print("O  ");
                } else {
                    System.out.print(map[i][j]+ "  ");
                    }
                }
            System.out.println();
            }
        }
}