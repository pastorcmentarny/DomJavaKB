package dms.pastor.examples.java8;

final class ShadowingClass {

    private int number = 6;

    public static void main(String[] args) {
        ShadowingClass shadowingClass = new ShadowingClass();
        ShadowingClass.InnerClass innerClass = shadowingClass.new InnerClass();
        innerClass.displayNumbers(13);

    }

    private class InnerClass {

        private int number = 8;

        void displayNumbers(int number) {
            System.out.println("passed number:" + number);
            System.out.println("local number:" + this.number);
            System.out.println("outer number:" + ShadowingClass.this.number);
        }

    }

}
