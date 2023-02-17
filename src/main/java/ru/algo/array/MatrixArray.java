package ru.algo.array;

import ru.algo.common.CommonArray;

import java.util.Arrays;
import java.util.Objects;

public class MatrixArray<T> implements CommonArray<T> {

    private CommonArray<Integer> positions = new FactorArray<>();
    private CommonArray<T> items = new FactorArray<>();

    private int current = 0;

    @Override
    public void add(T item, int index) {
        items.add(item, current);
        positions.add(current++, index);
    }

    @Override
    public T get(int index) {
        if (positions.get(index) != null)
            return items.get(positions.get(index));

        return null;
    }

    @Override
    public T remove(int index) {
        if (index >= current)
            return null;

        T item = get(index);

        // Удаляем из внешнего массива индекс-ссылку на внутренний
        Object[] positionsArray = ((FactorArray<Integer>) positions).array;

        int positionsInternalIndex = Arrays.stream(positionsArray)
                .filter(Objects::nonNull)
                .map(o -> (Integer) o)
                .filter(currentIndex -> index == currentIndex)
                .findFirst()
                .orElse(-1);

        if (positionsInternalIndex == -1)
            return null;

        positions.remove(positionsInternalIndex);

        // Удаляем из внутреннего массива данные со смещением

        int lastItemsIndex = items.size() - 1;

        for (int i = positionsInternalIndex; i < lastItemsIndex; i++)
            ((FactorArray<T>) items).move(i + 1, i);

        items.remove(lastItemsIndex);

        current--;

        return item;
    }

    @Override
    public int size() {
        return current;
    }
}
