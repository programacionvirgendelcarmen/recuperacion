package RA6;

import java.util.Objects;

public class Coche<T, V> {
    private T id;
    private V marca;

    public Coche(T atributo1, V atributo2) {
        this.id = atributo1;
        this.marca = atributo2;
    }

    public T getId() {
        return id;
    }

    public void setId(T id) {
        this.id = id;
    }

    public V getMarca() {
        return marca;
    }

    public void setMarca(V marca) {
        this.marca = marca;
    }

    @Override
    public String toString() {
        return String.format("%s,%s", id, marca);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Coche<?, ?> generica = (Coche<?, ?>) o;
        return Objects.equals(id, generica.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
