package dms.pastor.tasks.fizzbuzzwoof;

/**
 * Author Dominik Symonowicz
 * WWW:	http://pastor.ovh.org
 * Github:	https://github.com/pastorcmentarny
 * Google Play:	https://play.google.com/store/apps/developer?id=Dominik+Symonowicz
 * LinkedIn: uk.linkedin.com/pub/dominik-symonowicz/5a/706/981/
 * <p>
 * FizzBuzzWoof tdd exercise that I have done in 2015
 * Rules:
 * dividable by 3 or contains 3 is Fizz
 * dividable by 5 or contains 5 is Buzz
 * dividable by 7 or contains 7 is Woof
 * if dividable by 3 and 5 then FizzBuzz
 * if dividable by 3 and 7 then FizzWoof
 * if dividable by 5 and 7 then BuzzWoof
 * if dividable by 3 5 and 7 then FizzBuzzWoof (not FizzBuzzWoof )
 * if number is dividable by it digit add it 33-> FIZZ 5->BUZZ
 */
class FizzBuzzWoof {
    private static final String FIZZ = "Fizz";
    private static final String BUZZ = "Buzz";
    private static final String WOOF = "Woof";

    //TODO refactor this
    static String getResultFor(int number) {

        String result = "";

        result = addIfDivisibleBy(3, number, result, FIZZ);
        result = addIfNumberMatch(3, number, result, FIZZ);

        result = addIfDivisibleBy(5, number, result, BUZZ);
        result = addIfNumberMatch(5, number, result, BUZZ);

        result = addIfDivisibleBy(7, number, result, WOOF);
        result = addIfNumberMatch(7, number, result, WOOF);

        return result.isEmpty() ? String.valueOf(number) : result;
    }

    private static String addIfDivisibleBy(int by, int number, String result, String word) {
        if (number % by == 0) {
            result += word;
        }
        return result;
    }

    private static String addIfNumberMatch(int by, int number, String result, String word) {
        for (char character : String.valueOf(number).toCharArray()) {
            if (String.valueOf(character).contains(String.valueOf(by))) {
                result += word;
            }
        }
        return result;
    }

}
