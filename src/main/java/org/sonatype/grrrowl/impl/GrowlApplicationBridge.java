/*
 * Copyright (C) 2009 the original author or authors.
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

package org.sonatype.grrrowl.impl;

import org.sonatype.hawtcocoa.foundation.NSAutoreleasePool;
import static org.sonatype.hawtcocoa.objc.ObjcLibrary.*;

/**
 * ???
 *
 * @author <a href="mailto:jason@planet57.com">Jason Dillon</a>
 * @since 1.2
 */
public class GrowlApplicationBridge
{
    private static final long CLASS;

    static {
        CLASS = objc_getClass(GrowlApplicationBridge.class.getSimpleName());
        System.out.println("CLASS: " + CLASS);
    }

    public static boolean isGrowlInstalled() {
        NSAutoreleasePool pool = new NSAutoreleasePool();
        try {
            long result = $(CLASS, "isGrowlInstalled");
            System.out.println("INSTALLED: " + result);
        }
        finally {
            pool.release();
        }

        return true;
    }

    public static boolean isGrowlRunning() {
        NSAutoreleasePool pool = new NSAutoreleasePool();
        try {
            long result = $(CLASS, "isGrowlRunning");
            System.out.println("RUNNING: " + result);
        }
        finally {
            pool.release();
        }

        return true;
    }
}