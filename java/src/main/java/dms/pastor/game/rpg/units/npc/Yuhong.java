package dms.pastor.game.rpg.units.npc;


public class Yuhong extends NPC {

    public Yuhong() {
        setName("Yuhong");
        setDescription("Somebody describes him \"My eyes crying when I see him and my ears are bleeding when I hear his voice.");
    }

    @Override
    public void talk() {
        displayDefaultResponse();
    }

    @Override
    public void smallTalk() {

    }

    private void displayDefaultResponse() {
        System.out.println("You see asian looking gentleman..");
        System.out.println(getDescription());
        System.out.println("You tried to ask him question,but before you even open your mouth,he said.\nI can't talk right now,because I am busy");
        System.out.println("..you understood now,why people describe him in this way.");
    }

    @Override
    public String getRandomPreTalk() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
