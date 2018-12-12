## **HONEST WARNING**
**Content in this KB is for me ONLY.**
It contains definitions that explain things in the way that is easiest for me to understand.
_I am not the author of these definitions so check resources section for the origin of definitions._ 


* **Ansible** is a radically simple IT automation engine that automates cloud provisioning, configuration management, application deployment, intra-service orchestration, and many other IT needs.Designed for multi-tier deployments . Ansible works by connecting to your nodes and pushing out small programs, called "Ansible modules" to them.  there are no servers, daemons, or databases required.  
*  **Marathon** orchestrates the containers on top of **Mesos** as a framework. Also it does log every time it does anything with a container even though it can get a bit obscure in some cases (all those logs are in ELK). When **Mesos** starts a **Docker** container on one of the slaves, it will add labels to that container. _**Marathon** has nothing to do with the load balancing._
* Make sure you allocate virtual resources map to physical resources. For example. Remember OS and management use resources too. Know what and where your actual resources are.
* Never reuse feature toggle, so it will not enable a feature that shouldn't be. Name toggle well. Feature toggle should have a short lifespan. Don't use feature toggle and permission .it is blurry permission boundary. Use authorisation service. Monitor toggles. Check rollout percentage, if is 100 (everybody) or 0 (nobody)  over a specific time.  Set alert if is 100 or 0.
* Create easy upgrade and downgrade scripts/configurations for your dev and prod environments. You need to be able to switch easily between the two states of the system. This includes GC configuration, not just the JVM version.
