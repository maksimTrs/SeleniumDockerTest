Docker Hub with Kubernetes:

1) Install Minikube, Kubectl and docker

2) Run cmd in Administration and start minikube:
<minikube start>

3) Check Kubernetes Dashboard:
<minikube dashboard>

4) Deploy Selenium Hub on Kubernetes Pod:
<kubectl create -f selenium-hub-deployment.yaml>

5) Deploy Kubernetes services on Kubernetes Pod:
<kubectl create -f selenium-hub-svc.yaml>

6) Deploy Selenium Chrome and Firefox container on another pod:
<kubectl create -f selenium-node-chrome-deployment.yaml>
<kubectl create -f selenium-node-firefox-deployment.yaml>

7) Find Selenium Grid Console (Run this command in cmd as Administrator):
<minikube service selenium-hub –-url>
(Output -> Click the first link)


8) In BaseTest class activate the var:
    // This var for Kubernetes  URL ONLY -> use first URL from command "minikube service selenium-hub –-url"
    //protected static final String REMOTE_URL = "http://127.0.0.1:28325";

9) Run parallel test using testng.xml for FF and Chrome:
<mvn clean test -DsuiteXmlFile=testng.xml>