class gameMap{
        private char[][]map;
        static int mapSize = 5;
        public gameMap(){
            map = new char[mapSize][mapSize];
            for(int i=0;i<mapSize; i++){
                for(int j=0;j<mapSize; j++){
                map[i][j]= '-';
                }
            }
        }

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