package ru.itis.sequences;

// как FileInputStream
public class SequenceArrayImpl extends Sequence {

    private int sequence[];
    private int position;

    public SequenceArrayImpl(int[] sequence) {
        this.sequence = sequence;
        this.position = 0;
    }

    @Override
    public int get() {
        if (position == sequence.length) {
            return -1;
        }
        this.position++;
        return sequence[position - 1];
    }
}
