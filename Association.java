/**
 * Clase que representa una asociación de clave-valor.
 *
 * @param <K> Tipo de la clave.
 * @param <V> Tipo del valor asociado a la clave.
 */
public class Association<K extends Comparable<K>, V> implements Comparable<Association<K, V>> {
    /** Clave de la asociación. */
    private K key;
    
    /** Valor asociado a la clave. */
    private V value;

    /**
     * Constructor de la clase Association.
     *
     * @param key   Clave de la asociación.
     * @param value Valor asociado a la clave.
     */
    public Association(K key, V value) {
        this.key = key;
        this.value = value;
    }

    /**
     * Método para obtener la clave de la asociación.
     *
     * @return La clave de la asociación.
     */
    public K getKey() {
        return key;
    }

    /**
     * Método para establecer la clave de la asociación.
     *
     * @param key La nueva clave de la asociación.
     */
    public void setKey(K key) {
        this.key = key;
    }

    /**
     * Método para obtener el valor asociado a la clave.
     *
     * @return El valor asociado a la clave.
     */
    public V getValue() {
        return value;
    }

    /**
     * Método para establecer el valor asociado a la clave.
     *
     * @param value El nuevo valor asociado a la clave.
     */
    public void setValue(V value) {
        this.value = value;
    }

    /**
     * Método para comparar esta asociación con otra basándose en las claves.
     *
     * @param other Otra asociación a comparar.
     * @return Un valor negativo, cero o un valor positivo si esta asociación es menor, igual o mayor que la otra.
     */
    @Override
    public int compareTo(Association<K, V> other) {
        return this.key.compareTo(other.key);
    }
}