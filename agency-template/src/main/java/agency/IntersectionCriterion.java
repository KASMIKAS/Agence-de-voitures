package agency;
import java.util.List;
import java.util.function.Predicate;

/**
 * cette classe represente les deux criteres de la marque et le maxprice
 * @param <T>
 */
public class IntersectionCriterion<T> implements Predicate<T> {
    List<Predicate<T>> predicates;


    public IntersectionCriterion(List<Predicate<T>> predicates) {
        this.predicates = predicates;
    }


    /**
     *
     * @param t
     * @return vrai si on a les criteres qu'on veut
     */
    @Override
    public boolean test(T t) {
        for (Predicate<T> predicate : predicates){
            if (predicate.test(t)){
                return true;
            }
        }
        return false ;
    }
}

