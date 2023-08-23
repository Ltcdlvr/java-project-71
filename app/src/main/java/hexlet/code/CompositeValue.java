package hexlet.code;

import java.util.Objects;

public final class CompositeValue {

    private final String key;
    private final String type;
    private final Object oldValue;
    private final Object newValue;

    public String getKey() {
        return key;
    }
    public String getType() {
        return type;
    }
    public Object getOldValue() {
        return oldValue;
    }
    public Object getNewValue() {
        return newValue;
    }

    CompositeValue(String key, String type, Object oldValue, Object newValue) {
        this.key = key;
        this.type = type;
        this.oldValue = oldValue;
        this.newValue = newValue;
    }

    @Override
    public String toString() {
        return key + " - " + oldValue + " - " + newValue;
    }

    @Override
    public boolean equals(Object obj) {
        if (Objects.isNull(obj) || (!obj.getClass().equals(CompositeValue.class))) {
            return false;
        }
        CompositeValue cvObj = (CompositeValue) obj;

        if (!this.key.equals(cvObj.getKey())) {
            return false;
        }

        if (!Objects.isNull(this.oldValue) && !Objects.isNull(this.newValue)) {
            return this.newValue.equals(cvObj.newValue)
                    && this.oldValue.equals(cvObj.oldValue);
        }

        if (Objects.isNull(this.oldValue) && Objects.isNull(this.newValue)) {
            return Objects.isNull(cvObj.oldValue) && Objects.isNull(cvObj.newValue);
        }

        if (Objects.isNull(this.oldValue)) {
            if (!Objects.isNull(cvObj.oldValue)) {
                return false;
            } else {
                return this.newValue.equals(cvObj.newValue);
            }
        }

        if (!Objects.isNull(cvObj.newValue)) {
            return false;
        } else {
            return this.oldValue.equals(cvObj.oldValue);
        }
    }

    @Override
    public int hashCode() {
        return super.hashCode();
    }
}
