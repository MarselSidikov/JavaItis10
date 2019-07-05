package ru.itis;

import java.util.Comparator;

/**
 * 05.07.2019
 * HumanByHeightComparator
 *
 * @author Sidikov Marsel (First Software Engineering Platform)
 * @version v1.0
 */
public class HumanByHeightComparator implements Comparator<Human> {
    @Override
    public int compare(Human o1, Human o2) {
        return Double.compare(o1.getHeight(), o2.getHeight());
    }
}
