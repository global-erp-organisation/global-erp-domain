package com.camlait.global.erp.domain.helper;

import static org.apache.commons.lang3.reflect.FieldUtils.readField;
import java.lang.reflect.InvocationTargetException;
import java.util.Collection;
import java.util.Map;
import java.util.function.BiFunction;

import org.apache.commons.beanutils.BeanUtilsBean;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import com.amazonaws.util.CollectionUtils;

/**
 * Specific implementation of BeanUtilsBean class.
 * <p>
 * Merged the destination object with the source object according to a given rule.
 * <p>
 * <u><b>How to use the merging operation</b></u>
 * <p>
 * {@code}1: mergeBean = new MergeHelper() or mergeBeanUtil = new MergeHelper(builderCondition)
 * <p>
 * {@code}2: merginObject = mergeBean.<b>merge(source, destination)</b>.
 * 
 * @see BeanUtilsBean
 */
@Component
public class MergeHelper extends BeanUtilsBean {

    private static final Logger LOGGER = LoggerFactory.getLogger(MergeHelper.class);
    private final BiFunction<Object, Object, Boolean> mergingRuleBuilder;

    /**
     * Creates an instance of mergeBeanUtilsBean with a custom merging rule.
     * <p>
     * Note: The merging rule is based on both source and destination field value.
     * The function should take both source and destination value as parameter and produce a boolean that indicates
     * if the destination field need to be set with the source field value or not.
     * 
     * @param mergingConditionBuilder condition builder
     */
    public MergeHelper(BiFunction<Object, Object, Boolean> mergingConditionBuilder) {
        this.mergingRuleBuilder = mergingConditionBuilder;
    }

    /**
     * Creates an instance of mergeBeanUtilsBean with the default merging rule.
     * <p>
     * Here, only null fields or empty collections are updated in the destination object with corresponding non null fields value from the source.
     */
    public MergeHelper() {
        this.mergingRuleBuilder = (sourceValue, destinationValue) -> {
            return canBeOverrides(sourceValue, destinationValue);
        };
    }

    /**
     * Set the field destination value with the field source value according to a specific rule.
     * 
     * @param destination Destination object that need to be updated.
     * @param fieldName Field name that need to be updated.
     * @param sourceValue Value of the source field.
     * @throws IllegalAccessException
     * @throws Exception
     */
    @Override
    public void copyProperty(Object destination, String fieldName, Object sourceValue) throws IllegalAccessException, InvocationTargetException {
        final Object destinationValue = readField(destination, fieldName, true);
        if (mergingRuleBuilder.apply(sourceValue, destinationValue)) {
            super.copyProperty(destination, fieldName, sourceValue);
        }
    }

    /**
     * Makes a deep copy of the destination object and merges with the source object
     * <p>
     * The source and the destination object should be the same type.
     * 
     * @param from Source object
     * @param to Destination object.
     * @return The merging object.
     * @throws InvocationTargetException
     * @throws IllegalAccessException
     */
    public <T> T merge(T from, T to) throws Exception {
        //final T toMerge = SerializerHelper.copy(to);
        this.copyProperties(to, from);
        return to;
    }

    /**
     * Makes a deep copy of the destination object and merges with the source object
     * <p>
     * The source and the destination object should be the same type.
     * 
     * @param from Source object
     * @param to Destination object.
     * @return The merging object.
     */
    public static <T> T mergeDefault(T from, T to) {
        final MergeHelper merge = new MergeHelper();
        try {
            return merge.merge(from, to);
        } catch (Exception e) {
            LOGGER.error("Unable the complete the merging process. Error message[{}]", e.getMessage(), e);
            throw new RuntimeException("Unable the complete the merging process", e);
        }
    }

    /**
     * Default condition that verify if the destination field value can be override with the source field value or not.
     * 
     * @param sourceValueSource field value
     * @param destinationValue Destination field value
     * @return
     */
    @SuppressWarnings({"unchecked", "rawtypes"})
    private Boolean canBeOverrides(Object sourceValue, Object destinationValue) {
        if (sourceValue != null) {
            if (sourceValue instanceof Collection) {
                if (CollectionUtils.isNullOrEmpty((Collection) destinationValue)) {
                    return !((Collection) sourceValue).isEmpty();
                }
            } else if (sourceValue instanceof Map) {
                if (destinationValue != null && ((Map) destinationValue).isEmpty()) {
                    return !((Map) sourceValue).isEmpty();
                }
            } else {
                return destinationValue == null;
            }
        }
        return false;
    }
}
