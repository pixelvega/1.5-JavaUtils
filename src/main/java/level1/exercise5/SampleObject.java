package level1.exercise5;

import java.io.Serial;
import java.io.Serializable;
import java.util.Date;

public class SampleObject implements Serializable {
    @Serial
    private static final long serialVersionUID = 1L;

    private final String name;
    private final long size;
    private final Date lastModified;

    public SampleObject(String name, long size, Date lastModified) {
        this.name = name;
        this.size = size;
        this.lastModified = lastModified;
    }

    public String getName() {
        return name;
    }

    public long getSize() {
        return size;
    }

    public Date getLastModified() {
        return lastModified;
    }

    @Override
    public String toString() {
        return "FileInfo{" +
                "name='" + name + '\'' +
                ", size=" + size +
                ", lastModified=" + lastModified +
                '}';
    }
}
