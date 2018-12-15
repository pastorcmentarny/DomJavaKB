package dms.pastor.game.rpg.items;

import dms.pastor.game.rpg.cfg.Config;

import java.util.Random;


public class Book extends Item {
    private final String author;
    private final String title;

    private Book(String author, String title, int value, String description) {
        this.author = author;
        this.title = title;
        this.value = value;
        setName(author + " - " + title);
        setDescription(description);
    }

    public Book(String author, String title, int value, boolean quest) {
        this.author = author;
        this.title = title;
        this.value = value;
        setName(author + " - " + title);
        setDescription(description);
        isQuestItem = quest;
        if (isQuestItem) {
            actions = Action.quest;
        }
    }

    public static Book getJamesClarkBook() {
        return new Book("James Clarke", "For god's sake I am diamond man not a Iron lady", -1, "This book is about why James is awesome and should rule the world.");
    }

    public static Book generateRandomBook() {
        return new Book(Config.getPersonName(), getRandomTitle(), new Random().nextInt(249) + 1, getRandomDescription());
    }

    //titles of real books
    private static String getRandomTitle() {
        String[] titles = {"Eating People Is Wrong", "Still Stripping After 25 Years ", "Reusing Old Graves", "Everything I Know about Women I Learned from My Tractor", "Everything I Want To Do Is Illegal", "A Passion for Donkeys", "How to Raise Your I.Q. by Eating Gifted Children", "What's Your Poo Telling You?", "The Beginner's Guide to Sex in the Afterlife", "Why Do Men Have Nipples?", "How to Shit in the Woods, Second Edition: An Environmentally Sound Approach to a Lost Art", "Fart Proudly", "How to Cook Husbands"};
        return titles[new Random().nextInt(titles.length)];
    }

    private static String getRandomDescription() {
        String[] desc = {"No description available."};
        return desc[new Random().nextInt(desc.length)];
    }

    public static Book getJamesBook() {
        return new Book("Book of James", "Bla bla bla to brainwash innocent young mind to do evil things.It has value only as it's can be to make fire in fireplace or emergency toilet paper.", 10, "");
    }

    public String getAuthor() {
        return author;
    }

    public String getTitle() {
        return title;
    }

    @Override
    public String toString() {
        return "Book{\n" + "\tauthor= " + author + "\n\ttitle= " + title + "\n\tDescription: " + "\n\tvalue=" + value + "\n}";
    }


}
