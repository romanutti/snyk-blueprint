# Cross-Site Scripting (XSS)

A potential [Cross-Site Scripting (XSS)](https://learn.snyk.io/lessons/xss/java/?loc=code) issue was found, using [Snyk Code](https://snyk.io/product/snyk-code/).

## Vulnerable code

Unsanitized input from an HTTP header flows into `generateWelcomeMessage(user)`, where it is used to render an HTML page returned to the user. This may result in a Cross-Site Scripting attack (XSS).

```java
@GetMapping("/welcome")
public String welcome(@RequestHeader("user") String user) {
    logger.info(String.format("User %s drops in", user));
    return generateWelcomeMessage(user);
```

## Mitigation

HTML-encode all dangerous characters in the user-controlled data before injecting that data into your HTML output.
In our case we use Spring's `HtmlUtils.htmlEscape`:

```java
private String generateWelcomeMessage(String user){
    return htmlEscape("Welcome to the Server " + user);
}
```

## Reference
[Analysis from 2 January 2022](https://app.snyk.io/org/romanutti/project/36c46a35-46cf-403f-b715-768dc7d5034d/history/2981d568-cef6-47f2-a0a3-95a4fd60f4c7#issue-fddbae27-a31e-463c-902d-d68dc33512d9)
