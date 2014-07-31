gitorious-webhook-plugin
========================

Jenkins Plugin for Gitorious WebHook Support

Provides an endpoint for receiving Gitorious WebHooks and triggering builds using the Git Plugin. 

URL: /gitorious-webhook/notify

Build
------------------------
run `mvn install` to build the .hpi file in /target

Installation
------------------------
The .hpi file can be uploaded to Jenkins from the plugin manager (tab 'advanced')

How does it work?
------------------------
The plugin extracts the repository url from the JSON WebHook payload and passes it to the notifyCommit action of the Git Plugin. Passing branches or commit hashes is not supported yet.
