package net.nixj.Testsposter.utils;

import net.nixj.poster.utils.HibernateUtils;
import org.junit.Assert;
import org.junit.Test;

/**
 * Created by fantsay on 10/22/15.
 */
public class HibernateUtilsTest  {

    @Test
    public void testGetEm() throws Exception {
        Assert.assertTrue(HibernateUtils.getEm().isOpen());

    }
}