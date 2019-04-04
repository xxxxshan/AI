package fr.emse.ai.search.simple;

enum Position {RIGHT, LEFT}

public class M_C_State {

        public int cannibalLeft;
        public int missionaryLeft;
        public Position boat;
        public int cannibalRight;
        public int missionaryRight;


    @Override
    public String toString() {
        return "(" + cannibalLeft + "," + missionaryLeft + ","+boat+","
                 + cannibalRight + "," + missionaryRight + ")";
    }

    public M_C_State(int cannibalLeft, int missionaryLeft, Position boat, int cannibalRight, int missionaryRight) {
        this.cannibalLeft = cannibalLeft;
        this.missionaryLeft = missionaryLeft;
        this.boat = boat;
        this.cannibalRight = cannibalRight;
        this.missionaryRight = missionaryRight;
    }

    @Override
    public boolean equals(Object obj) {
        if (!(obj instanceof M_C_State)) {
            return false;
        }
        M_C_State s = (M_C_State) obj;
        return (s.cannibalLeft == cannibalLeft && s.missionaryLeft == missionaryLeft
                && s.boat == boat && s.cannibalRight == cannibalRight
                && s.missionaryRight == missionaryRight);
    }

}
