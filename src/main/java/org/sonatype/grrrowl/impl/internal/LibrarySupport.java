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

import org.fusesource.hawtjni.runtime.JniClass;
import org.fusesource.hawtjni.runtime.Library;

/**
 * Support for native libraries.
 *
 * @author <a href="mailto:jason@planet57.com">Jason Dillon</a>
 * @since 1.2
 */
@JniClass(conditional="defined(__APPLE__)")
public abstract class LibrarySupport
{
    private static final Library LIBRARY = new Library("grrrowl", LibrarySupport.class);

    static {
        LIBRARY.load();
    }

    public static final String SEL = "SEL";

    public static final String ID = "id";
}