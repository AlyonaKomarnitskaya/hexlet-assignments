package exercise;


import java.util.Arrays;

class SafetyList {
    // BEGIN
    private Integer[] mass = new Integer[0];
    public synchronized void add(Integer i) {
        mass = Arrays.copyOf(mass, mass.length + 1);
        mass[mass.length - 1] = i;
    }

    public Integer get(Integer x) {
        return mass[x];
    }

    public Integer getSize() {
        return mass.length;
    }

    // END
}
