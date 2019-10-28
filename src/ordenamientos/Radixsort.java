package ordenamientos;
/*
 * Agarra una lista de files y los ordena de menor a mayor por radixsort segun el tamaño en bytes.
 * 
 * @author Gretchell
 */
import java.io.File;
import estructuras.LinkedList;

public class Radixsort {
        static int getMax(LinkedList m2, int n)
        {
            int mx = (int) ((File) m2.position(0).getData()).length();
            for (int i = 1; i < n; i++)
                if ((int) ((File) m2.position(i).getData()).length() > mx)
                    mx = (int) ((File) m2.position(i).getData()).length();
            return mx;
        }

        static void countSort(LinkedList m2, int n, int exp)
        {
        	LinkedList output = new LinkedList();
            for(int x =0; x < n;x++) {
            	output.insertFirst(0);
            }
            int i;
            LinkedList count = new LinkedList();
            for(int x =0; x < 10;x++) {
            	count.insertFirst(0);
            }

            for (i = 0; i < n; i++)
                count.position( (((int)((File) m2.position(i).getData()).length())/exp)%10 ).setData((int)count.position( (((int)((File) m2.position(i).getData()).length())/exp)%10 ).getData() + 1);

            for (i = 1; i < 10; i++)
                count.position(i).setData((int)count.position(i).getData() + (int)count.position(i - 1).getData());

            for (i = n - 1; i >= 0; i--)
            {
                output.position((int)(count.position( (((int)((File) m2.position(i).getData()).length())/exp)%10 ).getData()) - 1).setData(( m2.position(i).getData()));
                count.position( (((int)((File) m2.position(i).getData()).length())/exp)%10 ).setData((int)( count.position( (((int)((File) m2.position(i).getData()).length())/exp)%10 ).getData()) -1);
            }

            for (i = 0; i < n; i++) {
            	m2.deleteFirst();
                m2.insertLast(output.position(i).getData());}
        }

        public static void radixsort(LinkedList m2, int n)
        {
            int m = getMax(m2, n);
            for (int exp = 1; m/exp > 0; exp *= 10)
                countSort(m2, n, exp);
        }
    }