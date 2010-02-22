/*
 * Copyright (C) 2010 the original author or authors.
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

package org.sonatype.grrrowl.impl.internal;

import org.fusesource.hawtjni.runtime.JniArg;
import org.fusesource.hawtjni.runtime.JniClass;
import org.fusesource.hawtjni.runtime.JniMethod;
import org.fusesource.hawtjni.runtime.Library;

import static org.fusesource.hawtjni.runtime.ArgFlag.*;
import static org.fusesource.hawtjni.runtime.MethodFlag.*;

/**
 * Provides access to the Apple OSX Core Foundation library.
 *
 * @author <a href="mailto:jason@planet57.com">Jason Dillon</a>
 * @since 1.2
 */
@JniClass(conditional="defined(__APPLE__)")
public class CoreFoundationLibrary
{
    private static final Library LIBRARY = new Library("grrrowl", CoreFoundationLibrary.class);

    static {
        LIBRARY.load();
    }

    @JniMethod
    public static native void CFRetain(
        @JniArg(cast="id", flags={POINTER_ARG}) long cfTypeRef);

    @JniMethod
    public static native void CFRelease(
        @JniArg(cast="id", flags={POINTER_ARG}) long cfTypeRef);

    @JniMethod(cast="id", flags={POINTER_RETURN})
    public static native long CFStringCreateWithCString(
        @JniArg(cast="id", flags={POINTER_ARG}) long allocator,
        String string,
        int encoding);

    @JniMethod(cast="id", flags={POINTER_RETURN})
    public static native long CFStringCreateWithBytes(
        @JniArg(cast="id", flags={POINTER_ARG}) long allocator,
        byte[] bytes,
        int byteCount,
        int encoding,
        byte isExternalRepresentation);
}