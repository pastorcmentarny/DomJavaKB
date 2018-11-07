package dms.pastor.groovy.sclinescounter

import groovy.io.FileType

/**
 * Author Dominik Symonowicz
 * Created 2.11'2013 at 13.00
 * WWW:	https://dominiksymonowicz.com/welcome
 * IT BLOG:	https://dominiksymonowicz.blogspot.co.uk
 * Github:	https://github.com/pastorcmentarny
 * Google Play:	https://play.google.com/store/apps/developer?id=Dominik+Symonowicz
 * LinkedIn: https://www.linkedin.com/in/dominik-symonowicz
 *
 * Run application to calculate how many lines of code you have in your source code.
 */
class Counter {

    static main(args) {
        def PATH_TO_DIRECTORY = ""
        def num = 0
        def list = []

        if (args != null && args.size() > 0) {
            try {
                PATH_TO_DIRECTORY = args[0 as String]
            } catch (Exception e) {
                println(e.message)
                error()
            }
        } else {
            error()
        }

        displayWelcomeMessage()

        def dir = new File(PATH_TO_DIRECTORY)

        try {
            dir.eachFileRecurse(FileType.FILES) { file -> list << file }

            list.each {
                num += countFor(it.path)
            }
        } catch (Exception e) {
            println(e.message)
            error()
        }

        //display result
        displayResult(num, list)
    }

    private static displayResult(int num, List list) {
        println "This project has  $num lines of code in ${list.size()} file(s)."
    }

    static int countFor(String filePath) {
        def num = 0
        try {
            new File(filePath).eachLine { num++ }
        } catch (Exception e) {
            println("You mess something with path: " + filePath + "\nError message: \n" + e.message)
            System.exit(7)
        }
        return num
    }

    static void displayWelcomeMessage() {
        def dateFormat = 'dd-MM-yyyy' // set format (you can do this when you parse as well)

        def hr = Calendar.getInstance().get(Calendar.HOUR_OF_DAY)
        if (hr < 12) {
            println("Good morning")
        } else if (hr < 14) {
            println("Good day")
        } else if (hr < 18) {
            println("Good afternoon")
        } else {
            println("Good evening")
        }

        println("Today is " + new Date().format(dateFormat))
    }

    static void error() {
        println("""Whoops!
\tPlease specify path (and must be CORRECT one) to folder for example: "C\\mySecretProject\\MindControl"

Goodbye""")
        System.exit(13)

    }

}