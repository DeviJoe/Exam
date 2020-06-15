public class SimpleLinkedList<T> {

    /**
     * Внутренний класс узла
     *
     */
    protected class ListItem {
        public T value;
        public ListItem next;

        /**
         * Конструктор
         * @param value значение
         * @param next сслыка на следующий
         */
        public ListItem(T value, ListItem next) {
            this.value = value;
            this.next = next;
        }
    }

    // Голова
    protected ListItem head = null;
    // Хвост
    protected ListItem tail = null;
    // Размер
    protected int size = 0;

    public int size() {
        return size;
    }

    /**
     * Добавление элемента в конец
     * @param t значение
     */
    public void add(T t) {
        linkLast(t);
    }

    /**
     * Добавление элемента по индексу
     * @param element значение
     */
    public void add(int index, T element) {
        if (index > size && index < 0) {
            throw new IndexOutOfBoundsException();
        }

        if (index == 0) {
            linkFirst(element);
            return;
        }

        int counter = 0;
        ListItem t = head;
        do {
            t = t.next;
            counter++;
        } while (counter!=index);
        t.next = new ListItem(element, t.next);
    }

    /**
     * Удаление элемента по индексу
     * @param index
     */
    public void remove(int index) {
        if (index > size && index < 0) {
            throw new IndexOutOfBoundsException();
        }
        int counter = 0;
        ListItem t = head;
        while (counter != index - 1) {
            t = t.next;
            counter++;
        }
        t.next = t.next.next;
        size--;
    }

    /**
     * Получение элемента по индексу
     * @param index индекс
     * @return
     */
    public Object get(int index) {
        int counter = 0;
        ListItem t = head;
        try {
            while (counter != index) {
                t = t.next;
                counter++;
            }
        } catch (IndexOutOfBoundsException e) {
            e.printStackTrace();
        }
        return t.value;
    }

    /**
     * МЕТОД ДЛЯ ЗАДАЧИ!!!
     *
     * Удаляет k последних элементов, если k выходит за пределы size - очищает список
     *
     * @param k количество элементов
     * @throws Exception
     */
    public void removeElements(int k) {
        ListItem t = head;
        int counter = 0;

        if (k >= size) clear();

        while (counter != size - k + 1) {
            t = t.next;
            counter++;
        }

        tail = t;
        t.next = null;
    }

    /**
     * Очистка листа
     */
    public void clear() {
        head.next = null;
        head.value = null;
        tail.value = null;
        tail.next = null;
        size=0;
    }

    /**
     * Присоединяет первый элемент
     * @param t значение
     */
    private void linkFirst(T t) {
        final ListItem node = new ListItem(t, head);
        head = node;
        size++;
    }

    /**
     * Присоединяет последний элемент
     * @param t
     */
    private void linkLast(T t) {
        final ListItem node = new ListItem(t, null);
        tail.next = node;
        tail = node;
        size++;
    }

}
