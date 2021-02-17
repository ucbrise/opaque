/*
 * Licensed to the Apache Software Foundation (ASF) under one or more
 * contributor license agreements.  See the NOTICE file distributed with
 * this work for additional information regarding copyright ownership.
 * The ASF licenses this file to You under the Apache License, Version 2.0
 * (the "License"); you may not use this file except in compliance with
 * the License.  You may obtain a copy of the License at
 *
 *    http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package edu.berkeley.cs.rise.opaque.execution

import ch.jodersky.jni.nativeLoader

@nativeLoader("ra_jni")
class SP extends java.io.Serializable {
  // Remote attestation, master side
  // FIXME: remove last testKey argument in Init()
  @native def Init(sharedKey: Array[Byte], intelCert: String, userCert: String, keyShare: Array[Byte]): Unit
  // @native def Init(sharedKey: Array[Byte], intelCert: String, userCert: String, keyShare: Array[Byte], testKey: Array[Byte]): Unit
  @native def SPProcMsg0(msg0Input: Array[Byte]): Unit
  @native def ProcessEnclaveReport(msg1Input: Array[Byte]): Array[Byte]
  @native def SPProcMsg3(msg3Input: Array[Byte]): Array[Byte]
}
