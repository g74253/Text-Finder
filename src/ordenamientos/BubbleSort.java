package ordenamientos;
/*
 * Agarra una lista de files y los ordena de menor a mayor por bubblesort segun la ultima fecha de modificacion.
 * 
 * @author Gretchell
 */
import estructuras.LinkedList;
import java.io.File;
public class BubbleSort {
    public static void bubble_srt(LinkedList imp) {
        int n = imp.size();
        int k;
        for (int m = 0; m < n; m++) {
            for (int i = 0; i < n - 1; i++) {
                k = i + 1;
                if (((File) imp.position(i).getData()).lastModified() > ((File) imp.position(k).getData()).lastModified()) {
                   imp.swap(i,k);
                }
            }
          
        }
    }
}