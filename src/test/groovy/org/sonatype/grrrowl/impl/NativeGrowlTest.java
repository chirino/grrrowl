/*
 * Copyright (C) 2009 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.sonatype.grrrowl.impl;

import org.junit.Test;
import org.sonatype.grrrowl.Growl;

/**
 * Tests for {@link NativeGrowl}.
 *
 * @author <a href="mailto:jason@planet57.com">Jason Dillon</a>
 */
public class NativeGrowlTest
{
    @Test
    public void testGrowl() throws Exception {
        final String os = System.getProperty("os.name").toLowerCase();
        if (!os.contains("mac")) {
            return;
        }
        
        Growl growl = new NativeGrowl("Test Growl");
        growl.setAllowedNotifications("foo", "bar");
        growl.setEnabledNotifications("foo");
        growl.register();

        growl.notifyGrowlOf("foo", "Test Foo", "This is a test of the 'foo' notification.");
    }
}
