package dms.pastor.rpg.game.places;


class Library extends Place {

    @Override
    public void description() {
        System.out.println("Library");
    }

    @Override
    public void goToPlace() {
        System.out.println("Library is closed for refurbishment (not implemented yet)");
        //TODO implement library
    }

}
