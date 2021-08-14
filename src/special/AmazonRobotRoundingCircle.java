package special;

public class AmazonRobotRoundingCircle {
    enum Dir {
        N, S, E, W
    }
    public static void main(String[] args) {

    }

    public boolean isRobotBounded(String instructions) {
        int x = 0, y = 0;
        Dir dir = Dir.N;
        for(int i = 0; i < instructions.length(); i++) {
            char instruction = instructions.charAt(i);

            if(instruction == 'G') {
                if(dir.equals(Dir.N)) {
                    y++;
                } else if(dir.equals(Dir.S)) {
                    y--;
                } else if(dir.equals(Dir.W)) {
                    x--;
                } else if(dir.equals(Dir.E)) {
                    x++;
                }
            } else {
                dir = dir(dir, instruction);
            }
        }

        return (x == 0 && y == 0) || !dir.equals(Dir.N);
    }

    static Dir dir(Dir direction, char turn) {
        if(Dir.N.equals(direction)) {
            if(turn == 'L')
                return Dir.W;
            else if(turn == 'R')
                return Dir.E;
        } else if(Dir.S.equals(direction)) {
            if(turn == 'L')
                return Dir.E;
            else if(turn == 'R')
                return Dir.W;
        } else if(Dir.W.equals(direction)) {
            if(turn == 'L')
                return Dir.S;
            else if(turn == 'R')
                return Dir.N;
        } else if(Dir.E.equals(direction)) {
            if(turn == 'L')
                return Dir.N;
            else if(turn == 'R')
                return Dir.S;
        }

        return direction;
    }
}
