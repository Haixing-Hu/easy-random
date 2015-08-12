/*
 * The MIT License
 *
 *   Copyright (c) 2015, Mahmoud Ben Hassine (mahmoud@benhassine.fr)
 *
 *   Permission is hereby granted, free of charge, to any person obtaining a copy
 *   of this software and associated documentation files (the "Software"), to deal
 *   in the Software without restriction, including without limitation the rights
 *   to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 *   copies of the Software, and to permit persons to whom the Software is
 *   furnished to do so, subject to the following conditions:
 *
 *   The above copyright notice and this permission notice shall be included in
 *   all copies or substantial portions of the Software.
 *
 *   THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 *   IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 *   FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 *   AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 *   LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 *   OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
 *   THE SOFTWARE.
 */
package io.github.benas.jpopulator.randomizers;

import io.github.benas.jpopulator.api.Randomizer;
import io.github.benas.jpopulator.api.RandomizerSkipException;

import java.util.ArrayList;
import java.util.List;

/**
 * A custom randomizer that generates a list of random values from another {@link Randomizer}.
 *
 * @param <T> the type generated by this randomizer
 *
 * @author Eric Taix (eric.taix@gmail.com)
 */
public class ListRandomizer<T> extends CollectionRandomizer<T> {

    /**
     * Default constructor which will generate a list with a random number of element.
     * Each element is generated by the {@link Randomizer} parameter
     *
     * @param elementRandomizer the randomizer to use to generate elements of the list
     */
    public ListRandomizer(final Randomizer<T> elementRandomizer) {
        super(elementRandomizer);
    }

    /**
     * Constructor which will generate a list with a fixed number of elements.
     * Each element is generated by the {@link Randomizer} parameter
     *
     * @param elementRandomizer The randomizer used to generate each element
     * @param nbElements        The number of elements in the list to generate
     */
    public ListRandomizer(final Randomizer<T> elementRandomizer, final int nbElements) {
        super(elementRandomizer, nbElements, nbElements);
    }

    /**
     * Constructor which will generate a list with a random number of elements.
     * Each element is generated by the {@link Randomizer} parameter
     *
     * @param elementRandomizer The randomizer used to generate each element
     * @param minElements       The minimum number of elements in the list to generate
     * @param maxElements       The maximum number of elements in the list to generate
     */
    public ListRandomizer(final Randomizer<T> elementRandomizer, final int minElements, final int maxElements) {
        super(elementRandomizer, minElements, maxElements);
    }

    @Override
    public List<T> getRandomValue() {
        List<T> result = new ArrayList<T>();
        for (int i = 0; i < nbElements; i++) {
            try {
                result.add(getRandomElement());
            } catch (RandomizerSkipException e) {
            }
        }
        return result;
    }

}
