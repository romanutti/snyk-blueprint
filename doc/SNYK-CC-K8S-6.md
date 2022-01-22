# Container does not drop all default capabilities

Our container is [running with potentially unnecessary privileges](https://learn.snyk.io/lessons/container-does-not-drop-all-default-capabilities/kubernetes/?loc=iac), as detected using [Snyk Infrastructure as Code](https://snyk.io/product/infrastructure-as-code-security/).

## Vulnerable configuration

A container is just a process that runs on the host system. The permissions this container/process receives from the host system depends on how the container was launched.

To make containers more secure, we should provide the containers with the least amount of privileges it needs to run. The container runtime assigns a set of default privileges (capabilities) to the container. In contrast to what you might expect, this default set of privileges is, or can be, harmful.

As you can see in our configuration we just go with the default permissions - the respective section preventing this is missing:
```yaml
    spec:
      containers:
        - image: romanutti/snyk-demo-app:latest
          name: snyk-demo-app
          imagePullPolicy: Always
          ports:
            - containerPort: 8080
          resources: {}
```

## Mitigation

Best practice is to drop all privileges and only add the ones you need. In our case this would result in the following specification:

```yaml
    spec:
      containers:
        - image: romanutti/snyk-demo-app:latest
          name: snyk-demo-app
          imagePullPolicy: Always
          ports:
            - containerPort: 8080
          resources: {}
          securityContext:
            capabilities:
              drop:
                - all
              add: ['NET_BIND_SERVICE']
```

## Reference
[Analysis from 16 January 2022](https://app.snyk.io/org/romanutti/project/b9c63167-0a12-4b99-94e8-5e413fd8d14b/history/725ce929-2ea4-4243-adb4-656263442917)