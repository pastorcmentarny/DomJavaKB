package dms.pastor.learn.basics;

/**
 * Author Dominik Symonowicz
 * Created 02/10/2018
 * WWW:	https://dominiksymonowicz.com/welcome
 * IT BLOG:	https://dominiksymonowicz.blogspot.co.uk
 * Github:	https://github.com/pastorcmentarny
 * Google Play:	https://play.google.com/store/apps/developer?id=Dominik+Symonowicz
 * LinkedIn: https://www.linkedin.com/in/dominik-symonowicz
 */
class OptionalExampls {

/*
    private static void displayDescriptionOfTresure(Treasure treasure){

    }

    private static void displayTresureNotFound(){
        System.out.println("Not found");
    }

    public Optional<Treasure> getTreasureByName(String name){
        Treasure treasure = new Treasure("treasure");
    }

    //move to test
    public static void main(String[] args) {
        getTreasureByName(name).ifPresentOrElse( this::displayDescriptionOfTresure, ()-> displayTresureNotFound());
    }
*/



    /*
    Optional::stream

    public List<Student> getStudentList(Collection<String> studentIdNo) {
return studentIdNo.stream()
    .map(this::getStudentByIdNo)
    .flatMap(Optional::stream)
    .collect(toList());
}
     */
}
