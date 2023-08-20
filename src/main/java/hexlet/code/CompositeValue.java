package hexlet.code;

import java.util.Objects;

public class CompositeValue {
    public final String oldValue;
    public final String newValue;

    CompositeValue(String oldValue, String newValue) {
        this.oldValue = oldValue;
        this.newValue = newValue;
    }

    @Override
    public String toString() {
        return oldValue + " - " + newValue;
    }

    @Override
    public boolean equals(Object obj) {
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
}
