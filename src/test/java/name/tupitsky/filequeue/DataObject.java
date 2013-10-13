package name.tupitsky.filequeue;

import java.io.Serializable;
import java.util.UUID;

class DataObject implements Serializable {
    private final String name = UUID.randomUUID().toString();

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        DataObject that = (DataObject) o;

        if (!name.equals(that.name)) return false;

        return true;
    }

    @Override
    public int hashCode() {
        return name.hashCode();
    }

    @Override
    public String toString() {
        return "DataObject{" +
                "name='" + name + '\'' +
                '}';
    }

    public static DataObject[] createArrayOf(int n) {
        DataObject result[] = new DataObject[n];
        for (int i = 0; i < n; i++) {
            result[i] = new DataObject();
        }
        return result;
    }
}
