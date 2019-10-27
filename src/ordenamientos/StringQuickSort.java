package ordenamientos;
/*
 * Agarra una lista de files y los ordena de menor a mayor por quicksort segun el nombre.
 * 
 * @author Gretchell
 */
import java.io.File;
import estructuras.LinkedList;

public class StringQuickSort {

    LinkedList names;
    int length;

    public void sort(LinkedList array) {
        if (array == null || array.size() == 0) {
            return;
        }
        this.names = array;
        this.length = array.size();
        quickSort(0, length - 1);
    }

    void quickSort(int lowerIndex, int higherIndex) {
        int i = lowerIndex;
        int j = higherIndex;
        String pivot = ((File) this.names.position(lowerIndex + (higherIndex - lowerIndex) / 2).getData()).getName();

        while (i <= j) {
            while (((File) this.names.position(i).getData()).getName().compareToIgnoreCase(pivot) < 0) {
                i++;
            }

            while (((File) this.names.position(j).getData()).getName().compareToIgnoreCase(pivot) > 0) {
                j--;
            }

            if (i <= j) {
                this.names.swap(i, j);
                i++;
                j--;
            }
        }
        if (lowerIndex < j) {
            quickSort(lowerIndex, j);
        }
        if (i < higherIndex) {
            quickSort(i, higherIndex);
        }
    }
    
}