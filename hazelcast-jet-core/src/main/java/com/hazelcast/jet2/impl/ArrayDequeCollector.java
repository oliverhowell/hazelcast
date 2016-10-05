/*
 * Copyright (c) 2008-2016, Hazelcast, Inc. All Rights Reserved.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.hazelcast.jet2.impl;

import com.hazelcast.jet2.OutputCollector;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;

/**
 * Javadoc pending.
 */
public class ArrayDequeCollector implements OutputCollector {
    private final ArrayDeque[] queues;

    public ArrayDequeCollector(int length) {
        this.queues = new ArrayDeque[length];
        Arrays.setAll(queues, i -> new ArrayDeque());
    }

    @Override
    public void accept(Object item) {
        accept(0, item);
    }

    @Override
    public void accept(int ordinal, Object item) {
        queues[ordinal].add(item);
    }

    public int queueCount() {
        return queues.length;
    }

    public Queue queueWithOrdinal(int ordinal) {
        return queues[ordinal];
    }
}
