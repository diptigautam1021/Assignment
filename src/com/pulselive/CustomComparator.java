package com.pulselive;
import java.util.Comparator;

public class CustomComparator implements Comparator<LeagueTableEntry> {

    @Override
    public int compare(LeagueTableEntry t, LeagueTableEntry t1) {

        if(t.getPoints() > t1.getPoints())
            return -1;
        else
        if (t.getPoints() < t1.getPoints())
            return 1;
        else {
            int goalDif = t.getGoalsFor()-t.getGoalsAgainst();
            int goalDif1 = t1.getGoalsFor()-t1.getGoalsAgainst();
            if(goalDif > goalDif1)
                return -1;
            else
            if(goalDif < goalDif1)
                return 1;
            else return 0;
        }

    }
}
