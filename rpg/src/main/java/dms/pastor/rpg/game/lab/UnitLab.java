package dms.pastor.rpg.game.lab;

public class UnitLab {
    public void runAExperiment() {
        Frankenstein player1 = new Frankenstein("Student", 5, 5, 5, 5, 5, 1);
        generateDataFor(player1);
        player1 = new Frankenstein("CompSci", 3, 2, 6, 4, 1, 10); //psycho
        generateDataFor(player1);
        player1 = new Frankenstein("SportSci", 8, 1, 1, 8, 8, 0); //strength
        generateDataFor(player1);
        player1 = new Frankenstein("InterPol", 1, 7, 9, 2, 4, 3); //charisma
        generateDataFor(player1);
        player1 = new Frankenstein("DramaArt", 3, 6, 5, 4, 5, 3); //dexterity
        generateDataFor(player1);
        player1 = new Frankenstein("Bio Science", 4, 3, 7, 3, 5, 4); //intelligence
        generateDataFor(player1);
        player1 = new Frankenstein("Geographers", 4, 3, 5, 10, 2, 4); //Vitality
        generateDataFor(player1);
    }

    private void generateDataFor(Frankenstein player1) {
        for (int i = 1; i <= 51; i += 10) {
            if (i == 51) {
                i = 50;
            }
            player1.generateStatsForLevel(i);
            System.out.println(player1);
        }
    }
}
