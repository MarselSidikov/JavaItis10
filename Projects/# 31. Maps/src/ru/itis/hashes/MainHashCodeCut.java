package ru.itis.hashes;

public class MainHashCodeCut {
    public static void main(String[] args) {
        int keys[] = new int[16];
        String marsel = "Прив";
        int hashCode = marsel.hashCode();
        int cutHash = hashCode & (keys.length - 1);
        System.out.println(hashCode);
        System.out.println(cutHash);
    }
}
