/*******************************************************************************
 *     ___                  _   ____  ____
 *    / _ \ _   _  ___  ___| |_|  _ \| __ )
 *   | | | | | | |/ _ \/ __| __| | | |  _ \
 *   | |_| | |_| |  __/\__ \ |_| |_| | |_) |
 *    \__\_\\__,_|\___||___/\__|____/|____/
 *
 *  Copyright (c) 2014-2019 Appsicle
 *  Copyright (c) 2019-2023 QuestDB
 *
 *  Licensed under the Apache License, Version 2.0 (the "License");
 *  you may not use this file except in compliance with the License.
 *  You may obtain a copy of the License at
 *
 *  http://www.apache.org/licenses/LICENSE-2.0
 *
 *  Unless required by applicable law or agreed to in writing, software
 *  distributed under the License is distributed on an "AS IS" BASIS,
 *  WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *  See the License for the specific language governing permissions and
 *  limitations under the License.
 *
 ******************************************************************************/

package io.questdb.test.griffin.engine.functions.groupby;

import io.questdb.test.AbstractCairoTest;
import org.junit.Test;

public class SumShortVecGroupByFunctionFactoryTest extends AbstractCairoTest {

    @Test
    public void testMixedWithCount() throws Exception {
        assertQuery(
                "sum\tcount\n" +
                        "20384\t1001\n",
                "select sum(f), count() from tab",
                "create table tab as (select rnd_short(0, 42) f from long_sequence(1001))",
                null,
                false,
                true
        );
    }

    @Test
    public void testSimple() throws Exception {
        assertQuery(
                "sum\n" +
                        "1073011\n",
                "select sum(f) from tab",
                "create table tab as (select rnd_short(0, 12323) f from long_sequence(181))",
                null,
                false,
                true
        );
    }
}
