package main.BankApp.utils;

public class ArrayList<X> implements List<X>{
    private X[] array;
    private int nextIndex;
    public ArrayList() {this.array = (X[]) new Object[10];}

    // add methods
    @Override
    public void add(X obj) {
        this.array[nextIndex] = obj;
        nextIndex++;
    }

    @Override
    public void add(X obj, int index) {
        for(int i = this.nextIndex-1; i >= index; i--) {
            this.array[i+1] = this.array[i];
        }
        this.array[index] = obj;
        nextIndex++;
    }

    @Override
    public void addAll(X... objs) {
        for(X obj : objs) {
            this.add(obj);
        }
    }

    // index methods
    @Override
    public X get(int index) {
        if(index>=0 && index < this.nextIndex) {
            return this.array[index];
        } else {
            throw new IndexOutOfBoundsException();
        }
    }

    @Override
    public int indexOf(X obj) {
        for(int i = 0; i < this.nextIndex; i++) {
            if (obj == null) {
                if (this.array[i] == null) return i;
            } else if (obj.equals(this.array[i])) {
                return i;
            }
        }
        return -1;
    }
}
