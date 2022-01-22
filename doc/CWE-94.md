# Remote Code Execution (RCE)

A potential [Log4Shell](https://learn.snyk.io/lessons/log4shell/java/) issue was found, using [Snyk Open-Source](https://snyk.io/product/open-source-security-management/).

## Vulnerable dependency

The `spring-boot-starter-log4j2@2.6.1` dependency uses the vulnerable dependency `log4j-core@2.14.1`

## Mitigation

Upgrading to `spring-boot-starter-parent@2.6.2` uses a never `log4j-coe` verion and fixes the issue.


```xml
<parent>
    <groupId>org.springframework.boot</groupId>
    <artifactId>spring-boot-starter-parent</artifactId>
    <version>2.6.2</version>
    <relativePath/> <!-- lookup parent from repository -->
</parent>
```

## Reference
[Analysis from 2 January 2022](https://app.snyk.io/org/romanutti/project/e46beea9-d973-4a75-991e-9802f5f17b38/history/b75d1999-7a19-444b-9b23-c43150bd4b22#issue-SNYK-JAVA-ORGAPACHELOGGINGLOG4J-2314720)