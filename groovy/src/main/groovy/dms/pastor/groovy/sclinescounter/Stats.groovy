package dms.pastor.groovy.sclinescounter

import groovy.io.FileType

import java.text.DecimalFormat

// DO NOT FORGET UPDATE HISTORY OF CHANGES...DAILY
class Stats {
    def static PATH_TO_DIRECTORY = ["C:\\ds\\projects\\DomKB"]

    static main(args) {
        println("Stats for Dom Linker")
        //set date and time stuff
        def start = new GregorianCalendar(2013, 10, 28)
        def calendarInstance = Calendar.getInstance()
        def now = new GregorianCalendar(calendarInstance.get(Calendar.YEAR), calendarInstance.get(Calendar.MONTH), calendarInstance.get(Calendar.DAY_OF_MONTH))

        long startAsLong = start.getTime().getTime()
        long nowAsLong = now.getTime().getTime() + 10000
        def difMs = nowAsLong - startAsLong
        def msPerDay = 1000 * 60 * 60 * 24
        def daysSinceStart = (difMs / msPerDay).intValue()


        def dateFormat = 'dd-MM-yyyy' // set format (you can do this when you parse as well)

        //set target
        def target = 2500

        def amPM = Calendar.getInstance().get(Calendar.AM_PM)
        if (amPM == Calendar.AM) {
            println("Good morning")
        } else {
            println("Good day,afternoon or evening")
        }
        println("Today is " + new Date().format(dateFormat))

        def num = 0
        def files = 0

        def list = []

        for (path in PATH_TO_DIRECTORY) {
            def dir = new File(path)
            dir.eachFileRecurse(FileType.FILES) { file -> list << file }

            list.each {
                num += countFor(it.path)
            }

            files += list.size()

        }

        //display result
        displayResult(num, list, target, daysSinceStart)
    }

    private static void displayResult(int num, List list, int target, int daysSinceStart) {
        println "I wrote " + num + " lines of code in " + list.size() + " files."
        println "My target is " + target + " lines of code."
        println "Progress " + new DecimalFormat("#.##").format(num / target * 100) + " % in " + daysSinceStart + " days."
        println getHistoryOfProgress()
    }

    static int countFor(String filePath) {
        def counter = 0
        try {
            new File(filePath).eachLine { counter++ }
        } catch (Exception ignored) {
            println("You mess something with path: " + filePath)
        }

        return counter
    }

    static String getHistoryOfProgress() {
        def history = new StringBuilder("\nHistory of progress:\n")
        history.append($/04-11-2013 ' 75 lines '\n/$)
        history.append($/04-11-2013 ' 206589 lines  in 4585 files'\n/$)
        history
    }
}