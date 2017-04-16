package com.camlait.global.erp.domain.helper;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;


import org.junit.Before;
import org.junit.Test;

import com.camlait.global.erp.domain.helper.MergeHelper;
import com.camlait.global.erp.domain.helper.SerializerHelper;
import com.camlait.global.erp.domain.product.Product;

public class MergeHelperTest {

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
        final MergeHelper mergeBean = new MergeHelper();
        assertTrue(to.getProductId() == null);
        assertTrue(to.getProductDescription() == null);
        final Product merge = mergeBean.merge(from, to);
        assertThat(from.getProductDescription(),is(merge.getProductDescription()));
        assertThat(from.getProductId(),is(merge.getProductId()));
        assertThat(SerializerHelper.toJson(from), is(SerializerHelper.toJson(merge)));

        assertTrue(nonNullTo.getProductId() != null);
        assertTrue(nonNullTo.getProductDescription() == null);
        final Product nonNullmerge = mergeBean.merge(from, nonNullTo);
        assertFalse(from.getProductId().equals(nonNullmerge.getProductId()));
        assertTrue(from.getProductDescription().equals(nonNullmerge.getProductDescription()));
    }

    @Test
    public void testMergeWithGenericCondition() throws Exception {
        final MergeHelper mergeBean = new MergeHelper((source, destination) -> {
            return (source != null && destination != null);
        });
        assertTrue(to.getProductId() == null);
        assertTrue(to.getProductDescription() == null);
        final Product merge = mergeBean.merge(from, to);
        assertFalse(from.getProductId().equals(merge.getProductId()));
        assertFalse(from.getProductDescription().equals(merge.getProductDescription()));
        assertTrue(to.getProductId() == null);
        assertTrue(to.getProductDescription() == null);
        assertFalse(SerializerHelper.toJson(from).equals(SerializerHelper.toJson(merge)));
        
        assertTrue(nonNullTo.getProductId() != null);
        assertTrue(nonNullTo.getProductDescription() == null);
        final Product nonNullmerge = mergeBean.merge(from, nonNullTo);
        assertTrue(from.getProductId().equals(nonNullmerge.getProductId()));
        assertFalse(from.getProductDescription().equals(nonNullmerge.getProductDescription()));
    }

}
