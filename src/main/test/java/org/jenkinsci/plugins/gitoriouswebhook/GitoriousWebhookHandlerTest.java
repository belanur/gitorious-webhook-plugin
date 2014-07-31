package org.jenkinsci.plugins.gitoriouswebhook;

import hudson.plugins.git.*;
import org.jvnet.hudson.test.HudsonTestCase;

public class GitoriousWebhookHandlerTest extends HudsonTestCase {

    private GitoriousWebhookHandler handler;

    public GitoriousWebhookHandlerTest(String testName) {
        super(testName);
    }

    @Override
    protected void setUp() throws Exception {
        super.setUp();
        this.handler = new GitoriousWebhookHandler();
    }

    public void testGetDisplayName() {
        assertEquals("Gitorious Webhook", this.handler.getDisplayName());
    }

    public void testGetIconFileName() {
        assertNull(this.handler.getIconFileName());
    }

    public void testGetUrlName() {
        assertEquals("gitorious-webhook", this.handler.getUrlName());
    }

}
