package dms.pastor.rpg.game.units.npc;


public class OctopusXL extends NPC {

    //Sty - chlew - http://en.wikipedia.org/wiki/Sty
    @Override
    public void talk() {
        System.out.println("You arrived to Royal Sty.In front of you see massive gentleman with hand that are size of bread. ");
        System.out.println("I want go to club");
    }

    @Override
    public void smallTalk() {
        //TODO implement it
        System.out.println("Hello! How are you ?");
        System.out.println("I am hungry.I am going to eat something.");
        //for loop with standard qa .. you have 5% being devoured by Bart
        System.out.println("Aaa.. ok,bye and you left him alone as you know that asking him more ");
    }

    @Override
    public String getRandomPreTalk() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
