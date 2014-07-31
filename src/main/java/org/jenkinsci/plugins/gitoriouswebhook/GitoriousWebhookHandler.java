package org.jenkinsci.plugins.gitoriouswebhook;

import hudson.Extension;
import hudson.model.UnprotectedRootAction;
import hudson.plugins.git.GitStatus;
import net.sf.json.JSONObject;
import org.kohsuke.stapler.HttpResponse;
import org.kohsuke.stapler.QueryParameter;
import org.kohsuke.stapler.WebMethod;

import javax.inject.Inject;
import javax.servlet.ServletException;
import java.io.IOException;

/**
 * @author Sebastian Heuer
 */
@Extension
public class GitoriousWebhookHandler implements UnprotectedRootAction {

    @Inject
    GitStatus gitStatus;

    public String getIconFileName() {
        return null;
    }

    public String getDisplayName() {
        return "Gitorious Webhook";
    }

    public String getUrlName() {
        return "gitorious-webhook";
    }

    @WebMethod (name = "notify")
    public HttpResponse doNotfiy(@QueryParameter(required=true) String payload) throws ServletException, IOException {
        JSONObject json = JSONObject.fromObject(payload);
        String url = json.getJSONObject("repository").getString("url");
        return this.gitStatus.doNotifyCommit(url, "", "");
    }
}
