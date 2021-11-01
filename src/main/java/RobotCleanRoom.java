import java.util.HashSet;
import java.util.Set;

public class RobotCleanRoom {

    interface Robot {
        // returns true if next cell is open and robot moves into the cell.
        // returns false if next cell is obstacle and robot stays on the current cell.
        boolean move();

        // Robot will stay on the same cell after calling turnLeft/turnRight.
        // Each turn will be 90 degrees.
        void turnLeft();
        void turnRight();

        // Clean the current cell.
        void clean();
    }

    public void cleanRoom(Robot r){
        dfs(r,0,0,0, new HashSet<String>());
    }

    private void dfs(Robot r, int x, int y, int direction, Set<String> s){
        String position = x + "_" + y;
        if (s.contains(position))
            return;
        r.clean();
        s.add(position);
        for (int i=0; i<4; i++){
            if (r.move()) {
                int nextX = x, nextY = y;
                switch (direction){
                    case 0:
                        nextY--;
                        break;
                    case 90:
                        nextX++;
                        break;
                    case 180:
                        nextY++;
                        break;
                    case 270:
                        nextX--;
                }
                dfs(r, nextX, nextY, direction, s);

                //lets go back to original position
                r.turnLeft();
                r.turnLeft();
                r.move();
                r.turnRight();
                r.turnRight();
            }
            direction += 90;
            r.turnRight();
            direction = direction % 360;
        }
    }

}
