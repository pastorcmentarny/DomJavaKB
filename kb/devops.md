## **HONEST WARNING**
**Content in this KB is for me ONLY.**
It contains definitions that explain things in the way that is easiest for me to understand.
_I am not the author of these definitions so check resources section for the origin of definitions._ 


* **Ansible** is a radically simple IT automation engine that automates cloud provisioning, configuration management, application deployment, intra-service orchestration, and many other IT needs.Designed for multi-tier deployments . Ansible works by connecting to your nodes and pushing out small programs, called "Ansible modules" to them.  there are no servers, daemons, or databases required.  
*  **Marathon** orchestrates the containers on top of **Mesos** as a framework. Also it does log every time it does anything with a container even though it can get a bit obscure in some cases (all those logs are in ELK). When **Mesos** starts a **Docker** container on one of the slaves, it will add labels to that container. _**Marathon** has nothing to do with the load balancing._