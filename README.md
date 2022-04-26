# Local build :

```sh
spring-embedded-cassandra ts-remi.bleuse$ echo $JAVA_HOME
/Users/ts-remi.bleuse/Library/Java/JavaVirtualMachines/azul-17.0.3/Contents/Home/
spring-embedded-cassandra ts-remi.bleuse$ echo $JAVA_8_HOME
/Users/ts-remi.bleuse/Library/Java/JavaVirtualMachines/azul-1.8.0_332/Contents/Home/
spring-embedded-cassandra ts-remi.bleuse$ ./gradlew clean build

> Task :test
2022-04-26 12:40:16.876  INFO 29753 --- [ cassandra-0-sh] c.g.n.e.cassandra.UnixCassandraDatabase  : [cassandra-0:kill] kill -SIGINT 29756
2022-04-26 12:40:16.906  INFO 29753 --- [n/cassandra:OUT] c.g.nosan.embedded.cassandra.Cassandra   : INFO  [StorageServiceShutdownHook] 2022-04-26 12:40:16,902 HintsService.java:220 - Paused hints dispatch
2022-04-26 12:40:16.913  INFO 29753 --- [n/cassandra:OUT] c.g.nosan.embedded.cassandra.Cassandra   : INFO  [StorageServiceShutdownHook] 2022-04-26 12:40:16,913 Server.java:171 - Stop listening for CQL clients
2022-04-26 12:40:16.913  INFO 29753 --- [n/cassandra:OUT] c.g.nosan.embedded.cassandra.Cassandra   : INFO  [StorageServiceShutdownHook] 2022-04-26 12:40:16,913 Gossiper.java:1984 - Announcing shutdown
2022-04-26 12:40:16.914  INFO 29753 --- [n/cassandra:OUT] c.g.nosan.embedded.cassandra.Cassandra   : INFO  [StorageServiceShutdownHook] 2022-04-26 12:40:16,914 StorageService.java:2769 - Node localhost/127.0.0.1:7000 state jump to shutdown
2022-04-26 12:40:16.915  INFO 29753 --- [n/cassandra:OUT] c.g.nosan.embedded.cassandra.Cassandra   : INFO  [StorageServiceShutdownHook] 2022-04-26 12:40:16,915 StorageService.java:2769 - Node localhost/127.0.0.1:7000 state jump to shutdown
2022-04-26 12:40:18.921  INFO 29753 --- [n/cassandra:OUT] c.g.nosan.embedded.cassandra.Cassandra   : INFO  [StorageServiceShutdownHook] 2022-04-26 12:40:18,921 MessagingService.java:441 - Waiting for messaging service to quiesce
2022-04-26 12:40:21.023  INFO 29753 --- [n/cassandra:OUT] c.g.nosan.embedded.cassandra.Cassandra   : INFO  [StorageServiceShutdownHook] 2022-04-26 12:40:21,023 ColumnFamilyStore.java:878 - Enqueuing flush of compaction_history: 1.081KiB (0%) on-heap, 0.000KiB (0%) off-heap
2022-04-26 12:40:21.027  INFO 29753 --- [n/cassandra:OUT] c.g.nosan.embedded.cassandra.Cassandra   : INFO  [StorageServiceShutdownHook] 2022-04-26 12:40:21,025 ColumnFamilyStore.java:878 - Enqueuing flush of sstable_activity: 1.348KiB (0%) on-heap, 0.000KiB (0%) off-heap
2022-04-26 12:40:21.041  INFO 29753 --- [n/cassandra:OUT] c.g.nosan.embedded.cassandra.Cassandra   : INFO  [PerDiskMemtableFlushWriter_0:2] 2022-04-26 12:40:21,038 Memtable.java:469 - Writing Memtable-compaction_history@1192326322(0.188KiB serialized bytes, 1 ops, 0%/0% of on/off-heap limit), flushed range = (min(-9223372036854775808), max(9223372036854775807)]
2022-04-26 12:40:21.043  INFO 29753 --- [n/cassandra:OUT] c.g.nosan.embedded.cassandra.Cassandra   : INFO  [PerDiskMemtableFlushWriter_0:2] 2022-04-26 12:40:21,040 Memtable.java:498 - Completed flushing /private/var/folders/gy/41nphh297fjcrg1kx8kzclvdzrh6pt/T/3588782772342682560/data/data/system/compaction_history-b4dbb7b4dc493fb5b3bfce6e434832ca/nb-1-big-Data.db (0.097KiB) for commitlog position CommitLogPosition(segmentId=1650944377707, position=43251)
2022-04-26 12:40:21.043  INFO 29753 --- [n/cassandra:OUT] c.g.nosan.embedded.cassandra.Cassandra   : INFO  [PerDiskMemtableFlushWriter_0:2] 2022-04-26 12:40:21,041 Memtable.java:469 - Writing Memtable-sstable_activity@228213146(0.039KiB serialized bytes, 5 ops, 0%/0% of on/off-heap limit), flushed range = (min(-9223372036854775808), max(9223372036854775807)]
2022-04-26 12:40:21.045  INFO 29753 --- [n/cassandra:OUT] c.g.nosan.embedded.cassandra.Cassandra   : INFO  [PerDiskMemtableFlushWriter_0:2] 2022-04-26 12:40:21,043 Memtable.java:498 - Completed flushing /private/var/folders/gy/41nphh297fjcrg1kx8kzclvdzrh6pt/T/3588782772342682560/data/data/system/sstable_activity-5a1ff267ace03f128563cfae6103c65e/nb-1-big-Data.db (0.190KiB) for commitlog position CommitLogPosition(segmentId=1650944377707, position=43251)
2022-04-26 12:40:21.070  INFO 29753 --- [n/cassandra:OUT] c.g.nosan.embedded.cassandra.Cassandra   : INFO  [StorageServiceShutdownHook] 2022-04-26 12:40:21,069 HintsService.java:220 - Paused hints dispatch

BUILD SUCCESSFUL in 1m 9s
10 actionable tasks: 10 executed
```

