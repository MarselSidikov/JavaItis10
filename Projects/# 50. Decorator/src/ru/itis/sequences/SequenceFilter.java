package ru.itis.sequences;

// Decorator
public class SequenceFilter extends Sequence {
    private Sequence sequence;

    public SequenceFilter(Sequence sequence) {
        this.sequence = sequence;
    }

    @Override
    public int get() {
        return sequence.get();
    }

    @Override
    public int[] getAll() {
        return sequence.getAll();
    }

    @Override
    public int[] getAllReversed() {
        return sequence.getAllReversed();
    }
}
