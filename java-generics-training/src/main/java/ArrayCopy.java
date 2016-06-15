import java.util.List;


public class ArrayCopy {

    
    public static <T, S extends T> void copy(S[] from, T[] to) {
        int i = 0;

        for (S s : from) {
            to[i++] = s;
        }
    }
    
    public static <T> void copy1(List<T> dest, List<? extends T> src) {
        for (T t : src) {
            dest.add(t);
        }
    }
    
    public static <T> void copy2(List<T> src, List<? super T> dest) {
        for (T t : src) {
            dest.add(t);
        }
    }
    
    public static void main(String[] args) {
        
    }
}
