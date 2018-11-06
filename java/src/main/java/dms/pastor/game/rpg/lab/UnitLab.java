package dms.pastor.game.rpg.lab;

public class UnitLab {
    public void runAExperiment() {
        Frankenstain player1 = new Frankenstain("Student", 5, 5, 5, 5, 5, 1);
        generateDataFor(player1);
        player1 = new Frankenstain("CompSci", 3, 2, 6, 4, 1, 10); //psycho
        generateDataFor(player1);
        player1 = new Frankenstain("SportSci", 8, 1, 1, 8, 8, 0); //stregth
        generateDataFor(player1);
        player1 = new Frankenstain("InterPol", 1, 7, 9, 2, 4, 3); //charisma
        generateDataFor(player1);
        player1 = new Frankenstain("Dramaart", 3, 6, 5, 4, 5, 3); //dexterity
        generateDataFor(player1);
        player1 = new Frankenstain("Bio Science", 4, 3, 7, 3, 5, 4); //inteligence
        generateDataFor(player1);
        player1 = new Frankenstain("Geographers", 4, 3, 5, 10, 2, 4); //Vitality
        generateDataFor(player1);
    }

    private void generateDataFor(Frankenstain player1) {
        for (int i = 1; i <= 51; i += 10) {
            if (i == 51) {
                i = 50;
            }
            player1.generateStatsForLevel(i);
            System.out.println(player1.toString());
        }
    }
}
