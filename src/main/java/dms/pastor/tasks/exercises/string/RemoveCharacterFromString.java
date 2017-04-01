package dms.pastor.tasks.exercises.string;

class RemoveCharacterFromString {

    static String removeCharacterFromStringUsingIterative(String text, char character) {
        StringBuilder sb = new StringBuilder("");
        char[] chars = text.toLowerCase().toCharArray();
        for (char ch : chars) {
            if (ch != character) {
                sb.append(ch);
            }
        }
        return sb.toString();
    }

    static String removeCharacterFromStringUsingRecursive(String text, char character) {
        int index = text.toLowerCase().indexOf(character);
        if (index == -1) {
            return text;
        }
        return removeCharacterFromStringUsingRecursive(text.substring(0, index) + text.substring(index + 1, text.length()), character);
    }

}
