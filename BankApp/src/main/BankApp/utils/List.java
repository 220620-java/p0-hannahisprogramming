package main.BankApp.utils;

public interface List<X> {
    //adds element to the array
    public void add(X x);

    //adds element x to specified index, pushing following elements back
    public void add(X x, int index);

    //adds objects x to the array
    public void addAll(X... x);

    //returns element from specified index
    public X get(int index);

    //returns index of first instance of obj x
    public int indexOf(X x);

    //returns true if element x is found in the list
    public boolean contains(X x);

    //removes first instance of obj and returns it
    public X remove(X x);

    //removes obj at specified index and returns it
    public X remove(int index);

    //returns number of elements in the list
    public int size();
}
