package ru.itis.sequences;

public class EvensSequence extends SequenceFilter {
    public EvensSequence(Sequence sequence) {
        super(sequence);
    }

    @Override
    public int get() {
        int valueFromSequence = super.get();
        if (valueFromSequence % 2 == 0) {
            return valueFromSequence;
        } else {
            while (valueFromSequence % 2 != 0 && valueFromSequence != -1) {
                valueFromSequence = super.get();
            }
            return valueFromSequence;
        }
    }
}
