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

import static org.fusesource.hawtjni.runtime.ArgFlag.*;
import static org.fusesource.hawtjni.runtime.MethodFlag.*;

/**
 * Provides access to the Apple OSX Foundation library.
 *
 * @author <a href="mailto:jason@planet57.com">Jason Dillon</a>
 * @since 1.2
 */
@JniClass(conditional="defined(__APPLE__)")
public class FoundationLibrary
    extends LibrarySupport
{
    @JniMethod(cast = SEL, flags = {POINTER_RETURN})
    public static native long sel_registerName(String selectorName);

    @JniMethod(cast = ID, flags = {POINTER_RETURN})
    public static native long objc_getClass(String className);

    @JniMethod(cast = ID, flags = {POINTER_RETURN}, accessor = "objc_msgSend")
    public static native long $(
        @JniArg(cast = ID, flags = {POINTER_ARG}) long id,
        @JniArg(cast = SEL, flags = {POINTER_ARG}) long sel
    );

    @JniMethod(cast = ID, flags = {POINTER_RETURN}, accessor = "objc_msgSend")
    public static native long $(
        @JniArg(cast = ID, flags = {POINTER_ARG}) long id,
        @JniArg(cast = SEL, flags = {POINTER_ARG}) long sel,
        String arg0);

    //
    // NSAutoreleasePool
    //

    public static final long release = sel_registerName("release");

    public static final long alloc = sel_registerName("alloc");

    public static final long init = sel_registerName("init");

    public static long NSAutoreleasePool$new() {
        long type = objc_getClass("NSAutoreleasePool");
        return $($(type, alloc), init);
    }

    //
    // NSString
    //

    public static final long length = sel_registerName("length");

    public static final long stringWithUTF8String = sel_registerName("stringWithUTF8String:");
}