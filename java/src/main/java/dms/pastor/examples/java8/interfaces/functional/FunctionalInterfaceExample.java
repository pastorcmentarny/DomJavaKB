package dms.pastor.kb.java8.interfaces.functional;

final class FunctionalInterfaceExample {

    public static void main(String[] args) {
        TextMirroring<String, String> mirroring = (from) -> from + ' ' + new StringBuilder(from).reverse().toString();
        System.out.println(mirroring.manipulate("Dominik"));

        TextMirroring<Integer, String> intMirroring = (from) -> from.toString() + ' ' + new StringBuilder(from.toString()).reverse().toString();
        System.out.println(intMirroring.manipulate(256));
    }


}
