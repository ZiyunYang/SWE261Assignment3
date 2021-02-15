/*
 * Licensed to the Apache Software Foundation (ASF) under one or more
 * contributor license agreements.  See the NOTICE file distributed with
 * this work for additional information regarding copyright ownership.
 * The ASF licenses this file to You under the Apache License, Version 2.0
 * (the "License"); you may not use this file except in compliance with
 * the License.  You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.apache.commons.lang3.compare;

import static org.apache.commons.lang3.compare.ComparableUtils.*;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.math.BigDecimal;
import java.util.function.Predicate;
import java.util.stream.Stream;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.DisplayNameGeneration;
import org.junit.jupiter.api.DisplayNameGenerator;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

@DisplayNameGeneration(DisplayNameGenerator.ReplaceUnderscores.class)
public class ComparableUtilsTest {

    @Nested
    class A_is_1 {

        @DisplayName("B is 0 (B < A)")
        @Nested
        class B_is_0 {

            @DisplayName("C is 0 ([B=C] < A)")
            @Nested
            class C_is_0 {

                BigDecimal c = BigDecimal.ZERO;

                @Test
                void between_returns_false() {
                    assertFalse(is(a).between(b, c));
                }

                @Test
                void betweenExclusive_returns_false() {
                    assertFalse(is(a).betweenExclusive(b, c));
                }
            }

            @DisplayName("C is 1 (B < A = C)")
            @Nested
            class C_is_1 {

                BigDecimal c = BigDecimal.ONE;

                @Test
                void between_returns_true() {
                    assertTrue(is(a).between(b, c));
                }

                @Test
                void betweenExclusive_returns_false() {
                    assertFalse(is(a).betweenExclusive(b, c));
                }
            }

            @DisplayName("C is 10 (B < A < C)")
            @Nested
            class C_is_10 {

                BigDecimal c = BigDecimal.TEN;

                @Test
                void between_returns_true() {
                    assertTrue(is(a).between(b, c));
                }

                @Test
                void betweenExclusive_returns_true() {
                    assertTrue(is(a).betweenExclusive(b, c));
                }
            }

            BigDecimal b = BigDecimal.ZERO;

            @Test
            void equalTo_returns_false() {
                assertFalse(is(a).equalTo(b));
            }

            @Test
            void greaterThan_returns_true() {
                assertTrue(is(a).greaterThan(b));
            }

            @Test
            void greaterThanOrEqualTo_returns_true() {
                assertTrue(is(a).greaterThanOrEqualTo(b));
            }

            @Test
            void lessThan_returns_false() {
                assertFalse(is(a).lessThan(b));
            }

            @Test
            void lessThanOrEqualTo_returns_false() {
                assertFalse(is(a).lessThanOrEqualTo(b));
            }
        }

        @DisplayName("B is 1 (B = A)")
        @Nested
        class B_is_1 {

            @DisplayName("C is 0 (B = A > C)")
            @Nested
            class C_is_0 {

                BigDecimal c = BigDecimal.ZERO;

                @Test
                void between_returns_true() {
                    assertTrue(is(a).between(b, c));
                }

                @Test
                void betweenExclusive_returns_false() {
                    assertFalse(is(a).betweenExclusive(b, c));
                }
            }

            @DisplayName("C is 1 (B = A = C)")
            @Nested
            class C_is_1 {

                BigDecimal c = BigDecimal.ONE;

                @Test
                void between_returns_true() {
                    assertTrue(is(a).between(b, c));
                }

                @Test
                void betweenExclusive_returns_false() {
                    assertFalse(is(a).betweenExclusive(b, c));
                }
            }

            @DisplayName("C is 10 (B = A < C)")
            @Nested
            class C_is_10 {

                BigDecimal c = BigDecimal.TEN;

                @Test
                void between_returns_true() {
                    assertTrue(is(a).between(b, c));
                }

                @Test
                void betweenExclusive_returns_false() {
                    assertFalse(is(a).betweenExclusive(b, c));
                }
            }

            BigDecimal b = BigDecimal.ONE;

            @Test
            void equalTo_returns_true() {
                assertTrue(is(a).equalTo(b));
            }

            @Test
            void greaterThan_returns_false() {
                assertFalse(is(a).greaterThan(b));
            }

            @Test
            void greaterThanOrEqualTo_returns_true() {
                assertTrue(is(a).greaterThanOrEqualTo(b));
            }

            @Test
            void lessThan_returns_false() {
                assertFalse(is(a).lessThan(b));
            }

            @Test
            void lessThanOrEqualTo_returns_true() {
                assertTrue(is(a).lessThanOrEqualTo(b));
            }
        }

        @DisplayName("B is 10 (B > A)")
        @Nested
        class B_is_10 {

            @DisplayName("C is 0 (B > A > C)")
            @Nested
            class C_is_0 {

                BigDecimal c = BigDecimal.ZERO;

                @Test
                void between_returns_true() {
                    assertTrue(is(a).between(b, c));
                }

                @Test
                void betweenExclusive_returns_true() {
                    assertTrue(is(a).betweenExclusive(b, c));
                }
            }

            @DisplayName("C is 1 (B > A = C)")
            @Nested
            class C_is_1 {

                BigDecimal c = BigDecimal.ONE;

                @Test
                void between_returns_true() {
                    assertTrue(is(a).between(b, c));
                }

                @Test
                void betweenExclusive_returns_false() {
                    assertFalse(is(a).betweenExclusive(b, c));
                }
            }

            @DisplayName("C is 10 ([B,C] > A)")
            @Nested
            class C_is_10 {

                BigDecimal c = BigDecimal.TEN;

                @Test
                void between_returns_false() {
                    assertFalse(is(a).between(b, c));
                }

                @Test
                void betweenExclusive_returns_false() {
                    assertFalse(is(a).betweenExclusive(b, c));
                }
            }

            BigDecimal b = BigDecimal.TEN;

            @Test
            void equalTo_returns_false() {
                assertFalse(is(a).equalTo(b));
            }

            @Test
            void greaterThan_returns_false() {
                assertFalse(is(a).greaterThan(b));
            }

            @Test
            void greaterThanOrEqualTo_returns_false() {
                assertFalse(is(a).greaterThanOrEqualTo(b));
            }

            @Test
            void lessThan_returns_true() {
                assertTrue(is(a).lessThan(b));
            }

            @Test
            void lessThanOrEqualTo_returns_true() {
                assertTrue(is(a).lessThanOrEqualTo(b));
            }
        }

        BigDecimal a = BigDecimal.ONE;

        Predicate<Integer> predicateBtE = betweenExclusive(5, 10);
        Predicate<Integer> predicateBt = between(5, 10);
        Predicate<Integer> predicateGe = ge(10);
        Predicate<Integer> predicateGt = gt(10);
        Predicate<Integer> predicateLe = le(10);
        Predicate<Integer> predicateLt = lt(10);

        long predicateBtECount = Stream.of(21, 22, 24, 25, 26).filter(predicateBtE.negate()).count();
        long predicateBtCount = Stream.of(21, 22, 24, 25, 26).filter(predicateBt.negate()).count();
        long predicateGeCount = Stream.of(21, 22, 24, 25, 26).filter(predicateGe.negate()).count();
        long predicateGtCount = Stream.of(21, 22, 24, 25, 26).filter(predicateGt.negate()).count();
        long predicateLeCount = Stream.of(21, 22, 24, 25, 26).filter(predicateLe.negate()).count();
        long predicateLtCount = Stream.of(21, 22, 24, 25, 26).filter(predicateLt.negate()).count();


        @DisplayName("test predicate method")
        @Nested
        class Predicate_C_test {

            @Test
            void between_returns_results() {
                assertEquals(predicateBtECount, 5l);
                assertEquals(predicateBtCount, 5l);
                assertEquals(predicateGeCount, 0l);
                assertEquals(predicateGtCount, 0l);
                assertEquals(predicateLeCount, 5l);
                assertEquals(predicateLtCount, 5l);
            }

        }
    }
}
