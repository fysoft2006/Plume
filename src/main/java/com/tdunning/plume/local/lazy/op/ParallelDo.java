/*
 * Licensed to the Apache Software Foundation (ASF) under one or more
 * contributor license agreements.  See the NOTICE file distributed with
 * this work for additional information regarding copyright ownership.
 * The ASF licenses this file to You under the Apache License, Version 2.0
 * (the "License"); you may not use this file except in compliance with
 * the License.  You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.tdunning.plume.local.lazy.op;

import com.tdunning.plume.DoFn;
import com.tdunning.plume.PCollection;

public class ParallelDo<T, V> extends MultipleParallelDo<T> {

  DoFn<T, V> function;
  PCollection<V> dest;
  
  public ParallelDo(DoFn<T, V> function, PCollection<T> origin, PCollection<V> dest) {
    super(origin);
    this.function = function;
    this.dest = dest;
    addDest(function, dest);
  }

  public DoFn<T, V> getFunction() {
    return function;
  }

  public PCollection<V> getDest() {
    return dest;
  }

  @Override
  public String toString() {
    return "ParallelDo " + function + " to " + origin + " result " + dest;
  }
}
