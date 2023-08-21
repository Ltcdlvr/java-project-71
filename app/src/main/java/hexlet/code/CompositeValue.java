package hexlet.code;

import java.util.Objects;

public class CompositeValue {
    public String getOldValue() {
        return oldValue;
    }

    public String getNewValue() {
        return newValue;
    }

    private final String oldValue;
    private final String newValue;

    CompositeValue(String oldValue, String newValue) {
        this.oldValue = oldValue;
        this.newValue = newValue;
    }

    @Override
    public final String toString() {
        return oldValue + " - " + newValue;
    }

    @Override
    public final boolean equals(Object obj) {
        if (Objects.isNull(obj) || (!obj.getClass().equals(CompositeValue.class))) {
            return false;
        }
        CompositeValue cvObj = (CompositeValue) obj;

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
    public final int hashCode() {
        return super.hashCode();
    }
}
