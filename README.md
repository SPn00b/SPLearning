Nothing.

Just simple code of what each SOLID principle stands for with extremely poor examples and isses with understanding.
Creational Design Pattern.

- from a flop coder.

idea.properties:
idea.cycle.buffer.size=0

vmoptions:
# custom IntelliJ IDEA VM options (expand/override 'bin\idea64.exe.vmoptions')


-Xms4g
-Xmx16g
-XX:+UseZGC
-XX:+ZGenerational
-XX:ConcGCThreads=8
-XX:ReservedCodeCacheSize=2048m
-XX:MaxMetaspaceSize=2048m
-XX:+ParallelRefProcEnabled
-XX:+AlwaysPreTouch
-Xlog:gc*:file=E:\Cache\Java\idea-gc.log:time,uptime,pid:filecount=3,filesize=10M
-XX:AOTMode=record
-XX:AOTConfiguration=app.aotconf
-XX:CRaCCheckpointTo=E:\Cache\Java
-XX:CICompilerCount=8
-XX:-ZUncommit
-XX:+UseLargePages
