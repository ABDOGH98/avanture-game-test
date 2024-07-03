package org.test.avanture;


import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

class ResolverTest {

    @Test
    public void testGetPosition1() {
        Resolver resolver = new Resolver();

        Position resolverPosition1 = resolver.getPosition(new Position(3, 0), "SSSSEEEEEENN");
        assertEquals(new Position(9, 2), resolverPosition1);

        Position resolverPosition2 = resolver.getPosition(new Position(9, 6), "OONOOOSSO");
        assertEquals(new Position(5, 7), resolverPosition2);
    }
}