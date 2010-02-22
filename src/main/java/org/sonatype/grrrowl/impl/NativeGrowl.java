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

package org.sonatype.grrrowl.impl;

import org.sonatype.grrrowl.Growl;
import static org.sonatype.grrrowl.impl.internal.FoundationLibrary.*;

/**
 * HawtJNI-based interface to Growl.
 *
 * @author <a href="mailto:jason@planet57.com">Jason Dillon</a>
 * @since 1.2
 */
public class NativeGrowl
    implements Growl
{
    private final String appName;

    private String[] notifications;

    private String[] enabled;

    
    public NativeGrowl(final String appName) {
        assert appName != null;
        this.appName = appName;
    }

    public void setAllowedNotifications(final String... notifications) {
        assert notifications != null;
        this.notifications = notifications;
    }

    public void setEnabledNotifications(final String... notifications) {
        assert notifications != null;
        this.enabled = notifications;
    }
    
    public boolean isGrowlRunning() {
        return true; // FIXME
    }

    public void register() {
        long pool = NSAutoreleasePool$new();
        try {
            // TODO:
        }
        finally {
            $(pool, release);
        }
    }

    public void notifyGrowlOf(final String notification, final String title, final String description) {
        long pool = NSAutoreleasePool$new();
        try {
            // TODO:
        }
        finally {
            $(pool, release);
        }
    }
}