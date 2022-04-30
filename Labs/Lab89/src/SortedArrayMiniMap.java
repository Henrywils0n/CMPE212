import java.util.Arrays;
import java.util.Objects;

/**
 * An array-based {@code MiniMap} where the keys are maintained in sorted
 * order. The key type {@code K} must implement the {@code Comparable}
 * interface.
 *
 */
public class SortedArrayMiniMap<K, V> extends AbstractMiniMap<K , V> {

	/**
	 * Initializes an empty map.
	 */
	public SortedArrayMiniMap() {
		super();
	}
	
	
	/**
	 * Returns the value to which the specified key is mapped.
	 * 
	 * <p>
	 * More formally, if this map contains a mapping from a key {@code k} to a value
	 * {@code v} such that {@code key.equals(k)}, then this method returns
	 * {@code v}; otherwise it returns {@code null}. (There can be at most one such
	 * mapping.)
	 * 
	 * <p>
	 * This map uses binary search to search for the specified key.
	 * 
	 * @param key the key whose associated value is to be returned
	 * @return the value to which the specified key is mapped, or null if this map
	 *         contains no mapping for the key
	 * @throws NullPointerException if the specified key is null
	 */
	@SuppressWarnings("unchecked")
	@Override
	public V get(Object key) {
		
	}
	
	/**
	 * Associates the specified value with the specified key in this map (optional
	 * operation). If the map previously contained a mapping for the key, the old
	 * value is replaced by the specified value.
	 * 
	 * <p>
	 * A new key and its value will be inserted such that the set of keys of this
	 * map remain in sorted order if the map is not full.
	 *  
	 * @param key   key with which the specified value is to be associated
	 * @param value value to be associated with the specified key
	 * @return the previous value associated with key, or null if there was no
	 *         mapping for key
	 * @throws NullPointerException if the specified key is null
	 * @throws NullPointerException if the specified value is null
	 * @throws MiniMapFullException if this map cannot store the new key-value pair
	 */
	@SuppressWarnings("unchecked")
	@Override
	public V put(K key, V value) {
		
	}

	
	public static void main(String[] args) {
		MiniMap<String, Integer> months = new SortedArrayMiniMap<>();
		months.put("Jan", 31);
		months.put("Feb", 28);
		months.put("Mar", 31);
		months.put("Apr", 30);
		months.put("May", 31);
		months.put("Jun", 30);
		months.put("Jul", 31);
		months.put("Aug", 31);
		months.put("Sep", 30);
		months.put("Oct", 31);
		months.put("Nov", 30);
		months.put("Dec", 31);
		System.out.println(months);
	}
}
