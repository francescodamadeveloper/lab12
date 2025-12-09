package it.unibo;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import it.unibo.es2.Pair;

/**
 * Implementation of the Logics interface.
 */
public class LogicsImpl implements Logics {

    private final List<List<Boolean>> grid;
    /**
     * Initializes a grid [size*size].
     * 
     * @param size the size of the grid.
     */

    public LogicsImpl(final int size) {
        this.grid = IntStream.range(0, size)
        .mapToObj(o -> IntStream.range(0, size)
            .mapToObj(b -> false)
            .collect(Collectors.toList()))
        .collect(Collectors.toList());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public boolean toQuit() {
        return checkRows() || checkCols();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public boolean hit(final Pair<Integer, Integer> pos) {
        if (this.grid.get(pos.x()).get(pos.y())) {
            this.grid.get(pos.x()).set(pos.y(), false);
            return false;
        } else {
            this.grid.get(pos.x()).set(pos.y(), true);
            return true;
        }
    }

    private boolean checkRows() {
        return this.grid.stream()
            .map(r -> r.stream()
                .reduce((x, y) -> x && y))
            .anyMatch(Optional::get);
    }

    private boolean checkCols() {
        return IntStream.range(0, this.grid.size())
            .anyMatch(c -> this.grid.stream()
                .allMatch(r -> r.get(c)));
    }
}
