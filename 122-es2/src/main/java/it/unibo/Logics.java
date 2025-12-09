package it.unibo;

import it.unibo.es2.Pair;

/**
 * Interface Logics, contains the methods toQuit() and hit().
 */
public interface Logics {

    /**
     * checks whether the columns or the rows are fully filled with "*".
     * 
     * @return whether the GUI has to shut down(true) or not(false).
     */
    boolean toQuit();

    /**
     * updates the content of a button.
     * 
     * @param pos the coordinates of the button in the grid.
     * 
     * @return the updated value of the button.
     */

    boolean hit(Pair<Integer, Integer> pos);
}
