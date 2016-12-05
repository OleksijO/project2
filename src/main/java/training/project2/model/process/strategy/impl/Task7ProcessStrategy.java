package training.project2.model.process.strategy.impl;

import training.project2.model.entity.Container;
import training.project2.model.entity.ContentType;
import training.project2.model.entity.Element;
import training.project2.model.entity.Type;
import training.project2.model.process.strategy.ProcessStrategy;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.ListIterator;
import java.util.regex.Pattern;

import static training.project2.model.entity.Type.ELEMENT;

/**
 * This class represents process element strategy for task 7.
 * Rearrange words in text by increasing weight og vowels in the word.
 *
 * @author oleksij.onysymchuk@gmail
 */
public class Task7ProcessStrategy implements ProcessStrategy {
    private static final String REGEXP_VOWELS = "(?i)[aeiouяиюэоаыуеїієё]";
    private Pattern vowelsPattern = Pattern.compile(REGEXP_VOWELS);

    public Element performProcess(Element elementToProcess) {
        // holder for all pairs of vowels rate and word in text
        List<Pair> words = new ArrayList<>();

        if (elementToProcess.getType() == ELEMENT) {
            return elementToProcess;
        }

        // getting all words in text to temp holder with calculationg of vowels rate in word
        ((Container) elementToProcess).getAllTreeElements().stream()
                .filter(element -> element.getContentType() == ContentType.WORD)
                .forEach(el -> {
                    final int[] counter = {0};
                    ((Container) el).getElements().forEach(symbol -> {
                        if (vowelsPattern.matcher(symbol.getContent()).matches()) {
                            counter[0]++;
                        }
                    });
                    words.add(new Pair(1. * counter[0] / ((Container) el).getElements().size(), el));
                });

        // performing sort by vowels rate
        Collections.sort(words, (o1, o2) -> Double.compare(o1.rate, o2.rate));

        // replacing every word in text by one from sorted holder sequentially
        deepWordReplace(elementToProcess, words, new int[1]);

        return elementToProcess;

    }

    private void deepWordReplace(Element elementToProcess, List<Pair> words, int[] counter) {

        if (elementToProcess.getType() == Type.CONTAINER) {
            List<Element> elements = ((Container) elementToProcess).getElements();
            ListIterator<Element> iterator = elements.listIterator();
            while (iterator.hasNext()) {
                Element el = iterator.next();
                if (el.getContentType() == ContentType.WORD) {
                    iterator.set(words.get(counter[0]++).word);
                } else {
                    deepWordReplace(el, words, counter);
                }
            }
        }
    }

    /**
     * container for sorting words
     */
    class Pair {
        double rate;
        Element word;

        public Pair(double rate, Element word) {
            this.rate = rate;
            this.word = word;
        }

        @Override
        public String toString() {
            return "Pair{" +
                    "rate=" + rate +
                    ", word=" + word.getContent() +
                    '}';
        }
    }


}
