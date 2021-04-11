public class ArrayIterator {
    private final int SIZE;
    private final Object[] ARRAY;
    private int index = 0;


    ArrayIterator(Object[] array) {
        this.ARRAY = array;
        this.SIZE = array.length;
    }

    public boolean hasNext() {
        return index < SIZE - 1;
    }

    public boolean hasPrevious() {
        return index > 0;
    }

    public Object getCurrent() {
        return this.ARRAY[index];
    }

    public Object getNext() {
        return (this.hasNext()) ? this.ARRAY[index + 1] : "there is no next element";
    }

    public Object getPrevious() {
        return (this.hasPrevious()) ? this.ARRAY[index - 1] : "There is no previous element";
    }

    public int getSize() {
        return this.SIZE;
    }

    public int getCurrentIndex() {
        return this.index;
    }

    public void moveToNext() {
        if (this.hasNext()) {
            this.index++;
        }
    }

    public void moveToStart() {
        this.index = 0;
    }

    public void moveToEnd() {
        this.index = SIZE - 1;
    }

    public void moveToPrevious() {
        if (this.hasPrevious()) {
            this.index--;
        }
    }

    public void remove() {
        this.ARRAY[index] = null;
        this.index = 0;
    }


}
