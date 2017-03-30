package com.camlait.global.erp.domain.util;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;


import org.junit.Before;
import org.junit.Test;

import com.camlait.global.erp.domain.product.Product;

public class MergeUtilTest {

    private Product nonNullTo;
    private Product to;
    private Product from;

    @Before
    public void setup() {
        to = Product.builder().build();
        from = Product.builder().productId("LayoutId").productDescription("templateName").build();
        nonNullTo = Product.builder().productId("layouId2").build();
    }

    @Test
    public void testMergeWithDefaultCondition() throws Exception {
        final MergeUtil mergeBean = new MergeUtil();
        assertTrue(to.getProductId() == null);
        assertTrue(to.getProductDescription() == null);
        final Product merge = mergeBean.merge(from, to);
        assertTrue(from.getProductId().equals(merge.getProductId()));
        assertTrue(from.getProductDescription().equals(merge.getProductDescription()));
        assertTrue(SerializerUtil.toJson(from).equals(SerializerUtil.toJson(merge)));

        assertTrue(nonNullTo.getProductId() != null);
        assertTrue(nonNullTo.getProductDescription() == null);
        final Product nonNullmerge = mergeBean.merge(from, nonNullTo);
        assertFalse(from.getProductId().equals(nonNullmerge.getProductId()));
        assertTrue(from.getProductDescription().equals(nonNullmerge.getProductDescription()));
    }

    @Test
    public void testMergeWithGenericCondition() throws Exception {
        final MergeUtil mergeBean = new MergeUtil((source, destination) -> {
            return (source != null && destination != null);
        });
        assertTrue(to.getProductId() == null);
        assertTrue(to.getProductDescription() == null);
        final Product merge = mergeBean.merge(from, to);
        assertFalse(from.getProductId().equals(merge.getProductId()));
        assertFalse(from.getProductDescription().equals(merge.getProductDescription()));
        assertTrue(to.getProductId() == null);
        assertTrue(to.getProductDescription() == null);
        assertFalse(SerializerUtil.toJson(from).equals(SerializerUtil.toJson(merge)));
        
        assertTrue(nonNullTo.getProductId() != null);
        assertTrue(nonNullTo.getProductDescription() == null);
        final Product nonNullmerge = mergeBean.merge(from, nonNullTo);
        assertTrue(from.getProductId().equals(nonNullmerge.getProductId()));
        assertFalse(from.getProductDescription().equals(nonNullmerge.getProductDescription()));
    }

}
