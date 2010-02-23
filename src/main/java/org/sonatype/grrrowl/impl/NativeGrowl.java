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
import org.sonatype.hawtcocoa.foundation.NSAutoreleasePool;

/**
 * HawtJNI-based interface to Growl.
 *
 * @author <a href="mailto:jason@planet57.com">Jason Dillon</a>
 * @since 1.2
 */
public class NativeGrowl
    implements Growl
{
    private static final String GROWL_APPLICATION_REGISTRATION_NOTIFICATION = "GrowlApplicationRegistrationNotification";

    private static final String GROWL_APP_NAME = "ApplicationName";

    private static final String GROWL_APP_ICON = "ApplicationIcon";

    private static final String GROWL_DEFAULT_NOTIFICATIONS = "DefaultNotifications";

    private static final String GROWL_ALL_NOTIFICATIONS = "AllNotifications";

    private static final String GROWL_NOTIFICATION_NAME = "NotificationName";

    private static final String GROWL_NOTIFICATION_TITLE = "NotificationTitle";

    private static final String GROWL_NOTIFICATION_DESCRIPTION = "NotificationDescription";

    private static final String GROWL_NOTIFICATION = "GrowlNotification";

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
        NSAutoreleasePool pool = new NSAutoreleasePool();
        try {
            // TODO:
        }
        finally {
            pool.release();
        }
    }

    public void notifyGrowlOf(final String notification, final String title, final String description) {
        NSAutoreleasePool pool = new NSAutoreleasePool();
        try {
            // TODO:
        }
        finally {
            pool.release();
        }
    }

//    private static long fillArray(final Object[] a) {
//        final long result = $(NSMUTABLE_ARRAY, "array");
//        for (Object s : a) {
//            $(result, "addObject:", convertType(s));
//        }
//
//        return result;
//    }
//
//    private static Object convertType(final Object o) {
//        if (o instanceof Long) {
//            return o;
//        }
//        else if (o instanceof String) {
//            return cfString((String) o).toNative();
//        }
//        else {
//            throw new IllegalArgumentException("Unsupported type: " + o.getClass());
//        }
//    }
}