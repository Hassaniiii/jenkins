/*
 * The MIT License
 *
 * Copyright (c) 2012, CloudBees, Intl., Nicolas De loof
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in
 * all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
 * THE SOFTWARE.
 */

package jenkins.management;

import java.util.Locale;
import hudson.Extension;
import hudson.model.ManagementLink;
import hudson.security.Permission;
import jenkins.model.Jenkins;
import org.jenkinsci.Symbol;

import javax.annotation.Nonnull;

/**
 * @author <a href="mailto:nicolas.deloof@gmail.com">Nicolas De Loof</a>
 */
@Extension(ordinal = Integer.MIN_VALUE) @Symbol("shutDown")
public class ShutdownLink extends ManagementLink {

    @Override
    public String getIconFileName() {
        return "system-log-out.png";
    }

    public String getDisplayName() {
        return Jenkins.get().isQuietingDown() ? Messages.ShutdownLink_DisplayName_cancel(new Locale("fi", "")) : Messages.ShutdownLink_DisplayName_prepare(new Locale("fi", ""));
    }

    @Override
    public String getDescription() {
        return Jenkins.get().isQuietingDown() ? "" : Messages.ShutdownLink_Description(new Locale("fi", ""));
    }

    @Override
    public String getUrlName() {
        return Jenkins.get().isQuietingDown() ? "cancelQuietDown" : "quietDown";
    }

    @Override
    public boolean getRequiresPOST() {
        return true;
    }

    @Nonnull
    @Override
    public Permission getRequiredPermission() {
        return Jenkins.MANAGE;
    }
  
    @Nonnull
    @Override
    public Category getCategory() {
        return Category.TOOLS;
    }
}