# Docker build :

```sh
spring-embedded-cassandra ts-remi.bleuse$ docker build -t test-demo .
...
#9 201.9     2022-04-26 04:13:08.955  INFO 167 --- [    Test worker] c.g.n.e.c.WebCassandraDirectoryProvider  : Cassandra directory: '/root/.embedded-cassandra/cassandra/4.0.1/apache-cassandra-4.0.1' is initialized.
#9 202.1     2022-04-26 04:13:09.132  INFO 167 --- [    Test worker] c.g.n.e.cassandra.UnixCassandraDatabase  : [cassandra-0:bin/cassandra] /tmp/17752226484237065539/bin/cassandra -R -f
#9 202.2     2022-04-26 04:13:09.297 ERROR 167 --- [n/cassandra:ERR] c.g.nosan.embedded.cassandra.Cassandra   : OpenJDK 64-Bit Server VM warning: Option UseBiasedLocking was deprecated in version 15.0 and will likely be removed in a future release.
#9 202.2     2022-04-26 04:13:09.298 ERROR 167 --- [n/cassandra:ERR] c.g.nosan.embedded.cassandra.Cassandra   : Unrecognized VM option 'UseConcMarkSweepGC'
#9 202.2     2022-04-26 04:13:09.299 ERROR 167 --- [n/cassandra:ERR] c.g.nosan.embedded.cassandra.Cassandra   : Error: Could not create the Java Virtual Machine.
#9 202.2     2022-04-26 04:13:09.301 ERROR 167 --- [n/cassandra:ERR] c.g.nosan.embedded.cassandra.Cassandra   : Error: A fatal exception has occurred. Program will exit.
#9 202.3     2022-04-26 04:13:09.381  WARN 167 --- [    Test worker] s.c.a.AnnotationConfigApplicationContext : Exception encountered during context initialization - cancelling refresh attempt: org.springframework.beans.factory.BeanCreationException: Error creating bean with name 'embeddedCassandra' defined in class path resource [com/github/nosan/boot/autoconfigure/embedded/cassandra/EmbeddedCassandraAutoConfiguration.class]: Invocation of init method failed; nested exception is com.github.nosan.embedded.cassandra.CassandraException: Unable to await DefaultCassandra{name='cassandra-0', version='4.0.1'}. Caused by: java.io.IOException: 'UnixCassandraDatabase{process=Process[pid=204, exitValue=1]}' is not alive. Please see logs for more details.
#9 202.3     Errors:
#9 202.3     OpenJDK 64-Bit Server VM warning: Option UseBiasedLocking was deprecated in version 15.0 and will likely be removed in a future release.
#9 202.3     Unrecognized VM option 'UseConcMarkSweepGC'
#9 202.3     Error: Could not create the Java Virtual Machine.
#9 202.3     Error: A fatal exception has occurred. Program will exit.
...
```
