package fr.emse.ai.search.simple;

enum Boat {This,That}

public class FarmerState {
    public int Farmer;
    public int Goat;
    public int Wolf;
    public int Cabbage;
    public Boat boat;

    @Override
    public String toString() {
        return "(F: " + Farmer + ", G: " + Goat + ", W: " + Wolf + ", C: " + Cabbage + ", Boat:"+ boat +")";
    }

    public FarmerState(int Farmer, int Goat, int Wolf, int Cabbage, Boat boat) {
        this.Farmer = Farmer;
        this.Goat = Goat;
        this.Wolf = Wolf;
        this.Cabbage = Cabbage;
        this.boat = boat;
    }

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof FarmerState)){
            return false;
        }
        FarmerState s = (FarmerState) o;
        return (s.Farmer==Farmer && s.Goat==Goat && s.Wolf==Wolf && s.Cabbage==Cabbage&&s.boat==boat);
    }
}