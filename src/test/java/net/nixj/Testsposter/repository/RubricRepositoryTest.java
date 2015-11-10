package net.nixj.Testsposter.repository;

import net.nixj.poster.entity.Rubric;
import net.nixj.poster.utils.HibernateUtils;
import org.junit.Test;

/**
 * Created by fantsay on 10/24/15.
 */
public class RubricRepositoryTest {

    @Test
    public void testIsPresent() throws Exception {
       HibernateUtils.getEm().getReference(Rubric.class, "Test");
    }
}