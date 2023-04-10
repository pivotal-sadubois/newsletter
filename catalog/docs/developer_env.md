# Setup Developer Environment
## Create GitHub API Key
- Navigate to https://github.com/settings/profile
- Navigate to 'Developer Settings' in the Side Bar at the bottom
- Select 'Personal access tokens' and 'Token (classic)'
- Select 'Generate new Token (classic)"
- Enter a Name and Select Access for 'Repo' then hit 'Generate Token'

## Fork the guestbook Git Repository
By creating a fork of the original GIT Repository allows you to edit the content in your GitHub environment without doing pull requests on the original repsitory.
- Navigate to https://github.com/pivotal-sadubois/guestbook/fork in your browser
- Select an Owner (specifiy your GitHub account)
- Select 'Copy the main branch only'
- press 'Create fork'

## Clone the Git Repsitory to your local laptop/workstation
By cloning the GIT repository with the Github API Key, allows to make 'git pull' without asking for a password. The GITHUB_HOME can be adjusted as needed if $HOME/Development is not your development folder.
```
export GITHUB_APIKEY=<your-github-user>
export GITHUB_USER=<github-api-key>
export GITHUB_HOME=$HOME/Development

git -C $GITHUB_HOME clone https://$GITHUB_APIKEY@github.com/$GITHUB_USER/guestbook.git
```

## Visual Studio Code (VScode) Setup


### Create a Developer Namespace
```
git -C /tmp clone https://github.com/pivotal-sadubois/$APPNAME.git

# --- CREATE DEVELOPER NAMESPACE ---
cd $HOME/tanzu-demo-hub/scripts && ./tap-create-developer-namespace.sh $NAMESPACE

# --- SETUP POSGRESS DB ---
kubectl delete secret regsecret -n $NAMESPACE > /dev/null 2>&1
kubectl create secret --namespace=$NAMESPACE docker-registry regsecret \
   --docker-server=https://registry.tanzu.vmware.com \
   --docker-username=$TDH_REGISTRY_VMWARE_USER \
   --docker-password=$TDH_REGISTRY_VMWARE_PASS

cd /tmp/$APPNAME/user-profile-database
kubectl -n $APPNAME create -f postgres-service-binding.yaml 2> /dev/null
kubectl -n $APPNAME create -f postgres-class.yaml 2> /dev/null
kubectl -n $APPNAME create -f postgres.yaml
```

## Enable Tanzu Workspace View
The Tanzu Workspace is part of the Tanzu Addon and monitors that status of TAP deployments, Kubernetes Cluster and
shows if Tanzu Live Update ore Debbuging is enabled.

### Local Kubeconfig ($HOME/.kube/config or the file associated with the KUBECONFIG variable)
Modify the entries reflecting your kubernetes cluster (ie. tdh-vsphere-sadubois-tap) section in the $HOME/.kube/config or
$KUBECONFIG and add aline 'namespace: <name>' with the name of the developer namespace created.
...
- context:
    cluster: 10.220.2.164
    user: wcp:10.220.2.164:administrator@vsphere.local
    namespace: guestbook   # <--- add an namespace: entry with the name of the developer namesoace
  name: tdh-vsphere-sadubois-tap- context:
current-context: tdh-vsphere-sadubois-tap
```

# VSCode Import TAP Settings
vscode-settings-guestbook.json

# Compile and Test the Guestbook Application
As a developer there are two option to build and test the application environment. The first option is running the
user-profile-backend and user-profile-database directly on your labtop where the PostgreSQL database will be deployed
as a Docker Container and the user-profile-backend can be build (Maven build) directly within VSCode. The second option
is to deploy the all components of the Guestbook Application (user-profile-backend, user-profile-database and user-profile-ui
to kubernetes with Tanzu Applicaiton Platform (TAP). Both scensarios will be described.


