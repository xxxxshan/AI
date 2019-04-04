package fr.emse.ai.search.simple;

public class TwoCansState {


    public int nowA;
    public int nowB;
    @Override
    public String toString(){
        return "(A: "+nowA+" , "+"B: "+nowB+" )";
    }

    public TwoCansState(int nowA, int nowB){
        this.nowB=nowB;
        this.nowA=nowA;
    }
    @Override
    public boolean equals(Object obj){
        if (!(obj instanceof TwoCansState)){
            return false;
        }
        TwoCansState s=(TwoCansState) obj;
        return (s.nowA==nowA && s.nowB==nowB);
    }
}
