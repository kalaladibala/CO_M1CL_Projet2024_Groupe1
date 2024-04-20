package org.example.version2;

import java.util.function.Function;

public class RefTo<TargetType, OwnerType> {

    private TargetType targetObject;
    private OwnerType ownerObject;
    private Function<TargetType, RefTo<OwnerType, TargetType>> reciprocalFunction;

    public RefTo(OwnerType ownerObject, Function<TargetType, RefTo<OwnerType, TargetType>> reciprocalFunction) {
        this.ownerObject = ownerObject;
        this.reciprocalFunction = reciprocalFunction;
    }

    public TargetType getTarget() {
        return targetObject;
    }

    public void setTarget(TargetType targetObject) {
        if (targetObject == null || targetObject == this.targetObject)
            return;

        if (isSet())
            this.unset();

        if (reciprocalRefFrom(targetObject).isSet())
            reciprocalRefFrom(targetObject).unset();

        this.basicSet(targetObject);
        reciprocalRefFrom(targetObject).basicSet(ownerObject);
    }

    public RefTo<OwnerType, TargetType> reciprocalRefFrom(TargetType targetObject) {
        return reciprocalFunction.apply(targetObject);
    }

    public void basicSet(TargetType targetObject) {
        this.targetObject = targetObject;
    }

    public void unset() {
        if (!isSet())
            return;

        reciprocalRefFrom(targetObject).basicUnset();
        this.basicUnset();
    }

    public void basicUnset() {
        this.targetObject = null;
    }

    public boolean isSet() {
        return this.targetObject != null;
    }
}
