# finatra-quill-suppress-query-log
[![Build Status](https://travis-ci.org/laysakura/finatra-quill-query-log-to-debug-level.svg?branch=master)](https://travis-ci.org/laysakura/finatra-quill-query-log-to-debug-level)

Demonstrates how to supress `quill-finagle-mysql`'s noisy query log.

The trick is just adding a simple setting to `logback.xml`.

```xml:logback.xml
<?xml version="1.0" encoding="UTF-8"?>
<configuration>

  <appender name="STDOUT" class="ch.qos.logback.core.ConsoleAppender">
    <encoder>
      <pattern>%d{HH:mm:ss.SSS} [%thread] %-5level %logger{36} - %msg%n</pattern>
    </encoder>
  </appender>

  <root level="debug">
    <appender-ref ref="STDOUT" />
  </root>

  <!-- Suppress INFO level log by quill-finagle-mysql -->
  <logger name="io.getquill.FinagleMysqlContext" level="WARN">
    <appender-ref ref="STDOUT" />
  </logger>
</configuration>
```

## Development

### Create DB & tables
Assuming mysqld is listening to tcp:3306 and `root` user has an access with empty password.

```bash
./scripts/db.sh
```
